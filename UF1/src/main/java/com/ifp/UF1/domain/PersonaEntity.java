package com.ifp.UF1.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Esta es la entidad Persona, con anotaciones que permiten la creacion de getters. setters. constructores vacios y
 * con argumentos.
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class PersonaEntity {
    @Id
    private Integer id;
    private String nombre;
    private String apellidos;
    private String ciudad;
    private String nacionalidad;
    private int edad;
}
