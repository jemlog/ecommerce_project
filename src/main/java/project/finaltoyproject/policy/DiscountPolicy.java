package project.finaltoyproject.policy;

import project.finaltoyproject.domain.money.Money;
import project.finaltoyproject.domain.order.Order;
import project.finaltoyproject.domain.user.User;

public interface DiscountPolicy {

    public Money discount(User user, Money orderPrice);

}
