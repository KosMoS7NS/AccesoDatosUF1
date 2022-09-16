package com.ifp.UF1.application;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifp.UF1.application.port.PersonaMapper;
import com.ifp.UF1.application.port.PersonaReadPort;
import com.ifp.UF1.infrastructure.controller.dto.output.PersonaOutputDTO;
import com.ifp.UF1.infrastructure.jpa.repository.PersonaRepository;

/**
 * Esta clase devuelve una lista con la Persona que se ha creado en otros Casos de Uso
 *
 */
@Service
public class PersonaReadUseCase implements PersonaReadPort {

    @Autowired
    PersonaRepository personaRepository;

    /**
     * Se utiliza una lambda para la conversion de una Entidad a un DTO por cada instancia encontrada
     * @return List
     */
    @Override
    public List<PersonaOutputDTO> getAll() {
	List<PersonaOutputDTO> personaOutputDTOList = new ArrayList<>();
	personaRepository.findAll().forEach(
		personaEntity -> personaOutputDTOList.add(PersonaMapper.INSTANCE.personaOutputDto(personaEntity)));

	return personaOutputDTOList;
    }
}
