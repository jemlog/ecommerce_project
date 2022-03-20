package project.finaltoyproject.domain.orderItem;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderOption {

    private String name;

    private int price;

    public OrderOption(String name, int price)
    {
        this.name = name;
        this.price = price;
    }

}


