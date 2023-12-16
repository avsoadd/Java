package com.example.board;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.example.board.repository")
@EntityScan("model")
public class Vboard202312Application {

	public static void main(String[] args) {
		SpringApplication.run(Vboard202312Application.class, args);
	}

}
