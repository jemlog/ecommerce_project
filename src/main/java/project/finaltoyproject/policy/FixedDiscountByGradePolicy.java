package project.finaltoyproject.policy;

import project.finaltoyproject.domain.order.Order;
import project.finaltoyproject.domain.user.Grade;
import project.finaltoyproject.domain.user.User;

public class FixedDiscountByGradePolicy implements DiscountPolicy{

    private static int BRONZE_DISCOUNT_RATE = 5;
    private static int SILVER_DISCOUNT_RATE = 10;
    private static int GOLD_DISCOUNT_RATE = 15;
    private static int VIP_DISCOUNT_RATE = 20;

    @Override
    public int discount(User user, int orderPrice) {

        Grade grade = user.getGrade();
        int resultPrice = 0;
        switch (grade){
            case BRONZE:
                resultPrice =  orderPrice * BRONZE_DISCOUNT_RATE / 100;
                break;
            case SILVER:
                resultPrice = orderPrice * SILVER_DISCOUNT_RATE / 100;
                break;
            case GOLD:
                resultPrice = orderPrice * GOLD_DISCOUNT_RATE / 100;
                break;
            case VIP:
                resultPrice = orderPrice * VIP_DISCOUNT_RATE / 100;
                break;
        }
        return resultPrice;

    }
}
