package servlets;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletGeneradorXML extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) 
            throws IOException, ServletException {
        
        System.out.println("-----------> LLAMADA AL ServletGeneradorXML");
        
//        ESTABLECER EL TIPO MIME MEDIANTE response.setContentType("xxx/yyy");

//        RESPUESTA DE TEXTO CONVENCIONAL PERO GENERADA POR EL SERVLET, EN LUGAR DE SER UN FICHERO DE TEXTO YA EXISTENTE:
        
//        response.setContentType("text/html"); // MODO TEXTO-HTML O BIEN TEXTO/PLANO ("text/plain").
//        PrintWriter escritor = response.getWriter();
//        escritor.println("<p style='color:green;'>DATOS HTML DESDE EL SERVIDOR</p>");
//        escritor.flush();
//        escritor.close();
        
        
        // MODO TEXTO-XML PARA QUE AJAX CARGUE LOS DATOS EN SU PROPIEDAD ResponseXML (responseText también lo recibirá).
        response.setContentType("text/xml"); 
        
        PrintWriter escritor = response.getWriter();

        // PODEMOS IMPRIMIR LAS "" CON \", PERO ES MÁS SENCILLO USAR '' (HTML Y JAVASCRIPT ACEPTAN AMBAS FORMAS,
        // MIENTRAS QUE JAVA SÓLO LAS "".
        //
        // TODO DOCUMENTO XML DEBE COMENZAR CON <?xml version='1.0' encoding='UTF-8'?> Y TENER UN NODO RAÍZ O
        // CONTENEDOR DE LOS DEMÁS NODOS.
        //
        // IMPORTANTE: LOS ESPACIOS BLANCOS Y LOS SALTOS DE LÍNEA FORMAN NODOS, LUEGO ES RECOMENDABLE NO UTILIZARLOS.
        // ASÍ, TODO EL CÓDIGO XML HA DE IR SEGUIDO.

        /* TEXTO FINAL QUE SE MANDARÍA AL CLIENTE (todo seguido) A TRAVÉS DEL NEGOCIADOR AJAX EN SU PROPIEDAD responseXML:
         
                <?xml version='1.0' encoding='UTF-8'?>
                
                <raiz>
                    <colores>red</colores>
                    <colores>green</colores>
                    <colores>blue</colores>
                </raiz>         
         
         */       
                
        // ESCRITURA DEL DOCUMENTO XML DE CARA AL CLIENTE (ES UNA SIMPLE LÍNEA DE TEXTO CON FORMATO XML).
        // SE CREAN ELEMENTOS <colores> QUE CONTENDRÁN A SU VEZ ELEMENTOS DE TIPO 'NODE-TEXT'.
        // ESTA INFORMACIÓN SE RECUPERARÁ DE LA PROPIEDAD responseXML DEL NEGOCIADOR AJAX EN EL CLIENTE.
        
        // RECORDAR: ESCRIBIRLO TODO SEGUIDO Y SIN ESPACIOS EN BLANCO ENTRE LOS NODOS, NI SALTOS DE LÍNEA.
        escritor.println("<?xml version='1.0' encoding='UTF-8'?><raiz><colores>red</colores><colores>green</colores><colores>blue</colores></raiz>");
        
        escritor.flush();
        escritor.close();
        
    }

}