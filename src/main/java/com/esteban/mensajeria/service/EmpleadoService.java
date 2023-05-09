package com.esteban.mensajeria.service;

import com.esteban.mensajeria.dto.EmpleadoDTO;
import com.esteban.mensajeria.exception.ApiRequestException;
import com.esteban.mensajeria.mapper.EmpleadoMapper;
import com.esteban.mensajeria.model.Empleado;
import com.esteban.mensajeria.repository.EmpleadoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmpleadoService {

    private final EmpleadoRepository empleadoRepository;

    private  final EmpleadoMapper empleadoMapper;

    public EmpleadoService(EmpleadoRepository empleadoRepository, EmpleadoMapper empleadoMapper) {
        this.empleadoRepository = empleadoRepository;
        this.empleadoMapper = empleadoMapper;
    }

    public Empleado crearEmpleado(EmpleadoDTO empleadoDTO){
        Empleado empleado = empleadoMapper.map(empleadoDTO);
        return this.empleadoRepository.save(empleado);
    }

    public Empleado actualizarEmpleado(EmpleadoDTO empleadoDTO) throws ApiRequestException {

        Empleado empleado = empleadoMapper.map(empleadoDTO);

        if(empleado.getCedula() == null){
            throw new ApiRequestException("La cedula del empleado no puede ser nula");
        }
        Optional<Empleado> dataEmpleado = empleadoRepository.findById(empleado.getCedula());
        if(dataEmpleado.isPresent()){
            Empleado empleadoExistente = dataEmpleado.get();
            empleadoExistente.setCedula(empleado.getCedula());
            empleadoExistente.setNombre(empleado.getNombre());
            empleadoExistente.setApellido(empleado.getApellido());
            empleadoExistente.setCelular(empleado.getCelular());
            empleadoExistente.setCorreoElectronico(empleado.getCorreoElectronico());
            empleadoExistente.setDireccionResidencia(empleado.getDireccionResidencia());
            empleadoExistente.setCiudad(empleado.getCiudad());
            empleadoExistente.setRh(empleado.getRh());
            empleadoExistente.setCargo(empleado.getCargo());
            return empleadoRepository.save(empleadoExistente);
        }else{
            throw new ApiRequestException("NO esta registrado ningun empleado con la cedula: " + empleado.getCedula());
        }
    }
    public Empleado borrarEmpleado(Integer cedula){
        Optional<Empleado> empleadoAEliminar = this.empleadoRepository.findById(cedula);
        if(empleadoAEliminar.isEmpty()){
            throw new ApiRequestException("Empleado no encontrado para su eliminacion");
        }
        this.empleadoRepository.delete(empleadoAEliminar.get());
        return empleadoAEliminar.get();
    }
    public Empleado obtenerEmpleado(Integer cedula){
        Optional<Empleado> empleadoAObtener = this.empleadoRepository.findById(cedula);
        if(empleadoAObtener.isEmpty()){
            throw new ApiRequestException("Empleado no registrado con este numero de cedula");
        }
        return empleadoAObtener.get();
    }
}
