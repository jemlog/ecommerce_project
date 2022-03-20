package project.finaltoyproject.domain.item.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class ItemRequestDto {

    // 옵션 그룹과 옵션은 여러개가 들어올 수 있다. 그거 고려해서 DTO 작성해야 함!


    private String itemName;
    private int quantity;
    private String optionGroupName;
    private String optionName;
    private int optionPrice;
    private boolean exclusive;  // 배타 선택 경우
    private boolean basic;  // 기본적으로 선택 되어져 있는 경우
    private MultipartFile imgfile;
}
