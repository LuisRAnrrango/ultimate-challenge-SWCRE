package com.kruger.star.msvcpersonas.services;

import com.kruger.star.msvcpersonas.models.entitys.Persona;
import com.kruger.star.msvcpersonas.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private PersonaRepository  repository;

    @Override
    @Transactional(readOnly = true)
    public List<Persona> listar() {
        return  repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Persona> porId(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Persona guardar(Persona persona) {
        return repository.save(persona);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
repository.deleteById(id);
    }
}
