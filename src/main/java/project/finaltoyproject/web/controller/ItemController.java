package project.finaltoyproject.web.controller;

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
@RequiredArgsConstructor
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;
    private final S3Uploader s3Uploader;
    @PostMapping
    public Long createItem(@ModelAttribute ItemRequestDto itemRequestDto) throws IOException {
        String path = s3Uploader.upload(itemRequestDto.getImgfile(),"static");

        Item saveItem = itemService.save(new Item(itemRequestDto.getItemName(),
                itemRequestDto.getQuantity(),
                itemRequestDto.getPrice(),path));
        return saveItem.getId();
    }



    @GetMapping
    public List<ItemResponseDto> findAllItems()
    {
        List<Item> allItems = itemService.findAllItems();
        List<ItemResponseDto> result = allItems.stream().map(i -> new ItemResponseDto(i.getId(),i.getItemName(), i.getQuantity(), i.getPrice(),i.getS3ImagePath()))
                .collect(Collectors.toList());
        return result;
    }

    @DeleteMapping("/{id}")
    public String deleteItem(@PathVariable("id") Long id)
    {
        itemService.delete(id);
        return "success";

    }




}
