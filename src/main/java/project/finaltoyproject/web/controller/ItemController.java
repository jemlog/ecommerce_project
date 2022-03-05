package project.finaltoyproject.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import project.finaltoyproject.domain.item.Item;
import project.finaltoyproject.domain.item.dto.ItemRequestDto;
import project.finaltoyproject.domain.item.dto.ItemResponseDto;
import project.finaltoyproject.service.ItemService;

import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping
    public List<ItemResponseDto> findAllItems()
    {
        List<Item> allItems = itemService.findAllItems();
        List<ItemResponseDto> result = allItems.stream().map(i -> new ItemResponseDto(i.getItemName(), i.getQuantity(), i.getPrice()))
                .collect(Collectors.toList());
        return result;
    }



}
