package com.ifp.UF1.application;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifp.UF1.application.port.PersonaCreatePort;
import com.ifp.UF1.application.port.PersonaMapper;
import com.ifp.UF1.infrastructure.controller.dto.input.PersonaInputDTO;
import com.ifp.UF1.infrastructure.controller.dto.output.PersonaOutputDTO;
import com.ifp.UF1.infrastructure.jpa.repository.PersonaRepository;

@Service
public class PersonaCreateUseCase implements PersonaCreatePort {

    @Autowired
    PersonaRepository personaRepository;

    /**
     * Se realiza un Escaner para capturar la información del usuario.
     * <p>
     * Se instancia la clase PersonaInputDTO mediante un constructor con argumentos, en el cual se le pasa los atributos
	 * anteriormente capturados.
     * <p>
     * Transformamos PersonaInputDTO en Entidad y poder guardarla en el repositorio. A continuación, se convierte la
	 * Entidad en un DTO de Salida mediante un Mapper, realizado en otro Caso de Uso.
     *
     * @return List
     */

    @Override
    public PersonaOutputDTO createPersona() {
	 Scanner scanner = new Scanner(System.in);

	System.out.println("Intrdouce un ID: ");
	Integer id = scanner.nextInt();

	System.out.println("Intrdouce tu nombre: ");
	String nombre = scanner.next();

	scanner.nextLine();
	System.out.println("Intrdouce tus apellidos: ");
	String apellidos = scanner.nextLine();

	System.out.println("Intrdouce tu edad: ");
	int edad = scanner.nextInt();

	scanner.nextLine();
	System.out.println("Intrdouce tu ciudad: ");
	String ciudad = scanner.nextLine();

	System.out.println("Intrdouce tu nacionalidad: ");
	String nacionalidad = scanner.next();

	PersonaInputDTO personaInputDTO = new PersonaInputDTO(id, nombre, apellidos, ciudad, nacionalidad, edad);
	return PersonaMapper.INSTANCE
		.personaOutputDto(personaRepository.save(PersonaMapper.INSTANCE.personaEntity(personaInputDTO)));
    }
}
