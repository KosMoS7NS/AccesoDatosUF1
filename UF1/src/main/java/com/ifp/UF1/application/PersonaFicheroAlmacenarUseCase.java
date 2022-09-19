package com.ifp.UF1.application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.ifp.UF1.configuration.PersonaStaticConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifp.UF1.application.port.PersonaFicheroAlmacenarPort;
import com.ifp.UF1.infrastructure.controller.dto.output.PersonaOutputDTO;
import com.ifp.UF1.infrastructure.jpa.repository.PersonaRepository;

import static com.ifp.UF1.configuration.PersonaStaticConfig.*;

/**
 * Esta clase devuelve true o false dependiendo de la respuesta del usuario para la creación de la Persona.
 */
@Service
public class PersonaFicheroAlmacenarUseCase implements PersonaFicheroAlmacenarPort {

    @Autowired
    PersonaRepository personaRepository;

    /**
     * Este método escribe la lista de Personas siempre y cuando el usuario afirme con un si, de lo contrario se cierra.
     *
     * @param personaOutputDTOList Información de la Persona
     * @return boolean
     * @throws IOException
     */
    @Override
    public boolean almacenarFichero(List<PersonaOutputDTO> personaOutputDTOList) throws IOException {
        Scanner scanner = new Scanner(System.in);
        List listSeparator = new ArrayList<>();

        File file = new File(RUTA);
        FileWriter fileWriter = new FileWriter(file, true);

        if (file.exists()) {
            System.out.println("El fichero ya existe, ¿quiere continuar? ");
            String respuesta = scanner.next();

            if (respuesta.equalsIgnoreCase("si")) {
                try {
                    personaOutputDTOList.forEach(personaOutputDTO ->
                            listSeparator.add(personaOutputDTO + System.lineSeparator()));

                    fileWriter.write(listSeparator.stream()
                            .map(Object::toString)
                            .collect(Collectors.joining()) + System.lineSeparator());

                    fileWriter.close();

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                return true;

            } else fileWriter.close();
        }

        throw new FileNotFoundException("No se ha encontrado el fichero.txt");

    }
}
