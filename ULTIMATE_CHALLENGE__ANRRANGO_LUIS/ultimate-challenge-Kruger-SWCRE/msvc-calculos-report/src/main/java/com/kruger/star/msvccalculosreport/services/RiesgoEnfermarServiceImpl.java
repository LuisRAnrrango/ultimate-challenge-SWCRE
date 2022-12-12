package com.kruger.star.msvccalculosreport.services;

import com.kruger.star.msvccalculosreport.clients.PersonaClientRest;
import com.kruger.star.msvccalculosreport.model.Persona;
import com.kruger.star.msvccalculosreport.model.entitys.RiesgoEnfermar;
import com.kruger.star.msvccalculosreport.model.entitys.RiesgoEnfermarPaciente;
import com.kruger.star.msvccalculosreport.repositories.RiesgoEnfermarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RiesgoEnfermarServiceImpl implements RiesgoEnfermarService {

    @Autowired
    private RiesgoEnfermarRepository repository;

    @Autowired
    private PersonaClientRest personaClient;


    @Override
    public List<RiesgoEnfermar> listar() {
        return repository.findAll();
    }

    @Override
    public Optional<RiesgoEnfermar> porId(Long id) {
        return repository.findById(id);
    }

    @Override
    public RiesgoEnfermar guardar(RiesgoEnfermar riesgoEnfermar) {
        return repository.save(riesgoEnfermar);
    }

    @Override
    public void eliminar(Long id) {
repository.deleteById(id);
    }

    @Override
    public String calcularNivelRiesgo(RiesgoEnfermar riesgoEnfermar) {
        String result="";
        double porcAzucar,porcGrasa,porcOxigeno;
        porcAzucar= riesgoEnfermar.getPorcAzucar();
        porcGrasa= riesgoEnfermar.getPorcGrasa();
        porcOxigeno= riesgoEnfermar.getPorcOxigeno();

        if ((porcAzucar >= 0 && porcAzucar <= 100) && (porcGrasa >= 0 && porcGrasa <= 100) && (porcOxigeno >= 0 && porcOxigeno <= 100)) {
            if ((porcAzucar > 70) && (porcGrasa>88.5) && (porcOxigeno<60)) {
                return result ="ALTO";
            }else if ((porcAzucar > 50 && porcAzucar< 70) && (porcGrasa>62.2 && porcGrasa<88.5) && (porcOxigeno>60 && porcOxigeno<70)){
return result="MEDIO";
            }else if((porcAzucar < 50) && (porcGrasa<62.2) && (porcOxigeno>70)){
                return result="BAJO";
            }
            else{
                return result="DATOSIN";
            }



        }
return  result="DATOSIN";
    }

    @Override
    public List<RiesgoEnfermar> porIdPaciente(Long id) {
        List<RiesgoEnfermar> riesgoEnfermarResp=new ArrayList<>() ;
        List<RiesgoEnfermar> riesgos= repository.findAll();
        for (int j = 0; j <riesgos.size(); j++) {
            if(riesgos.get(j).getIdPaciente()==id) {
                riesgoEnfermarResp.add(riesgos.get(j));
            }
        }
        return riesgoEnfermarResp;
    }

    @Override
    @Transactional
    public Optional<Persona> asignarPersona(Persona persona, Long riesgoId) {
      Optional<RiesgoEnfermar> o= repository.findById(riesgoId);
      if(o.isPresent()){
       Persona   personaMsvc= personaClient.detalle(persona.getId());

       RiesgoEnfermar riesgo= o.get();
          RiesgoEnfermarPaciente riesgoEnfermarPaciente= new RiesgoEnfermarPaciente();
          riesgoEnfermarPaciente.setPacienteId(personaMsvc.getId());

          riesgo.addRiesgoEnfermarPaciente(riesgoEnfermarPaciente);
          repository.save(riesgo);
          return  Optional.of(personaMsvc);

      }
      return  Optional.empty();
    }

    @Override
    public Optional<Persona> crearPersona(Persona persona, Long riesgoId) {
        return Optional.empty();
    }

    @Override
    public Optional<Persona> eliminarPersona(Persona persona, Long riesgoId) {
        return Optional.empty();
    }




}
