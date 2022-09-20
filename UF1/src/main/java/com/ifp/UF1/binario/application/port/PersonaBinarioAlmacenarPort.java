package com.ifp.UF1.binario.application.port;

import com.ifp.UF1.binario.infrastructure.dto.output.PersonaBinarioOutputDTO;
import com.ifp.UF1.texto.infrastructure.dto.output.PersonaOutputDTO;

import java.io.IOException;
import java.util.List;

/**
 * Puerto con el método de almacenar Personas en un fichero.dat
 */
public interface PersonaBinarioAlmacenarPort {

        /**
         *
         * @param personaBinarioOutputDTOList Lista de PersonaBinarioOutputDTO
         * @return List
         * @throws IOException
         */
        boolean almacenarBinario(List<PersonaBinarioOutputDTO> personaBinarioOutputDTOList) throws IOException;

}
