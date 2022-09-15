package com.ifp.UF1.infrastructure.controller.dto;

import com.ifp.UF1.domain.PersonaEntity;
import lombok.Data;

@Data
public class PersonaOutputDTO {
    private Integer id;
    private String nombre;
    private String apellidos;
    private String ciudad;
    private String nacionalidad;
    private int edad;

    public PersonaOutputDTO(PersonaEntity personaEntity) {
        if (personaEntity == null) return;
        id = personaEntity.getId();
        nombre = personaEntity.getNombre();
        apellidos = personaEntity.getApellidos();
        ciudad = personaEntity.getCiudad();
        nacionalidad = personaEntity.getNacionalidad();
        edad = personaEntity.getEdad();
    }
}
