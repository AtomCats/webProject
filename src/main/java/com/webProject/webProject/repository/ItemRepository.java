package com.webProject.webProject.repository;

import com.webProject.webProject.model.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Long> {}
}
