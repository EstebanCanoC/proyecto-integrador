package com.esteban.mensajeria.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CrearEnvioDTO {
    private Integer cedulaCliente;
    private String ciudadOrigen;
    private String ciudadDestino;
    private String direccionDestino;
    private String nombreRecibe;
    private String celular;
    private double valorDeclaradoPaquete;
    private Integer peso;
}
