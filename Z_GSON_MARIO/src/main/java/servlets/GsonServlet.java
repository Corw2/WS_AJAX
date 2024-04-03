package servlets;


import java.io.BufferedReader;
import java.io.IOException;
import com.google.gson.Gson;
import beans.Persona;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/generarGSON")
public class GsonServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
       
	
	// CONSTRUCTOR:
    /*
	public GsonServlet() {
    	System.out.println(">>> CONSTRUCTOR ... SE HA INSTANCIADO EL SERVLET ... " +
    				getClass().getCanonicalName() + " ---> " + hashCode());    	
    }
	*/

    // MÉTODOS HTTP:
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
    														throws ServletException, IOException {	
    	procesarPeticion(request, response);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
															throws ServletException, IOException {
		procesarPeticion(request, response);
	}

	
	

	////////////////////////////////////////////////////////////////////////////////////////////////////

	// MÉTODO DE PROCESAMIENTO DEL PROGRAMADOR:
	//
	// ESCRIBE AQUÍ LO QUE QUIERES QUE HAGA TU SERVLET:
	

	private void procesarPeticion(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		/*
    	System.out.println(">>> ¿QUE HILO ESTA PIDIENDO ESTE SERVLET? ... " + 
    			"NOMBRE: " + Thread.currentThread().getName() + "ID: " + Thread.currentThread().getId());		
		*/
		
		
		
		//String parametroPersona = "\"{" + request.getParameter("persona") + "}\"";
		
		//System.out.println("\n\n >>>>>>> PARAMETRO persona: " + parametroPersona );
		
		
		String cabeceraContentType = request.getHeader("Content-Type");
		
		System.out.println("\n\n >>>>>>> CABECERA Content-Type: " + cabeceraContentType );
		
				
		//String datosJSON   = request.getParameter("datosJSON");
		
		//System.out.println("\n\n>>>>>>>> DATOS JSON: " + datosJSON);
		
		
		BufferedReader lector = request.getReader();
		
		String datosLectura = lector.readLine();
		
		System.out.println("DATOS LECTURA: " + datosLectura);
		
		/*
			>>>>>>> CABECERA Content-Type: application/json
		
			DATOS LECTURA: {"nombre":"PEPE","apellidos":"GARCIA PEREZ"}
		
			>>> PERSONA CREADA ... 

			Nombre = PEPE, Apellidos = GARCIA PEREZ
			
		*/
		
		
		
		// MATCHING ... CARGA REFLEXIVA DE PROPIEDADES
		
		Persona persona = new Gson().fromJson(datosLectura, Persona.class);
		
		System.out.println(">>> PERSONA CREADA ... \n\n" + persona);
		
		
		/*
		
		JAVA I/O:
		
		CLASES ABSTRACTAS ... Reader y Writer
		
		
		
		// MODO BINARIO - BAJO NIVEL
		InputStream							-- lector
		OutputStream						-- escritor
		
		// MODO BINARIO - ALTO NIVEL
		DataInputStream						-- lector
		DataOutputStream					-- escritor
		
		
		///////////////////////////////////////////////////////////
		
		
		// MODO TEXTO - BAJO NIVEL
		FileReader							-- lector
		FileWriter							-- escritor
		
		// MODO TEXTO - ALTO NIVEL
		BufferReader						-- lector					<-------- MARIO PARA LEER JSON --------
		BufferedWriter						-- escritor
		PrintWriter							-- escritor .. CAPACIDAD IO.	
		
		
		//////////////////////////////////////////////////////////
		
		
		// MODO OBJETO - ALTO NIVEL (no tiene bajo nivel) ... SERIALIZACIÓN	
		ObjectInputStream
		ObjectOutputStream
		
		*/
		
	}
	

	////////////////////////////////////////////////////////////////////////////////////////////////////	
	
}
