package com.shopitems.shopitemsmanagement.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {

        UserDetails adminUser = User.withDefaultPasswordEncoder().username("admin").password("admin").roles("admin").build();
        UserDetails guestUser = User.withDefaultPasswordEncoder().username("guest").password("guest").roles("guest").build();

        return new InMemoryUserDetailsManager(adminUser, guestUser);

    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        return httpSecurity.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/**").permitAll();
                    auth.requestMatchers(HttpMethod.POST, "/**").hasRole("admin");
                }).httpBasic(Customizer.withDefaults()).build();

    }


}
