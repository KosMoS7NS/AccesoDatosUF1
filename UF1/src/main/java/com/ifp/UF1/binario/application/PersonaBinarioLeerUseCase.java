package com.ifp.UF1.binario.application;

import com.ifp.UF1.binario.application.port.PersonaBinarioLeerPort;
import com.ifp.UF1.binario.domain.no_database.PersonaBinarioNoEntity;
import com.ifp.UF1.binario.infrastructure.dto.output.PersonaBinarioOutputDTO;
import com.ifp.UF1.texto.infrastructure.dto.output.PersonaOutputDTO;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.ifp.UF1.shared.configuration.PersonaStaticConfig.NOMBRE;

/**
 * Esta clase esta compuesta por dos métodos.
 * <p>
 * EL primer método leerFichero devuelve una lista con todas las personas del fichero.txt
 * <p>
 * El segundo método leerFicheroNombre devuelve una lista con los datos de una persona del fichero.txt
 */
@Service
public class PersonaBinarioLeerUseCase implements PersonaBinarioLeerPort {

    private final List personaList = new ArrayList<>();
    private BufferedReader bufferedReader;
    private String lineaTextoFichero;

    /**
     * @param ruta Ruta del fichero.txt
     * @return List
     * @throws IOException
     */
    @Override
    public void leerBinario(String ruta) throws IOException, ClassNotFoundException {
        InputStream inputStream = new FileInputStream(new File(ruta));

        int content;
        while ((content = inputStream.read()) != -1) System.out.print((char) content);
        inputStream.close();
    }

    /**
     * @param ruta   Ruta del fichero.txt
     * @param nombre Nombre de la persona
     * @return List
     * @throws IOException
     */
    public List leerFicheroNombre(String ruta, String nombre) throws IOException {

        FileReader fileReader = new FileReader(new File(ruta));
        bufferedReader = new BufferedReader(fileReader);

        while ((lineaTextoFichero = bufferedReader.readLine()) != null) {
            String[] infoSplit = lineaTextoFichero.split("=");

            if (infoSplit.length > 1 && NOMBRE.equalsIgnoreCase(infoSplit[1]
                    .substring(0, infoSplit[1].length() - 11)))
                personaList.add(System.lineSeparator() + lineaTextoFichero);

        }
        fileReader.close();

        return personaList;
    }
}
