package com.ifp.UF1.application.port;

import com.ifp.UF1.domain.PersonaEntity;
import com.ifp.UF1.infrastructure.controller.dto.PersonaInputDTO;
import com.ifp.UF1.infrastructure.controller.dto.PersonaOutputDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonaMapper {

    PersonaMapper INSTANCE = Mappers.getMapper(PersonaMapper.class);

    PersonaEntity personaEntity(PersonaInputDTO personaInputDTO);

    PersonaOutputDTO personaOutputDto(PersonaEntity personaEntity);
}
