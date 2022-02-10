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
import project.finaltoyproject.domain.user.dto.LoginDto;
import project.finaltoyproject.service.OrderService;
import project.finaltoyproject.util.exeption.ClientInvalidInputException;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public Long createOrder(@Login User loginUser, @RequestBody OrderRequestDto orderRequestDto)
    {

        return orderService.createOrder(loginUser.getId(),
                orderRequestDto.getItemId(),
                orderRequestDto.getOrderQuantity()).getId();
    }

    // TODO : MVC2의 타입 컨버터를 공부해야 해결할 수 있는 문제
    @GetMapping
    public Page<OrderResponseDto> findOrdersByCondition(Pageable pageable, OrderSearch orderSearch)
    {

        Page<Order> allOrders = orderService.findAllOrders(pageable, orderSearch);
        System.out.println(allOrders.getContent().get(0).getOrderItems().get(0).getItem().getItemName());
        return allOrders.map(p ->
                new OrderResponseDto(p.getOrderState(), p.getTotalOrderPrice(), p.getUser().getUsername(),
                        p.getOrderItems().stream().findFirst().orElse(null).getItem().getItemName(),
                        p.getOrderItems().stream().findFirst().orElse(null).getItem().getQuantity())
                        );
    }

    @GetMapping("/{id}/cancel")
    public String cancelOrder(@PathVariable("id") Long id) throws ClientInvalidInputException
    {
        // TODO : orderState를 cancel로 만들어주자
        // TODO : 개수 복원
        orderService.cancelOrder(id);
        return "cancel success";
    }
}
