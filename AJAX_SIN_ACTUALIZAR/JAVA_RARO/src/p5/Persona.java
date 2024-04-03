package p5;


public class Persona implements Cloneable {

	private Anillo anillo;
	
	public Persona() {
		anillo = new Anillo();
	}
	
	
	@Override
	public String toString() {
		
		return "PERSONA ... " + hashCode() + "\n" +
				"ANILLO ... " + anillo.hashCode();
		
	}
	
	
	public Object clonar() throws CloneNotSupportedException {
		return clone();
	}
	
	
	
	
	
	
	

	public static void main(String[] args) throws CloneNotSupportedException {
		
		Persona original = new Persona();
		
		Object clon = original.clonar();
		
		
		System.out.println("ORIGINAL ... " + original);
		System.out.println("\n\n");
		System.out.println("CLON ... " + clon);
		
		
		
		
		
		/*
		Gato g1 = new Gato();
		g1.bufar();
		
		//Gato g2 = new Gato();
		
		Gato g2 = g1;
		g2.bufar();
		
		Object g3 = g1;
		
		//g3.bufar();
		
		// DOWNCASTING
		((Gato)g3).bufar();
		*/
		
	}


}


class Gato {
	
	public void bufar() {
		System.out.println("FFFFFFUUUUU!!!");
	}
	
}
