package project.finaltoyproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.finaltoyproject.domain.item.Item;
import project.finaltoyproject.domain.item.OptionGroupSpecification;
import project.finaltoyproject.domain.item.OptionSpecification;
import project.finaltoyproject.domain.item.dto.ItemRequestDto;
import project.finaltoyproject.domain.item.repository.ItemRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional
    public Item saveItemAndOptions(ItemRequestDto itemRequestDto,String path)
    {
        Item item = new Item(itemRequestDto.getItemName(),
                itemRequestDto.getQuantity(),
                path,
                itemRequestDto.getOptionGroupDto()
                        .stream()
                        .map(i -> new OptionGroupSpecification(
                                i.getName(),
                                i.isExclusive(),
                                i.isBasic(),
                                i.getOptionDto()
                                        .stream()
                                        .map(o -> new OptionSpecification(
                                                o.getName(),
                                                o.getOptionPrice()))
                                        .collect(Collectors.toList())))
                        .collect(Collectors.toList()));

        return itemRepository.save(item);


    }

    public Item findById(Long itemId)
    {
        Optional<Item> item = itemRepository.findById(itemId);
        return item.orElse(null);

    }

    public List<Item> findAllItems()
    {
        return itemRepository.findAll();
    }

    @Transactional
    public void delete(Long itemId)
    {
        Item item = itemRepository.findById(itemId)
                .orElseThrow(()->new IllegalStateException("잘못된 아이디 입니다"));
        itemRepository.delete(item);

    }

}
