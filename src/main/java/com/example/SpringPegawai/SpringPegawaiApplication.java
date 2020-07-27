package com.example.SpringPegawai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringPegawaiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringPegawaiApplication.class, args);
	}

}
