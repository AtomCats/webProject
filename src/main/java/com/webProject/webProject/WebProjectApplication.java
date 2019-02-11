package com.webProject.webProject;

import com.webProject.webProject.model.Item;
import com.webProject.webProject.service.ItemService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WebProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebProjectApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(ItemService itemService) {
		return args -> {
			itemService.save(new Item("Комод ХЭМНЭС", "Мебель","https://www.ikea.com/ru/ru/images/products/hemnes-komod-s-asikami__0152646_PE311001_S4.JPG","https://www.ikea.com/ru/ru/catalog/products/10368432/"));
			itemService.save(new Item("Стол кухонный ИНГАТОРП", "Мебель","https://www.ikea.com/ru/ru/images/products/ingatorp-stol-c-otkidnymi-polami__0161883_PE317000_S4.JPG","https://www.ikea.com/ru/ru/catalog/products/90423104/"));
			itemService.save(new Item("Тумба по тв ХЭМНЭС", "Мебель","https://www.ikea.com/ru/ru/images/products/hemnes-tumba-pod-tv-koricnevyj__0583377_PE671187_S4.JPG","https://www.ikea.com/ru/ru/catalog/products/90413529/"));
		};
	}
}

