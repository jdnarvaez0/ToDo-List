package com.todolist.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class CrudApplication {
    public static void main(String[] args) {
        // Cargar variables del archivo .env
        Dotenv dotenv = Dotenv.configure().load();

        // Configurar el URI de MongoDB como variable de entorno
        System.setProperty("spring.data.mongodb.uri", dotenv.get("MONGODB_URI"));

        // Iniciar la aplicación
        SpringApplication.run(CrudApplication.class, args);
    }
}
