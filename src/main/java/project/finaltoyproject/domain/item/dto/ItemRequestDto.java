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
    private String itemName;
    private int quantity;
    private int price;
    private MultipartFile imgfile;
}
