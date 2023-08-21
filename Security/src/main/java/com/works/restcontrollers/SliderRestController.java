package com.works.restcontrollers;

import com.works.entities.Product;
import com.works.entities.Slider;
import com.works.services.ProductService;
import com.works.services.SliderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/slider")
@RequiredArgsConstructor
public class SliderRestController {

    final SliderService sliderService;

    @PostMapping("/save")

    public ResponseEntity save(@RequestBody Slider slider) {
        return sliderService.save(slider);
    }

    @GetMapping("/list")
    public ResponseEntity list() {
        return sliderService.list();
    }

}
