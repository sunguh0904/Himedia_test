package com.ohgiraffers.lms_jpa_test.controller;

import com.ohgiraffers.lms_jpa_test.dto.DrinkDTO;
import com.ohgiraffers.lms_jpa_test.service.DrinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/drink")
@RequiredArgsConstructor
public class DrinkController {

    private final DrinkService drinkService;

    @GetMapping("/{drinkCode}")
    public String findDrinkByCode(Model model, @PathVariable int drinkCode) {
        DrinkDTO drinkDTO = drinkService.findDrinkByDrinkCode(drinkCode);
        model.addAttribute("drink", drinkDTO);
        return "drink/detail";
    }

    @GetMapping("/list")
    public String findDrinkList(Model model) {
        List<DrinkDTO> drinkDTO = drinkService.findDrinkList();
    }
}
