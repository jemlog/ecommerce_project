package project.finaltoyproject.domain.order.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.finaltoyproject.domain.order.OrderState;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderResponseDto {

    private OrderState orderState;
    private Integer totalOrderPrice;
    private String username;
    private String itemName;
    private int remainQuantity;

    public OrderResponseDto(OrderState orderState, Integer totalOrderPrice, String username, String itemName, int remainQuantity) {
        this.orderState = orderState;
        this.totalOrderPrice = totalOrderPrice;
        this.username = username;
        this.itemName = itemName;
        this.remainQuantity = remainQuantity;
    }
}
