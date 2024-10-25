package com.example.thuchanh.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private Long productId;
    @Future(message = "Ngày mua phải lớn hơn ngày hiện tại")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate orderDate;
    @NotNull(message = "Số lượng không được để trống")
    @Positive(message = "Số lượng phải là số nguyên dương")
    private Integer quantity;
}
