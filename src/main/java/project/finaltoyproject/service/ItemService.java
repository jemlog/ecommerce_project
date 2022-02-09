package project.finaltoyproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.finaltoyproject.domain.item.Item;
import project.finaltoyproject.domain.item.repository.ItemRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional
    public Item save(Item item)
    {
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
