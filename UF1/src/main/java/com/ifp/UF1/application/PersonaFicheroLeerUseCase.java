package com.ifp.UF1.application;

import com.ifp.UF1.application.port.PersonaFicheroLeer;
import com.ifp.UF1.application.port.PersonaMapper;
import com.ifp.UF1.domain.PersonaEntity;
import com.ifp.UF1.infrastructure.controller.dto.output.PersonaOutputDTO;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
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
    public List leerFicheroNombre(String ruta, String nombre) throws IOException {

        FileReader fileReader = new FileReader(new File(ruta));
        bufferedReader = new BufferedReader(fileReader);

        List personaList = new ArrayList<>();
        List<PersonaOutputDTO> nombresList = new ArrayList<>();
        String[] infoSplit = new String[0];


        int i = 1;
        int j = 3;
        int k = 5;
        int l = 7;
        int m = 9;
        int n = 11;
        while ((lineaTextoFichero = bufferedReader.readLine()) != null) {
            totalLineasFichero += lineaTextoFichero + System.lineSeparator();
//            infoSplit = totalLineasFichero.split(",|\\=");
//
//
//            personaList.add(PersonaMapper.INSTANCE.personaOutputDto(
//                    new PersonaEntity(
//                            Integer.valueOf(infoSplit[i]),
//                            infoSplit[j],
//                            infoSplit[k],
//                            infoSplit[l],
//                            infoSplit[m],
//                            Integer.parseInt(infoSplit[n].substring(0, 2)))
//            ));
//
//            i+=2;
//            j+=2;
//            k+=2;
//            l+=2;
//            m+=2;
//            n+=2;
//        }
}
        infoSplit = totalLineasFichero.split(",|\\=");
        System.out.println(infoSplit[1]);
        System.out.println(infoSplit[3]);
        System.out.println(infoSplit[5]);
        System.out.println(infoSplit[7]);
        System.out.println(infoSplit[9]);
        System.out.println(infoSplit[11].substring(0, 2));

        System.out.println(infoSplit[12]);
        System.out.println(infoSplit[14]);
        System.out.println(infoSplit[16]);
        System.out.println(infoSplit[18]);
        System.out.println(infoSplit[20]);
        System.out.println(infoSplit[22].substring(0, 2));

        System.out.println(infoSplit[23]);
        System.out.println(infoSplit[25]);
        System.out.println(infoSplit[27]);
        System.out.println(infoSplit[29]);
        System.out.println(infoSplit[31]);
        System.out.println(infoSplit[33].substring(0, 2));

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
