package com.nikki.bank.configurations;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.BeanRegistrarDslMarker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }
}
