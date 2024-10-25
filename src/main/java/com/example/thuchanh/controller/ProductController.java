package com.example.thuchanh.controller;

import com.example.thuchanh.dto.ProductDTO;
import com.example.thuchanh.entity.Product;
import com.example.thuchanh.repository.CategoryRepository;
import com.example.thuchanh.service.CategoryService;
import com.example.thuchanh.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final CategoryService categoryService;
    private final ProductService productService;

    @GetMapping()
    public String listProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("categories", categoryService.getAllCategories());
        return "new-product";
    }

    @PostMapping("/add")
    public String addProduct(@ModelAttribute ProductDTO productDTO) {
        Product product = productService.convertToEntity(productDTO);
        product.setCategory(categoryService.getCategoryById(productDTO.getCategoryId()));
        productService.addProduct(product);
        return "redirect:/orders/add";
    }

}
