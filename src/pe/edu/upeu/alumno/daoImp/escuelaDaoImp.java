package pe.edu.upeu.alumno.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import pe.edu.upeu.alumno.dao.escuelaDao;
import pe.edu.upeu.alumno.entity.escuela;
import pe.edu.upeu.alumno.util.Conexion;

public class escuelaDaoImp implements escuelaDao{
	private PreparedStatement ps;
	private ResultSet rs;
	private Connection cx;
	
	@Override
	public int create(escuela d) {
		int x = 0;
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement("INSERT INTO escuela(nombrecat) values(?)");
			ps.setString(1, d.getNombre());
			x = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return x;
	}

	@Override
	public List<escuela> listarescuelas() {
		List<escuela> list = new ArrayList<>();
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement("SELECT * FROM escuela");
			rs = ps.executeQuery();
			while (rs.next()) {
				escuela a = new escuela();
				a.setNombre(rs.getString("nombrecat"));
				list.add(a);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

	
}
