package com.ohgiraffers.lms_jpa_test.service;

import com.ohgiraffers.lms_jpa_test.dto.CategoryDTO;
import com.ohgiraffers.lms_jpa_test.dto.DrinkDTO;
import com.ohgiraffers.lms_jpa_test.model.Category;
import com.ohgiraffers.lms_jpa_test.model.Drink;
import com.ohgiraffers.lms_jpa_test.repository.CategoryRepository;
import com.ohgiraffers.lms_jpa_test.repository.DrinkRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DrinkService {

    private final DrinkRepository drinkRepository;
    private final ModelMapper modelMapper;
    private final CategoryRepository categoryRepository;

    /* 파라미터 해당 값 단일 출력 */
    public DrinkDTO findDrinkByDrinkCode(int drinkCode) {
        Drink foundDrink = drinkRepository.findById(drinkCode).orElseThrow(IllegalArgumentException::new);
        return modelMapper.map(foundDrink, DrinkDTO.class);
    }

    /* 음료 리스트 모두 출력 */
    public List<DrinkDTO> findDrinkList() {
        List<Drink> foundDrinks = drinkRepository.findAll(Sort.by("drinkCode").descending());
        return foundDrinks.stream().map(drink -> modelMapper.map(drink, DrinkDTO.class)).toList();
    }

    /* 페이징 처리 음료 리스트 모두 출력 */
    public Page<DrinkDTO> findDrinkList(Pageable pageable) {
        pageable = PageRequest.of(
                pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() - 1,
                pageable.getPageSize(),
                Sort.by("drinkCode").descending()
        );
        Page<Drink> drinkList = drinkRepository.findAll(pageable);
        return drinkList.map(drink -> modelMapper.map(drink, DrinkDTO.class));
    }

    public List<DrinkDTO> findByDrinkPrice(Integer drinkPrice) {
        /* 파라미터 이상의 금액 출력 */
//        List<Drink> drinks = drinkRepository.findByDrinkPriceGreaterThanEqual(drinkPrice);
        /* 파라미터 이상의 금액 내림차순 출력 */
        List<Drink> drinks = drinkRepository
                .findByDrinkPriceGreaterThanEqual(drinkPrice, Sort.by("drinkPrice").descending());
        return drinks.stream().map(drink -> modelMapper.map(drink, DrinkDTO.class)).toList();
    }

    /* nativeQuery를 사용한 모든 카테고리 조회 */
    public List<CategoryDTO> findAllCategory() {
        List<Category> categorys = categoryRepository.findAllCategory();
        return categorys.stream().map(category -> modelMapper.map(category, CategoryDTO.class)).toList();
    }

    /* 음료 신규 등록 */
    @Transactional
    public void registNewDrink(DrinkDTO drinkDTO) {
        drinkRepository.save(modelMapper.map(drinkDTO, Drink.class));
    }

    /* 기존 음료 수정 */
    @Transactional
    public void modifyDrink(DrinkDTO drinkDTO) {
        Drink drink = drinkRepository.findById(drinkDTO.getDrinkCode()).orElseThrow(IllegalArgumentException::new);
        drink.modifyDrinkName(drinkDTO.getDrinkName());
    }

    /* 기존 음료 삭제 */
    @Transactional
    public void deleteDrink(Integer drinkCode) {
        drinkRepository.deleteById(drinkCode);
    }
}
