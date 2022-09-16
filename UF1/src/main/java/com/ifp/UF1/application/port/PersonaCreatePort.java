package com.ifp.UF1.application.port;

import com.ifp.UF1.infrastructure.controller.dto.output.PersonaOutputDTO;

public interface PersonaCreatePort {
//    PersonaOutputDTO createPersona();

    PersonaOutputDTO createPersona(Integer id, String nombre, String apellidos, String ciudad,
                                   String nacionalidad, int edad);
}
