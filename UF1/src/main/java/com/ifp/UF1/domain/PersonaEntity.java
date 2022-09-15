package com.ifp.UF1.domain;

import com.ifp.UF1.infrastructure.controller.dto.PersonaInputDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class PersonaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String apellidos;
    private String ciudad;
    private String nacionalidad;
    private int edad;
    public PersonaEntity(PersonaInputDTO personaInputDTO) {
        if (personaInputDTO == null) return;
        id = personaInputDTO.getId();
        nombre = personaInputDTO.getNombre();
        apellidos = personaInputDTO.getApellidos();
        ciudad = personaInputDTO.getCiudad();
        nacionalidad = personaInputDTO.getNacionalidad();
        edad = personaInputDTO.getEdad();
    }
}
