package com.cinemaweb.API.Cinema.Web.Configuration;

import com.cinemaweb.API.Cinema.Web.Enum.Role;
import com.cinemaweb.API.Cinema.Web.Repository.RoleRepository;
import com.cinemaweb.API.Cinema.Web.Repository.UserRepository;
import com.cinemaweb.API.Cinema.Web.entity.User;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


import java.util.HashSet;
import java.util.List;

@Configuration
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class ApplicationInitConfig {

    PasswordEncoder passwordEncoder;
    RoleRepository roleRepository;


    @Bean
    public ApplicationRunner applicationRunner(UserRepository userRepository) {
        return args -> {
            if (!userRepository.existsByUsername("admin")) {
                var roles = new HashSet<>(roleRepository.findAllById(List.of(Role.ADMIN.name())));
                User user = User.builder()
                        .username("admin")
                        .password(passwordEncoder.encode("admin"))
                        .gender(1)
                        .roles(roles)
                        .build();
                userRepository.save(user);
                log.warn("admin account has been created with default password: admin!");
            }
        };
    }


}
