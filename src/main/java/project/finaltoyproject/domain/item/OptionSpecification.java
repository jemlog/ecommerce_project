package project.finaltoyproject.domain.item;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Configuration;
import project.finaltoyproject.domain.money.Money;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


// item -> optionGroup -> option

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OptionSpecification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "option_spec_id")
    private Long id;

    private String name;

    // 사은품 추가 시 가격
    private int price;

    public OptionSpecification(String name, int price)
    {
        this.name = name;
        this.price = price;
    }
    // 코딩은 특히 무언가를 공부할때 동기가 꼭 있어야 한다.
    // 나는 지금 주문 도메인을 더 잘 짜고 싶다.
    // 거기에 enum으로 더 깔끔하게 작성하고 싶다.
    // 테스트 코드도 더 잘 짜고 싶어, 웬만하면 jacoco라는 것을 써서 테스트도 잘하고 싶다.
    // 그럭저럭들 사이에서 두각을 드러내려면 테스트 코드 작성을 의무화 해야 한다.
    // 협업을 잘 하기 위해서는 git과 github를 잘 다뤄야 한다.




}
