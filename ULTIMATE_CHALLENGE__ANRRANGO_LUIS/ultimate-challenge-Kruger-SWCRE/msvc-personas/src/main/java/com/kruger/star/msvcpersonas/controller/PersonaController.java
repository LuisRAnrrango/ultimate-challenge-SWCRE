package com.kruger.star.msvcpersonas.controller;

import com.kruger.star.msvcpersonas.models.entitys.Persona;
import com.kruger.star.msvcpersonas.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persona/")
public class PersonaController {
     @Autowired
    private PersonaService personaService;


    @GetMapping
    private ResponseEntity<List<Persona>>   getAllPersonas(){
        return ResponseEntity.ok(personaService.listar());

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> detalle(@PathVariable Long id) {
        Optional<Persona> usuarioOptional = personaService.porId(id);
        if (usuarioOptional.isPresent()) {
            return ResponseEntity.ok(usuarioOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    private  ResponseEntity<Persona> savePersona(@RequestBody Persona persona){
        	System.out.println("Datos Recibidos cedula :"+persona.getCedula()+" Nombre"+persona.getNombre()+" Apellido:"+persona.getApellido()+" FechaNA: "+persona.getFechaNacim()+" genero: "+persona.getGenero()+" EstadoCivil: "+persona.getEstadoCivil()+" direccion: "+persona.getDireccion()+" celular: "+persona.getCelular()+" genero: "+persona.getGenero()+" email: "+persona.getEmail()+" paisId: "+persona.getPais().getId()+" Pais:"+persona.getPais().getNombre()+" nombrepais:"+persona.getPais().getNombre()+" CiudadId:"+persona.getProvincia().getId()+" Ciudad:"+persona.getProvincia().getNombre()+" tipoSangre:"+persona.getTipoSangre());
        try {
            Persona personaGuardada= personaService.guardar(persona);
            return ResponseEntity.created(new URI("/personas/"+personaGuardada.getId())).body(personaGuardada);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@RequestBody Persona persona, @PathVariable Long id) {
        Optional<Persona> o = personaService.porId(id);
        if (o.isPresent()) {
            Persona personaDb = o.get();
            personaDb.setNombre(persona.getNombre());
            personaDb.setApellido(persona.getApellido());
            personaDb.setCedula(persona.getCedula());
            personaDb.setFechaNacim(persona.getFechaNacim());
            personaDb.setGenero(persona.getGenero());
            personaDb.setEstadoCivil(persona.getEstadoCivil());
            personaDb.setDireccion(persona.getDireccion());
            personaDb.setCelular(persona.getCelular());
            personaDb.setEmail(persona.getEmail());
            personaDb.setTipoSangre(persona.getTipoSangre());
            return ResponseEntity.status(HttpStatus.CREATED).body(personaService.guardar(personaDb));

        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping (value="delete/{id}")
    private ResponseEntity<Boolean> deletePersona(@PathVariable("id") Long id){
        personaService.eliminar(id);
        return ResponseEntity.ok(!(personaService.porId(id)!=null));
    }
}
