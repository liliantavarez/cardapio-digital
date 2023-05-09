package com.springreact.cardapio.dto;

import com.springreact.cardapio.entities.Food;

import java.math.BigDecimal;

public record FoodResponseDto(Long id, String title, String image, BigDecimal price) {
    public FoodResponseDto(Food food) {
        this(food.getId(), food.getTitle(), food.getImage(), food.getPrice());
    }
}
