/*package com.unla.elDeporteOnline.converters;

import org.springframework.stereotype.Component;

import com.unla.elDeporteOnline.entities.Empleado;
import com.unla.elDeporteOnline.models.EmpleadoModel;


@Component("empleadoConverter")
public class EmpleadoConverter {
	
	public EmpleadoModel entityToModel(Empleado empleado) {
		return new EmpleadoModel(empleado.getIdEmpleado(), empleado.getApellido(), empleado.getNombre(), empleado.getDni(),
				empleado.getEmail(), empleado.isGerente());
	}

	public Empleado modelToEntity(EmpleadoModel empleadoModel) {
		return new Empleado(empleadoModel.getIdEmpleado(), empleadoModel.getApellido(), empleadoModel.getNombre(), 
				empleadoModel.getDni(), empleadoModel.getEmail(), empleadoModel.isGerente());
	}

}
*/