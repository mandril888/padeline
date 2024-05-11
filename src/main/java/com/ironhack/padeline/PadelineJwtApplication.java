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
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

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
//            userService.saveUser(new Admin(1L, "Admin", "admin", "1234", new ArrayList<>()));
//            userService.saveUser(new Manager(2L, "Manager1", "manager1", "1234", new ArrayList<>(), new GregorianCalendar(2001, Calendar.JANUARY, 1).getTime(), 5, new ArrayList<>()));
//            userService.saveUser(new Manager(3L, "Manager2", "manager2", "1234", new ArrayList<>(), new GregorianCalendar(2002, Calendar.FEBRUARY, 2).getTime(), 6, new ArrayList<>()));
//            userService.saveUser(new Player(4L, "Player1", "player1", "1234", new ArrayList<>(), new GregorianCalendar(2003, Calendar.MARCH, 3).getTime(), 7));
//            userService.saveUser(new Player(5L, "Player2", "player2", "1234", new ArrayList<>(), new GregorianCalendar(2004, Calendar.APRIL, 4).getTime(), 8));
//
//            userService.addRoleToUser("player1", "ROLE_PLAYER");
//            userService.addRoleToUser("player2", "ROLE_PLAYER");
//            userService.addRoleToUser("manager1", "ROLE_MANAGER");
//            userService.addRoleToUser("manager2", "ROLE_MANAGER");
//            userService.addRoleToUser("admin", "ROLE_ADMIN");
        };
    }

}
