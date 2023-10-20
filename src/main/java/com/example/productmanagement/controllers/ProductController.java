package com.example.productmanagement.controllers;

import com.example.productmanagement.beans.CustomResponse;
import com.example.productmanagement.models.Product;
import com.example.productmanagement.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/products/")
public class ProductController {

    @Autowired
    ProductService productService;
    @Autowired
    CustomResponse customResponse;

    @PostMapping(value = "add")
    public ResponseEntity<CustomResponse> addProduct(@RequestBody @NonNull Product product) {
        try {
            productService.insertProduct(product);
            customResponse.setRespMessage("Success");
            customResponse.setProduct(product);
        }
        catch (Exception e) {
            customResponse.setRespMessage("Following Error Occured while inserting product: " + e.getMessage());
            customResponse.setProduct(product);
            return new ResponseEntity(customResponse, HttpStatus.PRECONDITION_FAILED);
        }


        return ResponseEntity.ok(customResponse);
    }


    @PostMapping(value = "delete")
    public ResponseEntity<CustomResponse> deleteProduct(@RequestBody @NonNull Product product) {
        try {
            productService.deleteProduct(product);
            customResponse.setRespMessage("Product deleted Successfully");
            customResponse.setProduct(product);
        }
        catch (Exception e) {
            customResponse.setRespMessage("Following Error Occured while deleting product: " + e.getMessage());
            customResponse.setProduct(product);
            return new ResponseEntity(customResponse, HttpStatus.PRECONDITION_FAILED);
        }


        return ResponseEntity.ok(customResponse);
    }





}
