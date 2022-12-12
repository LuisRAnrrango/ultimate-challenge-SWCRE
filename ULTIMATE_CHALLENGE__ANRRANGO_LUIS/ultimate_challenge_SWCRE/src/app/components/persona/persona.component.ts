import { Component, OnInit } from '@angular/core';
import { PersonaService } from 'src/app/services/persona/persona.service';
import { PaisService } from 'src/app/services/pais/pais.service';
import { ProvinciaService } from 'src/app/services/provincia/provincia.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-persona',
  templateUrl: './persona.component.html',
  styleUrls: ['./persona.component.css'],
})
export class PersonaComponent implements OnInit {
  personaForm: FormGroup;
  paises: any;
  provincias: any;
  personas: any;
  persona: any;
  error: any;

  constructor(
    public fb: FormBuilder,
    public provinciaService: ProvinciaService,
    public paisService: PaisService,
    public personaService: PersonaService
  ) {}

  ngOnInit(): void {
    this.personaForm = this.fb.group({
      id: [''],
      cedula: ['', [Validators.required]],
      nombre: ['', [Validators.required]],
      apellido: ['', [Validators.required]],
      fechaNacim: ['', [Validators.required]],
      genero: ['', [Validators.required]],
      estadoCivil: ['', [Validators.required]],
      direccion: ['', [Validators.required]],
      celular: ['', [Validators.required]],
      email: ['', [Validators.required]],
      pais: ['', [Validators.required]],
      provincia: ['', [Validators.required]],
      tipoSangre: [''],
    });

    this.paisService.getAllPaises().subscribe(
      (resp) => {
        this.paises = resp;
      },
      (error) => {
        console.error(error);
      }
    );
    //Metodo retorna las personas
    this.personaService.getAllPersonas().subscribe(
      (resp) => {
        this.personas = resp;
      },
      (error) => {
        console.log(error);
      }
    );

    this.personaForm.get('pais').valueChanges.subscribe((value) => {
      this.provinciaService.getAlProvinciasByPais(value.id).subscribe(
        (resp) => {
          this.provincias = resp;
        },
        (error) => {}
      );
    });
  }
  //METODO GUARDAR PERSONAS
  guardar(): void {
    //alert('Datos enviados');
    //   console.log(this.persona);
    this.personaService.savePersona(this.personaForm.value).subscribe(
      (resp) => {
        this.personaForm.reset();
        this.personas = this.personas.filter(
          (persona) => resp.id !== persona.id
        );
        this.personas.push(resp);
      },
      (error) => {
        console.error(error);
      }
    );
  }
  //METODO PARA ELIMINAR PERSONAS
  deletePersona(persona: any) {
    this.personaService.deletePersonabyId(persona.id).subscribe(
      (resp) => {
        if (resp === true) {
          this.personas.pop(this.persona);
        }
      },
      (error) => {
        console.error(error);
      }
    );
  }
  //Editar
  editarPersona(persona) {
    this.personaForm.setValue({
      id: persona.id,
      nombre: persona.nombre,
      apellido: persona.apellido,
      edad: persona.edad,
      cedula: persona.cedula,
      fechaNacim: persona.fechaNacim,
      genero: persona.genero,
      estadoCivil: persona.estadoCivil,
      direccion: persona.direccion,
      celular: persona.celular,
      email: persona.email,
      pais: persona.pais,
      provincia: persona.provincia,
    });
  }
}
