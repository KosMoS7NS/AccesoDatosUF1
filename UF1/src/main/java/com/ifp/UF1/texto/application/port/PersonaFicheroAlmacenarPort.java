package com.ifp.UF1.texto.application.port;

import com.ifp.UF1.texto.infrastructure.dto.output.PersonaOutputDTO;

import java.io.IOException;
import java.util.List;

/**
 * Puerto con el método de almacenar Personas en un fichero.txt
 */
public interface PersonaFicheroAlmacenarPort {
        /**
         *
         * @param personaOutputDTOList Lista de PersonaOutputDTO
         * @return List
         * @throws IOException
         */
        boolean almacenarFichero(List<PersonaOutputDTO> personaOutputDTOList) throws IOException;
}
