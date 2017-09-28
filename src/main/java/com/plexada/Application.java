package com.plexada;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = "com.plexada")
//@EntityScan("com.plexada.domain")
//@EnableJpaRepositories("com.plexada.repositories")

public class Application {
    public static void main(String[] args){
          SpringApplication.run(Application.class, args);
    }
}
