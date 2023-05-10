package com.esteban.mensajeria.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnvioDTO {
    private int cedulaCliente;
    private String nombreRemitente;
    private String ciudadOrigen;
    private String ciudadDestino;
    private String direccionDestino;
    private String nombreRecibe;
    private String celular;
    private double valorDeclaradoPaquete;
    private int peso;
    private double valorEnvio;
    private String estadoEnvio;
}
