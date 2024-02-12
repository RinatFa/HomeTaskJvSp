package org.s811286.sem7hw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
    /**
     * Подключение к домашней странице.
     */
    @GetMapping("/")
    public String home() {
        return "home";
    }

    /**
     * Подключение к странице 'Доступ запрещен'.
     */
    @GetMapping("/access-denied")
    public String accessDenied() {
        return "access_denied";
    }

    /**
     * Аутентификация.
     */
    @GetMapping("/login")
    public String auth() {
        return "login";
    }

    /**
     * Подключение к странице для пользователей USER.
     */
    @GetMapping("/public-data")
    public String userPage() {
        return "public";
    }

    /**
     * Подключение к странице для администраторов ADMIN.
     */
    @GetMapping("/private-data")
    public String adminPage() {
        return "private";
    }
}
