package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


// REGISTRO PROGRAMATIVO DEL SERVLET EN EL CONTENEDOR WEB:
@WebServlet("/ConversorMayusculasServletXML")
public class ConversorMayusculasServletXML extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	
	/*
	
	// CONSTRUCTOR IMPLÍCITO:
	
    public ConversorMayusculasServlet() {
        super();
    }

	*/
	
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
													throws ServletException, IOException {
		// DELEGACIÓN.
		procesarPeticion(request, response);
		
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
													throws ServletException, IOException {
		// DELEGACIÓN.		
		procesarPeticion(request, response);		
		
	}

	
	
	
	
	
	//////////////////// AQUÍ LO QUE QUIERAS QUE HAGA TU SERVLET ////////////////////////////////////
	
	private void procesarPeticion(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException {
		
		System.out.println("\n>>>>>>>>>> HE LLEGADO A ... " + getClass().getSimpleName());
	
		// CAPTURA DEL PARÁMETRO DE LA PETICIÓN CLIENTE:		
		String nombre = request.getParameter("nombre");
		
		
		// DOCUMENTO XML QUE SE RECUPERARÁ EN EL CLIENTE COMO TEXTO Y SE DEBERÁ CONVERTIR A UN OBJETO XML (parser).
		
		String xml = "";

		xml += "<?xml version='1.0'?>";			// NO OLVIDAR QUE SON 2 CARACTERES ?
		xml += "<datos>";		
		xml += "<nombre>";
		
		xml += nombre.toUpperCase();			// EL DATO CAPTURADO Y CONVERTIDO A MAYÚSCULAS.
		
		xml += "</nombre>";
		xml += "</datos>";
		
		
		System.out.println("\n\n>>> TEXTO EN ATRIBUTO XML: " + xml);
				
		// GUARDA EL VALOR DE LA VARIABLE xml NO LA DE nombre (parámetro de la petición):
		request.setAttribute("nombre", xml);	
		
		request.getRequestDispatcher("/indexXML.jsp").forward(request, response);
		
	}
	
}