package project.finaltoyproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.finaltoyproject.domain.item.Item;
import project.finaltoyproject.domain.money.Money;
import project.finaltoyproject.domain.order.Order;
import project.finaltoyproject.domain.order.dto.OrderRequestDto;
import project.finaltoyproject.domain.order.dto.OrderSearch;
import project.finaltoyproject.domain.order.repository.OrderRepository;
import project.finaltoyproject.domain.orderItem.OrderItem;
import project.finaltoyproject.domain.user.User;
import project.finaltoyproject.policy.DiscountPolicy;
import project.finaltoyproject.policy.FixedDiscountByGradePolicy;
import project.finaltoyproject.util.exeption.ClientInvalidInputException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserService userService;
    private final ItemService itemService;


    @Transactional
    public Order createOrder(OrderRequestDto orderRequestDto) {
        // 사용자 찾음
        User findUser = userService.findById(orderRequestDto.getUserId());
        // 상품 찾음
        Item findItem = itemService.findById(orderRequestDto.getItemId());
        // 주문 상품 만듬
        OrderItem orderItem = OrderItem.createOrderItem(orderRequestDto, findItem);
        // Order 생성
        Order order = Order.createOrder(findUser, orderItem);
        // 검증 로직 (아직 생성 안함)
        order.place();
        // 하나의 order 안에 있는 옵션들의 가격 모두 합산
        Money totalOrderPrice = order.calculateTotalPrice();
        // 등급별로 할인율을 차등 적용하는 로직
        DiscountPolicy discountPolicy = new FixedDiscountByGradePolicy();
        Money discountPrice = discountPolicy.discount(findUser, totalOrderPrice);
        // order entity에 실제 할인 가격 적용하기
        order.setTotalMoney(discountPrice);
        // 구매 금액별 실시간 등급 산정을 위한 로직 - 사용자의 전체 결제 가격에 추가한다.
        findUser.addTotalOrderPriceForGrade(order.getTotalMoney());
        return orderRepository.save(order);
    }

    @Transactional
    public void payed(Long orderId) {

        Order order = orderRepository.findById(orderId).orElseThrow(IllegalStateException::new);
        order.payedOrder();
    }

    @Transactional
    public void cancelOrder(Long orderId) throws ClientInvalidInputException {

        Order findOrder = orderRepository.findById(orderId)
                .orElseThrow(() -> new ClientInvalidInputException("잘못된 id 값입니다."));
        findOrder.cancelOrder();


    }

    public Page<Order> findAllOrders(Pageable pageable, OrderSearch orderSearch) {

        return orderRepository.searchPage(pageable, orderSearch);
    }

}