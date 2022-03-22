package project.finaltoyproject.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "order controller",description = "주문 관리 컨트롤러입니다.")
@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;


    @Operation(summary = "주문 생성",description = "주문 상품, 옵션 그룹, 옵션을 기반으로 주문 생성")
    @PostMapping
    public Long createOrder(@RequestBody OrderRequestDto orderRequestDto)
    {
        return orderService.createOrder(orderRequestDto).getId();
    }


    @Operation(summary = "결제 진행")
    @PostMapping("/{id}/pay")
    public String payOrder(@PathVariable("id") Long id)
    {
        orderService.payed(id);
        return "pay order success";
    }

    @Operation(summary = "주문 조회")
    @GetMapping
    public Page<OrderResponseDto> findOrdersByCondition(Pageable pageable, OrderSearch orderSearch) {

        Page<Order> allOrders = orderService.findAllOrders(pageable, orderSearch);

        return allOrders.map(p ->
                new OrderResponseDto(p.getId(),p.getOrderState(), p.getTotalMoney(), p.getUser().getUsername(),
                        p.getOrderItems().stream().map(o->new OrderResponseDto.OrderItemResponseDto(o.getName())).collect(Collectors.toList()))
                        );
    }

    @Operation(summary = "주문 취소")
    @DeleteMapping("/{id}")
    public String cancelOrder(@PathVariable("id") Long id) throws ClientInvalidInputException
    {
        orderService.cancelOrder(id);
        return "cancel success";
    }
}
