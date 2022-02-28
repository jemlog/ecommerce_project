package project.finaltoyproject.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import project.finaltoyproject.domain.item.Item;
import project.finaltoyproject.domain.item.dto.ItemRequestDto;
import project.finaltoyproject.service.ItemService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;

    @PostMapping
    public Long createItem(@RequestBody ItemRequestDto itemRequestDto)
    {
        Item saveItem = itemService.save(new Item(itemRequestDto.getItemName(),
                itemRequestDto.getQuantity(),
                itemRequestDto.getPrice()));
        return saveItem.getId();
    }



}
