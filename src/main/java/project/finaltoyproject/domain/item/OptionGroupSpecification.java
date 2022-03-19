package project.finaltoyproject.domain.item;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OptionGroupSpecification {


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
    private List<OptionSpecification> optionSpec = new ArrayList<>();

    @Builder
    public OptionGroupSpecification(Long id,String name,boolean exclusive, boolean basic, List<OptionSpecification> options)
    {
        this.id = id;
        this.name = name;
        this.exclusive = exclusive;
        this.basic = basic;
        this.optionSpec.addAll(options);
    }


}
