<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>


<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <style type="text/css">
            #caja{color:blue; font-size:0.5cm; width:14cm; height:3cm; background-color:cyan;}
        </style>

        <!-- CARGA DEL FICHERO EXTERNO JAVASCRIPT -->
        <script type="text/javascript" src="negociador.js"></script>
        
        <script type="text/javascript">
            
            function f_mostrarCoches() {                
                f_negociador("ServletConcesionario", f_mostrar);
            }
            

            function f_mostrar(documentoXML) {
                
                var cajaTexto = document.getElementById("caja");
                
                // BORRAR EL RESULTADO DE POSIBLES EJECUCIONES ANTERIORES.
                cajaTexto.innerHTML = "";

                // OBTENER UN ARRAY (NodeList) DE ELEMENTOS <coche>.
                var coches = documentoXML.getElementsByTagName("coche");
                
                // RECORRER EL ARRAY DE NODOS <coche>:
                for (contador=0; contador<coches.length; contador++) {
                    // OBTENER EL NOMBRE DEL COCHE ACTUAL ... [RENAULT LAGUNA 2007, AUDI TT 2013].
                                        
                    // EJEMPLO DE LO QUE ENCONTRAMOS EN EL XML RECIBIDO:
                    // <coche usado='SI' precio='12000'>
                    //    RENAULT LAGUNA 2007
                    // </coche>
                  
                    // OBTENER EL TEXTO DEL COCHE ACTUAL:
                    var cocheActual = coches[contador].firstChild.nodeValue;    // Ej: RENAULT LAGUNA 2007
                    
                    // OBTENER LOS ATRIBUTOS DEL COCHE ACTUAL Y SU VALOR.
                    var losAtributos = coches[contador].attributes;         // DEVUELVE UN "named node map" DE ATRIBUTOS (cada coche los suyos).
                    var usado = losAtributos.getNamedItem("usado").value;   // OBTENER UN ATRIBUTO EN PARTICULAR INDICANDO SU NOMBRE.
                    var precio = losAtributos.getNamedItem("precio").value; // SI NO EXISTE, DEVOLVERÁ null Y UN ERROR POR CONSOLA.
                                                                            // EL VALOR SE OBTIENE CON .value, NO SIRVE .nodeValue NI .data.
                    
                    cajaTexto.innerHTML += "<br/>" + cocheActual + " ... USADO = " + usado +
                                           " // PRECIO = " + precio + "<br/>";
                }
                
            }
            
        </script>
        
    </head>

    
    
    <body>
        
        <center>
        
            <h1> CONSULTAR ATRIBUTOS DE UN ELEMENTO/ETIQUETA XML </h1>
            
            <h2> - NAMED NODE MAP - </h2>
            
            <br/><br/>
            
            <input type="button" value="MOSTRAR COCHES" onclick="f_mostrarCoches();"/>
            
            <br/><br/>
            
            <div id="caja"/>
            
        </center>
    
    </body>

</html>