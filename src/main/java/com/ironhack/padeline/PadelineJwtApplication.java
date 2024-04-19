package com.ironhack.padeline;

import com.ironhack.padeline.models.Role;
import com.ironhack.padeline.models.User;
import com.ironhack.padeline.services.impl.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class PadelineJwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(PadelineJwtApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(UserService userService) {
        return args -> {
            userService.saveRole(new Role(null, "ROLE_PLAYER"));
            userService.saveRole(new Role(null, "ROLE_MANAGER"));
            userService.saveRole(new Role(null, "ROLE_ADMIN"));

            userService.saveUser(new User(null, "Player1", "player1", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "Player2", "player2", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "Manager1", "manager1", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "Manager2", "manager2", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "Admin", "admin", "1234", new ArrayList<>()));

            userService.addRoleToUser("player1", "ROLE_PLAYER");
            userService.addRoleToUser("player2", "ROLE_PLAYER");
            userService.addRoleToUser("manager1", "ROLE_MANAGER");
            userService.addRoleToUser("manager2", "ROLE_MANAGER");
            userService.addRoleToUser("admin", "ROLE_ADMIN");
        };
    }

}
