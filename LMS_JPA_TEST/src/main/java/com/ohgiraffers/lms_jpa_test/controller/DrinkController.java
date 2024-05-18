package com.ohgiraffers.lms_jpa_test.controller;

import com.ohgiraffers.lms_jpa_test.common.Pagenation;
import com.ohgiraffers.lms_jpa_test.common.PagingButton;
import com.ohgiraffers.lms_jpa_test.dto.CategoryDTO;
import com.ohgiraffers.lms_jpa_test.dto.DrinkDTO;
import com.ohgiraffers.lms_jpa_test.service.DrinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String findDrinkList(Model model, @PageableDefault Pageable pageable) {
//        List<DrinkDTO> drinkDTO = drinkService.findDrinkList();
        Page<DrinkDTO> drinkDTO = drinkService.findDrinkList(pageable);
        PagingButton pagingButton = Pagenation.getPagingButtonInfo(drinkDTO);
        model.addAttribute("drinks", drinkDTO);
        model.addAttribute("pagingButton", pagingButton);
        return "drink/list";
    }

    @GetMapping("/querymethod")
    public void queryMethodPage() {}

    @GetMapping("/search")
    public String findByDrinkPrice(Model model, @RequestParam Integer drinkPrice) {
        List<DrinkDTO> drinkDTO = drinkService.findByDrinkPrice(drinkPrice);
        model.addAttribute("drinks", drinkDTO);
        return "drink/searchResult";
    }

    @GetMapping("/nativeQueryCategory")
    @ResponseBody
    public List<CategoryDTO> findAllCategory() {
        return drinkService.findAllCategory();
    }

    @GetMapping("/regist")
    public void registPage() {}

    @PostMapping("/regist")
    public String registNewDrink(@ModelAttribute DrinkDTO drinkDTO) {
        drinkService.registNewDrink(drinkDTO);
        return "redirect:/drink/list";
    }

    @GetMapping("/modify")
    public void modifyPage() {}

    @PostMapping("/modify")
    public String modifyDrink(@ModelAttribute DrinkDTO drinkDTO) {
        drinkService.modifyDrink(drinkDTO);
        return "redirect:/drink/" + drinkDTO.getDrinkCode();
    }

    @GetMapping("/delete")
    public void deletePage() {}

    @PostMapping("/delete")
    public String deleteDrink(@RequestParam Integer drinkCode) {
        drinkService.deleteDrink(drinkCode);
        return "redirect:/drink/list";
    }
}
