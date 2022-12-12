package com.kruger.star.msvcpersonas.repositories;

import com.kruger.star.msvcpersonas.models.entitys.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona,Long> {
}
