package com.ifp.UF1.shared.port;

import com.ifp.UF1.binario.domain.no_database.PersonaBinarioNoEntity;
import com.ifp.UF1.binario.infrastructure.dto.input.PersonaBinarioInputDTO;
import com.ifp.UF1.binario.infrastructure.dto.output.PersonaBinarioOutputDTO;
import com.ifp.UF1.texto.domain.no_database.PersonaNoEntity;
import com.ifp.UF1.texto.infrastructure.dto.input.PersonaInputDTO;
import com.ifp.UF1.texto.infrastructure.dto.output.PersonaOutputDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Puerto con un mapeo de los DTOS a Entidades y estas a DTOS
 */
@Mapper
public interface PersonaMapperPort {

    PersonaMapperPort INSTANCE = Mappers.getMapper(PersonaMapperPort.class);

    PersonaNoEntity personaEntity(PersonaInputDTO personaInputDTO);

    List<PersonaOutputDTO> personaOutputDtoList(List<PersonaNoEntity> personaNoEntityList);

    PersonaBinarioNoEntity personaBinarioNoEntity(PersonaBinarioInputDTO personaBinarioInputDTO);

    List<PersonaBinarioOutputDTO> personaBinarioOutputDtoList(List<PersonaBinarioNoEntity> personaBinarioNoEntityList);

}
