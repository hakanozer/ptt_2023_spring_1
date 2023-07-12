package com.works.restcontrollers;

import com.works.entities.Product;
import com.works.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductRestController {

    final ProductService productService;

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Product product) {
        return productService.save(product);
    }

    @PostMapping("/allSave")
    public ResponseEntity allSave(@RequestBody List<Product> products) {
        return productService.allSave(products);
    }

    @GetMapping("/list/{cid}")
    public ResponseEntity list(
            @PathVariable Long cid,
            @RequestParam(defaultValue = "0") int pageCount,
            @RequestParam(defaultValue = "asc") String sortType
    ) {
        return productService.list(cid, pageCount, sortType);
    }

}
