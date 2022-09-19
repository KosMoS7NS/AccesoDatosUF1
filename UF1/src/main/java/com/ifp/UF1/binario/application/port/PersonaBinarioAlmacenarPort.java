package com.ifp.UF1.binario.application.port;

import com.ifp.UF1.binario.infrastructure.dto.output.PersonaBinarioOutputDTO;
import com.ifp.UF1.texto.infrastructure.dto.output.PersonaOutputDTO;

import java.io.IOException;
import java.util.List;

/**
 * Puerto con el método de almacenar Personas en un fichero.txt
 */
public interface PersonaBinarioAlmacenarPort {
//        boolean almacenarBinario(List<PersonaOutputDTO> personaOutputDTOList) throws IOException;

        boolean almacenarBinario(List<PersonaBinarioOutputDTO> personaBinarioOutputDTOList) throws IOException;
}
