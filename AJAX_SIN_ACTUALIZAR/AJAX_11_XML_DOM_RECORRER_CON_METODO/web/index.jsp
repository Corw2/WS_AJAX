<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>


<html>

    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <style type="text/css">
            #caja{color:green; font-size:0.6cm; width:10cm; height:4cm; background-color:yellow;}
        </style>
        
        <!-- CARGA DE FICHERO EXTERNO JAVASCRIPT -->
        <script type="text/javascript" src="negociador.js"></script>
        
        <script type="text/javascript">
            
            function f_listarRiquezas() {   
                // Generar la petición Ajax, la cual usará como función de retorno la función f_listar recibiéndo
                // la respuesta en formato XML a través del negociador.
                f_negociador("ServletRiquezas", f_listar);
            }
            
            
            function f_listar(documentoXML) {

                // REFERENCIA A LA CAJA DE TEXTO EN LA QUE SE INDICARÁN LAS RIQUEZAS.
                var cajaTexto = document.getElementById("caja");
            
                // LIMPIAR EL CONTENIDO DE LA CAJA CON RESPECTO A POSIBLES EJECUCIONES ANTERIORES.
                cajaTexto.innerHTML = "";                
                
                // VARIABLE QUE ACUMULARÁ EL VALOR TOTAL DE LAS RIQUEZAS.
                var valorTotal = 0;

                
                // RECORRER EL DOM MEDIANTE EL USO DE MÉTODOS.

                // BÚSQUEDA DE LAS ETIQUETAS DEL DOM (el documento XML recibido) CUYO TIPO SEA <valor>
                var valores = documentoXML.getElementsByTagName("valor");

                alert("DOCUMENTO XML: \n" + documentoXML);
                alert("cuantas etiquetas <valor> = " + valores.length);
                
                for (contador=0; contador<valores.length; contador++) {                    
                            
                    /* EL SERVLET CREÓ UN FICHERO XML EN BASE AL SIGUIENTE CÓDIGO:
                            
                            escritor.print("<?xml version='1.0'?>");        
                            escritor.print("<riquezas>");
                            escritor.print("<diamantes>");  // ... nodo padre de este elemento <valor>.
                            escritor.print("<valor>");      // ... elemento <valor>, obteniendo un total de 3.
                            escritor.print("<500000");      // ... primer hijo del elemento <valor>, indicando el precio de la riqueza.
                            escritor.print("</valor>");
                            escritor.print("</diamantes>");
    
                            ...    
                            ... resto de líneas para las otras riquezas ...
                            ...
                            
                            escritor.print("</riquezas>");
                    
                    */
                           
                    // VAMOS OBTENIENDO EL TEXTO DE LAS ETIQUETAS <valor> Y LO PARSEAMOS A UN NÚMERO ENTERO.
                    var valor = parseInt(valores[contador].firstChild.nodeValue);
                    
                    // SE PUEDE OBTENER LA ETIQUETA PADRE A PARTIR DE UNA HIJA DADA.
                    // ASÍ, A PARTIR DEL VALOR CONSULTAREMOS LA RIQUEZA A LA QUE PERTENECE:
                    // Ej: 500000 ... <diamantes>
                    var nombrePadre = valores[contador].parentNode.nodeName;                    
                    
                    // SE MOSTRARÁ EN LA CAJA DE TEXTO EL TIPO DE RIQUEZA Y SU VALOR.
                    cajaTexto.innerHTML += nombrePadre + " ... " + valor + "<br/>";
                    
                    // Y SE IRÁ SUMANDO EL VALOR TOTAL DE TODAS ELLAS.
                    valorTotal += valor;

                    alert("riqueza: " + nombrePadre + " ... valor " + valor);
                }
                
                // IMPRIMIR EL VALOR TOTAL.
                cajaTexto.innerHTML += "<hr/>" + "VALOR TOTAL = " + valorTotal;
                alert("VALOR TOTAL: " + valorTotal);
            }
            
        </script>
        
    </head>

    
    
    <body>
        
        <center>
            
            <h2> OBTENER ELEMENTOS DEL FICHERO XML MEDIANTE EL USO DE METODOS DEL DOM Y SUS PROPIEDADES </h2>
            
            <input type="button" onclick="f_listarRiquezas();" value="LISTAR RIQUEZAS"/>
            
            <br/><br/>
            
            <div id="caja"></div>            
            
        </center>
    
    </body>

</html>