package com.tech.kj.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationConfig {

    @Bean
    //@LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
