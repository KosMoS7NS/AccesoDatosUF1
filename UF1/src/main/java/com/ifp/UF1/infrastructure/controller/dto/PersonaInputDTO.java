package com.ifp.UF1.infrastructure.controller.dto;

import lombok.Data;

@Data
public class PersonaInputDTO {
    private Integer id;
    private String nombre;
    private String apellidos;
    private String ciudad;
    private String nacionalidad;
    private int edad;
}
