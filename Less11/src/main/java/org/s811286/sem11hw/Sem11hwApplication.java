package org.s811286.sem11hw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Задание: По примерам показанным на семинаре:
 * 1) Подключить к своему проекту зависимости actuator, registry-prometheus и micrometer.
 * 2) Установить и подключить к проекту prometheus.
 * 3) Установить и подключить Grafana. В Grafana добавить пару точеу контроля
 * (Например: процессорное время приложения и количество запросов)
 * Формат сдачи: проект с добавленными зависимостями, файл настройки prometheus и
 * скриншот Grafana с добавленными контрольными точками.
 */
@SpringBootApplication
public class Sem11hwApplication {
    public static void main(String[] args) {
        SpringApplication.run(Sem11hwApplication.class, args);
    }
}
