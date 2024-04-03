package p6;


import java.util.Objects;


public class Billete500Euros {

	final private int valor;
	final private String color;
	final private int numeroSerie;
	
	
	public Billete500Euros() {
	
		//super();
		
		valor 		= 500;
		color 		= "PURPURA";
		numeroSerie = hashCode();
	}
	
	
	
	// GETTERS:
	public int getValor() {
		return valor;
	}
	
	
	public String getColor() {
		return color;
	}

	
	public int getNumeroSerie() {
		return valor;
	}
	
	
	// equals, hashCode, toString

	@Override
	public int hashCode() {
		//return Objects.hash(color, valor);
		return super.hashCode();		
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
			
		if (obj == null) {
			return false;
		}
			
		if (getClass() != obj.getClass()) {
			return false;
		}
		
		Billete500Euros other = (Billete500Euros) obj;
		
		return Objects.equals(color, other.color) && valor == other.valor;
	}



	@Override
	public String toString() {
		return "Billete500Euros [valor=" + valor + ", color=" + color + 
										", numeroSerie=" + numeroSerie + "] \n";
	}
	
}
