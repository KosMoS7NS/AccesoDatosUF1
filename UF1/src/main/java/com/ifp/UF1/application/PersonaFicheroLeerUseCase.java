package com.ifp.UF1.application;

import com.ifp.UF1.application.port.PersonaFicheroLeer;
import com.ifp.UF1.application.port.PersonaMapper;
import com.ifp.UF1.configuration.PersonaStaticConfig;
import com.ifp.UF1.domain.PersonaEntity;
import com.ifp.UF1.infrastructure.controller.dto.input.PersonaInputDTO;
import com.ifp.UF1.infrastructure.controller.dto.output.PersonaOutputDTO;
import com.ifp.UF1.infrastructure.jpa.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

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
    public List leerFicheroNombre(PersonaOutputDTO personaOutputDTO, String ruta, String nombre) throws IOException {
        FileReader fileReader = new FileReader(new File(ruta));
        bufferedReader = new BufferedReader(fileReader);

        List personaList = new ArrayList<>();

        while ((lineaTextoFichero = bufferedReader.readLine()) != null) {
            if (PersonaStaticConfig.NOMBRE.equalsIgnoreCase(personaOutputDTO.getNombre())) {
                totalLineasFichero += lineaTextoFichero + System.lineSeparator();
                personaList.add(totalLineasFichero);
            }

        }
        fileReader.close();
        return personaList;
    }
}
