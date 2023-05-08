package com.esteban.mensajeria.controller;

import com.esteban.mensajeria.dto.ClienteDTO;
import com.esteban.mensajeria.model.Cliente;
import com.esteban.mensajeria.service.ClienteService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/")
public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping("/clientes")
    public Cliente crearCliente(@RequestBody ClienteDTO clienteDTO){
        return this.clienteService.crearCliente(clienteDTO);
    }
}
