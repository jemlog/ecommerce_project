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

    /*
    1. userId 들어가야함
    2. itemId 필요함
    3. 몇개 살지 수량 필요함
    4. 사용자 등급 필요(userId로 사용자 등급 찾아서 활용)
     */
//    @Transactional
//    public Order createOrder(Long userId,Long itemId,int quantity)
//    {
//        // 사용자 찾음
//        User findUser = userService.findById(userId);
//        // 상품 찾음
//        Item findItem = itemService.findById(itemId);
//        // 주문 상품 만듬
//        OrderItem orderItem = OrderItem.createOrderItem(quantity, findItem);
//        Order order = Order.createOrder(findUser, orderItem);
//        order.place();
//        int totalOrderPrice = order.getTotalOrderPrice();
//        DiscountPolicy discountPolicy = new FixedDiscountByGradePolicy();
//        int discountPrice = discountPolicy.discount(findUser, totalOrderPrice);
//        order.discountOrderPrice(discountPrice);
//        findUser.addTotalOrderPriceForGrade(order.getTotalOrderPrice());
//        return orderRepository.save(order);
//    }

    @Transactional
    public Order createOrder(OrderRequestDto orderRequestDto)
    {
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
//        int totalOrderPrice = order.getOrderItems()
//        DiscountPolicy discountPolicy = new FixedDiscountByGradePolicy();
//        int discountPrice = discountPolicy.discount(findUser, totalOrderPrice);
//        order.discountOrderPrice(discountPrice);
//        findUser.addTotalOrderPriceForGrade(order.getTotalOrderPrice());
        Money totalOrderPrice = order.calculateTotalPrice();
        DiscountPolicy discountPolicy = new FixedDiscountByGradePolicy();
        Money discountPrice = discountPolicy.discount(findUser, totalOrderPrice);
        order.setTotalMoney(discountPrice);
        findUser.addTotalOrderPriceForGrade(order.getTotalMoney());
        return orderRepository.save(order);
    }

    @Transactional
    public void payOrder(Long orderId)
    {
        Order order = orderRepository.findById(orderId).orElseThrow(IllegalStateException::new);
        // order.payed 처럼 계산하는 로직 추가
    }
    @Transactional
    public void cancelOrder(Long orderId) throws ClientInvalidInputException
    {
        Order findOrder = orderRepository.findById(orderId)
                .orElseThrow(() -> new ClientInvalidInputException("잘못된 id 값입니다."));
        findOrder.cancelOrder();


    }


    public Page<Order> findAllOrders(Pageable pageable, OrderSearch orderSearch)
    {
       return orderRepository.searchPage(pageable,orderSearch);
    }

//    @Transactional
//    public void deleteOrder(Long orderId) throws ClientInvalidInputException {
//
//        // TODO : id값 잘못 들어왔을때 사용할 공통 예외를 만들자!
//        Order findOrder = orderRepository.findById(orderId)
//                .orElseThrow(
//                        () -> new ClientInvalidInputException("사용자가 잘못된 값을 입력했습니다.")
//                );
//
//        orderRepository.delete(findOrder);
//
//    }

}
