package com.ifp.UF1;

import com.ifp.UF1.application.port.PersonaCreatePort;
import com.ifp.UF1.application.port.PersonaReadPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class Uf1Application implements CommandLineRunner{

	@Autowired
	PersonaCreatePort personaCreatePort;

	@Autowired
	PersonaReadPort personaReadPort;

	public static void main(String[] args) {
		SpringApplication.run(Uf1Application.class, args);
	}

	/**
	 * Se muesta en los logs, una lista con la información de la Persona.
	 * @throws Exception
	 */
	@Override
	public void run(String... args) throws Exception {
		personaCreatePort.createPersona();
		log.info("PERSONA -> {}", personaReadPort.getAll());
	}
}
