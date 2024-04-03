package servlets;


import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class ServletCalculadoraXML extends HttpServlet {

    private static final long serialVersionUID = 1L;

	@Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        
        System.out.println("---> SE HA LLAMADO AL servletCalculadoraXML. MÉTODO = " + request.getMethod());
        
        // Suponemos que los datos recogidos son correctos y que no se van a producir excepciones.
        // Se hizo la validación en el cliente con isNaN(x) pero se debería volver a realizar en el servidor
        // dado que es posible que la misma hubiese sido intercepta y modificada.
        
        float x = Float.parseFloat(request.getParameter("x"));
        float y = Float.parseFloat(request.getParameter("y"));
        
        float suma  = x+y;
        
        float resta = x-y;

        // SÓLO 2 DECIMALES. DIVIDIR ENTRE 100F (indicar float) O LO COGERÁ COMO int (sin decimales).       
        float multiplicacion    = ((int)((x*y)*100))/100F; 

        float division          = ((int)((x/y)*100))/100F;         

        
        // NOTA: EL SERVLET DEBERÍA HACER USO DE OTRO OBJETO PARA CALCULAR LAS OPERACIONES MATEMÁTICAS. 
        //       JAVA TAMBIÉN PROPORCIONA CLASES PARA EL FORMATEO NUMÉRICO DE DATOS.
        
        // ESTABLECER EL ENVÍO DE LA RESPUESTA EN XML.
        response.setContentType("text/xml");
        
        // OBTENER FLUJO ESCRITOR DE SALIDA HACIA EL CLIENTE.
        PrintWriter escritor = response.getWriter();
        
        // EL DOCUMENTO XML QUE GENERAMOS PARA LEERLO EN EL CLIENTE POR JAVASCRIPT.
        //      ESCRIBIR EL CÓDIGO DE FORMA QUE NO SE INTRODUZCAN EN ÉL ESPACIOS BLANCOS NI SALTOS DE LÍNEA.
        escritor.println("<?xml version='1.0'?>" +
                         "<calculadora>" +
                            "<resultados>" + suma + "</resultados>" +
                            "<resultados>" + resta + "</resultados>" +
                            "<resultados>" + multiplicacion + "</resultados>" +
                            "<resultados>" + division + "</resultados>" +
                         "</calculadora>");

        
        // EL CÓDIGO JAVASCRIPT-AJAX IMPLEMENTADO EN EL CLIENTE:
        
        // xml = negociador.responseXML;                                    El documento xml generado en el Servlet.
        
        // var arrayResultados = xml.getElementsByTagName("resultados");    Un array de elementos Node (NodeList):
        // para x=3 y=2 -->     <resultados>5</resultados><resultados>1</resultados><resultados>6</resultados><resultados>1.50</resultados>
        
        // arrayResultados[0]                                               El primer nodo (posición 0) de dicho array:
        // <resultados>5</resultados>                                       El nodo se compone de todo, no solamente del 5.
    
        // arrayResultados[0].firstChild                                    El contenido del primer nodo de dicho array:
        // 5                                                                Es un elemento u objeto de tipo Text 5, no es el "5" como valor.
        
        // arrayResultados[0].firstChild.data o .nodeValue                  El valor del contenido del primer nodo de dicho array:
        // "5"                                                              Ahora sí es el "5".
    
        // Así, para obtener los resultados correspondientes a las operaciones aritméticas realizadas utilizaremos:
        // arrayResultados[n].firstChild.data

        //      ... en lugar de .data también podemos usar .nodeValue, que es menos eficiente pero más compatible entre
        //          los distintos navegadores web.
        
        escritor.flush();
        escritor.close();
    }

}