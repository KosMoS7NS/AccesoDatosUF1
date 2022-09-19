package com.ifp.UF1.infrastructure.jpa.repository;

import com.ifp.UF1.domain.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Este repositorio se utilizara para metodos de creación de las Personas.
 */
@Repository
public interface PersonaRepository extends JpaRepository<PersonaEntity, Integer> {
}
