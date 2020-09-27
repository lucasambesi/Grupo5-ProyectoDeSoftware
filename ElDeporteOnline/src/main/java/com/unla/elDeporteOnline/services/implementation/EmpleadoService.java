/*package com.unla.elDeporteOnline.services.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.elDeporteOnline.converters.EmpleadoConverter;
import com.unla.elDeporteOnline.entities.Empleado;
import com.unla.elDeporteOnline.models.EmpleadoModel;
import com.unla.elDeporteOnline.repositories.IEmpleadoRepository;
import com.unla.elDeporteOnline.services.IEmpleadoService;

@Service("empleadoService")
public class EmpleadoService implements IEmpleadoService {
	
	@Autowired
	@Qualifier("empleadoRepository")
	private IEmpleadoRepository empleadoRepository;
	
	@Autowired
	@Qualifier("empleadoConverter")
	private EmpleadoConverter empleadoConverter;
	
	@Override
	public List<Empleado> getAll() {
		return empleadoRepository.findAll();
	}
	
	@Override
	public List<EmpleadoModel> getAlls() {
		List<EmpleadoModel> em = new ArrayList<EmpleadoModel>();
		for (Empleado empleado : empleadoRepository.findAll()) {
			em.add(empleadoConverter.entityToModel(empleado));
		}
		return em;
	}
	
	@Override
	public EmpleadoModel findByIdEmpleado(long idEmpleado) {
		return empleadoConverter.entityToModel(empleadoRepository.findByIdEmpleado(idEmpleado));
	}

	@Override
	public EmpleadoModel findByNombre(String nombre) {
		return empleadoConverter.entityToModel(empleadoRepository.findByNombre(nombre));
	}

	@Override
	public EmpleadoModel insert(EmpleadoModel empleadoModel) {
		Empleado empleado = empleadoRepository.save(empleadoConverter.modelToEntity(empleadoModel));
		return empleadoConverter.entityToModel(empleado);
	}

	@Override
	public EmpleadoModel update(EmpleadoModel empleadoModel) {
		Empleado empleado = empleadoRepository.save(empleadoConverter.modelToEntity(empleadoModel));
		return empleadoConverter.entityToModel(empleado);
	}

	@Override
	public boolean remove(long idEmpleado) {

		try {
			empleadoRepository.deleteById(idEmpleado);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	@Override
	public List<EmpleadoModel> findByGerente(boolean gerente) {

		return null;
	}

}
*/