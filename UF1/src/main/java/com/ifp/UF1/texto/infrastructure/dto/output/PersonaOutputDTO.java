package com.ifp.UF1.texto.infrastructure.dto.output;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Se utilizan DTOS para securizar la api porque nunca hay que exponer la entidad.
 * <p>
 * Esta clase tiene los datos para la conversion de la entidad Personas.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaOutputDTO {
    private String nombre;
    private String apellidos;
    private String ciudad;
    private String nacionalidad;
    private int edad;
}
