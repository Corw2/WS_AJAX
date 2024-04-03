package p6;


public class FactoriaBilletes {

	public static Billete500Euros fabricar() {
		
		return new Billete500Euros();
		
	}
	
	
	public static Billete500Euros imprimir() throws Exception {
		
		final int probabilidadFallo = 50;
		
		final int aleatorio = (int)(Math.random() * 100) + 1;  // [1..100]
		
		
		String queBillete;
		
		if(aleatorio > probabilidadFallo) {
			queBillete = "p6.Billete500Euros";
		} else {
			queBillete = "p6.Billete1000Euros"; // NO EXISTE LA CLASE
		}
			
			
		return (Billete500Euros)Class.forName(queBillete).newInstance();
		
	}
	
}
