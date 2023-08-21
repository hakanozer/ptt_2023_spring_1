package com.works.services;

import com.works.entities.Product;
import com.works.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    final ProductRepository productRepository;

    public ResponseEntity save(Product product) {
        try {
            productRepository.save(product);
            return new ResponseEntity(product, HttpStatus.OK);
        }catch (Exception ex) {
            return new ResponseEntity("Insert Fail", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity list()  {
        List<Product> productList = productRepository.findAll();
        return new ResponseEntity(productList, HttpStatus.OK);
    }

}
