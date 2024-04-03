package servlets;


import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class ServletAccesoZonaPrivada extends HttpServlet {

    private static final long serialVersionUID = 1L;

	@Override
    protected void service(HttpServletRequest request, HttpServletResponse response) 
            throws IOException, ServletException {

        // Es conveniente el uso de este tipo de trazas en desarrollo para ver que el cliente Ajax realmente está
        // invocando al servidor.
        System.out.println("-----------> SE HA LLAMADO AL servletAccesoZonaPrivada");
        

        String codigoSecreto;
        
        // Una vez en el Servlet, el hecho de que los parámetros se hayan envíado por GET o por POST, es irrelevante.
        String nombre   = request.getParameter("nombre");
        String clave    = request.getParameter("clave");
        
        
        // Si el usuario y la clave son los correctos, sobrescribimos el valor original de la cadena codigoSecreto.
        if("juan".equals(nombre) && "12345".equals(clave)) {
            codigoSecreto = "<span style='color:green; font-size:1.2cm'>ALFA-BRAVO-TANGO 101-22092006-W4E</span>";
        } else {
        	codigoSecreto = "<span style='color:red; font-size:1.2cm'>!!! ACCESO NO AUTORIZADO !!!</span>";
        }
        
        
        response.setContentType("text/html");
        
        PrintWriter escritor = response.getWriter();
                
        escritor.print(codigoSecreto);	// ESCRIBIR EN LA SALIDA

        escritor.flush();
        escritor.close(); // close hace flush() automáticamente, al igual que se cierra el flujo al terminarse el método.

    }

}