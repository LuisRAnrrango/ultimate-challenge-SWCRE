package com.kruger.star.msvccalculosreport.clients;

import com.kruger.star.msvccalculosreport.model.Persona;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "msvc-personas",url="localhost:8012")
public interface PersonaClientRest {

    @GetMapping("/{id}")
 Persona detalle(@PathVariable Long id);

   @PostMapping("/")
   Persona crear (@RequestBody Persona persona);

}
