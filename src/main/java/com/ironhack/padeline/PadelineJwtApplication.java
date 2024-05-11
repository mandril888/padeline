package com.ironhack.padeline;

import com.ironhack.padeline.models.*;
import com.ironhack.padeline.services.impl.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Date;

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
//            userService.saveRole(new Role(null, "ROLE_PLAYER"));
//            userService.saveRole(new Role(null, "ROLE_MANAGER"));
//            userService.saveRole(new Role(null, "ROLE_ADMIN"));
//
//            userService.saveUser(new Admin(5L, "Admin", "admin", "1234", new ArrayList<>()));
//            userService.saveUser(new Manager(3L, "Manager1", "manager1", "1234", new ArrayList<>(), "2001-01-01", 5, new ArrayList<>()));
//            userService.saveUser(new Manager(4L, "Manager2", "manager2", "1234", new ArrayList<>(), "2002-02-02", 6, new ArrayList<>()));
//            userService.saveUser(new Player(1L, "Player1", "player1", "1234", new ArrayList<>(), "2003-03-03", 7));
//            userService.saveUser(new Player(2L, "Player2", "player2", "1234", new ArrayList<>(), "2004-04-04", 8));
//
//            userService.addRoleToUser("player1", "ROLE_PLAYER");
//            userService.addRoleToUser("player2", "ROLE_PLAYER");
//            userService.addRoleToUser("manager1", "ROLE_MANAGER");
//            userService.addRoleToUser("manager2", "ROLE_MANAGER");
//            userService.addRoleToUser("admin", "ROLE_ADMIN");
        };
    }

}
