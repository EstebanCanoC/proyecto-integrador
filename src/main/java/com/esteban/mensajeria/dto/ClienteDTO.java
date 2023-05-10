package com.esteban.mensajeria.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteDTO {
    private Integer cedula;
    private String nombre;
    private String apellido;
    private String celular;
    private String correoElectronico;
    private String direccionResidencia;
    private String ciudad;
}
