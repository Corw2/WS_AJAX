package beans;

public class Persona {
	
	// ATRIBUTOS:
	private String nombre;
	private String apellidos;
	
	
	
	// CONSTRUCTORES:
	public Persona() {}


	public Persona(String nombre, String apellidos) {
		this.nombre = nombre;
		this.apellidos = apellidos;
	}

	

	// GETTERS Y SETTERS:
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	
	
	
	@Override
	public String toString() {
		return "Nombre = " + nombre + ", Apellidos = " + apellidos;
	}
	
	
}
