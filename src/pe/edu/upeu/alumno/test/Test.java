package pe.edu.upeu.alumno.test;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import pe.edu.upeu.alumno.dao.datosDao;
import pe.edu.upeu.alumno.dao.escuelaDao;
import pe.edu.upeu.alumno.daoImp.datosDaoImp;
import pe.edu.upeu.alumno.daoImp.escuelaDaoImp;
import pe.edu.upeu.alumno.entity.datos;
import pe.edu.upeu.alumno.entity.escuela;
import pe.edu.upeu.alumno.util.Conexion;

public class Test {
	private static datosDao datosDao = new datosDaoImp();
	private static escuelaDao escuelaDao = new escuelaDaoImp();
	private static Gson g = new Gson();
	List<escuela> esc = new ArrayList<escuela>(); 
	List<datos> dat = new ArrayList<datos>();
	static datosDao ddao = new datosDaoImp();
	public static void main(String[] args) {
		//listaresc();
		listardat();
		//create();
		//crearescuela();
		//conexion();
	}
	
	public static void listaresc() {
		escuelaDao edao = new escuelaDaoImp();
		System.out.println(g.toJson(edao.listarescuelas()));
	}
	
	public static void listardat() {
		
		System.out.println(g.toJson(ddao.read()));
	}
	
	static void conexion() {
		if (Conexion.getConexion()!=null) {
			System.out.println("Hay conexion....");
		}
	}
	static void crearescuela() {
		
		escuela escuela = new escuela(3, "Civil");
		int e = escuelaDao.create(escuela);
		if (e > 0) {
			System.out.println("Escuela Creada");
		} else {
			System.out.println("Creación de Escuela Fallida");
		}
	}
	public static void create() {
		if(ddao.create(new datos(0, 0,"Ingeniera Civil", "Dairus LOl", "daris@gmail", "986472513"))>=1){
			System.out.println("Usuario creado");
		}else{
			System.out.println("Error al crear el usuario");
		}
	}
}
