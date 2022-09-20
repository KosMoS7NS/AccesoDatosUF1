package com.ifp.UF1.texto.application;

import com.ifp.UF1.texto.application.port.PersonaFicheroLeerPort;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static com.ifp.UF1.shared.configuration.PersonaStaticConfig.NOMBRE;

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

    /**
     * @param ruta Ruta del fichero.txt
     * @return List
     * @throws IOException
     */
    @Override
    public List leerFichero(String ruta) throws IOException {
        bufferedReader = new BufferedReader(new FileReader(new File(ruta)));

        while ((lineaTextoFichero = bufferedReader.readLine()) != null)
            personaList.add(System.lineSeparator() + lineaTextoFichero);

        bufferedReader.close();
        return personaList;
    }

    /**
     * @param ruta Ruta del fichero.txt
     * @param nombre Nombre de la persona a buscar en el fichero.txt
     * @return List
     * @throws IOException
     */
    @Override
    public List leerFicheroNombre(String ruta, String nombre) throws IOException {
        bufferedReader = new BufferedReader(new FileReader(new File(ruta)));

        while ((lineaTextoFichero = bufferedReader.readLine()) != null) {
            String[] infoSplit = lineaTextoFichero.split("=");

            if (infoSplit.length > 1 && NOMBRE.equalsIgnoreCase(infoSplit[1]
                    .substring(0, infoSplit[1].length() - 11)))
                personaList.add(System.lineSeparator() + lineaTextoFichero);

        }
        bufferedReader.close();
        return personaList;
    }
}
