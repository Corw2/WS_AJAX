package pruebas;


public class Prueba {

	public static void main(String[] args) {
		
		Dinosaurio d = new Dinosaurio();
		
		Gato g = new Gato();
		
		// PROGRAMA EN BASE A UN SUPERTIPO NO A UNA IMPLEMENTACIÓN (REGLAS DE LA OOP)
		Animal a1 = new Dinosaurio(); 
		Animal a2 = new Gato();
		
		final Animal[] animales = {new Dinosaurio(), new Gato()};
		
		int aleatorio = (int)(Math.random() * animales.length); // [0..1]
		
		String sonido = animales[aleatorio].emitirSonido();
		
		System.out.println("... " + sonido);
		
		
	}
	
}



abstract class Animal {
	
	public abstract String emitirSonido();
	
}


class Dinosaurio extends Animal {
	public String emitirSonido() {
		return "GRRRRRARARRRRRRR !!!";
	}
}



class Gato extends Animal {
	public String emitirSonido() {
		return "MIAUUUU";
	}
}
