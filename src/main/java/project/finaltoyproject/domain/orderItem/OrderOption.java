package project.finaltoyproject.domain.orderItem;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.finaltoyproject.domain.money.Money;

import javax.persistence.*;
import java.math.BigDecimal;

@Embeddable
@Getter
public class OrderOption{


    @Column(name="NAME")
    private String name;

    @Column(name = "PRICE")
    private Money price;

    public OrderOption() {
    }

    public OrderOption(String name, Money price)
    {
        this.name = name;
        this.price = price;
    }

}


