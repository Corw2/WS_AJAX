package servlets;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


// MISMO FUNCIONAMIENTO QUE EL ServletContadorNegociadorGlobal.

public class ServletContadorNegociadorLocal extends HttpServlet {

    // Variable global (comportamiento estático, SIN SERLO, para todos los clientes de este Servlet).    
    private int contador;
    
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
               
        response.setContentType("text/html");

        // RETARDO PARA FACILITAR QUE LLEGUE UNA NUEVA PETICIÓN (PULSAR EL BOTÓN RÁPIDAMENTE) ANTES DE QUE LA
        // RESPUESTA DE LA ACTUAL HAYA SIDO PROCESADA Y ENVÍADA ... DADO QUE CADA PETICIÓN TIENE SU PROPIO 
        // NEGOCIADOR NO SE PERDERÁ NINGUNA RESPUESTA, INDEPENDIENTEMENTE DEL TIEMPO QUE SE NECESITE PARA SER
        // PROCESADA. SE CONSUMEN MÁS RECURSOS PERO ES LA SOLUCIÓN ADECUADA PARA PODER GARANTIZAR QUE TODOS LOS
        // CLIENTES VAN A SER DEBIDAMENTE ATENDIDOS.
        
        try {
            Thread.sleep(500);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }        
        
        // INCREMETAR EL CONTADOR.
        contador++;        
        
        PrintWriter escritor = response.getWriter();
        escritor.println(contador + "  ... NEGOCIADOR LOCAL, PETICION ATENDIDA. <br/>");
        System.out.println("----------> SE HA LLAMADO A ServletContadorNegociadorLocal, PETICION ..." + contador );

        escritor.flush();
        escritor.close();
    
    } 

}