package project.finaltoyproject.policy;

import project.finaltoyproject.domain.money.Money;
import project.finaltoyproject.domain.order.Order;
import project.finaltoyproject.domain.user.Grade;
import project.finaltoyproject.domain.user.User;

public class FixedDiscountByGradePolicy implements DiscountPolicy{

    private static double BRONZE_DISCOUNT_RATE = 5.0 / 100.0;
    private static double SILVER_DISCOUNT_RATE = 10.0 / 100.0;
    private static double GOLD_DISCOUNT_RATE = 15.0 / 100.0;
    private static double VIP_DISCOUNT_RATE = 20.0 / 100.0;

    @Override
    public Money discount(User user, Money orderPrice) {

        Grade grade = user.getGrade();
        Money resultPrice = Money.ZERO;
        switch (grade){
            case BRONZE:
               // resultPrice =  orderPrice * BRONZE_DISCOUNT_RATE / 100;
                resultPrice = orderPrice.times(BRONZE_DISCOUNT_RATE);
                break;
            case SILVER:
                resultPrice = orderPrice.times(SILVER_DISCOUNT_RATE);
                break;
            case GOLD:
                resultPrice = orderPrice.times(GOLD_DISCOUNT_RATE);
                break;
            case VIP:
                resultPrice = orderPrice.times(VIP_DISCOUNT_RATE);
                break;
        }
        return resultPrice;

    }
}
