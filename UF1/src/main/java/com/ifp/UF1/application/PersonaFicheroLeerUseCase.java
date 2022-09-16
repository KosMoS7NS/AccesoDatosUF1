package com.ifp.UF1.application;

import com.ifp.UF1.application.port.PersonaFicheroLeerPort;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class PersonaFicheroLeerUseCase implements PersonaFicheroLeerPort {

    @Override
    public String leerFichero(String ruta) throws IOException {
        FileReader fileReader = new FileReader(new File(ruta));
        BufferedReader bufferedReader;
        String lineaTextoFichero;
        String totalLineasFichero = "";

        bufferedReader = new BufferedReader(fileReader);
        while ((lineaTextoFichero = bufferedReader.readLine()) != null)
            totalLineasFichero += lineaTextoFichero + System.lineSeparator();

        fileReader.close();
        return totalLineasFichero;
    }
}
