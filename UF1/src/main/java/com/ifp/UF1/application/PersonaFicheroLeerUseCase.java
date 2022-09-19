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

    private BufferedReader bufferedReader;
    private String lineaTextoFichero;
    private String totalLineasFichero = "";
    private List personaList = new ArrayList<>();

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
     *
     * @param ruta Ruta del fichero.txt
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
                totalLineasFichero += lineaTextoFichero + System.lineSeparator();
//                String[] infoSplit = lineaTextoFichero.split("=");
                String[] infoSplit = lineaTextoFichero.split("\\(|=|,");
//                String[] infoSplit = lineaTextoFichero.split("=|,");

                if (NOMBRE.equalsIgnoreCase(infoSplit[4])) {
                    totalLineasFichero += lineaTextoFichero + System.lineSeparator();
                    personaList.add(lineaTextoFichero);

                }
                System.out.println("PERSONA 0: " + infoSplit[0]);
                System.out.println("PERSONA 1: " + infoSplit[1]);
                System.out.println("PERSONA 2: " + infoSplit[2]);
                System.out.println("PERSONA 3: " + infoSplit[3]);
                System.out.println("PERSONA 4: " + infoSplit[4]);

            }


            fileReader.close();

        } catch (Exception e) {
            throw new FileNotFoundException("No se ha encontrado la ruta del fichero");
        }

        return personaList;
    }
}
