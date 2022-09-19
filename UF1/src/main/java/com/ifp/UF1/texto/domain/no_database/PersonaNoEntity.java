package com.ifp.UF1.texto.domain.no_database;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Esta es la entidad Persona, con anotaciones que permiten la creacion de getters. setters. constructores vacios y
 * con argumentos.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaNoEntity {
    private String nombre;
    private String apellidos;
    private String ciudad;
    private String nacionalidad;
    private int edad;
}
