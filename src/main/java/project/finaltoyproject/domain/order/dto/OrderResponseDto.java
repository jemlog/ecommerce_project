package project.finaltoyproject.domain.order.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.finaltoyproject.domain.order.OrderState;

import java.math.BigDecimal;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderResponseDto {
    private Long orderId;
    private OrderState orderState;
    private double totalOrderPrice;
    private String username;
    private String itemName;
    private int remainQuantity;

    public OrderResponseDto(Long orderId, OrderState orderState, double totalOrderPrice, String username, String itemName, int remainQuantity) {
        this.orderId = orderId;
        this.orderState = orderState;
        this.totalOrderPrice = totalOrderPrice;
        this.username = username;
        this.itemName = itemName;
        this.remainQuantity = remainQuantity;
    }
}
