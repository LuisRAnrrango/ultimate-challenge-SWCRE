package com.kruger.star.msvcpersonas.services;

import com.kruger.star.msvcpersonas.models.entitys.Persona;

import java.util.List;
import java.util.Optional;

public interface PersonaService {
    List<Persona> listar();
    Optional<Persona> porId(Long id);
    Persona guardar(Persona persona);
    void eliminar(Long id);
}
