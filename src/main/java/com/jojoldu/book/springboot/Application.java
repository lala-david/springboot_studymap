package com.jojoldu.book.springboot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

// location, setting  read
@SpringBootApplication
// JPA Auditing Active
@EnableJpaAuditing
// Main class
public class Application {
    public static void main(String[] args){
          SpringApplication.run(Application.class, args);
    }
}
