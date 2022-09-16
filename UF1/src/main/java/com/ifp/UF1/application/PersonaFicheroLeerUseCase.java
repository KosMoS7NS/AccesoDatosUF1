package com.ifp.UF1.application;

import com.ifp.UF1.application.port.PersonaFicheroLeer;
import com.ifp.UF1.domain.PersonaEntity;
import com.ifp.UF1.infrastructure.controller.dto.output.PersonaOutputDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PersonaFicheroLeerUseCase implements PersonaFicheroLeer {

    private BufferedReader bufferedReader;
    private String lineaTextoFichero;
    private String totalLineasFichero = "";

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
        bufferedReader = new BufferedReader(fileReader);

        List personaList = new ArrayList<>();
        List<PersonaOutputDTO> nombresList = new ArrayList<>();
        String[] infoSplit;

        while ((lineaTextoFichero = bufferedReader.readLine()) != null)
            totalLineasFichero += lineaTextoFichero + System.lineSeparator();

        infoSplit = totalLineasFichero.split(",|\\=");
        personaList.add(infoSplit[3]);

        List<String> nombres = nombresList.stream()
                .map(PersonaOutputDTO::getNombre)
                        .collect(Collectors.toList());


        personaList.stream()
                .filter(persona -> nombres.contains(persona))
                .forEach(System.out::println);

        fileReader.close();
        return personaList;
    }
}
