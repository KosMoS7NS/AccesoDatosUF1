package com.ifp.UF1.application.port;

import com.ifp.UF1.infrastructure.controller.dto.output.PersonaOutputDTO;

import java.io.IOException;

public interface PersonaFicheroAlmacenarPort {
    boolean almacenarFichero(PersonaOutputDTO personaOutputDTO) throws IOException;
}
