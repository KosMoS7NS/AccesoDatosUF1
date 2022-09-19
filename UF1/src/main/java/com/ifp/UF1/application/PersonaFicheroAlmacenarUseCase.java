package com.ifp.UF1.application;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.ifp.UF1.configuration.PersonaStaticConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifp.UF1.application.port.PersonaFicheroAlmacenar;
import com.ifp.UF1.infrastructure.controller.dto.output.PersonaOutputDTO;
import com.ifp.UF1.infrastructure.jpa.repository.PersonaRepository;

/**
 * Esta clase devuelve true o false dependiendo de la respuesta del usuario para la creación de la Persona.
 */
@Service
public class PersonaFicheroAlmacenarUseCase implements PersonaFicheroAlmacenar {

    @Autowired
    PersonaRepository personaRepository;

	/**
	 * Este método utiliza una lambda para escribir en un fichero los datos con un salto de línea
	 * por cada instancia encontrada siempre y cuando el usuario afirme con un si, de lo contrario se cierra.
	 * @param personaOutputDTO
	 * @return boolean
	 * @throws IOException
	 */
    @Override
    public boolean almacenarFichero(PersonaOutputDTO personaOutputDTO) throws IOException {
	Scanner scanner = new Scanner(System.in);
	File file = new File(PersonaStaticConfig.RUTA);
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
