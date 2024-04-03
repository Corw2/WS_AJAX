package p6;


public class Prueba {

	public static void main(String[] args) throws Exception {
		
		
		//System.out.println(new Billete500Euros());
			
		
		for(int i=0; i<5; i++) {
			System.out.println(new Billete500Euros());
		}
		
		
		System.out.println("-------------------- FACTORIA BILLETES ---------------\n\n");
		
		System.out.println(FactoriaBilletes.fabricar());
		
		System.out.println(FactoriaBilletes.imprimir());
		
	}
	
}
