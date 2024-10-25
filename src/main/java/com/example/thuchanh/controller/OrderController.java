package com.example.thuchanh.controller;

import com.example.thuchanh.dto.OrderDTO;
import com.example.thuchanh.entity.Order;
import com.example.thuchanh.entity.Product;
import com.example.thuchanh.service.OrderService;
import com.example.thuchanh.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    private final ProductService productService;

    @GetMapping
    public String listOrders(@RequestParam(defaultValue = "0") int page, Model model) {
        int pageSize = 5;
        Page<Order> orderPage = orderService.getOrders(page, pageSize);
        model.addAttribute("orders", orderPage);
        return "orders";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "new-order";
    }

    @PostMapping("/add")
    public String addOrder(@ModelAttribute OrderDTO orderDTO) {
        Order order = orderService.convertToEntity(orderDTO);
        Product product = productService.getProductById(orderDTO.getProductId());
        order.setProduct(product);
        orderService.addOrder(order);
        return "redirect:/orders";
    }
}
