package pe.edu.upeu.alumno.entity;

public class datos {
	private int iddatos;
	private int idescuela;
	private String apell_nom;
	private String correo;
	private String telefono;
	private String nombreescuela;
	public datos() {
		super();
		// TODO Auto-generated constructor stub
	}
	public datos(int iddatos, int idescuela, String apell_nom, String correo, String telefono, String nombreescuela) {
		super();
		this.iddatos = iddatos;
		this.idescuela = idescuela;
		this.apell_nom = apell_nom;
		this.correo = correo;
		this.telefono = telefono;
		this.nombreescuela = nombreescuela;
	}
	public int getIddatos() {
		return iddatos;
	}
	public void setIddatos(int iddatos) {
		this.iddatos = iddatos;
	}
	public int getIdescuela() {
		return idescuela;
	}
	public void setIdescuela(int idescuela) {
		this.idescuela = idescuela;
	}
	public String getApell_nom() {
		return apell_nom;
	}
	public void setApell_nom(String apell_nom) {
		this.apell_nom = apell_nom;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getNombreescuela() {
		return nombreescuela;
	}
	public void setNombreescuela(String nombreescuela) {
		this.nombreescuela = nombreescuela;
	}
	
	
}
