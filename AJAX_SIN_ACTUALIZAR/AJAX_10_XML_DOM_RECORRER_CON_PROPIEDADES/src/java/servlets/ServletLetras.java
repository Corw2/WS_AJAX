package servlets;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletLetras extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
      
        System.out.println("SE LLAMA AL SERVLET ServletLetras ... ");
        
        response.setContentType("text/xml");

        PrintWriter escritor = response.getWriter();
        
        // !!!IMPORTANTE!!!.  
        // NO USAR println() O CREARÁ UN NODO DE TIPO #text CORRESPONDIENTE AL SALTO DE LÍNEA. TAMPOCO DEBEMOS
        // UTILIZAR ESPACIOS EN BLANCO PARA LOS VALORES DE LOS NODOS YA QUE LOS TRATARÁ TAMBIÉN COMO #text.
        
        // USAR SIEMPRE print() PARA GENERAR EL DOCUMENTO XML Y ESCRIBIR TODO EL TEXTO DE FORMA QUE QUEDE CONTINUO:
        
        escritor.print("<?xml version='1.0'?>");
        escritor.print("<datos>");
        escritor.print("<letras>");
        escritor.print("<vocal>");       
        escritor.print("A");  
        escritor.print("</vocal>");
        escritor.print("<consonante>");
        escritor.print("Z");
        escritor.print("</consonante>");
        escritor.print("</letras>");
        escritor.print("</datos>");
        
        escritor.flush();
        escritor.close();
    
    } 

}