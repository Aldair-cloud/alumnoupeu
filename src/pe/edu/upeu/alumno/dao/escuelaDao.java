package pe.edu.upeu.alumno.dao;

import java.util.List;
import java.util.Map;

import pe.edu.upeu.alumno.entity.datos;
import pe.edu.upeu.alumno.entity.escuela;

public interface escuelaDao {
	public int create(escuela d);
	List<escuela> listarescuelas();

}
