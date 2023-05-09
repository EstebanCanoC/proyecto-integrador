package com.esteban.mensajeria.service;

import com.esteban.mensajeria.dto.EmpleadoDTO;
import com.esteban.mensajeria.mapper.EmpleadoMapper;
import com.esteban.mensajeria.model.Empleado;
import com.esteban.mensajeria.repository.EmpleadoRepository;
import org.springframework.stereotype.Service;

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
}
