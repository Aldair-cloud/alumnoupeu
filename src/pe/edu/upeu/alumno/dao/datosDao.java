package pe.edu.upeu.alumno.dao;

import java.util.List;

import pe.edu.upeu.alumno.entity.datos;

public interface datosDao {
	public int create(datos d);
	public int update(datos d);
	public int delete(int idddatos);
	public List<datos>read();
	public datos finds(int iddatos);
}
