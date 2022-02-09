package project.finaltoyproject.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import project.finaltoyproject.domain.order.Order;
import project.finaltoyproject.domain.order.dto.OrderRequestDto;
import project.finaltoyproject.domain.order.dto.OrderResponseDto;
import project.finaltoyproject.domain.order.dto.OrderSearch;
import project.finaltoyproject.domain.user.dto.LoginDto;
import project.finaltoyproject.service.OrderService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public Order createOrder(@Login LoginDto loginDto, OrderRequestDto orderRequestDto)
    {
        return orderService.createOrder(loginDto.getId(),
                orderRequestDto.getItemId(),
                orderRequestDto.getOrderQuantity());
    }

    @GetMapping
    public Page<OrderResponseDto> findOrdersByCondition(Pageable pageable, OrderSearch orderSearch)
    {
        Page<Order> allOrders = orderService.findAllOrders(pageable, orderSearch);
        return allOrders.map(p ->
                new OrderResponseDto(p.getOrderState(), p.getTotalOrderPrice(), p.getUser().getUsername()));
    }
}
