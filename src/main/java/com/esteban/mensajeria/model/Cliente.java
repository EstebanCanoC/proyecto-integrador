package com.esteban.mensajeria.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "clientes")
public class Cliente extends Usuario{
    public Cliente(Integer cedula, String nombre, String apellido, String celular, String correoElectronico, String direccionResidencia, String ciudad) {
        super(cedula, nombre, apellido, celular, correoElectronico, direccionResidencia, ciudad);
    }
}
