package com.esteban.mensajeria.dto;

import com.esteban.mensajeria.model.TipoEmpleado;
import lombok.Data;

@Data
public class EmpleadoDTO {
    private Integer cedula;
    private String nombre;
    private String apellido;
    private String celular;
    private String correoElectronico;
    private String direccionResidencia;
    private String ciudad;
    private Integer antiguedadEmpresa;
    private String rh;
    private TipoEmpleado cargo;
}
