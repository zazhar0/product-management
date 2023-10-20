package com.example.productmanagement.services;


import com.example.productmanagement.models.Product;
import com.example.productmanagement.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {


    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public Product insertProduct(Product product) throws Exception {

        if (product.getProductId() <= 0) {
            throw new Exception("Invalid Product Id");
        } else if (productRepository.findById(product.getProductId()).isPresent()){
            throw new Exception("Product Already Exists");
    }
        return productRepository.save(product);

    }


    @Transactional
    public void deleteProduct(Product product) throws Exception {
        if (productRepository.findById(product.getProductId()).isEmpty()) {
            throw new Exception("Product Not Present");
        }
        productRepository.deleteById(product.getProductId());
    }



}
