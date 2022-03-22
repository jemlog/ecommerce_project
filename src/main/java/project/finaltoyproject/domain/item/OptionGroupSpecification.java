package project.finaltoyproject.domain.item;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.finaltoyproject.util.BaseEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OptionGroupSpecification extends BaseEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "option_group_spec_id")
    private Long id;

    // optionGroupName
    private String name;

    // 선택할 수 있는게 배타적인가?
    private boolean exclusive;

    // 기본 옵션이 지정되어 나오는가?
    private boolean basic;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "option_group_spec_id")
    private List<OptionSpecification> optionSpec;

    @Builder
    public OptionGroupSpecification(String name,boolean exclusive, boolean basic,List<OptionSpecification> options)
    {
        this.name = name;
        this.exclusive = exclusive;
        this.basic = basic;
        this.optionSpec = options;
    }

    public static OptionGroupSpecification basic(String name, boolean exclusive, OptionSpecification... options)
    {
        return new OptionGroupSpecification(name,exclusive,true, Arrays.asList(options));
    }

    public static OptionGroupSpecification additive(String name, boolean exclusive, OptionSpecification... options)
    {
        return new OptionGroupSpecification(name,exclusive,false,Arrays.asList(options));
    }


}
