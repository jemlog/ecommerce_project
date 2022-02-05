package project.finaltoyproject.domain.item;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.finaltoyproject.domain.orderItem.OrderItem;
import project.finaltoyproject.util.BaseEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Item extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long id;

    private String itemName;

    private int quantity;

    private int price;





    @OneToMany(mappedBy = "item")
    private List<OrderItem> orderItemList = new ArrayList<>();
}
