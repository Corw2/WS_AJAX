package servlets;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletConcesionario extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        response.setContentType("text/xml");
        
        PrintWriter escritor = response.getWriter();

        escritor.print("<?xml version='1.0'?>");
        
        escritor.print("<concesionario>");
        
        // *** LOS ATRIBUTOS SIEMPRE SON TEXTO, LUEGO NECESITAN DE '' ***
        
        escritor.print("<coche usado='SI' precio='12000'>");
        escritor.print("RENAULT LAGUNA 2007");
        escritor.print("</coche>");

        escritor.print("<coche usado='NO' precio='30000'>");
        escritor.print("AUDI TT 2013");
        escritor.print("</coche>");

        escritor.print("</concesionario>");
        
        escritor.flush();
        escritor.close();
        
    }

}