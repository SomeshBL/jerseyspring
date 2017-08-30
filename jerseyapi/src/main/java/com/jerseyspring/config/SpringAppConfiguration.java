package com.jerseyspring.config;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.jerseyspring.service.header.HeaderService;
import com.jerseyspring.service.header.HeaderServiceImpl;

/**
 * 
 * @author sk
 *
 */
@Component
@Configuration
@ComponentScan(basePackages = {"com.jerseyspring.config","com.jerseyspring.filter", "com.jerseyspring.json",
		"com.jerseyspring.service","com.jerseyspring.api"})
public class SpringAppConfiguration {
    
    @Configuration
    //@Profile("production")
    static class HeaderServiceConfiguration {
        
        @Bean
        public HeaderService headerService() {
            return new HeaderServiceImpl();
        }
    }
    
    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        return mapper;
    }

    @Bean
    public BeanPostProcessor validationPostProcessor() {
        return new MethodValidationPostProcessor();
    }
}
