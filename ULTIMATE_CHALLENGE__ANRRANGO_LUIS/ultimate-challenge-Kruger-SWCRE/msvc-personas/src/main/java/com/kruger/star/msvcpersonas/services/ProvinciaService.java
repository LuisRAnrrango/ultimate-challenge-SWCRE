package com.kruger.star.msvcpersonas.services;


import com.kruger.star.msvcpersonas.models.entitys.Provincia;

import java.util.List;


public interface ProvinciaService {
    List<Provincia> obtenerProvinciasPorPais(Long id);
}
