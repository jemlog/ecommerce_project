package project.finaltoyproject.domain.orderItem;

import lombok.Getter;
import lombok.NoArgsConstructor;
import project.finaltoyproject.domain.item.Item;
import project.finaltoyproject.domain.order.Order;
import project.finaltoyproject.util.BaseEntity;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class OrderItem extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int orderPrice;

    private int orderQuantity;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;
}
