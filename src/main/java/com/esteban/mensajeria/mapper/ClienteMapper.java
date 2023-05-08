package com.esteban.mensajeria.mapper;

import com.esteban.mensajeria.dto.ClienteDTO;
import com.esteban.mensajeria.model.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper implements IMapper<ClienteDTO, Cliente> {

    @Override
    public Cliente map(ClienteDTO in){
        Cliente cliente = new Cliente();
        cliente.setCedula(in.getCedula());
        cliente.setNombre(in.getNombre());
        cliente.setApellido(in.getApellido());
        cliente.setCelular(in.getCelular());
        cliente.setCorreoElectronico(in.getCorreoElectronico());
        cliente.setDireccionResidencia(in.getDireccionResidencia());
        cliente.setCiudad(in.getCiudad());
        return  cliente;
    }
}
