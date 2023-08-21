package com.works.services;

import com.works.entities.Product;
import com.works.entities.Slider;
import com.works.repositories.ProductRepository;
import com.works.repositories.SliderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SliderService {

    final SliderRepository sliderRepository;

    public ResponseEntity save(Slider slider) {
        try {
            sliderRepository.save(slider);
            return new ResponseEntity(slider, HttpStatus.OK);
        }catch (Exception ex) {
            return new ResponseEntity("Insert Fail", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity list()  {
        List<Slider> productList = sliderRepository.findAll();
        return new ResponseEntity(productList, HttpStatus.OK);
    }

}
