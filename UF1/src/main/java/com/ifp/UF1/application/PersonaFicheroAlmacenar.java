package com.ifp.UF1.application;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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
    public void almacenarFichero(PersonaOutputDTO personaOutputDTO) throws IOException {
	File file = new File("Fichero.txt");
	FileWriter fileWriter = new FileWriter(file);

	personaRepository.findAll().forEach(personaEntity -> {
	    try {
		fileWriter.write(personaOutputDTO.toString());
	    } catch (IOException e) {
		throw new RuntimeException(e);
	    }
	});

	fileWriter.close();

    }
}
