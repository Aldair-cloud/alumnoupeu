package pe.edu.upeu.alumno.entity;

public class escuela {
	private int idescuela;
	private String nombre;
	public escuela() {
		super();
		// TODO Auto-generated constructor stub
	}
	public escuela(int idescuela, String nombre) {
		super();
		this.idescuela = idescuela;
		this.nombre = nombre;
	}
	public int getIdescuela() {
		return idescuela;
	}
	public void setIdescuela(int idescuela) {
		this.idescuela = idescuela;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
