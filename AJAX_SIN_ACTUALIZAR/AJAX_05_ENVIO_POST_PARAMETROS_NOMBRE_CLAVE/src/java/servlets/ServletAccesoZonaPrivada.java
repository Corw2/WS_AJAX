package servlets;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletAccesoZonaPrivada extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) 
            throws IOException, ServletException {

        // Es conveniente el uso de este tipo de trazas en desarrollo para ver que el cliente Ajax realmente está
        // invocando al servidor.
        System.out.println("-----------> SE HA LLAMADO AL servletAccesoZonaPrivada");
        
        // Partimos de que no se le concede acceso al usuario.
        String codigoSecreto = "<span style='color:red; font-size:1.2cm'>!!! ACCESO NO AUTORIZADO !!!</span>";
        
        // Una vez en el Servlet, el hecho de que los parámetros se hayan envíado por GET o por POST, es irrelevante.
        String nombre   = request.getParameter("nombre");
        String clave    = request.getParameter("clave");
        
        // Si el usuario y la clave son los correctos, sobrescribimos el valor original de la cadena codigoSecreto.
        if("juan".equals(nombre) && "12345".equals(clave)) {
            codigoSecreto = "<span style='color:green; font-size:1.2cm'>ALFA-BRAVO-TANGO 101-22092006-W4E</span>";
        }
        
        response.setContentType("text/html");
        
        PrintWriter escritor = response.getWriter();
                
        escritor.println(codigoSecreto);

        escritor.flush();
        escritor.close(); // close hace flush() automáticamente, al igual que se cierra el flujo al terminarse el método.

    }

}