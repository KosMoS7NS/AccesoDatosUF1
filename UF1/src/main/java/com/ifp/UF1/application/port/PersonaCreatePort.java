package com.ifp.UF1.application.port;

import com.ifp.UF1.infrastructure.controller.dto.output.PersonaOutputDTO;

import java.util.List;

/**
 * Puerto con el método de creación de Personas.
 */
public interface PersonaCreatePort {

    List<PersonaOutputDTO> createPersona() throws Exception;
}
