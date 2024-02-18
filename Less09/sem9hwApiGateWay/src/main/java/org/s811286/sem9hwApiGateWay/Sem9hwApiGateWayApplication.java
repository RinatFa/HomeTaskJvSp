package org.s811286.sem9hwApiGateWay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

/**
 * ApiGateWay.
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
public class Sem9hwApiGateWayApplication {

    public static void main(String[] args) {
        SpringApplication.run(Sem9hwApiGateWayApplication.class, args);
    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("Sem9hwMicroservice", r -> r.path("/notes/**")
                        .uri("http://localhost:8081/"))
                .build();
    }
}
