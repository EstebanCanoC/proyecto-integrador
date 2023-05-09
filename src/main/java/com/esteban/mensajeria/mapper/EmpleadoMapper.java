package com.esteban.mensajeria.mapper;

import com.esteban.mensajeria.dto.EmpleadoDTO;
import com.esteban.mensajeria.model.Empleado;
import org.springframework.stereotype.Component;

@Component
public class EmpleadoMapper implements IMapper<EmpleadoDTO, Empleado> {
    @Override
    public Empleado map(EmpleadoDTO in){
        Empleado empleado = new Empleado();
        empleado.setCedula(in.getCedula());
        empleado.setNombre(in.getNombre());
        empleado.setApellido(in.getApellido());
        empleado.setCelular(in.getCelular());
        empleado.setCorreoElectronico(in.getCorreoElectronico());
        empleado.setDireccionResidencia(in.getDireccionResidencia());
        empleado.setCiudad(in.getCiudad());
        empleado.setAntiguedadEmpresa(in.getAntiguedadEmpresa());
        empleado.setRh(in.getRh());
        empleado.setCargo(in.getCargo());
        return empleado;
    }
}
