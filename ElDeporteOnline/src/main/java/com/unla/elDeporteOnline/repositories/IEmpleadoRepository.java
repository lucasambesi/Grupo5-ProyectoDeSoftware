/*package com.unla.elDeporteOnline.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unla.elDeporteOnline.entities.Empleado;

@Repository("empleadoRepository")
public interface IEmpleadoRepository extends JpaRepository<Empleado, Serializable> {

	public abstract Empleado findByIdEmpleado(long idEmpleado);

	public abstract Empleado findByNombre(String nombre);

	public abstract Object findByGerente(boolean gerente);

}*/