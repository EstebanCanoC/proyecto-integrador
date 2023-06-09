package com.esteban.mensajeria.controller;

import com.esteban.mensajeria.dto.ClienteDTO;
import com.esteban.mensajeria.exception.ApiRequestException;
import com.esteban.mensajeria.model.Cliente;
import com.esteban.mensajeria.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/clientes")
public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public Cliente crearCliente(@RequestBody ClienteDTO clienteDTO){
        return this.clienteService.crearCliente(clienteDTO);
    }

    @PutMapping("/{cedula}")
    public ResponseEntity<Cliente> actualizarCliente(@PathVariable("cedula") Integer cedula, @RequestBody ClienteDTO clienteDTO){
        Cliente clienteActualizado = clienteService.actualizarCliente(clienteDTO);
        return ResponseEntity.ok(clienteActualizado);
    }

    @DeleteMapping("/{cedula}")
    public ResponseEntity<Cliente> borrarCliente(@PathVariable("cedula") Integer cedula) throws ApiRequestException {
        Cliente clienteEliminado = clienteService.borrarCliente(cedula);
        return ResponseEntity.ok(clienteEliminado);
    }

    @GetMapping("/{cedula}")
    public ResponseEntity<Cliente> obtenerCliente(@PathVariable("cedula") Integer cedula) throws ApiRequestException{
        Cliente clienteObtenido = clienteService.obtenerCliente(cedula);
        return ResponseEntity.ok(clienteObtenido);
    }
}
