package com.esteban.mensajeria.service;

import com.esteban.mensajeria.dto.ClienteDTO;
import com.esteban.mensajeria.mapper.ClienteMapper;
import com.esteban.mensajeria.model.Cliente;
import com.esteban.mensajeria.repository.ClienteRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    private final ClienteMapper clienteMapper;

    public ClienteService(ClienteRepository clienteRepository, ClienteMapper clienteMapper) {
        this.clienteRepository = clienteRepository;
        this.clienteMapper = clienteMapper;
    }

    public Cliente crearCliente(ClienteDTO clienteDTO){
        Cliente cliente = clienteMapper.map(clienteDTO);
        return this.clienteRepository.save(cliente);
    }
}
