package com.example.productmanagement.product;


import com.example.productmanagement.models.Product;
import com.example.productmanagement.services.ProductService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
public class ProductTests {

    @Autowired
    ProductService productService;

    @Test
    public void productTest() throws Exception {
        Product product = new Product();
        product.setProductId(1);
        product.setProductName("testProd");
        product.setPrice(1);
        product.setQuantity(1);
        Assert.notNull(productService.insertProduct(product), "product cannot be null");

    }




}
