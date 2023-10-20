package com.example.productmanagement.controllers;


import com.example.productmanagement.beans.CustomResponse;
import com.example.productmanagement.models.Product;
import com.example.productmanagement.services.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(ProductController.class)
public class ProductControllerTest {


    @MockBean
    ProductService productService;
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private Product product;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private CustomResponse customResponse;

    @MockBean
    private List<Product> productsList;


    @BeforeEach
    private void setup() throws Exception {
        when(product.getProductId()).thenReturn(1);
        when(product.getProductName()).thenReturn("testMockProd");
        when(product.getPrice()).thenReturn(120D);
        when(product.getQuantity()).thenReturn(12);

        when(productService.insertProduct(any(Product.class))).thenReturn(product);
        when(customResponse.getRespMessage()).thenReturn("Product Deleted SuccessFully");
        when(customResponse.getProduct()).thenReturn(product);


    }

    @Test
    public void addProductTest() throws Exception {

        String requestBody = objectMapper.writeValueAsString(product);
        String responseBody = objectMapper.writeValueAsString(customResponse);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/products/add")
                        .contentType(MediaType.APPLICATION_JSON).content(requestBody)
                )
                .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON)).andExpect(
                        jsonPath("$.product.productName").value("testMockProd")
                );


    }


    @Test
    public void deleteProductTest() throws Exception {

        String requestBody = objectMapper.writeValueAsString(product);
        String responseBody = objectMapper.writeValueAsString(customResponse);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/products/add")
                        .contentType(MediaType.APPLICATION_JSON).content(requestBody)
                )
                .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON)).andExpect(
                        jsonPath("$.respMessage").value("Product Deleted SuccessFully")
                ).andExpect(jsonPath("$.product.productId").value(1));


    }


}
