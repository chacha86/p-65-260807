package com.back.p65260807;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class P65260807Application {

    public static void main(String[] args) {
        SpringApplication.run(P65260807Application.class, args);
    }

}
