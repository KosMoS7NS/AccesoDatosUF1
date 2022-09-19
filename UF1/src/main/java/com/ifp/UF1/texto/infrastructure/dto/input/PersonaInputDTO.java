package com.ifp.UF1.texto.infrastructure.dto.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Se utilizan DTOS para securizar la api porque nunca hay que exponer la entidad.
 * <p>
 * Esta clase tiene los datos para la craeción de Personas.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaInputDTO {
    private String nombre;
    private String apellidos;
    private String ciudad;
    private String nacionalidad;
    private int edad;
}
