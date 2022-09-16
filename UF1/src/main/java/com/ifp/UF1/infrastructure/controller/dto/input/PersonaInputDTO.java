package com.ifp.UF1.infrastructure.controller.dto.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaInputDTO {
    private Integer id;
    private String nombre;
    private String apellidos;
    private String ciudad;
    private String nacionalidad;
    private int edad;
}
