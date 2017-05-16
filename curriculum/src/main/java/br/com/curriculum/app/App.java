package br.com.curriculum.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import br.com.curriculum.configuration.JpaConfiguration;

@Import(JpaConfiguration.class)
@SpringBootApplication(scanBasePackages = {"br.com.curriculum"})
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}