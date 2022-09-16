package com.ifp.UF1.application;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifp.UF1.application.port.PersonaMapper;
import com.ifp.UF1.application.port.PersonaReadPort;
import com.ifp.UF1.infrastructure.controller.dto.output.PersonaOutputDTO;
import com.ifp.UF1.infrastructure.jpa.repository.PersonaRepository;

@Service
public class PersonaReadUseCase implements PersonaReadPort {

    @Autowired
    PersonaRepository personaRepository;

    @Override
    public List<PersonaOutputDTO> getAll() {
	List<PersonaOutputDTO> personaOutputDTOList = new ArrayList<>();
	personaRepository.findAll().forEach(
		personaEntity -> personaOutputDTOList.add(PersonaMapper.INSTANCE.personaOutputDto(personaEntity)));

	return personaOutputDTOList;
    }
}
