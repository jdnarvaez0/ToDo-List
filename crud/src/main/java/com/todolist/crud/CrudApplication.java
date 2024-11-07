package com.todolist.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class CrudApplication {
    public static void main(String[] args) {

        Dotenv dotenv = Dotenv.configure().load();
        System.setProperty("spring.data.mongodb.uri", dotenv.get("MONGODB_URI"));

        SpringApplication.run(CrudApplication.class, args);
    }
}
