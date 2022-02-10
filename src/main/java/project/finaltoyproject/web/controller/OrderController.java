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
        log.info("check={}",loginUser.getId());
        return orderService.createOrder(loginUser.getId(),
                orderRequestDto.getItemId(),
                orderRequestDto.getOrderQuantity()).getId();
    }

    @GetMapping
    public Page<OrderResponseDto> findOrdersByCondition(Pageable pageable, OrderSearch orderSearch)
    {
        Page<Order> allOrders = orderService.findAllOrders(pageable, orderSearch);
        System.out.println(allOrders.getContent().get(0).getOrderItems().get(0).getItem().getItemName());
        return allOrders.map(p ->
                new OrderResponseDto(p.getOrderState(), p.getTotalOrderPrice(), p.getUser().getUsername(),
                        p.getOrderItems().stream().findFirst().orElse(null).getItem().getItemName())
                        );
    }
}
