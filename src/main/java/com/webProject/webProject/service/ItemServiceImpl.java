package com.webProject.webProject.service;

import com.webProject.webProject.model.Item;
import com.webProject.webProject.repository.ItemRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {

    private ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Iterable<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public Item getItemById(long id) {
        return itemRepository.findById(id).get();
    }

    @Override
    public Item save(Item item) {
        return itemRepository.save(item);
    }
}
