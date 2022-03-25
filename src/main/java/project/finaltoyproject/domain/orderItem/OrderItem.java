package project.finaltoyproject.domain.orderItem;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.finaltoyproject.domain.item.Item;
import project.finaltoyproject.domain.money.Money;
import project.finaltoyproject.domain.order.Order;
import project.finaltoyproject.domain.order.dto.OrderRequestDto;
import project.finaltoyproject.util.BaseEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class OrderItem extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_item_id")
    private Long id;

    // item의 name이다.
    private String name;


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

    public OrderItem(Item item,String itemName, int orderQuantity,List<OrderOptionGroup> orderOptionGroups)
    {
        this.name = itemName;
        this.orderQuantity = orderQuantity;
        this.item = item;
        this.optionGroups = orderOptionGroups;

    }

    public static OrderItem createOrderItem(OrderRequestDto orderRequestDto, Item item)
    {
        // 1. orderItem 생성할 예정
        OrderItem orderItem = new OrderItem(item, // 예시의 menu
                                            orderRequestDto.getName(), // itemName
                                            orderRequestDto.getOrderQuantity(),// 주문 수량
                                            orderRequestDto.getOrderGroupsDto().stream()
                                            .map(og-> new OrderOptionGroup(og.getName(),
                                                    og.getOrderOptionDto().stream().map(o-> new OrderOption(
                                                            o.getName(),
                                                            Money.wons(o.getPrice())))
                                                            .collect(Collectors.toList())
                                            ))
                                                    .collect(Collectors.toList())
                    );
      //  item.minusQuantity(orderRequestDto.getOrderQuantity());
        return orderItem;

    }

    public Money calculatePrice() {
        return Money.sum(optionGroups, OrderOptionGroup::caculatePrice).times(orderQuantity);
    }

}
