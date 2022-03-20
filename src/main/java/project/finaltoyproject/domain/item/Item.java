package project.finaltoyproject.domain.item;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.finaltoyproject.domain.orderItem.OrderItem;
import project.finaltoyproject.util.BaseEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Item extends BaseEntity {

    // TODO : ITEM의 PRICE를 OPTION의 PRICE로 변경

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long id;

    private String itemName;

    private int quantity;

    private String s3ImagePath;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "item_id")
    private List<OptionGroupSpecification> optGroupSpecs = new ArrayList<>();

    public void minusQuantity(int quantity)
    {
        this.quantity -= quantity;
        if(this.quantity < 0){
            throw new IllegalStateException("개수가 0개 이하로 내려가면 안됩니다");
        }
    }

    public void addQuantity(int quantity)
    {
        this.quantity += quantity;
    }



    @Builder
    public Item(String itemName,int quantity, String s3ImagePath, OptionGroupSpecification basic)
    {
        this.itemName = itemName;
        this.quantity = quantity;
        this.s3ImagePath = s3ImagePath;
        // 기본 가격은 basic한 옵션 고정으로 들어간다.
        this.optGroupSpecs.add(basic);

    }

    // 가격이 기본 속성으로 들어가있다.
    // 그러므로 여러 optionSpec들 중 basic이라 되있는걸 찾아야 한다.
    public OptionGroupSpecification getBasicOptionGroupSpec()
    {
        return optGroupSpecs.stream().filter(o->o.isBasic())
                .findFirst().orElseThrow(IllegalStateException::new);
    }

    // basic은 어차피 하나 , get(0)으로 처음 option 가져온 후 price를 가져오자.
    public int getBasicPrice()
    {
        return getBasicOptionGroupSpec().getOptionSpec().get(0).getPrice();
    }





}
