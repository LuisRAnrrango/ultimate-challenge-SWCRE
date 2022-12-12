package com.kruger.star.msvccalculosreport.controller;

import com.kruger.star.msvccalculosreport.model.Persona;
import com.kruger.star.msvccalculosreport.model.entitys.RiesgoEnfermar;
import com.kruger.star.msvccalculosreport.services.RiesgoEnfermarService;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("calcular")
public class RiesgoEnfermarController {
    @Autowired
    private RiesgoEnfermarService  riesgoEnfermarService;

    @GetMapping
    private ResponseEntity<List<RiesgoEnfermar>> getAllPersonas(){
        return ResponseEntity.ok(riesgoEnfermarService.listar());
    }
    @GetMapping("{id}")
    private ResponseEntity<List<RiesgoEnfermar>>  getAllProvinciaByPais(@PathVariable("id") Long idpaciente){
        return ResponseEntity.ok(riesgoEnfermarService.porIdPaciente(idpaciente));
    }
    @PostMapping
    private  ResponseEntity<?> savePersona(@RequestBody RiesgoEnfermar riesgoEnfermar){
        try {
           String resultCalc= riesgoEnfermarService.calcularNivelRiesgo(riesgoEnfermar);
           if(resultCalc.equals("ALTO")){
               riesgoEnfermar.setPorcResultado("ALTO");
               RiesgoEnfermar analisisGuardado= riesgoEnfermarService.guardar(riesgoEnfermar);
               return ResponseEntity.created(new URI("/result/"+analisisGuardado.getId())).body(analisisGuardado);
           }else if(resultCalc.equals("MEDIO")){
               riesgoEnfermar.setPorcResultado("MEDIO");
               RiesgoEnfermar analisisGuardado= riesgoEnfermarService.guardar(riesgoEnfermar);
               return ResponseEntity.created(new URI("/result/"+analisisGuardado.getId())).body(analisisGuardado);
           }else if(resultCalc.equals("BAJO")){
               riesgoEnfermar.setPorcResultado("BAJO");
               RiesgoEnfermar analisisGuardado= riesgoEnfermarService.guardar(riesgoEnfermar);
               return ResponseEntity.created(new URI("/result/"+analisisGuardado.getId())).body(analisisGuardado);
           }
           else {
           //   return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
       return  ResponseEntity.badRequest()
               .body(Collections
                       .singletonMap("mensaje","Datos fuera de Rango"));

           }



        } catch (Exception e) {
            return  ResponseEntity.badRequest()
                    .body(Collections
                            .singletonMap("mensaje","Datos fuera de Rango"));
        }

    }
    @PutMapping("/asignar-Usuario/{riesgoId}")
            public ResponseEntity<?> asiganarPersona(@RequestBody Persona persona, @PathVariable Long riesgoId){
Optional<Persona>o=null;
try {
    o=riesgoEnfermarService.asignarPersona(persona, riesgoId);

}catch (FeignException e){

    return  ResponseEntity.status(HttpStatus.NOT_FOUND )
            .body(Collections.singletonMap("mensaje","No existe El Paciente por"+
           "el id o error en la informacion: "+e.getMessage()));


}
    if(o.isPresent()){
        return ResponseEntity.status(HttpStatus.CREATED).body((o.get()));
    }
    return  ResponseEntity.notFound().build();
    }


    {

    }









}
