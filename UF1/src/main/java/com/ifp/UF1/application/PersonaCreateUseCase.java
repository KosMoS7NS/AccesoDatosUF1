package com.ifp.UF1.application;

import java.util.Scanner;

import com.ifp.UF1.configuration.PersonaStaticConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifp.UF1.application.port.PersonaCreatePort;
import com.ifp.UF1.application.port.PersonaMapperPort;
import com.ifp.UF1.infrastructure.controller.dto.input.PersonaInputDTO;
import com.ifp.UF1.infrastructure.controller.dto.output.PersonaOutputDTO;
import com.ifp.UF1.infrastructure.jpa.repository.PersonaRepository;

/**
 * Clase con el método de creación de las Personas.
 */
@Service
public class PersonaCreateUseCase implements PersonaCreatePort {

    @Autowired
    PersonaRepository personaRepository;

    /**
     * Se realiza un Scaner para capturar la información del usuario.
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
    public PersonaOutputDTO createPersona() throws Exception {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Introduce el nombre del fichero: ");
            PersonaStaticConfig.RUTA = scanner.next();

            System.out.println("Introduce un ID: ");
            Integer id = scanner.nextInt();

            System.out.println("Introduce tu nombre: ");
            String nombre = scanner.next();

            scanner.nextLine();
            System.out.println("Introduce tus apellidos: ");
            String apellidos = scanner.nextLine();

            System.out.println("Introduce tu edad: ");
            int edad = scanner.nextInt();

            scanner.nextLine();
            System.out.println("Introduce tu ciudad: ");
            String ciudad = scanner.nextLine();

            System.out.println("Introduce tu nacionalidad: ");
            String nacionalidad = scanner.next();

            PersonaInputDTO personaInputDTO = new PersonaInputDTO(id, nombre, apellidos, ciudad, nacionalidad, edad);
            return PersonaMapperPort.INSTANCE.personaOutputDto(
                    personaRepository.save(PersonaMapperPort.INSTANCE.personaEntity(personaInputDTO)
                    ));

        } catch (Exception e) {
            throw new Exception("Introduce correctamente los datos");
        }

    }
}
