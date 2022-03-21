package project.finaltoyproject.domain.order.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.finaltoyproject.domain.orderItem.OrderOptionGroup;

import java.math.BigDecimal;
import java.util.List;

// 중첩 구조 받는 법
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderRequestDto {

    private Long userId;
    private Long itemId;
    private String name; // item 이름
    private int orderQuantity;
    private List<OrderOptionGroupDto> orderGroupsDto;

    @Data
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class OrderOptionGroupDto
    {
        private String name;
        private List<OrderOptionDto> orderOptionDto;
    }

    @Data
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class OrderOptionDto
    {
        private String name;
        private double price;
    }


}
