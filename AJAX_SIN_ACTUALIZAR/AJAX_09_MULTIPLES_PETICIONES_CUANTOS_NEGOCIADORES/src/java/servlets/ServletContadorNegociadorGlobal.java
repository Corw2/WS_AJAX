package servlets;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletContadorNegociadorGlobal extends HttpServlet {

    // Variable global (comportamiento estático, SIN SERLO, para todos los clientes de este Servlet).
    private int contador;
    
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        // RETARDO PARA FACILITAR QUE LLEGUE UNA NUEVA PETICIÓN (PULSAR EL BOTÓN RÁPIDAMENTE) ANTES DE QUE LA
        // RESPUESTA DE LA ACTUAL HAYA SIDO PROCESADA Y ENVÍADA ... PROBLEMA: SE PERDERAN ALGUNAS RESPUESTAS
        // AL UTILIZARSE EL MISMO OBJETO NEGOCIADOR AJAX PARA TODAS ELLAS.
        try {
            Thread.sleep(500); // 500 ms.
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
        
        response.setContentType("text/html");
        
        // INCREMETAR EL CONTADOR.
        contador++;
        
        PrintWriter escritor = response.getWriter();
        escritor.println(contador + "  ... NEGOCIADOR GLOBAL, PETICION ATENDIDA. <br/>");
        System.out.println("----------> SE HA LLAMADO A ServletContadorNegociadorGlobal, PETICION ..." + contador);

        escritor.flush();
        escritor.close();

    }

}