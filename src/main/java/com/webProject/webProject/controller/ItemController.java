package com.webProject.webProject.controller;

import com.webProject.webProject.model.Item;
import com.webProject.webProject.service.ItemService;
import com.webProject.webProject.service.ItemServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/items")
public class ItemController {
    private ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping(value = {"", ""})
    public @NotNull Iterable<Item> getItrems() {
        return itemService.getAllItems();
    }
}
