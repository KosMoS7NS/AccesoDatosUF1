package com.ifp.UF1.infrastructure.controller.dto.output;

import com.ifp.UF1.domain.PersonaEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaOutputDTO {
    private Integer id;
    private String nombre;
    private String apellidos;
    private String ciudad;
    private String nacionalidad;
    private int edad;
}
