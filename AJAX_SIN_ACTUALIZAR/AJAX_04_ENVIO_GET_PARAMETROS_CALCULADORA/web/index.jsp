<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>


<html>

    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <script type="text/javascript">



            function f_crearNegociador(x,y) {
                
                if(window.XMLHttpRequest) {
                    negociador = new XMLHttpRequest();
                } else {
                    negociador = new ActiveXObject("Microsoft.XMLHTTP");
                }
                
                if (negociador != null) {
                    f_configurarNegociador(x,y);
                    f_conectarNavegadorServidor();
                }
                
            }


            
            function f_configurarNegociador(x,y) {
                
                // AÑADIR LOS PARÁMETROS A LA URL DE LA PETICIÓN EN FORMA DE QUERY-STRING (?x=1&y=2).
              
                // NOTA: LO MÁS CONVENIENTE SERÍA REALIZAR EL ENVÍO EN MODO POST (REQUIERE DE UNA CABECERA HTTP),
                // ALGO QUE SE MOSTRARÁ EN EL SIGUIENTE EJERCICIO (EL PRESENTE HACE USO DEL MODO GET CON LO QUE
                // NO PODREMOS INTRODUCIR NINGÚN PARÁMETRO EN EL MÉTODO send() DEL NEGOCIADOR).

                // CONSTRUIR LA URL A SER LANZADA POR AJAX (es aquí dónde están los parámetros ... send(null)).
                var url = "ServletCalculadoraXML" + "?" + "x=" + x + "&" + "y=" + y;
                alert("URL QUE SE LANZA:\n" + url)
                negociador.open("GET",url);
                
                // FUNCIÓN DE RETORNO (sólo cuando los datos estén disponibles se procesará la respuesta):
                // SE CARGA UNA PROPIEDAD DEL OBJETO XmlHttpRequest CON UNA FUNCIÓN.
                negociador.onreadystatechange = function() {
                    if (negociador.readyState===4 && negociador.status===200) {                       
                        // Crear un objeto que represente el fichero XML devuelto por el Servlet.
                        // Se obtendrá éste de la propiedad responseXML del negociador Ajax.
                        var xml = negociador.responseXML;
                        
                        // Datos de la respuesta del servidor ... un conjunto de etiquetas obtenidas del anterior fichero XML.
                        var arrayResultados         = xml.getElementsByTagName("resultados");
                        
                        // Referenciar los elementos <label> de la página del cliente (se rellenarán respetando el orden de escritura).
                        // En total son 4, uno para cada operación + - * / (también les podríamos haber dado un id a cada uno de ellos,
                        // pero se busca el practicar cómo recorrer los elementos dentro del array).
                        var arrayLabelsDocumento    = document.getElementsByTagName("label");

                        for(var x=0; x < arrayResultados.length; x++) {
                            // Utilizamos los elementos obtenidos a partir del documento de respuesta XML
                            // para dar valor a las etiquetas <label> de la página. Recorrer el array.
                            
                            // Ejemplo: Si elegimos como datos de la petición x=3 y=2:
                            //      EL PRIMER LABEL (SUMA),
                            //      RELLENARLO CON EL VALOR DEL PRIMER NODE (<resultados>5</resultados>) ... "5".

                            // Rellenar el valor del nodo de tipo <label> con el resultado de la suma (valor del primer nodo
                            // <resultados> del XML recuperado):
                            arrayLabelsDocumento[x].innerHTML = arrayResultados[x].firstChild.nodeValue;
                            
                            // El uso de .data es más aconsejable que .nodeValue por eficiencia, pero a su vez, .nodeValue
                            // supera a la opción .data en lo relacionado con temas de COMPATIBILIDAD entre navegadores:
                            
                            /*
                             The nodeValue property is the best way of manipulating the value of nodes - preferable
                             over more specialized properties, such as data or value, because of various browser issues.
                
                             The nodeValue field is defined for all Nodes and maps to different things depending on the
                             node type. The data field is defined on Nodes that inherit from CharacterData, which is to
                             say Text, CDATASection, and Comment nodes. For those three node types, nodeValue maps straight
                             to data. I know it's weird, but the DOM does have quite a few such irrelevant duplication due 
                             to trying to make the vendors happy back then.                
                            */
                        }

                    }
                    
                };
                
            }
            
            
            
            function f_calcular() {
                // OBTENER EL VALOR DE LOS PARÁMETROS A ENVIAR AL SERVLET, PARA AÑADIRLOS A LA URL LANZADA.
                var x = document.getElementById("cajaX").value.trim();
                var y = document.getElementById("cajaY").value.trim();                
                
                // COMPROBAR SI LOS NÚMEROS SON CORRECTOS ...
                                
                if(""==x || ""==y) {
                    alert("ERROR, LOS CAMPOS X,Y NO PUEDEN ESTAR VACIOS");
                    return;
                }
                
                if(isNaN(x) || isNaN(y)) {
                    alert("ERROR, DEBES INTRODUCIR VALOR NUMÉRICO EN X,Y");
                    return;
                }

                // REALIZAREMOS LAS 4 OPERACIONES: + - * /.
                if(y==0) {
                    alert("ERROR, EL DIVISOR NO PUEDE SER 0");
                    return;
                }

                alert("VALORES CORRECTOS ... X = " + x + " , " + "Y = " + y);                
                
                // ... Y SI LO SON, CREAR EL NEGOCIADOR.
                f_crearNegociador(x,y);
            }



            function f_conectarNavegadorServidor() {
                negociador.send(null);
            }

        </script>

        
        <!-- ESTILO COMÚN DE LAS CELDAS DE LA TABLA - USO DE UN ESTILO "INCRUSTADO" O DECLARADO EN EL HEAD DEL DOCUMENTO -->
        <style type="text/css">
            td{text-align:center; width:3cm; height:1.5cm;}
            label{color:red;font-weight:bold}
        </style>
        
    </head>

    
    
    <body onload="document.getElementById('cajaX').focus();">

        <center>
            
            <h3 style="color:blue">
                *** INTRODUCE 2 VALORES Y LUEGO PULSA CALCULAR ***
            </h3>
            
            <h5 style="color:blue">
                *** ENVIO DE PARAMETROS USANDO GET (no cambia la url del navegador
                        porque no hay recarga de pagina) ***
            </h5>
            
            <br><br>
            
            <!-- 4 columnas de ancho -->
            <table border="1" style="background-color:silver;">
                
                <tr style="background-color:orange">
                    <td colspan="2">
                        <!-- RECORDAR QUE COLOCAMOS LOS PARÁMETROS DIRECTAMENTE EN LA URL DE AJAX PORQUE USAMOS GET -->
                        X: <input type="text" id="cajaX" value="" size="3" maxlength="3" style="color:red;"/>
                    </td>
                    <td colspan="2">
                        Y: <input type="text" id="cajaY" value="" size="3" maxlength="3" style="color:red;"/>
                    </td>
                </tr>

                <tr>
                    <td>
                        <!-- Depositaremos los valores de las operaciones en las siguientes etiquetas <label>, sin hacer uso
                                de id. En su lugar usaremos document.getElementsByTagName("label") y su orden de escritura
                                en el documento -->
                        SUMA: <label></label>
                    </td>
                    
                    <td>
                        RESTA: <label></label>
                    </td>
                    
                    <td>
                        MULTIPL: <label></label>
                    </td>
                    
                    <td>
                        DIVISION: <label></label>
                    </td>
                </tr>

                <tr>
                    <td colspan="4">
                        <input type="button"
                               value="CALCULAR"
                               style="text-align:center;font-weight:bold;color:blue;background-color:gold;border-style:outset;"
                               onclick="f_calcular();"/>
                    </td>
                </tr>
                
            </table>
            
            <br/><br/>
                        
        </center>
    </body>

</html>