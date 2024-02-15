package org.s811286.sem8hw.configuration;

import org.s811286.sem8hw.aspects.LogAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "org.s811286.sem8hw")
@EnableAspectJAutoProxy
public class ProjectConfiguration {
    @Bean
    public LogAspect aspect() {
        return new LogAspect();
    }
}
