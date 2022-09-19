package com.ifp.UF1.application.port;

import com.ifp.UF1.domain.PersonaEntity;
import com.ifp.UF1.infrastructure.controller.dto.input.PersonaInputDTO;
import com.ifp.UF1.infrastructure.controller.dto.output.PersonaOutputDTO;
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

    PersonaOutputDTO personaOutputDto(PersonaEntity personaEntity);
    List<PersonaEntity> personaEntityList(List<PersonaInputDTO> personaInputDTOList);
    List<PersonaOutputDTO> personaOutputDtoListEntity(List<PersonaEntity> personaEntityList);
    List<PersonaOutputDTO> personaOutputDtoList(List<PersonaInputDTO> personaInputDTOList);
}
