package tabla_pagos;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;



public class MesaJuego {

	// EL MAPA (MAP) QUE CONSTITUIRÁ LA TABLA DE PAGOS (IMPLEMENTACIÓN HashMap)
	private Map<String, Integer> tablaPagos;	// null
	

	// INICIALIZAR LA TABLA DE PAGOS (K-V) - Key Value.
	private void inicializarTablaPagos() {
		
		tablaPagos = new HashMap<String, Integer>();
		
		tablaPagos.put("pleno", 36);
		tablaPagos.put("color", 2);
		tablaPagos.put("mitad", 2);
		tablaPagos.put("cuartos", 9);
		tablaPagos.put("fila", 3);
		tablaPagos.put("columna", 12);
		
		//System.out.println("\n" + tablaPagos + "\n");
		
	}
	
	
	// CONSULTA SOBRE TABLA DE PAGOS (el juego es A QUÉ APUESTA ... a "pleno", a "color" ... a "columna"
	public int consultarPago(String juego) {
		return tablaPagos.get(juego);
	}
	
	
	// CONSTRUCTOR
	public MesaJuego() {		
		inicializarTablaPagos();		
	}
	
	
	
	
	
	
	////////////////////////////////////
	
	public static void main(String[] args) {
		
		MesaJuego mesa = new MesaJuego();
		
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("¿A QUE APUESTAS? ... ");
		
		String juego = sc.nextLine().toLowerCase();
		
		
		System.out.print("\n\n¿CUÁNTO DINERO? ... ");
		
		int dinero = Integer.parseInt(sc.nextLine());
		
		
		int ganancias = mesa.consultarPago(juego) * dinero;
		
		System.out.println("\n\n HAS GANADO ... " + ganancias + " €.");
		
	}
	
	
}
