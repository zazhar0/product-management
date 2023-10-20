package com.example.productmanagement.beans;

import com.example.productmanagement.models.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomResponse {

    private String respMessage;
    private Product product;

    private List<Product> productsList;


    public String getRespMessage() {
        return respMessage;
    }

    public void setRespMessage(String respMessage) {
        this.respMessage = respMessage;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Product> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<Product> productsList) {
        this.productsList = productsList;
    }
}
