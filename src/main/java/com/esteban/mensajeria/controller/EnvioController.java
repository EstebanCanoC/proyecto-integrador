package com.esteban.mensajeria.controller;

import com.esteban.mensajeria.service.EnvioService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/envios")
public class EnvioController {
    private final EnvioService envioService;
    public EnvioController(EnvioService envioService) {
        this.envioService = envioService;
    }
    
}
