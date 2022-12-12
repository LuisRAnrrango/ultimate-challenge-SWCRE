package com.kruger.star.msvcpersonas.services;

import com.kruger.star.msvcpersonas.models.entitys.Pais;
import com.kruger.star.msvcpersonas.repositories.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaisServiceImpl implements PaisService {

    @Autowired
    private PaisRepository repository;


    @Override
    public List<Pais> listar() {
        return repository.findAll();
    }
}
