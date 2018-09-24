package com.github.ipan97.springbootquerydslexample;

import com.github.ipan97.springbootquerydslexample.entity.User;
import com.github.ipan97.springbootquerydslexample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringBootQuerydslExampleApplication implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootQuerydslExampleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();

        List<User> users = new ArrayList<>();
        users.add(User.builder()
                .firstName("John")
                .lastName("Doe")
                .email("john@doe.com")
                .age(22)
                .build());
        users.add(User.builder()
                .firstName("Tom")
                .lastName("Doe")
                .email("tom@doe.com")
                .age(21)
                .build());
        // save all
        userRepository.saveAll(users);
    }
}
