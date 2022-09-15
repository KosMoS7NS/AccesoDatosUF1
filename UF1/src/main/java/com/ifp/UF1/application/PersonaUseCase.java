package com.ifp.UF1.application;

import com.ifp.UF1.application.port.PersonaPort;
import com.ifp.UF1.domain.PersonaEntity;
import com.ifp.UF1.infrastructure.controller.dto.PersonaInputDTO;
import com.ifp.UF1.infrastructure.controller.dto.PersonaOutputDTO;
import com.ifp.UF1.infrastructure.jpa.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaUseCase implements PersonaPort {

    @Autowired
    PersonaRepository personaRepository;

    @Override
    public List<PersonaOutputDTO> getAll() {

        /**
         * Se crea una lista de PersonaOuputDTO que se utilizara en la conversion de una entidad para tener la
         * aplicacion más segura.
         *
         * Se instancia PersonaInputDTO.
         */

        List<PersonaOutputDTO> personaOutputDTOList = new ArrayList<>();
        PersonaInputDTO personaInputDTO = new PersonaInputDTO();

        /**
         * Se setean los datos en la clase persanaInputDTO. Este proceso seria mejor hacer con peticiones POST enviando
         * un Body, pero no es el objetivo del ejercicio.
         */

        personaInputDTO.setNombre("Daniel");
        personaInputDTO.setApellidos("Díez Miguel");
        personaInputDTO.setCiudad("Logroño");
        personaInputDTO.setNacionalidad("España");

        /**
         * Se instancia PersonaOutputDTO, pasando como parametro un metodo que permite persistir la informacion.
         * La informacion que guarda es de la PersonaEntity, cuyo parametro el PersonaInputDTO que tiene los datos
         * seteados anteriormente.
         */

        PersonaOutputDTO personaOutputDTO = new PersonaOutputDTO(personaRepository
                .save(new PersonaEntity(personaInputDTO)));

        /**
         * Transformamos Persona en DTO para no exponer la entidad y cumplir la arquitectura hexgonal.
         *  No se utlizan controladores ya que no se realiza ninguna petición http.
         */

        personaRepository.findAll()
                .forEach(personaEntity -> personaOutputDTOList.add(personaOutputDTO));

        /**
         * Devolvemos la lista
         */

        return personaOutputDTOList;
    }
}
