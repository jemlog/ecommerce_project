package project.finaltoyproject.policy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import project.finaltoyproject.domain.user.Grade;
import project.finaltoyproject.domain.user.User;
import project.finaltoyproject.service.OrderService;

import static org.junit.jupiter.api.Assertions.*;

class FixedDiscountByGradePolicyTest {


//    @Test
//    @DisplayName("고객 등급 silver일때 할인률 10퍼")
//    public void 고객의_등급이_SILVER일때_할인률은_10프로이다()
//    {
//        User user = new User(Grade.SILVER);
//        FixedDiscountByGradePolicy fixedDiscountByGradePolicy = new FixedDiscountByGradePolicy();
//        int discount = fixedDiscountByGradePolicy.discount(user, 10000);
//        Assertions.assertThat(discount).isEqualTo(1000);
//
//    }
//
//    @Test
//    @DisplayName("고객 등급 GOLD일때 할인률 15퍼")
//    public void 고객의_등급이_GOLD일때_할인률은_15프로이다()
//    {
//        User user = new User(Grade.GOLD);
//        FixedDiscountByGradePolicy fixedDiscountByGradePolicy = new FixedDiscountByGradePolicy();
//        int discount = fixedDiscountByGradePolicy.discount(user, 10000);
//        Assertions.assertThat(discount).isEqualTo(1500);
//
//    }


}