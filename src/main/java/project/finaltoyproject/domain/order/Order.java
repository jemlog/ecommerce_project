package project.finaltoyproject.domain.order;

import lombok.*;
import project.finaltoyproject.domain.money.Money;
import project.finaltoyproject.domain.orderItem.OrderItem;
import project.finaltoyproject.domain.user.User;
import project.finaltoyproject.util.BaseEntity;

import javax.persistence.*;
import java.math.BigDecimal;
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

    // 할인 적용하기 위한 전체 가격
    @Column(nullable = true)
    private double totalMoney;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;


    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();

    public Order(OrderState orderState)
    {
        this.orderState = orderState;
    }

    public void addUser(User user)
    {
        user.getOrderList().add(this);
        this.user = user;
    }

    public void addOrderItem(OrderItem orderItem)
    {
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }

    // 주문 취소 시, CANCEL로 상태 변경
    public void cancelOrder()
    {
        this.orderState = OrderState.CANCEL;
        // 지금 로그인한 유저의 총 결제 가격에서 빼는 로직
        this.getUser().minusTotalOrderPriceForGrade(totalMoney);
    }

    public void place()
    {
        ordered();
    }

    public void ordered()
    {
        this.orderState = OrderState.ORDERED;
    }
    public static Order createOrder(User user, OrderItem ...orderItems)
    {
        Order order = new Order();

        for (OrderItem orderItem : orderItems) {
            order.addOrderItem(orderItem);
        }
        order.addUser(user); // user와 order의 연관관계 편의 메서드
        return order;
    }

    public void payedOrder()
    {
        this.orderState = OrderState.PAYED;
    }


    // 여기서 사용자 등급에 따른 할인 적용을 해줘야 한다.
    public Money calculateTotalPrice() {
        return Money.sum(orderItems, OrderItem::calculatePrice);
    }

    public void setTotalMoney(Money discountPrice)
    {
        Money finalMoney = calculateTotalPrice();
        double amount = finalMoney.minus(discountPrice).doubleValue();
        totalMoney = amount;
    }


}
