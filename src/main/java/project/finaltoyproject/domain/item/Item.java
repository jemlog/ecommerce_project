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

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long id;

    private String itemName;

    private int quantity;

    private int price;

    private String s3ImagePath;

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
    public Item(String itemName,int quantity,int price,String s3ImagePath)
    {
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
        this.s3ImagePath = s3ImagePath;
    }




}
