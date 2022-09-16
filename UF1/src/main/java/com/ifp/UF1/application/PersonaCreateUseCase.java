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
     * Se crea una lista de PersonaOuputDTO que se utilizara en la conversion de una
     * entidad para tener la aplicacion más segura.
     * <p>
     * Se setean los datos en la clase persanaInputDTO. Este proceso seria mejor
     * hacer con peticiones POST enviando un Body, pero no es el objetivo del
     * ejercicio.
     * <p>
     * Se instancia PersonaOutputDTO, pasando como parametro un metodo que permite
     * persistir la informacion. La informacion que guarda es de la PersonaEntity,
     * cuyo parametro el PersonaInputDTO que tiene los datos seteados anteriormente.
     * <p>
     * Transformamos Persona en DTO para no exponer la entidad y cumplir la
     * arquitectura hexgonal. No se utlizan controladores ya que no se realiza
     * ninguna petición http.
     *
     * @return Lista de PersonaOutputDTO
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
