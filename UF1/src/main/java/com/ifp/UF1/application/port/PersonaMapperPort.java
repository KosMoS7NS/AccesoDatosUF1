package com.ifp.UF1.application.port;

import com.ifp.UF1.domain.PersonaEntity;
import com.ifp.UF1.infrastructure.dto.input.PersonaInputDTO;
import com.ifp.UF1.infrastructure.dto.output.PersonaOutputDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Puerto con un mapeo de los DTOS a Entidades y estas a DTOS
 */
@Mapper
public interface PersonaMapperPort {

    PersonaMapperPort INSTANCE = Mappers.getMapper(PersonaMapperPort.class);

    PersonaEntity personaEntity(PersonaInputDTO personaInputDTO);

    List<PersonaOutputDTO> personaOutputDtoList(List<PersonaEntity> personaEntityList);

}
