package com.ifp.UF1.binario.domain.no_database;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Esta es la entidad PersonaBinario, con anotaciones que permiten la creacion de getters. setters. constructores vacios
 * y con argumentos.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaBinarioNoEntity {
    private String nombre;
    private String apellidos;
    private String ciudad;
    private String nacionalidad;
    private int edad;
}
