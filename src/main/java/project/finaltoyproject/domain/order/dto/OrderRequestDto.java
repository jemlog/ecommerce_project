package project.finaltoyproject.domain.order.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderRequestDto {

    private int orderQuantity;

    private Long itemId;
}
