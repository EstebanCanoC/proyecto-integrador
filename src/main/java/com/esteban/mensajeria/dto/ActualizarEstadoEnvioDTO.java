package com.esteban.mensajeria.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ActualizarEstadoEnvioDTO {
    private String numeroGuia;
    private String estadoEnvio;
    private String cedulaEmpleado;
}
