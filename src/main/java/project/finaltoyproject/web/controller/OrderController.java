package project.finaltoyproject.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import project.finaltoyproject.domain.order.Order;
import project.finaltoyproject.domain.order.dto.OrderRequestDto;
import project.finaltoyproject.domain.order.dto.OrderResponseDto;
import project.finaltoyproject.domain.order.dto.OrderSearch;
import project.finaltoyproject.domain.user.User;
import project.finaltoyproject.service.OrderService;
import project.finaltoyproject.util.exeption.ClientInvalidInputException;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public Long createOrder(@RequestBody OrderRequestDto orderRequestDto)
    {
        System.out.println("orderService 호출??");
        System.out.println(orderRequestDto.getOrderQuantity());
        System.out.println(orderRequestDto.getUserId());
        System.out.println(orderRequestDto.getItemId());
        return orderService.createOrder(orderRequestDto.getUserId(),
                orderRequestDto.getItemId(),
                orderRequestDto.getOrderQuantity()).getId();
    }

    // TODO : MVC2의 타입 컨버터를 공부해야 해결할 수 있는 문제
    @GetMapping
    public Page<OrderResponseDto> findOrdersByCondition(Pageable pageable, OrderSearch orderSearch)
    {

        Page<Order> allOrders = orderService.findAllOrders(pageable, orderSearch);
        System.out.println(allOrders);
     //   System.out.println(allOrders.getContent().get(0).getOrderItems().get(0).getItem().getItemName());
        return allOrders.map(p ->
                new OrderResponseDto(p.getId(),p.getOrderState(), p.getTotalOrderPrice(), p.getUser().getUsername(),
                        p.getOrderItems().stream().findFirst().orElse(null).getItem().getItemName(),
                        p.getOrderItems().stream().findFirst().orElse(null).getItem().getQuantity())
                        );
    }

    @DeleteMapping("/{id}")
    public String cancelOrder(@PathVariable("id") Long id) throws ClientInvalidInputException
    {
        // TODO : orderState를 cancel로 만들어주자
        // TODO : 개수 복원
        System.out.println("cancel order 호출!!!");
        orderService.cancelOrder(id);
        return "cancel success";
    }
}
