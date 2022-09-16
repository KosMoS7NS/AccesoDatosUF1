package com.ifp.UF1.application.port;

import com.ifp.UF1.infrastructure.controller.dto.input.PersonaInputDTO;
import com.ifp.UF1.infrastructure.controller.dto.output.PersonaOutputDTO;

import java.io.IOException;
import java.util.List;

public interface PersonaFicheroLeer {
    String leerFichero(String ruta) throws IOException;

//    List leerFicheroNombre(String ruta, String nombre) throws IOException;

    List leerFicheroNombre(PersonaOutputDTO personaOutputDTO, String ruta, String nombre) throws IOException;

//    List leerFicheroNombre(PersonaOutputDTO personaOutputDTO, String ruta, String nombre) throws IOException;
}
