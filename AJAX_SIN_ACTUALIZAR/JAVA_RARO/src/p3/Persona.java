package p3;


public class Persona {

	private String nombre = "JUAN";			// EAGERLY DECLARATION
	
	private byte edad = dameNumero();
	
	
	
	private byte dameNumero() {
		return (byte)(Math.random() * 100 + 1);
	}

	
	
	
	public static void main(String[] args) {
		
		System.out.println(new Persona().edad);
		
	}
	
}
