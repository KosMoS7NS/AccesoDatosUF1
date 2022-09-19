package com.ifp.UF1.binario.application;

import com.ifp.UF1.binario.application.port.PersonaBinarioAlmacenarPort;
import com.ifp.UF1.binario.infrastructure.dto.output.PersonaBinarioOutputDTO;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.ifp.UF1.shared.configuration.PersonaStaticConfig.RUTA;

/**
 * Esta clase devuelve true o false dependiendo de la respuesta del usuario para la creación de la Persona.
 */
@Service
public class PersonaBinarioAlmacenarUseCase implements PersonaBinarioAlmacenarPort {

    /**
     * Este método escribe la lista de Personas siempre y cuando el usuario afirme con un si, de lo contrario se cierra.
     *
     * @param personaOutputDTOList Información de la Persona
     * @return boolean
     * @throws IOException
     */
    @Override
    public boolean almacenarBinario(List<PersonaBinarioOutputDTO> personaBinarioOutputDTOList) throws IOException {
        Scanner scanner = new Scanner(System.in);

        File file = new File(RUTA);
        FileOutputStream fileOutputStream = new FileOutputStream(file, true);
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file, true));

        if (file.exists()) {
            System.out.println("El fichero ya existe, ¿quiere continuar? ");
            String respuesta = scanner.next();

            if (respuesta.equalsIgnoreCase("si")) {
                try {

                    fileOutputStream.write(personaBinarioOutputDTOList.toString().getBytes(StandardCharsets.UTF_8));
//                    objectOutputStream.writeObject(personaBinarioOutputDTOList);
                    fileOutputStream.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }

                return true;

            } else fileOutputStream.close();
        }

        throw new FileNotFoundException("No se ha encontrado el fichero.txt");

    }
}
