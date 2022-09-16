package com.ifp.UF1.application.port;

import com.ifp.UF1.infrastructure.controller.dto.output.PersonaOutputDTO;

import java.io.IOException;

public interface PersonaFicheroAlmacenarPort {
    void almacenarFichero(PersonaOutputDTO personaOutputDTO) throws IOException;
}
