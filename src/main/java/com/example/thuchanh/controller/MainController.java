package com.example.thuchanh.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
@RequestMapping()
public class MainController {

    @GetMapping
    public String index(HttpSession session) {
        LocalDate currentDate = LocalDate.now();
        session.setAttribute("currentDate", currentDate);
        return "redirect:/orders";
    }
}
