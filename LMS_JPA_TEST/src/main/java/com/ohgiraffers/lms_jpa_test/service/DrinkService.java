package com.ohgiraffers.lms_jpa_test.service;

import com.ohgiraffers.lms_jpa_test.dto.DrinkDTO;
import com.ohgiraffers.lms_jpa_test.entity.Drink;
import com.ohgiraffers.lms_jpa_test.repository.DrinkRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DrinkService {

    private final DrinkRepository drinkRepository;
    private final ModelMapper modelMapper;

    public DrinkDTO findDrinkByDrinkCode(int drinkCode) {
        Drink foundDrink = drinkRepository.findById(drinkCode).orElseThrow(IllegalArgumentException::new);
        return modelMapper.map(foundDrink, DrinkDTO.class);
    }

    public List<DrinkDTO> findDrinkList() {
        List<Drink> foundDrinks = drinkRepository.findAll();
        return null;
    }
}
