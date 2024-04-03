package servlets;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletComprobar extends HttpServlet {
       
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        response.setContentType("text/html");
        
        System.out.println("HE LLEGADO A ... ServletComprobar");
        
        int numeroAleatorio = (int)(Math.random() * 9 + 1); // [1..9]        
        
        //numeroAleatorio = 6;
        
        String textoNumero = request.getParameter("numero");
             
        String mensaje = "EL NUMERO ALEATORIO FUE ... " + numeroAleatorio + "<br/><br/>";
                
        try {
            
            int numero = Integer.parseInt(textoNumero);
            
            if(numeroAleatorio == numero) {                
                mensaje += "<span style='color:red; font-size:40px'> !!! PREMIO !!! </span>";
            } else {
                mensaje += "--- SIGUE JUGANDO --- ";
            }
            
        } catch(NumberFormatException nfe) {
            System.out.println("ERROR DE CONVERSION NUMERICA ... " + nfe);
            mensaje = "ERROR. DEBES INTRODUCIR UN NUMERO";
        }
        
        System.out.println(">>>>> NUMERO ELEGIDO >>>>> " + textoNumero);
        System.out.println(">>>>> NUMERO ALEATORIO >>>>> " + numeroAleatorio + "\n\n");

        
        // ESCRIBIR LA RESPUESTA HACIA EL CLIENTE:
        
        PrintWriter escritor = response.getWriter();
        escritor.print(mensaje);
        
        escritor.flush();
        escritor.close();

    }

}