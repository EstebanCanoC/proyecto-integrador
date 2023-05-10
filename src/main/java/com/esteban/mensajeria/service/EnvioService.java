package com.esteban.mensajeria.service;

import com.esteban.mensajeria.dto.CrearEnvioDTO;
import com.esteban.mensajeria.dto.CrearEnvioRespuestaDTO;
import com.esteban.mensajeria.model.Cliente;
import com.esteban.mensajeria.model.Envio;
import com.esteban.mensajeria.model.EstadoEnvio;
import com.esteban.mensajeria.model.Paquete;
import com.esteban.mensajeria.repository.EnvioRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class EnvioService {
    private final EnvioRepository envioRepository;
    private final ClienteService clienteService;
    private final PaqueteService paqueteService;


    public EnvioService(EnvioRepository envioRepository, ClienteService clienteService, PaqueteService paqueteService) {
        this.envioRepository = envioRepository;
        this.clienteService = clienteService;
        this.paqueteService = paqueteService;
    }


    public CrearEnvioRespuestaDTO crearEnvio(CrearEnvioDTO crearEnvioDTO){
        Cliente cliente = clienteService.obtenerCliente(crearEnvioDTO.getCedulaCliente());
        if (cliente == null) {
            //throw new ClienteNotFoundException("El cliente con cedula " + crearEnvioDTO.getCedulaCliente() + " no está registrado");
        }
        Paquete paquete = paqueteService.crearPaquete(crearEnvioDTO.getPeso(), crearEnvioDTO.getValorDeclaradoPaquete());
        double valorEnvio = generarValorEnvio(crearEnvioDTO.getPeso());
        String numGuia = generarNumGuia();

        Envio envio = new Envio();
        envio.setNumeroGuia(numGuia);
        envio.setCliente(cliente);
        envio.setCiudadOrigen(crearEnvioDTO.getCiudadOrigen());
        envio.setCiudadDestino(crearEnvioDTO.getCiudadDestino());
        envio.setDireccionDestino(crearEnvioDTO.getDireccionDestino());
        envio.setNombreRecibe(crearEnvioDTO.getNombreRecibe());
        envio.setCelular(crearEnvioDTO.getCelular());
        envio.setValorDeclaradoPaquete(crearEnvioDTO.getValorDeclaradoPaquete());
        envio.setPeso(crearEnvioDTO.getPeso());
        envio.setValorEnvio(valorEnvio);
        envio.setEstadoEnvio(EstadoEnvio.RECIBIDO);
        envio.setPaquete(paquete);
        envio.setEmpleado(null);

        envioRepository.save(envio);

        CrearEnvioRespuestaDTO respuestaDTO = new CrearEnvioRespuestaDTO();
        respuestaDTO.setNumeroGuia(envio.getNumeroGuia());
        respuestaDTO.setEstadoEnvio(envio.getEstadoEnvio());

        return respuestaDTO;
    }
    private String generarNumGuia(){
        UUID uuid = UUID.randomUUID();
        String numGuia = uuid.toString().replace("-", "").substring(0, 10);
        return numGuia;
    }

    private double generarValorEnvio(int peso){
        if (peso < 2) {
            return 30000;
        } else if (peso < 5) {
            return 40000;
        } else {
            return 50000;
        }
    }
}
