package com.kruger.star.msvcpersonas.services;

import com.kruger.star.msvcpersonas.models.entitys.Provincia;
import com.kruger.star.msvcpersonas.repositories.PaisRepository;
import com.kruger.star.msvcpersonas.repositories.ProvinciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProvinciaServiceImpl implements  ProvinciaService{

    @Autowired
    private ProvinciaRepository repository;


    @Override
    public List<Provincia> obtenerProvinciasPorPais(Long id) {
        List<Provincia> provinciarespuesta=new ArrayList<>() ;
        List<Provincia> provincias= repository.findAll();
        for (int j = 0; j <provincias.size(); j++) {
            if(provincias.get(j).getPais().getId()==id) {
                provinciarespuesta.add(provincias.get(j));
            }
        }
        return provinciarespuesta;
    }
}
