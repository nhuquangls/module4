package com.example.thuchanh.config;

import com.example.thuchanh.dto.OrderDTO;
import com.example.thuchanh.dto.ProductDTO;
import com.example.thuchanh.entity.Order;
import com.example.thuchanh.entity.Product;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean
    public ModelMapper modelMapper(){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.typeMap(OrderDTO.class, Order.class).addMappings(mapper -> {
            mapper.skip(Order::setId);
        });
        modelMapper.typeMap(ProductDTO.class, Product.class).addMappings(mapper -> {
            mapper.skip(Product::setId);
        });
        return modelMapper;
    }
}
