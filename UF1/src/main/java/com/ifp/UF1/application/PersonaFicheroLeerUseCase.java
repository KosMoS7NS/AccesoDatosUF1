package com.ifp.UF1.application;

import com.ifp.UF1.application.port.PersonaFicheroLeerPort;
import com.ifp.UF1.configuration.PersonaStaticConfig;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static com.ifp.UF1.configuration.PersonaStaticConfig.*;

/**
 * Esta clase esta compuesta por dos métodos.
 * <p>
 * EL primer método leerFichero devuelve una lista con todas las personas del fichero.txt
 * <p>
 * El segundo método leerFicheroNombre devuelve una lista con los datos de una persona del fichero.txt
 */
@Service
public class PersonaFicheroLeerUseCase implements PersonaFicheroLeerPort {

    private final List personaList = new ArrayList<>();
    private BufferedReader bufferedReader;
    private String lineaTextoFichero;
    private String totalLineasFichero = "";

    /**
     * @param ruta Ruta del fichero.txt
     * @return List
     * @throws IOException
     */
    @Override
    public List leerFichero(String ruta) throws IOException {
        try {
            FileReader fileReader = new FileReader(new File(ruta));
            bufferedReader = new BufferedReader(fileReader);

            while ((lineaTextoFichero = bufferedReader.readLine()) != null)
                totalLineasFichero += lineaTextoFichero + System.lineSeparator();

            personaList.add(totalLineasFichero);
            fileReader.close();

        } catch (Exception e) {
            throw new FileNotFoundException("No se ha encontrado la ruta del fichero");
        }
        return personaList;
    }

    /**
     * @param ruta   Ruta del fichero.txt
     * @param nombre Nombre de la persona
     * @return List
     * @throws IOException
     */
    @Override
    public List leerFicheroNombre(String ruta, String nombre) throws IOException {

        try {
            FileReader fileReader = new FileReader(new File(ruta));
            bufferedReader = new BufferedReader(fileReader);

            while ((lineaTextoFichero = bufferedReader.readLine()) != null) {
                String[] infoSplit = lineaTextoFichero.split("=");

                if (infoSplit.length > 1 && NOMBRE.equalsIgnoreCase(infoSplit[2].substring(0, 1)))
                    personaList.add(lineaTextoFichero + System.lineSeparator());
            }
            fileReader.close();

        } catch (Exception e) {
            throw new FileNotFoundException("No se ha encontrado la ruta del fichero");
        }

        return personaList;
    }
}
