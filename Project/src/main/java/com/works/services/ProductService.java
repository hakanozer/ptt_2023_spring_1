package com.works.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.works.entities.Product;
import com.works.models.DummyProducts;
import com.works.models.DummyProduct;
import com.works.repositories.ProductRepository;
import com.works.utils.Rest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    final ProductRepository productRepository;
    final RestTemplate restTemplate;
    final ObjectMapper objectMapper;

    public ResponseEntity save(Product product) {
        productRepository.save(product);
        return Rest.success(product);
    }

    public ResponseEntity allSave(List<Product> list) {
        productRepository.saveAll(list);
        return Rest.success(list);
    }

    public ResponseEntity list(Long cid, int pageCount, String sortType) {
        Sort sort = Sort.by("price").ascending();
        if ( sortType.equals("desc")) {
            sort = Sort.by("price").descending();
        }
        Pageable page = PageRequest.of(pageCount,2, sort);
        return Rest.success( productRepository.allProCat(cid, page) );
    }

    // Dummy DummyProduct
    public List<DummyProduct> dummyProduct() {
        String url = "https://dummyjson.com/products";
        DummyProducts stData = restTemplate.getForObject(url, DummyProducts.class);
        return stData.getProducts();
    }

    public DummyProduct dummSave( DummyProduct dummyProduct ) {
        String url = "https://dummyjson.com/products/add";
        String sendata = "";
        try {
            sendata = objectMapper.writeValueAsString(dummyProduct);
        }catch (Exception ex) {}

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity httpEntity = new HttpEntity(sendata, headers);

        ResponseEntity<DummyProduct> entity = restTemplate.postForEntity(url, httpEntity, DummyProduct.class );

        return entity.getBody();
    }

}
