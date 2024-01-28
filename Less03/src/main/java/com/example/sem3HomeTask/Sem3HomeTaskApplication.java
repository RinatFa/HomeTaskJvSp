package com.example.sem3HomeTask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Приложение разработано на семинаре А.Г.
 * <p>
 * GET
 * localhost:8080/tasks/sort
 * localhost:8080/tasks/calc
 * localhost:8080/tasks/filter/38
 * localhost:8080/user
 * POST
 * localhost:8080/user/cons
 * localhost:8080/user/body
 * {
 * "name":"Artur",
 * "age":23,
 * "email":"exam1@yandex.ru"
 * }
 */
@SpringBootApplication
public class Sem3HomeTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(Sem3HomeTaskApplication.class, args);
    }

}
