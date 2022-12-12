package com.kruger.star.msvcpersonas.services;

import com.kruger.star.msvcpersonas.models.entitys.Persona;
import com.kruger.star.msvcpersonas.repositories.PersonaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static org.hamcrest.Matchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static reactor.core.publisher.Mono.when;

class PersonaServiceImplTest {
    /*
    @Mock
    private PersonaRepository repository;
    @InjectMocks
    private PersonaServiceImpl personaService;
    private Persona persona;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        persona =new Persona();
        persona.setId(new Long("1"));
        persona.setNombre("Luisito");

    }

    @Test
    void guardar() {
        when(repository.save(any(Persona.class))).thenReturn(Arrays.asList(persona));
    }

     */
}