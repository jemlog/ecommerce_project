package project.finaltoyproject.domain.order;

import lombok.*;
import project.finaltoyproject.domain.orderItem.OrderItem;
import project.finaltoyproject.domain.user.User;
import project.finaltoyproject.util.BaseEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Getter
@Table(name = "orders")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private OrderState orderState;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private int totalOrderPrice;

    private int totalOrderQuantity;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<>();

    public void addOrder(User user)
    {
        user.getOrderList().add(this);
        this.user = user;
    }


    public void addAllOrderPriceAndOrderQuantity(int orderPrice, int orderQuantity)
    {
        this.totalOrderPrice += orderPrice;
        this.totalOrderQuantity += orderQuantity;
    }

    public Order(OrderState orderState)
    {
        this.orderState = orderState;
    }


    public static Order createOrder(User user, OrderItem ...orderItems)
    {
        Order order = new Order(OrderState.SUCCESS); // orderState 넣어주는 법

        Arrays.stream(orderItems)  // 입력된 모든 orderItem들의 수량과 가격 합을 더해주는 연산
                .forEach(orderItem -> order.addAllOrderPriceAndOrderQuantity(orderItem.getOrderPrice(),
                        orderItem.getOrderQuantity()));

        order.addOrder(user); // user와 order의 연관관계 편의 메서드
        return order;
    }



}
