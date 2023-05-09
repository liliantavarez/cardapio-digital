package com.springreact.cardapio.controllers;

import com.springreact.cardapio.dto.FoodRequestDto;
import com.springreact.cardapio.dto.FoodResponseDto;
import com.springreact.cardapio.entities.Food;
import com.springreact.cardapio.repositories.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/food")
public class FoodController {

    @Autowired
    private FoodRepository foodRepository;

    @GetMapping
    public List<FoodResponseDto> getAll() {
        List<FoodResponseDto> foodList;
        foodList = foodRepository.findAll().stream().map(FoodResponseDto::new).collect(Collectors.toList());

        return foodList;
    }

    @PostMapping
    public void saveFood(@RequestBody FoodRequestDto data) {
        Food foodData = new Food(data);

        foodRepository.save(foodData);
    }
}
