package servlets;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletRiquezas extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        // RESPUESTA EN FORMATO XML.
        response.setContentType("text/xml");
        
        PrintWriter escritor = response.getWriter();
        
        escritor.print("<?xml version='1.0'?>");
        
        escritor.print("<riquezas>");
        
        escritor.print("<diamantes>");
        escritor.print("<valor>");
        escritor.print("500000");
        escritor.print("</valor>");
        escritor.print("</diamantes>");

        escritor.print("<oro>");
        escritor.print("<valor>");
        escritor.print("250000");
        escritor.print("</valor>");
        escritor.print("</oro>");

        escritor.print("<cuadros>");
        escritor.print("<valor>");
        escritor.print("1250000");
        escritor.print("</valor>");
        escritor.print("</cuadros>");        
        
        escritor.print("</riquezas>");
        
        escritor.flush();
        escritor.close();
    
    } 

}