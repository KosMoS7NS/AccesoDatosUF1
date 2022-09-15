package com.ifp.UF1.infrastructure.jpa.repository;

import com.ifp.UF1.domain.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<PersonaEntity, Integer> {
}
