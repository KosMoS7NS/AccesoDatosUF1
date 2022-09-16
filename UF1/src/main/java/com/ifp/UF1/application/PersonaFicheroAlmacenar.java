package com.ifp.UF1.application;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifp.UF1.application.port.PersonaFicheroAlmacenarPort;
import com.ifp.UF1.infrastructure.controller.dto.output.PersonaOutputDTO;
import com.ifp.UF1.infrastructure.jpa.repository.PersonaRepository;

@Service
public class PersonaFicheroAlmacenar implements PersonaFicheroAlmacenarPort {

    @Autowired
    PersonaRepository personaRepository;

    @Override
    public boolean almacenarFichero(PersonaOutputDTO personaOutputDTO) throws IOException {
	Scanner scanner = new Scanner(System.in);
	File file = new File("Fichero.txt");
	FileWriter fileWriter = new FileWriter(file, true);

	if (file.exists()) {
	    System.out.println("El fichero ya existe, ¿quiere continuar? ");
	    String respuesta = scanner.next();

	    if (respuesta.equalsIgnoreCase("si")) {
		personaRepository.findAll().forEach(personaEntity -> {
		    try {
			fileWriter.write(personaOutputDTO.toString() + System.lineSeparator());
			fileWriter.close();
		    } catch (IOException e) {
			throw new RuntimeException(e);
		    }
		});
		return true;

	    } else
		fileWriter.close();
	}
	return false;

    }
}
