package org.s811286.sem4hw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 1. Простая страница с использованием Spring MVC
 * "localhost:8080/hello"
 * 2. Простая страница с переменными, с использованием Spring MVC и
 * с отображением на странице с использованием Thymeleaf
 * "localhost:8080/animal?hl=115&hs=38&wl=46&ws=1.8"
 * 3. Страница с формой ввода с использованием Thymeleaf. Контроллер Spring MVC
 * обрабатывает отправку формы и выводит полученные данные
 * "localhost:8080/animals"
 */
@SpringBootApplication
public class Sem4hwApplication {

    public static void main(String[] args) {
        SpringApplication.run(Sem4hwApplication.class, args);
    }
}
