package com.webProject.webProject.service;

import com.webProject.webProject.model.Item;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Validated
public interface ItemService {
    @NotNull Iterable<Item> getAllItems();
    Item getItemById(@Min(value = 1L, message = "Invalid product ID.") long id);
    Item save(@NotNull @Valid Item item);
}
