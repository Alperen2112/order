package com.switchfully.order.item;

import com.switchfully.order.item.dtos.AddItemDto;
import com.switchfully.order.item.dtos.ItemDto;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    private final ItemRepository itemRepository;
    private final ItemMapper mapper;

    public ItemService(ItemRepository itemRepository, ItemMapper mapper) {
        this.itemRepository = itemRepository;
        this.mapper = mapper;
    }

    public ItemDto addItem(AddItemDto addItemDto) {
        Item item = mapper.toItem(addItemDto);
        Item savedItem = itemRepository.addItem(item);

        return mapper.toDto(savedItem);
    }

}
