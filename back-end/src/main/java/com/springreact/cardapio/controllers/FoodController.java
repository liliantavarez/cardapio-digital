package com.springreact.cardapio.controllers;

import com.springreact.cardapio.dto.FoodRequestDto;
import com.springreact.cardapio.dto.FoodResponseDto;
import com.springreact.cardapio.entities.Food;
import com.springreact.cardapio.repositories.FoodRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/food")
@CrossOrigin(origins = "http://localhost:5173")
public class FoodController {

    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<FoodResponseDto>> getAll() {
        List<FoodResponseDto> foodList = foodRepository.findAll().stream().map(food -> modelMapper.map(food, FoodResponseDto.class)).toList();

        return ResponseEntity.ok(foodList);
    }

    @PostMapping
    public ResponseEntity<FoodRequestDto> saveFood(@RequestBody FoodRequestDto data, UriComponentsBuilder uriComponentsBuilder) {
        Food foodData = modelMapper.map(data, Food.class);
        foodRepository.save(foodData);
        var uri = uriComponentsBuilder.path("/food/{id}").buildAndExpand(foodData.getId()).toUri();

        return ResponseEntity.created(uri).body(data);
    }
}
