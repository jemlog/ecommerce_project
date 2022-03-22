package project.finaltoyproject.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import project.finaltoyproject.domain.item.Item;
import project.finaltoyproject.domain.item.dto.ItemRequestDto;
import project.finaltoyproject.domain.item.dto.ItemResponseDto;
import project.finaltoyproject.service.ItemService;
import project.finaltoyproject.service.S3Uploader;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Tag(name = "상품 관리 컨트롤러입니다.")
@RequiredArgsConstructor
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;
    private final S3Uploader s3Uploader;

    @Operation(summary = "상품 등록",description = "S3를 통한 이미지 업로드와 FormData 전송")
    @PostMapping
    public Long createItem(@ModelAttribute ItemRequestDto itemRequestDto) throws IOException {

        String path = s3Uploader.upload(itemRequestDto.getImgfile(),"static");

        Item saveItem = itemService.saveItemAndOptions(itemRequestDto,path);
        return saveItem.getId();
    }


    @Operation(summary = "상품 조회")
    @GetMapping
    public List<ItemResponseDto> findAllItems()
    {
        List<Item> allItems = itemService.findAllItems();
        return allItems.stream()
                .map(i -> new ItemResponseDto(i.getId(),i.getItemName(), i.getQuantity(), i.getBasicPrice(),i.getS3ImagePath()))
                .collect(Collectors.toList());

    }

    @Operation(summary = "상품 삭제")
    @DeleteMapping("/{id}")
    public String deleteItem(@PathVariable("id") Long id)
    {
        itemService.delete(id);
        return "item delete success";

    }




}
