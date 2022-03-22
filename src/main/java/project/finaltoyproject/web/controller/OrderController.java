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
import retrofit2.http.Path;

import java.util.stream.Collectors;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;


    @PostMapping
    public Long createOrder(@RequestBody OrderRequestDto orderRequestDto)
    {
        return orderService.createOrder(orderRequestDto).getId();
    }

    @PostMapping("/{id}/pay")
    public String payOrder(@PathVariable("id") Long id)
    {
        orderService.payed(id);
        return "pay order success";
    }



    // TODO : MVC2의 타입 컨버터를 공부해야 해결할 수 있는 문제
    @GetMapping
    public Page<OrderResponseDto> findOrdersByCondition(Pageable pageable, OrderSearch orderSearch)
    {

        Page<Order> allOrders = orderService.findAllOrders(pageable, orderSearch);
        System.out.println(allOrders);

        return allOrders.map(p ->
                new OrderResponseDto(p.getId(),p.getOrderState(), p.getTotalMoney(), p.getUser().getUsername(),
                        p.getOrderItems().stream().map(o->new OrderResponseDto.OrderItemResponseDto(o.getName())).collect(Collectors.toList()))
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
