package com.springreact.cardapio.dto;

import java.math.BigDecimal;

public record FoodRequestDto(String title, String image, BigDecimal prica) {
}
