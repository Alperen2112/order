package com.switchfully.order.item;

import com.switchfully.order.customer.CustomerService;
import com.switchfully.order.customer.dtos.CustomerDto;
import com.switchfully.order.customer.dtos.RegisterCustomerDto;
import com.switchfully.order.item.dtos.AddItemDto;
import com.switchfully.order.item.dtos.ItemDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "items")
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ItemDto addItem (@RequestBody AddItemDto addItemDto) {
        return itemService.addItem(addItemDto);
    }

}
