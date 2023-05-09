package com.esteban.mensajeria.service;

import com.esteban.mensajeria.dto.ClienteDTO;
import com.esteban.mensajeria.exception.ApiRequestException;
import com.esteban.mensajeria.mapper.ClienteMapper;
import com.esteban.mensajeria.model.Cliente;
import com.esteban.mensajeria.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
    public Cliente actualizarCliente(ClienteDTO clienteDTO) throws ApiRequestException{
        Cliente cliente = clienteMapper.map(clienteDTO);

        if(cliente.getCedula() == null){
            throw new ApiRequestException("La cedula del cliente no puede ser nula");
        }
        Optional<Cliente> optionalCliente = clienteRepository.findById(cliente.getCedula());
        if(optionalCliente.isPresent()){
            Cliente clienteExistente = optionalCliente.get();
            clienteExistente.setCedula(cliente.getCedula());
            clienteExistente.setNombre(cliente.getNombre());
            clienteExistente.setApellido(cliente.getApellido());
            clienteExistente.setCelular(cliente.getCelular());
            clienteExistente.setCorreoElectronico(cliente.getCorreoElectronico());
            clienteExistente.setDireccionResidencia(cliente.getDireccionResidencia());
            clienteExistente.setCiudad(cliente.getCiudad());
            return clienteRepository.save(clienteExistente);
        }else {
            throw new ApiRequestException("NO esta registrado ningun cliente con la cedula: " + cliente.getCedula());
        }
    }

    public Cliente borrarCliente(Integer cedula){
        Optional<Cliente> clienteAEliminar = this.clienteRepository.findById(cedula);
        if (clienteAEliminar.isEmpty()){
            throw new ApiRequestException("Cliente no encontrado para su eliminacion");
        }
        this.clienteRepository.deleteById(cedula);
        return clienteAEliminar.get();
    }

    public Cliente obtenerCliente(Integer cedula){
        Optional<Cliente> clienteAOptener = this.clienteRepository.findById(cedula);
        if(clienteAOptener.isEmpty()){
            throw new ApiRequestException("Cliente no registrado con este numero de cedula");
        }
        return clienteAOptener.get();
    }
}
