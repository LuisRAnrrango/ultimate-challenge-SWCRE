package com.kruger.star.msvcpersonas.controller;

import com.kruger.star.msvcpersonas.models.entitys.Provincia;
import com.kruger.star.msvcpersonas.services.ProvinciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/provincia/")
public class ProvinciaController {
    @Autowired
    private ProvinciaService provinciaService;

    @GetMapping("{id}")
    private ResponseEntity<List<Provincia>>  getAllProvinciaByPais(@PathVariable("id") Long idpais){
        return ResponseEntity.ok(provinciaService.obtenerProvinciasPorPais(idpais));
    }
}
