package com.ifp.UF1.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifp.UF1.application.port.PersonaCreatePort;
import com.ifp.UF1.application.port.PersonaMapperPort;
import com.ifp.UF1.infrastructure.dto.input.PersonaInputDTO;

import static com.ifp.UF1.configuration.PersonaStaticConfig.RUTA;


/**
 * Clase con el método de creación de las Personas.
 */
@Service
public class PersonaCreateUseCase implements PersonaCreatePort {

    /**
     * Se realiza un Scaner para capturar la información del usuario.
     * <p>
     * Se instancia la clase PersonaInputDTO mediante un constructor con argumentos, en el cual se le pasa los atributos
     * anteriormente capturados.
     * <p>
     * La lista de personaEntity guardara PersonaNoEntity con un mapeon de PersonaInputDTO. A continuación,
     * se convierte la lista de personaEntity en un DTO de Salida mediante un Mapper, realizado en otro Caso de Uso.
     *
     * @return List
     */

    @Override
    public List createPersona() throws Exception {
        Scanner scanner = new Scanner(System.in);
        List personaEntityList = new ArrayList<>();
        int i = 1;

        try {
            System.out.println("Introduce el nombre del fichero: ");
            RUTA = scanner.next();
            System.out.println("=====================================");

            do {
//                System.out.println("PERSONA " + i);
//                System.out.println("Introduce un ID: ");
//                Integer id = scanner.nextInt();

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
                System.out.println("=====================================");


                personaEntityList.add(PersonaMapperPort.INSTANCE.personaEntity(
                        new PersonaInputDTO(nombre, apellidos, ciudad, nacionalidad, edad)));

                i += 1;

            } while (i <= 3);
            return PersonaMapperPort.INSTANCE.personaOutputDtoList(personaEntityList);

        } catch (Exception e) {
            throw new Exception("Introduce correctamente los datos");
        }

    }
}
