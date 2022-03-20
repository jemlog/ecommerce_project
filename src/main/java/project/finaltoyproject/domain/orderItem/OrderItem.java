package project.finaltoyproject.domain.orderItem;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.finaltoyproject.domain.item.Item;
import project.finaltoyproject.domain.order.Order;
import project.finaltoyproject.util.BaseEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class OrderItem extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_item_id")
    private Long id;

    private int orderPrice;

    private int orderQuantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_item_id")
    private List<OrderOptionGroup> optionGroups = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    public OrderItem(int orderPrice, int orderQuantity, Item item)
    {
        this.orderPrice = orderPrice;
        this.orderQuantity = orderQuantity;
        this.item = item;
    }

    public static OrderItem createOrderItem(int orderQauntity, Item item)
    {
        OrderItem orderItem = new OrderItem(item.getBasicPrice(),orderQauntity,item);
        item.minusQuantity(orderQauntity);
        return orderItem;

    }

}
