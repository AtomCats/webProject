package com.webProject.webProject;

import com.webProject.webProject.model.Product;
import com.webProject.webProject.service.ProductService;
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
	CommandLineRunner runner(ProductService productService) {
		return args -> {
			productService.save(new Product(1L,"Комод ХЭМНЭС", "Мебель",100.00,"https://www.ikea.com/ru/ru/images/products/hemnes-komod-s-asikami__0152646_PE311001_S4.JPG","https://www.ikea.com/ru/ru/catalog/products/10368432/"));
			productService.save(new Product(2L,"Стол кухонный ИНГАТОРП", "Мебель",100.00,"https://www.ikea.com/ru/ru/images/products/ingatorp-stol-c-otkidnymi-polami__0161883_PE317000_S4.JPG","https://www.ikea.com/ru/ru/catalog/products/90423104/"));
			productService.save(new Product(3L,"Тумба по тв ХЭМНЭС", "Мебель",100.00,"https://www.ikea.com/ru/ru/images/products/hemnes-tumba-pod-tv-koricnevyj__0583377_PE671187_S4.JPG","https://www.ikea.com/ru/ru/catalog/products/90413529/"));
		};
	}
}

