package org.s811286.sem4hw.controllers;

import org.s811286.sem4hw.model.Animal;
import org.s811286.sem4hw.services.AnimalService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * 3. Страница с формой ввода с использованием Thymeleaf.
 * Контроллер Spring MVC обрабатывает отправку формы и
 * выводит полученные данные.
 * "localhost:8080/animals"
 */
@Controller
public class AnimalsController {

    private final AnimalService animalService;

    public AnimalsController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping("/animals")
    public String viewAnimals(Model model) {
        var animals = animalService.findAll();
        model.addAttribute("animals", animals);
        return "animals";
    }

    @PostMapping("/animals")
    public String addAnimal(Animal a, Model model) {
        animalService.addAnimal(a);
        var animals = animalService.findAll();
        model.addAttribute("animals", animals);
        return "animals";
    }
}
