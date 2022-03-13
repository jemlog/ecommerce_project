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

    @OneToMany(mappedBy = "order",cascade = CascadeType.PERSIST)
    private List<OrderItem> orderItems = new ArrayList<>();

    public void addUser(User user)
    {
        user.getOrderList().add(this);
        this.user = user;
    }


    public void addAllOrderPriceAndOrderQuantity(int orderPrice, int orderQuantity)
    {
        this.totalOrderPrice += orderQuantity * orderPrice;
        this.totalOrderQuantity += orderQuantity;
    }

    public void cancelOrder()
    {
       this.orderState = OrderState.CANCEL;
       this.orderItems.stream().forEach(o-> o.getItem().addQuantity(totalOrderQuantity));
       this.getUser().minusTotalOrderPriceForGrade(totalOrderPrice);
    }

    public void discountOrderPrice(int discountPrice)
    {
        this.totalOrderPrice -= discountPrice;
    }



    public Order(OrderState orderState)
    {
        this.orderState = orderState;
    }

    public void addOrderItem(OrderItem orderItem)
    {
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }

    public static Order createOrder(User user, OrderItem ...orderItems)
    {
        Order order = new Order(OrderState.SUCCESS); // orderState 넣어주는 법

        /*
        먼저 모든 아이템들의 수량을 다 더한뒤에 최종적으로 등급에 따라 가격 할인을 해줘야 한다.
         */
        Arrays.stream(orderItems)  // 입력된 모든 orderItem들의 수량과 가격 합을 더해주는 연산
                .forEach(orderItem -> order.addAllOrderPriceAndOrderQuantity(orderItem.getOrderPrice(),
                        orderItem.getOrderQuantity()));






        for (OrderItem orderItem : orderItems) {
            order.addOrderItem(orderItem);
        }
        order.addUser(user); // user와 order의 연관관계 편의 메서드
        return order;
    }



}
