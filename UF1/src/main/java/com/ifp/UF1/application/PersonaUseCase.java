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

    /**
     * Se crea una lista de PersonaOuputDTO que se utilizara en la conversion de una entidad para tener la
     * aplicacion más segura.
     * <p>
     * Se setean los datos en la clase persanaInputDTO. Este proceso seria mejor hacer con peticiones POST enviando
     * un Body, pero no es el objetivo del ejercicio.
     * <p>
     * Se instancia PersonaOutputDTO, pasando como parametro un metodo que permite persistir la informacion.
     * La informacion que guarda es de la PersonaEntity, cuyo parametro el PersonaInputDTO que tiene los datos
     * seteados anteriormente.
     * <p>
     * Transformamos Persona en DTO para no exponer la entidad y cumplir la arquitectura hexgonal.
     * No se utlizan controladores ya que no se realiza ninguna petición http.
     *
     * @return Lista de PersonaOutputDTO
     */

    @Override
    public List<PersonaOutputDTO> getAll() {

        List<PersonaOutputDTO> personaOutputDTOList = new ArrayList<>();
        PersonaInputDTO personaInputDTO = new PersonaInputDTO();

        personaInputDTO.setNombre("Daniel");
        personaInputDTO.setApellidos("Díez Miguel");
        personaInputDTO.setCiudad("Logroño");
        personaInputDTO.setNacionalidad("España");

        PersonaOutputDTO personaOutputDTO = new PersonaOutputDTO(personaRepository
                .save(new PersonaEntity(personaInputDTO)));

        personaRepository.findAll()
                .forEach(personaEntity -> personaOutputDTOList.add(personaOutputDTO));

        return personaOutputDTOList;
    }
}
