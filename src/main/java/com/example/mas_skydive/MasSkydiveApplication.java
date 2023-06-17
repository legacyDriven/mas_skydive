package com.example.mas_skydive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.vaadin.flow.component.dependency.CssImport;

@SpringBootApplication
@CssImport("./styles/shared-styles.css")
public class MasSkydiveApplication {

    public static void main(String[] args) {
        SpringApplication.run(MasSkydiveApplication.class, args);
    }

}
