package com.example.thuchanh.service;

import com.example.thuchanh.dto.OrderDTO;
import com.example.thuchanh.entity.Order;
import com.example.thuchanh.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;

    public Page<Order> getOrders(int page, int size) {
        Pageable pageable = Pageable.ofSize(size).withPage(page);
        return orderRepository.findAll(pageable);
    }

    public void addOrder(Order order) {
        orderRepository.save(order);
    }
    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public Order convertToEntity(OrderDTO orderDTO) {
        return modelMapper.map(orderDTO, Order.class);
    }


    public OrderDTO convertToDto(Order order) {
        return modelMapper.map(order, OrderDTO.class);
    }
}
