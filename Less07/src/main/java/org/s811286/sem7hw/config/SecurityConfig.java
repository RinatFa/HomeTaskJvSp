package org.s811286.sem7hw.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * Конфигурация защиты Spring Security.
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/private-data").hasRole("ADMIN")
                .antMatchers("/public-data").authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .loginProcessingUrl("/process-login")
                .defaultSuccessUrl("/public-data")
                .failureUrl("/login?error")
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .and()
                .exceptionHandling()
                .accessDeniedPage("/access-denied");
    }

    /**
     * Служба свойств пользователя и
     * Блок кодировки паролей.
     */
    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager auth = new InMemoryUserDetailsManager();
        auth.createUser(User.withDefaultPasswordEncoder()
                .username("user").password("password").roles("USER").build());
        auth.createUser(User.withDefaultPasswordEncoder()
                .username("admin").password("password").roles("ADMIN").build());
        return auth;
    }
}
