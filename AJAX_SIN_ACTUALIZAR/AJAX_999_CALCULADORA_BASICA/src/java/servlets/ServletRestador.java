package servlets;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletRestador extends HttpServlet {
   
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        response.setContentType("text/html");
        
        float x         = Float.parseFloat(request.getParameter("x"));
        float y         = Float.parseFloat(request.getParameter("y"));        
        float resultado = x - y;
        
        PrintWriter escritor = response.getWriter();
        
        escritor.print(x + " - " + y + " = " + resultado);
        
        escritor.flush();
        escritor.close();
        
    }

}