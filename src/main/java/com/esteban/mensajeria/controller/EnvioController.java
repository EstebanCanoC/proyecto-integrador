package com.esteban.mensajeria.controller;

import com.esteban.mensajeria.dto.CrearEnvioDTO;
import com.esteban.mensajeria.dto.CrearEnvioRespuestaDTO;
import com.esteban.mensajeria.dto.EnvioDTO;
import com.esteban.mensajeria.service.EnvioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/{numeroGuia}")
    public ResponseEntity<EnvioDTO> obtenerEnvioPorNumeroGuia(@PathVariable String numeroGuia) {
        EnvioDTO envioDTO = envioService.obtenerEnvioPorNumeroGuia(numeroGuia);
        return ResponseEntity.ok(envioDTO);
    }
}
