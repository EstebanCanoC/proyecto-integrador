package com.esteban.mensajeria.service;

import com.esteban.mensajeria.dto.ActualizarEstadoEnvioDTO;
import com.esteban.mensajeria.dto.CrearEnvioDTO;
import com.esteban.mensajeria.dto.CrearEnvioRespuestaDTO;
import com.esteban.mensajeria.dto.EnvioDTO;
import com.esteban.mensajeria.model.*;
import com.esteban.mensajeria.repository.EnvioRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class EnvioService {
    private final EnvioRepository envioRepository;
    private final ClienteService clienteService;
    private final PaqueteService paqueteService;

    private final EmpleadoService empleadoService;


    public EnvioService(EnvioRepository envioRepository, ClienteService clienteService, PaqueteService paqueteService, EmpleadoService empleadoService) {
        this.envioRepository = envioRepository;
        this.clienteService = clienteService;
        this.paqueteService = paqueteService;
        this.empleadoService = empleadoService;
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

    public EnvioDTO obtenerEnvioPorNumeroGuia(String numeroGuia) {
        Optional<Envio> envioOptional = envioRepository.findById(numeroGuia);
        if (envioOptional.isPresent()) {
            Envio envio = envioOptional.get();
            EnvioDTO envioDTO = new EnvioDTO();
            envioDTO.setCedulaCliente(envio.getCliente().getCedula());
            envioDTO.setNombreRemitente(envio.getCliente().getNombre());
            envioDTO.setCiudadOrigen(envio.getCiudadOrigen());
            envioDTO.setCiudadDestino(envio.getCiudadDestino());
            envioDTO.setDireccionDestino(envio.getDireccionDestino());
            envioDTO.setNombreRecibe(envio.getNombreRecibe());
            envioDTO.setCelular(envio.getCelular());
            envioDTO.setValorDeclaradoPaquete(envio.getValorDeclaradoPaquete());
            envioDTO.setPeso(envio.getPeso());
            envioDTO.setValorEnvio(envio.getValorEnvio());
            envioDTO.setEstadoEnvio(envio.getEstadoEnvio().toString());
            return envioDTO;
        }
        return null;
    }

    public EnvioDTO actualizarEstadoEnvio(ActualizarEstadoEnvioDTO actualizarEstadoEnvioDTO){
        Empleado empleado = empleadoService.obtenerEmpleado(actualizarEstadoEnvioDTO.getCedulaEmpleado());
        if (empleado == null) {
            //throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El empleado con cédula " + actualizarEstadoEnvioDTO.getCedulaEmpleado() + " no existe en nuestra compañía.");
        }

        TipoEmpleado tipoEmpleado = empleado.getCargo();
        if (tipoEmpleado != TipoEmpleado.REPARTIDOR && tipoEmpleado != TipoEmpleado.COORDINADOR) {
            //throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El empleado con cédula " + actualizarEstadoEnvioDTO.getCedulaEmpleado() + " no tiene los permisos necesarios para actualizar el estado del envío.");
        }

        Envio envio = envioRepository.findById(actualizarEstadoEnvioDTO.getNumeroGuia()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "El envío con número de guía " + actualizarEstadoEnvioDTO.getNumeroGuia() + " no existe en nuestra base de datos."));

        // Validar si el nuevo estado del envío es válido
        EstadoEnvio estadoActual = envio.getEstadoEnvio();
        EstadoEnvio nuevoEstado = EstadoEnvio.valueOf(actualizarEstadoEnvioDTO.getEstadoEnvio());
        if (estadoActual == EstadoEnvio.RECIBIDO && nuevoEstado != EstadoEnvio.EN_RUTA) {
            //throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El envío con número de guía " + actualizarEstadoEnvioDTO.getNumeroGuia() + " solo puede cambiar su estado de RECIBIDO a EN RUTA.");
        } else if (estadoActual == EstadoEnvio.EN_RUTA && nuevoEstado != EstadoEnvio.ENTREGADO) {
           // throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El envío con número de guía " + actualizarEstadoEnvioDTO.getNumeroGuia() + " solo puede cambiar su estado de EN RUTA a ENTREGADO.");
        } else if (estadoActual == EstadoEnvio.ENTREGADO || estadoActual == nuevoEstado) {
           // throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El envío con número de guía " + actualizarEstadoEnvioDTO.getNumeroGuia() + " no puede cambiar su estado de " + estadoActual + " a " + nuevoEstado + ".");
        }

        envio.setEstadoEnvio(nuevoEstado);
        envioRepository.save(envio);


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
