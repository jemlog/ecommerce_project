package project.finaltoyproject.domain.orderItem;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderOptionGroup {

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

}
