package com.springreact.cardapio.entities;

import com.springreact.cardapio.dto.FoodRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(of = "id")
@Table(name = "foods")
@Entity(name = "Food")
@NoArgsConstructor
@AllArgsConstructor
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String image;
    private BigDecimal price;

    public Food(FoodRequestDto data) {
        this.title = data.title();
        this.image = data.image();
        this.price = data.prica();
    }
}