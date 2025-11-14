package sdev.mediamasterserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // Security filter chain configuration
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers("/auth/**").permitAll() // Allow public access to /auth/** endpoints
                        .anyRequest().authenticated() // Require authentication for all other endpoints
                )
                .httpBasic(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults())

//                .authorizeHttpRequests(request -> request
//                .requestMatchers("/cashcards/**")
//                .hasRole("CARD-OWNER"))
//                .httpBasic(Customizer.withDefaults())
                .csrf(csrf -> csrf.disable());

        return http.build();
    }

//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails userDetails = User.withDefaultPasswordEncoder()
//                .username("user")
//                .password("password")
//                .roles("USER")
//                .build();
//
//        return new InMemoryUserDetailsManager(userDetails);
//    }

//    @Bean
//    PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

//    @Bean
//    UserDetailsService testOnlyUsers(PasswordEncoder passwordEncoder) {
//        User.UserBuilder users = User.builder();
//        UserDetails test1 = users
//                .username("test")
//                .password(passwordEncoder.encode("abc123"))
//                .roles("CARD-OWNER")
//                .build();
//        return new InMemoryUserDetailsManager(test1);
//    }

}
