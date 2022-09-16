package com.ifp.UF1.application.port;

import com.ifp.UF1.infrastructure.controller.dto.PersonaOutputDTO;

import java.util.List;

public interface PersonaReadPort {
    List<PersonaOutputDTO> getAll();
}
