package pe.edu.upeu.alumno.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import pe.edu.upeu.alumno.dao.datosDao;
import pe.edu.upeu.alumno.entity.datos;
import pe.edu.upeu.alumno.util.Conexion;

public class datosDaoImp implements datosDao{
	
	private PreparedStatement ps;
	private ResultSet rs;
	private Connection cx;
	
	@Override
	public int create(datos d) {
		int x = 0;
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement("INSERT INTO alumno (nombreescuela,apellnombres, correo, telefono) VALUES (?, ?, ?, ?)");
			//ps.setInt(1, d.getIddatos());
			ps.setString(1, d.getNombreescuela());
			ps.setString(2, d.getApell_nom());
			ps.setString(3, d.getCorreo());
			ps.setString(4, d.getTelefono());
			x = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return x;
	}

	@Override
	public int update(datos d) {
		int x = 0;
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement("UPDATE alumno SET idescuela = ?, apellnombres = ?, correo = ?, telefono = ? WHERE idalumno = ?");
			ps.setInt(1,  d.getIdescuela());
			ps.setString(2, d.getApell_nom());
			ps.setString(3, d.getCorreo());
			ps.setString(4, d.getTelefono());
			ps.setInt(5, d.getIddatos());
			x = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return x;
	}

	@Override
	public int delete(int id) {
		int x = 0;
		String sql = "DELETE FROM datos WHERE idalumno = ?";
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(sql);
			ps.setInt(1, id);
			x = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return x;
	}
	//e.idescuela; nombrecat; idalumno, apellnombres, correo, telefono FROM escuela e, alumno a where e.idescuela = a.idescuela
	@Override
	public List<datos> read() {
		List<datos> dt = new ArrayList<>();
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement("SELECT * FROM alumno");
			rs = ps.executeQuery();
			while (rs.next()) {
				datos dts = new datos();
				dts.setIddatos(rs.getInt("idalumno"));
				dts.setNombreescuela(rs.getString("nombreescuela"));
				dts.setApell_nom(rs.getString("apellnombres"));
				dts.setCorreo(rs.getString("correo"));
				dts.setTelefono(rs.getString("telefono"));
				dt.add(dts);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return dt;
	}

	@Override
	public datos finds(int iddatos) {
		datos dt = new datos();
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement("SELECT * FROM datos where iddatos = ?");
			ps.setInt(1, iddatos);
			rs = ps.executeQuery();
			rs.next();
			dt.setIddatos(rs.getInt("iddatos"));
			dt.setIdescuela(rs.getInt("idescuela"));
			dt.setApell_nom(rs.getString("apell_nom"));
			dt.setCorreo(rs.getString("correo"));
			dt.setTelefono(rs.getString("telefono"));
		} catch (Exception e) {
			System.out.println(e);
		}
		return dt;
	}

	
}
