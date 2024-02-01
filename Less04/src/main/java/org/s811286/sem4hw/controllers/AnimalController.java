package org.s811286.sem4hw.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 2. Простая страница с переменными, с использованием Spring MVC и
 * с отображением на странице с использованием Thymeleaf.
 * Используются параметры из файла application.properties.
 * "localhost:8080/animal?hl=115&hs=38&wl=46&ws=1.8"
 */
@Controller
public class AnimalController {

    @Value("${data.parametr.minGrowthLarge:110}")
    private Integer minGrowthLarge;
    @Value("${data.parametr.maxGrowthLarge:120}")
    private Integer maxGrowthLarge;
    @Value("${data.parametr.minGrowthSmall:30}")
    private Integer minGrowthSmall;
    @Value("${data.parametr.maxGrowthSmall:45}")
    private Integer maxGrowthSmall;
    @Value("${data.parametr.minWeightSmall:1}")
    private Integer minWeightSmall;
    @Value("${data.parametr.maxWeightSmall:2.5}")
    private double maxWeightSmall;

    /**
     * Строка для вывода значений, соответствующих диапазону:
     * "localhost:8080/animal?hl=115&hs=38&wl=46&ws=1.8".
     */
    @GetMapping("/animal")
    public String getRandomNumber3(@RequestParam("hl") Integer heightLarge,
                                   @RequestParam("hs") Integer heightSmall,
                                   @RequestParam("wl") Integer weightLarge,
                                   @RequestParam("ws") double weightSmall,
                                   Model model) {
        model.addAttribute("hl", heightLarge);
        model.addAttribute("hs", heightSmall);
        model.addAttribute("wl", weightLarge);
        model.addAttribute("ws", weightSmall);

        model.addAttribute("minGrowthLarge", minGrowthLarge);
        model.addAttribute("maxGrowthLarge", maxGrowthLarge);
        model.addAttribute("minGrowthSmall", minGrowthSmall);
        model.addAttribute("maxGrowthSmall", maxGrowthSmall);
        model.addAttribute("minWeightSmall", minWeightSmall);
        model.addAttribute("maxWeightSmall", maxWeightSmall);
        return "animal";
    }
}
