package project.finaltoyproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.finaltoyproject.domain.item.Item;
import project.finaltoyproject.domain.order.Order;
import project.finaltoyproject.domain.order.dto.OrderSearch;
import project.finaltoyproject.domain.order.repository.OrderRepository;
import project.finaltoyproject.domain.orderItem.OrderItem;
import project.finaltoyproject.domain.user.User;
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
    public Order createOrder(Long userId, Long itemId,int quantity)
    {
        User findUser = userService.findById(userId);
        Item findItem = itemService.findById(itemId);
        OrderItem orderItem = OrderItem.createOrderItem(quantity, findItem);
        Order order = Order.createOrder(findUser, orderItem);
        return orderRepository.save(order);
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

    @Transactional
    public void deleteOrder(Long orderId) throws ClientInvalidInputException {

        // TODO : id값 잘못 들어왔을때 사용할 공통 예외를 만들자!
        Order findOrder = orderRepository.findById(orderId)
                .orElseThrow(
                        () -> new ClientInvalidInputException("사용자가 잘못된 값을 입력했습니다.")
                );

        orderRepository.delete(findOrder);

    }

}
