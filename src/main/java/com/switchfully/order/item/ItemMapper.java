package com.switchfully.order.item;

import com.switchfully.order.item.dtos.AddItemDto;
import com.switchfully.order.item.dtos.ItemDto;
import org.springframework.stereotype.Component;

@Component
public class ItemMapper {


    public Item toItem(AddItemDto addItemDto) {
        return new Item(
                addItemDto.getName(),
                addItemDto.getDescription(),
                addItemDto.getPrice(),
                addItemDto.getAmount());

    }

    public ItemDto toDto(Item savedItem) {
        return new ItemDto(
                savedItem.getId(),
                savedItem.getName(),
                savedItem.getDescription(),
                savedItem.getPrice(),
                savedItem.getAmount());
    }
}
