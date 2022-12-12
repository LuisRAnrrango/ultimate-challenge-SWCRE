package com.kruger.star.msvccalculosreport.model.entitys;


import com.kruger.star.msvccalculosreport.model.Persona;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="riesgo_enfermar")
public class RiesgoEnfermar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double porcAzucar;
    private double porcGrasa;
    private double porcOxigeno;
    private String porcResultado;
    private Long idPaciente;
    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "riesgo_id")
    private List<RiesgoEnfermarPaciente> riesgoEnfermarPacientes;
    @Transient
    private List<Persona> pacientes;

public RiesgoEnfermar(){
    riesgoEnfermarPacientes=new  ArrayList<>();
    pacientes=new ArrayList<>();
}

    public RiesgoEnfermar(double porcAzucar, double porcGrasa, double porcOxigeno, String porcResultado, Long idPaciente, List<RiesgoEnfermarPaciente> riesgoEnfermarPacientes, List<Persona> pacientes) {
        this.porcAzucar = porcAzucar;
        this.porcGrasa = porcGrasa;
        this.porcOxigeno = porcOxigeno;
        this.porcResultado = porcResultado;
        this.idPaciente = idPaciente;
        this.riesgoEnfermarPacientes = riesgoEnfermarPacientes;
        this.pacientes = pacientes;
    }

    public Long getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Long idPaciente) {
        this.idPaciente = idPaciente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPorcAzucar() {
        return porcAzucar;
    }

    public void setPorcAzucar(double porcAzucar) {
        this.porcAzucar = porcAzucar;
    }

    public double getPorcGrasa() {
        return porcGrasa;
    }

    public void setPorcGrasa(double porcGrasa) {
        this.porcGrasa = porcGrasa;
    }

    public double getPorcOxigeno() {
        return porcOxigeno;
    }

    public void setPorcOxigeno(double porcOxigeno) {
        this.porcOxigeno = porcOxigeno;
    }

    public String getPorcResultado() {
        return porcResultado;
    }

    public void setPorcResultado(String porcResultado) {
        this.porcResultado = porcResultado;
    }

    public List<RiesgoEnfermarPaciente> getRiesgoEnfermarPacientes() {
        return riesgoEnfermarPacientes;
    }

    public void setRiesgoEnfermarPacientes(List<RiesgoEnfermarPaciente> riesgoEnfermarPacientes) {
        this.riesgoEnfermarPacientes = riesgoEnfermarPacientes;
    }

    public void addRiesgoEnfermarPaciente(RiesgoEnfermarPaciente riesgoEnfermarPaciente){
    riesgoEnfermarPacientes.add(riesgoEnfermarPaciente);
}
public void removeRiesgoEnfermarPaciente(RiesgoEnfermarPaciente riesgoEnfermarPaciente){
    riesgoEnfermarPacientes.remove(riesgoEnfermarPaciente);
}

    public List<Persona> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Persona> pacientes) {
        this.pacientes = pacientes;
    }
}
