package project.finaltoyproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
// 레디스의 사용 이유 -> 세션 클러스터링!
// spring:session:sessions:expires는 내가 설정한 값 : 레디스가 세션만료키를 만료하는 시간 -> 보통 이걸로 로그인 여부 판단
// spring:session:sessions에는 +5분 된 값이 세션키의 만료시간 -> 레디스가 세션키를 만료시키는 시간
// 5분이 추가된 이유 -> 세션이 만료되는 순간에도 세션키가 필요하기 때문에 세션키의 시간은 5분 연장했다!
//@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 60) // springboot 설정상 초단위 redis에는 밀리세컨트로 들어감
@EnableJpaAuditing                                         // 내가 1분으로 해도 redis의 session 만료 시간에는 +5분이 된다.
@SpringBootApplication
public class FinaltoyprojectApplication {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    public static void main(String[] args) {
        SpringApplication.run(FinaltoyprojectApplication.class, args);
    }


    /*
    @Override
    public void run(String... args) {
        Cart cart = new Cart(1L, 1L,
                        new CartLineItem(1L, "삼겹살 1인세트", 2,
                            new CartOptionGroup("기본",
                                    new CartOption("소(250g)", Money.wons(12000)))));

        orderService.placeOrder(cart);

        orderService.payOrder(1L);

        orderService.deliverOrder(1L);
    }
 */
}
