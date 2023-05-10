package com.esteban.mensajeria.dto;

import com.esteban.mensajeria.model.EstadoEnvio;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CrearEnvioRespuestaDTO {
    private String numeroGuia;
    private EstadoEnvio estadoEnvio;
}
