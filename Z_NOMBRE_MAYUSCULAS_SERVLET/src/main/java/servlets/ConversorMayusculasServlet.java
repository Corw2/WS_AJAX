package servlets;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;



@WebServlet("/ConversorMayusculasServlet")
public class ConversorMayusculasServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	
	/*
    public ConversorMayusculasServlet() {
        super();
    }
	*/
	
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
													throws ServletException, IOException {
		
		procesarPeticion(request, response);
		
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
													throws ServletException, IOException {
		
		procesarPeticion(request, response);		
		
	}

	
	
	
	//////////////////// AQUÍ LO QUE QUIERAS QUE HAGA TU SERVLET ////////////////////////////////////
	
	private void procesarPeticion(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		System.out.println("\n>>>>>>>>>> HE LLEGADO A ... " + getClass().getSimpleName());
	
		// CAPTURA PARÁMETRO DE LA PETICIÓN CLIENTE:		
		String nombre = request.getParameter("nombre");
		
		
		System.out.println("\n>>>>>>>>>> PARAMETRO nombre ORIGINAL =  " + nombre);
	
		nombre = nombre.toUpperCase();
		
		System.out.println("\n>>>>>>>>>> PARAMETRO nombre A MAYUSCULAS =  " + nombre);
	
		
		request.setAttribute("nombre", nombre);
		
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	
		
		//System.out.println("\n\n......... EL SERVLET CONTINUA .......\n\n");
		
		// GENERARÁ EXCEPCIÓN POR LA CONSOLA DEL SERVIDOR ... EN PANTALLA NO VERÁS NADA RARO, PERO LO HAY !!!.
		//
		//request.getRequestDispatcher("/index.jsp").forward(request, response);
		
	}
	
}