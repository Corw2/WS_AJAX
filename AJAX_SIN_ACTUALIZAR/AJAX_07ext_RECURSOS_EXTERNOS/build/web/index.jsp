<%@page contentType="text/html" import="java.util.Date" pageEncoding="UTF-8"%>


<!DOCTYPE html>


<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>

    
    <body>
        <center>

            <!-- RECURSO EXTERNO EN FUNCIONAMIENTO -->
            
            <p style="font-size:2cm;color:blue;">
                
                
                <%                     
                    // INTRODUCIMOS DIRECTAMENTE CÓDIGO JAVA EN LA PÁGINA (VISTA) MEDIANTE EL USO DE
                    //      SCRIPTLET's ... ES UNA TÉCNICA OBSOLETA Y TOTALMENTE DESACONSEJABLE DE
                    //      CARA A MANTENIMIENTO. EN SU LUGAR, DEBERIAMOS UTILIZAR ACCIONES JSP, J.S.T.L,
                    //      EXPRESIONES DEL LENGUAJE, CUSTOM-TAGS ... etc, ALGO QUE SE VERÁ EN LOS EJERCICIOS
                    //      CORRESPONDIENTES AL MÓDULO DE JSP's.

                    // TODO EL CONTENIDO DE LA PÁGINA SERÁ INCLUÍDO COMO RECURSO EXTERNO ALLÍ DÓNDE SE SOLICITE.
                                              
                    response.setContentType("text/html");
                    
                    // Observar la importación del objeto java.util.Date en la directiva de página.
                    // Los métodos de Date están deprecados pero son de fácil uso:
                    Date fecha = new Date();
                    String hora = fecha.getHours() + " : " + fecha.getMinutes();
                    out.println("HORA: <br/>" + hora);
                %>
                
            </p>
            
        </center>
    </body>

</html>