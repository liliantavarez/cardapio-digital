package com.springreact.cardapio.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class FoodResponseDto {
    Long id;
    String title;
    String image;
    BigDecimal price;
}
