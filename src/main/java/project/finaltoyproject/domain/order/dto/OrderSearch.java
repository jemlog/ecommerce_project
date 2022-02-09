package project.finaltoyproject.domain.order.dto;

import lombok.Data;
import project.finaltoyproject.domain.order.OrderState;

@Data
public class OrderSearch {

    private OrderState orderState;

    private Integer totalPriceGoe;

    private Integer totalPriceLoe;

}
