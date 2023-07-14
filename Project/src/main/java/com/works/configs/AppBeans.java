package com.works.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppBeans {

    @Bean
    public RestTemplate restTemplate() {
        System.out.println("restTemplate Call");
        return new RestTemplate();
    }

    @Bean(name = "rt_1")
    public RestTemplate restTemplate_1() {
        System.out.println("restTemplate Call");
        return new RestTemplate();
    }


}
