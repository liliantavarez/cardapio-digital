package com.springreact.cardapio.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class FoodRequestDto {
    String title;
    String image;
    BigDecimal price;
}
