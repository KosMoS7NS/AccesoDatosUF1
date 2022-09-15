package com.ifp.UF1;

import com.ifp.UF1.application.port.PersonaPort;
import com.ifp.UF1.infrastructure.controller.dto.PersonaInputDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class Uf1Application implements CommandLineRunner{

	@Autowired
	PersonaPort personaPort;

	public static void main(String[] args) {
		SpringApplication.run(Uf1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("PERSONA -> {}", personaPort.getAll().toString());
	}
}
