package com.example.productmanagement;

import com.example.productmanagement.controllers.ProductController;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductManagementApplicationTests {

	@Autowired
	ProductController productController;

	@Test
	void contextLoads() {
		assertThat(productController).isNotNull();

	}

}
