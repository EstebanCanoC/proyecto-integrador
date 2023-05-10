package com.esteban.mensajeria.controller;

import com.esteban.mensajeria.dto.CrearEnvioDTO;
import com.esteban.mensajeria.dto.CrearEnvioRespuestaDTO;
import com.esteban.mensajeria.service.EnvioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/envios")
public class EnvioController {
    private final EnvioService envioService;
    public EnvioController(EnvioService envioService) {
        this.envioService = envioService;
    }
    @PostMapping
    public ResponseEntity<CrearEnvioRespuestaDTO> crearEnvio(@RequestBody @Valid CrearEnvioDTO crearEnvioDTO) {
        CrearEnvioRespuestaDTO respuestaDTO = envioService.crearEnvio(crearEnvioDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(respuestaDTO);
    }
}
