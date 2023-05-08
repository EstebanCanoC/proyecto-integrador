package com.esteban.mensajeria.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public abstract class Usuario {
    @Id
    private Integer cedula;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "celular")
    private String celular;
    @Column(name = "correo")
    private String correoElectronico;
    @Column(name = "direccion")
    private String direccionResidencia;
    @Column (name = "ciudad")
    private String ciudad;

}
