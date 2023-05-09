package com.esteban.mensajeria.controller;

import com.esteban.mensajeria.dto.EmpleadoDTO;
import com.esteban.mensajeria.model.Empleado;
import com.esteban.mensajeria.service.EmpleadoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/empleados")
public class EmpleadoController {

    private final EmpleadoService empleadoService;

    public EmpleadoController(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    @PostMapping
    public Empleado crearEmpleado(@RequestBody EmpleadoDTO empleadoDTO){
        return this.empleadoService.crearEmpleado(empleadoDTO);
    }
}
