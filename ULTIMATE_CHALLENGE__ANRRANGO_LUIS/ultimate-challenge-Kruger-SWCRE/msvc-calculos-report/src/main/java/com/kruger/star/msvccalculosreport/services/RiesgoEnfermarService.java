package com.kruger.star.msvccalculosreport.services;

import com.kruger.star.msvccalculosreport.model.Persona;
import com.kruger.star.msvccalculosreport.model.entitys.RiesgoEnfermar;

import java.util.List;
import java.util.Optional;

public interface RiesgoEnfermarService {

    List<RiesgoEnfermar> listar();
    Optional<RiesgoEnfermar> porId(Long id);
    RiesgoEnfermar guardar(RiesgoEnfermar riesgoEnfermar);
    void eliminar(Long id);
    String calcularNivelRiesgo(RiesgoEnfermar riesgoEnfermar);
    List<RiesgoEnfermar> porIdPaciente(Long id);


    //Para poder representar los datos de persona como pacientes recibidos en Json(Long id es de RiesgoEnfermar) paciente existente
    Optional<Persona> asignarPersona(Persona persona,Long riesgoId);
   //Paciente que no existe en la tabla de Pacientes, enviamos a registrar
    Optional<Persona> crearPersona(Persona persona,Long riesgoId);
    //NO elimina de la bdd solo lo des- asignamos del Riesgo
    Optional<Persona> eliminarPersona(Persona persona,Long riesgoId);

}
