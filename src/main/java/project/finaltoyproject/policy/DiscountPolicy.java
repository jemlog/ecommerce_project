package project.finaltoyproject.policy;

import project.finaltoyproject.domain.order.Order;
import project.finaltoyproject.domain.user.User;

public interface DiscountPolicy {

    public int discount(User user, int orderPrice);

}
