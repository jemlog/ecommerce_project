package project.finaltoyproject.domain.item.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class ItemRequestDto {

    // 옵션 그룹과 옵션은 여러개가 들어올 수 있다. 그거 고려해서 DTO 작성해야 함!


    private String itemName;
    private int quantity;
    private List<OptionGroupSpecDto> optionGroupDto;

    @Data
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class OptionGroupSpecDto
    {
      private String name;
      private boolean exclusive;
      private boolean basic;
      private List<OptionSpecDto> optionDto;
    }

    @Data
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class OptionSpecDto
    {
        private String name;
        private int optionPrice;
    }

    private MultipartFile imgfile;
}
