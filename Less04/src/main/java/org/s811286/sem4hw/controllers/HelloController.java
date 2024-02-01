package org.s811286.sem4hw.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 1. Простая страница с использованием Spring MVC.
 * "localhost:8080/hello"
 */
@Controller
@RequestMapping("/hello")
public class HelloController {

    @GetMapping
    public String hello() {
        return "hello";
    }
}
