package com.esteban.mensajeria.controller;

import com.esteban.mensajeria.dto.EmpleadoDTO;
import com.esteban.mensajeria.model.Empleado;
import com.esteban.mensajeria.service.EmpleadoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @PutMapping("/{cedula}")
    public ResponseEntity<Empleado> actualizarEmpleado(@PathVariable("cedula") Integer cedula, @RequestBody EmpleadoDTO empleadoDTO){
        Empleado empleadoActualizado = empleadoService.actualizarEmpleado(empleadoDTO);
        return ResponseEntity.ok(empleadoActualizado);
    }
}
