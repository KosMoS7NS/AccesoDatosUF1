package com.ifp.UF1.application.port;

import com.ifp.UF1.infrastructure.dto.output.PersonaOutputDTO;

import java.io.IOException;
import java.util.List;

/**
 * Puerto con el método de almacenar Personas en un fichero.txt
 */
public interface PersonaFicheroAlmacenarPort {
        boolean almacenarFichero(List<PersonaOutputDTO> personaOutputDTOList) throws IOException;
}
