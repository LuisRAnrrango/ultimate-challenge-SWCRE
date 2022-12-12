package com.kruger.star.msvcpersonas.models.entitys;

import net.bytebuddy.implementation.bind.annotation.Empty;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
@Table (name = "persona")
public class Persona {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String cedula;
    private String nombre;
    private String apellido;
    private Date fechaNacim;
    private String genero;
    private String estadoCivil;
    private String direccion;
    private int celular;
    @Email
    @Column (unique = true)
    private String email;
    private String TipoSangre;
    private String TipoPersona;
    @ManyToOne
    @JoinColumn(name = "id_pais")
    private Pais pais;
    @ManyToOne
    @JoinColumn(name = "id_provincia")
    private Provincia provincia;

    public Persona(String cedula, String nombre, String apellido, Date fechaNacim, String genero, String estadoCivil, String direccion, int celular, String email, String tipoSangre, String tipoPersona, Pais pais, Provincia provincia) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacim = fechaNacim;
        this.genero = genero;
        this.estadoCivil = estadoCivil;
        this.direccion = direccion;
        this.celular = celular;
        this.email = email;
        TipoSangre = tipoSangre;
        TipoPersona = tipoPersona;
        this.pais = pais;
        this.provincia = provincia;
    }

    public Persona() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaNacim() {
        return fechaNacim;
    }

    public void setFechaNacim(Date fechaNacim) {
        this.fechaNacim = fechaNacim;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipoSangre() {
        return TipoSangre;
    }

    public void setTipoSangre(String tipoSangre) {
        TipoSangre = tipoSangre;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }
}

