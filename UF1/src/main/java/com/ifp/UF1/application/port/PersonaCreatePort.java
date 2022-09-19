package com.ifp.UF1.application.port;

import com.ifp.UF1.infrastructure.controller.dto.output.PersonaOutputDTO;

/**
 * Puerto con el método de creación de Personas.
 */
public interface PersonaCreatePort {

    PersonaOutputDTO createPersona() throws Exception;
}
