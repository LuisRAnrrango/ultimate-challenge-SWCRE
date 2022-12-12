package com.kruger.star.msvccalculosreport.model.entitys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;



@Table(name="RiesgosE_Pacientes")
@Entity
public class RiesgoEnfermarPaciente{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "paciente_id", unique = true)
    private Long pacienteId;

    public RiesgoEnfermarPaciente(Long pacienteId) {
        this.pacienteId = pacienteId;
    }
    public RiesgoEnfermarPaciente(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(Long pacienteId) {
        this.pacienteId = pacienteId;
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj){
            return  true;
        }
        if(!(obj instanceof RiesgoEnfermarPaciente)){
            return  false;
        }
        RiesgoEnfermarPaciente r= (RiesgoEnfermarPaciente) obj;
        return  this.pacienteId != null && this.pacienteId.equals(r.pacienteId);
    }
}
