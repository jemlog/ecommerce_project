package project.finaltoyproject.domain.order.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.finaltoyproject.domain.order.OrderState;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderResponseDto {
    private Long orderId;
    private OrderState orderState;
    private double totalOrderPrice;
    private String username;
    private List<OrderItemResponseDto> orderItemResponseDtos;



    public OrderResponseDto(Long orderId, OrderState orderState, double totalOrderPrice, String username,List<OrderItemResponseDto> orderItemResponseDtos) {
        this.orderId = orderId;
        this.orderState = orderState;
        this.totalOrderPrice = totalOrderPrice;
        this.username = username;
        this.orderItemResponseDtos = orderItemResponseDtos;
    }

    @Data
    public static class OrderItemResponseDto{
        private String itemName;

        public OrderItemResponseDto(String itemName)
        {
            this.itemName = itemName;
        }



    }
}
