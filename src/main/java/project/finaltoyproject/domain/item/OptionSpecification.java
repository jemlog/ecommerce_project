package project.finaltoyproject.domain.item;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Configuration;
import project.finaltoyproject.domain.money.Money;
import project.finaltoyproject.util.BaseEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;



@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OptionSpecification extends BaseEntity {

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





}
