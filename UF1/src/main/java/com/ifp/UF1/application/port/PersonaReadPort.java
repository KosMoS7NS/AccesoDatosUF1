package com.ifp.UF1.application.port;

import com.ifp.UF1.infrastructure.controller.dto.output.PersonaOutputDTO;

import java.util.List;

/**
 * Puerto con el método de obtener la Persona creada.
 */
public interface PersonaReadPort {
    List<PersonaOutputDTO> getAll();

    List<PersonaOutputDTO> getByName(String nombre);
}
