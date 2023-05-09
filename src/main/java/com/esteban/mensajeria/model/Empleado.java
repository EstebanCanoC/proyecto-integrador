package com.esteban.mensajeria.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "empleados")
public class Empleado extends Usuario{

    @Column(name = "antiguedad")
    private Integer antiguedadEmpresa;
    @Column(name = "rh")
    private String rh;
    @Column(name = "cargo")
    @Enumerated(EnumType.STRING)
    private TipoEmpleado cargo;

    public Empleado(Integer cedula, String nombre, String apellido, String celular, String correoElectronico, String direccionResidencia, String ciudad, Integer antiguedadEmpresa, String rh, TipoEmpleado cargo) {
        super(cedula, nombre, apellido, celular, correoElectronico, direccionResidencia, ciudad);
        this.antiguedadEmpresa = antiguedadEmpresa;
        this.rh = rh;
        this.cargo = cargo;
    }
}
