package org.s811286.sem9hwMicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Микросервис со Spring Data.
 * Порядок запуска проектов в отдельных IntelliJ IDEA:
 * 1. проект Eureka sem9hwEureka
 * 2. проект ApiGateWay sem9hwApiGateWay
 * 3. проект микросервиса sem9hwMicroservice
 * * Ссылки в браузере:
 *  * 1. http://localhost:8761/
 *  * 2. http://localhost:8765/notes
 *  * 3. http://localhost:8081/notes
 */
@SpringBootApplication
public class Sem9hwMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(Sem9hwMicroserviceApplication.class, args);
    }
}
