package com.ifp.UF1.application;

import com.ifp.UF1.application.port.PersonaFicheroLeer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaFicheroLeerUseCase implements PersonaFicheroLeer {

    private BufferedReader bufferedReader;
    private String lineaTextoFichero;
    private String totalLineasFichero;

    @Override
    public String leerFichero(String ruta) throws IOException {
        FileReader fileReader = new FileReader(new File(ruta));

        bufferedReader = new BufferedReader(fileReader);
        while ((lineaTextoFichero = bufferedReader.readLine()) != null)
            totalLineasFichero += lineaTextoFichero + System.lineSeparator();

        fileReader.close();
        return totalLineasFichero;
    }

    @Override
    public List leerFicheroNombre(String ruta) throws IOException {
        FileReader fileReader = new FileReader(new File(ruta));
        List personaList = new ArrayList<>();
        String[] infoSplit;

        bufferedReader = new BufferedReader(fileReader);
        while ((lineaTextoFichero = bufferedReader.readLine()) != null)
            totalLineasFichero += lineaTextoFichero + System.lineSeparator();

        personaList.add(totalLineasFichero);
        infoSplit = totalLineasFichero.split("=");

        System.out.println("INFOSPLIT: " + infoSplit[0]);
        System.out.println("INFOSPLIT: " + infoSplit[1]);
        System.out.println("INFOSPLIT: " + infoSplit[2]);
        System.out.println("");

        personaList.stream()
                .filter(persona -> persona.equals(infoSplit[1]))
                .forEach(System.out::println);

        fileReader.close();
        return personaList;
    }
}
