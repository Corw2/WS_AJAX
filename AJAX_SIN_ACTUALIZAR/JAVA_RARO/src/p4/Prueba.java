package p4;

public class Prueba {

	private static enum BebidasOK {
		GINEBRA, PACHARAN, REDBULL, LIMON;
	}
	
	
	public static void main(String[] args) {
		
		String[] bebidas = {"COCACOLA","WHISKY","VODKA","LEJIA"};
		
		final int aleatorio = (int)(Math.random() * bebidas.length); // [0..3]
		
		String bebidaElegida = bebidas[aleatorio];
		
		
		if("LEJIA".equals(bebidaElegida)) {
			System.out.println("!!! PELIGRO, ES LEJIA ... NO ME LO BEBO !!!");			
		} else {
			System.out.println("VOY A BEBER ... " + bebidaElegida);	
		}
		
				
	
		
		////////////////////////
		
		BebidasOK bebidaOK_1 = BebidasOK.GINEBRA;
		
		//System.out.println("BEBE ... " + bebidaOK_1);		
		
		System.out.println("BEBES ... " + BebidasOK.values());
		
		// ERROR: // BebidasOK bebidaOK_2 = BebidasOK.LEJIA;
		
		
		System.out.println(new Muerto());
		System.out.println(new Muerto());
		
	}
	
}

class Muerto {
	
	private String nombre = "ALBERTO FRONT";

	
	@Override
	public boolean equals(Object otro) {
		
		if( getClass() != otro.getClass() ) {
			// DISTINTOS TIPOS O NATURALEZAS ... CLASS
			return false;
		}
		
		// MISMO TIPO O NATURALEZA ... CLASS
		
		// SI SE LLAMAN IGUAL DIREMOS SON IGUALES (no nos importa su código de hash)
		
		// TIPO variable = casting a Gato de otra variable;
		
		/*
		Animal a = new Gato() | new Alien();
		
		
		a.alimentarse(); // depende de la implementación con la que cargues
						// el supertipo Animal.
		
		( (Alien)animal ).escupirAcido();
		
		
		( (Gato)animal ).bufar();
		*/
		
		
		
		final Muerto otroMuerto = (Muerto)otro;
		
		if (nombre.equals(otroMuerto.nombre)) {
			return true;
		}
		
		return false;
		
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName() + ": " +  nombre + " ---> " + hashCode();
	}
	
}