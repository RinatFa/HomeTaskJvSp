package com.example.sem3HomeTask.services;

import com.example.sem3HomeTask.domain.User;
import org.springframework.stereotype.Service;

import java.util.Scanner;

/**
 * Добавление пользователя
 * 3 поля зависимостей:
 * DataProcessingService
 * UserService
 * NotificationService
 */
@Service
public class RegistrationService {

    private DataProcessingService dataProcessingService;
    private UserService userService;
    private NotificationService notificationService;

    public RegistrationService(DataProcessingService dataProcessingService,
                               UserService userService,
                               NotificationService notificationService) {
        this.dataProcessingService = dataProcessingService;
        this.userService = userService;
        this.notificationService = notificationService;
    }

    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }

    /**
     * Метод для добавления пользователя в список из консоли
     * по POST "localhost:8080/user/cons"
     */
    public void processRegistration() {
        String[] sArr = new String[0];
        String sStr = "";
        notificationService.sendNotification(
                "\nВведите данные через пробел в формате [Имя Возраст Email]:");
        Scanner sScanner = new Scanner(System.in);
        while (true) {
            sStr = sScanner.nextLine();
            sStr = sStr.trim();
            sArr = sStr.split(" ");
            if (sArr.length > 3) {
                notificationService.sendNotification(
                        "Данных больше, чем требуется (>3)! Введите снова:");
            } else if (sArr[0].length() < 2) {
                notificationService.sendNotification(
                        "Длина имени меньше, чем требуется (<2)! Введите снова:");
            } else if (sArr[2].length() < 6) {
                notificationService.sendNotification(
                        "Длина email меньше, чем требуется (<6)! Введите снова (n@n.nn):");
            } else if (!sArr[2].contains("@") || !sArr[2].contains(".")) {
                notificationService.sendNotification(
                        "Данные email ошибочны! Введите снова (n@n.nn):");
            } else if (!isNumber(sArr[1])) {
                notificationService.sendNotification(
                        "Возраст должен быть числом! Введите снова:");
            } else {
                notificationService.sendNotification("Данные введены верно!");
                break;
            }
        }
        sScanner.close();
        User user = userService.createUser(sArr[0], Integer.parseInt(sArr[1]), sArr[2]);
        dataProcessingService.getRepository().getUsers().add(user);
        notificationService.sendNotification("Новый пользователь занесен в список!");
    }

    /**
     * Метод для проверки ввода числа для возраста
     */
    public boolean isNumber(String str) {
        if (str == null || str.isEmpty()) return false;
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) return false;
        }
        return true;
    }
}
