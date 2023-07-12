package com.works.services;

import com.works.entities.Product;
import com.works.repositories.ProductRepository;
import com.works.utils.Rest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    final ProductRepository productRepository;

    public ResponseEntity save(Product product) {
        productRepository.save(product);
        return Rest.success(product);
    }

    public ResponseEntity allSave(List<Product> list) {
        productRepository.saveAll(list);
        return Rest.success(list);
    }

    public ResponseEntity list(Long cid, int pageCount) {
        Pageable page = PageRequest.of(pageCount,2);
        return Rest.success( productRepository.allProCat(cid, page) );
    }

}