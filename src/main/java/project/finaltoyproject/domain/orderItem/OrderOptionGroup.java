package project.finaltoyproject.domain.orderItem;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.finaltoyproject.domain.money.Money;
import project.finaltoyproject.util.BaseEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderOptionGroup extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_option_group_id")
    private Long id;

    private String name;

    @ElementCollection
    @CollectionTable(name = "order_options",joinColumns = @JoinColumn(name = "order_option_group_id"))
    private List<OrderOption> orderOptions;

    public OrderOptionGroup(String name, List<OrderOption> options)
    {
        this.name = name;
        this.orderOptions = options;
    }

    public Money caculatePrice()
    {
        return Money.sum(orderOptions,OrderOption::getPrice);
    }

}
