package p0;


public class Prueba {
	
	public static void main(String[] args) {
		
		/*
		while(true) {
			
		}
		*/

		
		/*
		while(true) {
			
		}


		System.out.println("F.U");
		*/
		
		
		/*
		while(false) {}
		*/
		
		
		/*
		boolean siNo = false;
		
		while(siNo) {}
		
		System.out.println("F.U");
		*/

		
		/*
		final boolean siNo = false;
		
		while(siNo) {}
		*/
		
		
		/*
		final boolean[] fumadorSiNo = {true, false};
		
		final boolean fumas = fumadorSiNo[ (int)(Math.random() * fumadorSiNo.length) ];
		
		
		
		
		while(fumas) {
			System.out.println("OFERTA DE TABACO FORTUNA \n");
		}
		
		System.out.println("!!! COMPRATE UN CHUPACHUP !!!");
		*/
		
		
		final boolean[] fumadorSiNo = {true, false};
		
		final boolean tuFumas = fumadorSiNo[ (int) (Math.random() * fumadorSiNo.length) ];
				
		/////
		
		String mensaje;
				
		
		// TERNARIO:
		//mensaje = tuFumas ? "TOMA UN CIGARRO" : "TOMA UN CARAMELO";
		
		
		// IF-ELSE:
		if(tuFumas) {
			mensaje = "TOMA UN CIGARRO";
			
		} else {
			mensaje = "TOMA UN CARAMELO";
		}
		
		
		
		
		System.out.println("¿TU FUMAS? ... " + tuFumas + " --> " + mensaje);
		
	}
	
}
