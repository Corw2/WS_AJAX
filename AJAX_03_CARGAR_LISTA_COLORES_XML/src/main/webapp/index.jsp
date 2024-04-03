<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>


<html>

    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>JSP Page</title>
        
        <script type="text/javascript">
            
            var negociador;             // EL NEGOCIADOR AJAX.
            var xml;                    // LA RESPUESTA XML DEL SERVIDOR.


            function f_crearNegociador() {
                
                if(window.XMLHttpRequest) {
                    negociador = new XMLHttpRequest();
                } else {
                    negociador = new ActiveXObject("Microsoft.XMLHTTP");
                }
                
                if (negociador != null) {
                    // CONFIGURAR EL NEGOCIADOR (MODO, URL Y FUNCIÓN DE RETORNO).
                    f_configurarNegociador();
                    // CONECTAR CON EL SERVIDOR.
                    f_conectarNavegadorServidor();
                }
                
            }
            


            function f_configurarNegociador() {
                
                // LLAMAMOS AL SERVLET QUE GENERARÁ LA RESPUESTA XML CON LOS COLORES QUE SE NOS PERMITIRÁ USAR.
                
                //negociador.open("GET", "ServletGeneradorXML");
                
                //negociador.open("GET", "PEPE");
                
                negociador.open("GET", "ANA");
                
                
                
                // ESTA ES LA FUNCIÓN ANÓNIMA QUE USAREMOS COMO FUNCIÓN DE RETORNO:
                negociador.onreadystatechange = function() {
                    if (negociador.readyState === 4 && negociador.status === 200) {
                        // AUNQUE ENVIEMOS XML PODEMOS TAMBIÉN LEER SU CONTENIDO CON responseText (no al revés).
                        // alert("negociador.responseText = " +  negociador.responseText);
                        // 
                        // DEBE OBTENERSE UN OBJETO Document [object Document]. VIGILAR QUE NO SEA null.
                        //alert("negociador.responseXML = " +  negociador.responseXML); // [object XMLDocument].

                        // ALMACENAR EL CONTENIDO XML DE LA RESPUESTA EN LA VARIABLE GLOBAL QUE HEMOS DENOMINADO xml.
                        const xml = negociador.responseXML;

                        /* --- PROCESAR LA RESPUESTA XML MEDIANTE DHTML (Dynamic Hyper Text MarkUp Language) ---

                                    EL FICHERO XML RECIBIDO EN EL CLIENTE (se escribió todo en 1 línea):
            
                                    <?xml version='1.0' encoding='UTF-8'?>

                                    <raiz>
                                        <colores>red</colores>
                                        <colores>green</colores>
                                        <colores>blue</colores>
                                    </raiz>         

                        */

                        // Obtener el array de elementos <colores> leyendo el contenido de la variable xml. 
                        // Buscamos por el nombre de la etiqueta. Hay 3 etiquetas de nombre o tipo <colores>.
                        // Usamos DHTML y su método getElementsByTagName("xxx").
                        
                        // Ahora no es document.getElementById(xxx), sino xml.getElementsByTagName("xxx");
                        // Se genera Element[] ... un array de elementos.

                        var arrayColoresServidor = xml.getElementsByTagName("colores");



                        // COMENTAREMOS LOS 'alert()' UNA VEZ VERIFICADO QUE SE RECIBE LA RESPUESTA Y ES CORRECTA.
                        
                        /*
                        
                        alert("arrayColoresServidor = " + arrayColoresServidor);                                                                               
                            // [object HTMLCollection] ... nodeList ... array de <colores>.
                            
                        alert("arrayColoresServidor - primer nodo = " + arrayColoresServidor[0]);
                            // [object Element] ... node ... el primero de los <colores> ... <colores>red</colores>.
                            
                        alert("arrayColoresServidor - primer nodo - primer hijo = " + arrayColoresServidor[0].firstChild);
                            // [object Text] ... nodeText ... red es el contenido, pero es un objeto tipo Text y no sólo una cadena de texto.
                            
                        alert("arrayColoresServidor - primer nodo - primer hijo - valor de su propiedad data/nodeValue = " + arrayColoresServidor[0].firstChild.data);
                            // "red" ... su valor es una cadena de texto.

                        //alert("primer NodeList - .nodeValue = " + arrayColoresServidor[0].firstChild.nodeValue);  // Valor String del nodo (igual que con .data, pero más antiguo).
                        
                        */



                        // EL TEXTO CON EL QUE RELLENAREMOS LA CAJA CENTRAL INFORMATIVA (se irá completando en sucesivas líneas).
                        var texto = "TOTAL COLORES SERVIDOR ... " + arrayColoresServidor.length + " <br/>";

                        // Obtener una referencia a la lista desplegable de colores de la página que hasta ahora sólo contenía la opción (<option>) "ninguno".
                        // AVISO: NO UTILIZAR EL id YA EXISTENTE (listaColores), DEBIÉNDOSE CREAR UNA NUEVA REFERENCIA O NO FUNCIONARÁ BIEN.
                        
                        var comboListaColores = document.getElementById("listaColores"); // EL COMBO O CONTROL TIPO SELECT-OPTIONS.
                        
                        
                        // MODIFICAR EL CONTENIDO DE LA CAJA DE TEXTO INFORMATIVA Y RELLENAR LA LISTA DE COLORES CON LOS OBTENIDOS DEL SERVIDOR:
                        for (let x=0; x < arrayColoresServidor.length; x++) {
                                                        
                            // Obtener el valor de cada elemento <colores> del xml en formato texto ... "red", "green", "blue".
/* -----IMPORTANTE----> */  var valorNodo = arrayColoresServidor[x].firstChild.data; // "red", "green", "blue".
                            
                            // Ir generando el texto de la caja central informativa (no confundirla con el combo o lista de selección del color).
                            texto += " [*] COLOR " + x + " ... " + valorNodo + "<br/>";

                            // *** CREAR LOS NODOS OPTION DENTRO DE LA LISTA HTML ***:
                            // Como empezamos en 0, se elimina el <option> original cuyo valor era "ninguno".
                            // El uso de new crea un nuevo objeto de tipo Option.
                            
/*comboLista-IMPORTANTE----> */  comboListaColores.options[x] = new Option(valorNodo);

                            // Se rellenará la lista select desplegable con:
                            //              red
                            //              green
                            //              blue
                            // que son los valores de color (en inglés) con los que podremos colorear el texto,
                            // los cuales se han obtenido a través de la consulta AJAX al servidor.

                            // !!! LLEGADOS AQUÍ, LA LISTA DE COLORES MOSTRARÁ SUS 3 NUEVAS OPCIONES PARA EL COLOR !!!.

                        }

                        // COLOCAR EL TEXTO INFORMATIVO EN LA CAJA CENTRAL.
                        document.getElementById("cajaTexto").innerHTML = texto;
                        
                        // DESHABILITAR EL BOTÓN QUE PERMITE LA CARGA DE LOS COLORES DESDE EL SERVIDOR.
                        document.getElementById("botonCargarColores").disabled = true;

                    }
                    
                };      // PUNTO DE FINALIZACIÓN DE LA FUNCIÓN DE RETORNO.
                
            }
            


            function f_conectarNavegadorServidor() {
                negociador.send(null);
            }                                    



            // SE PEDIRÁ AL SERVIDOR LA LISTA DE COLORES QUE NOS DEVOLVERÁ EN FORMATO XML.
            function f_cargarColores_responseXML() {
                f_crearNegociador();
            }



            function f_colorearTexto() {

                // OBTENER UNA REFERENCIA AL COMBO CON LA LISTA DE COLORES.
                var comboListaColores = document.getElementById("listaColores");
                
                // CONSULTAR CUÁL ES EL COLOR ACTUALMENTE SELECCIONADO (SÓLO PUEDE ELEGIRSE UNO ... size = 1 y NO múltiple).
                var colorElegido = comboListaColores.value;

                if(colorElegido == "ninguno") { // En JavaScript podemos comparar el contenido del texto directamente con ==.
                    alert(" !!! PRIMERO DEBES CARGAR LA LISTA CON LOS COLORES ENTREGADOS POR EL SERVIDOR !!! ");
                    return;
                }

                //alert("VALOR ELEGIDO PARA COLOREAR ... " + colorElegido);                                 // "red", "green", "blue".
                //alert("POSICION DEL COLOR ELEGIDO EN LA LISTA ... " + comboListaColores.selectedIndex);   // 0,1,2 (no lo usaremos en el ejercicio).

                // OBTENER UNA REFERENCIA A LA CAJA INFORMATIVA DE TEXTO.
                var caja = document.getElementById("cajaTexto");
                //alert("!!! APLICANDO COLOR ... " + colorElegido + " !!!");
                
                // MODIFICAR EL ESTILO DE COLOR DE DICHA CAJA A TRAVÉS DE JAVASCRIPT.
                // ESTABLECER EL VALOR DE LA PROPIEDAD .style.color.                
                caja.style.color = colorElegido;
            }

        </script>
        
    </head>

    
    
    <body>
        <div align="center">
    
            <h3 style="color:blue">*** CARGA LOS COLORES EN LA LISTA, ELIGE UNO Y LUEGO PULSA COLOREAR ***</h3>
            
            <br><br>
            
            <table border="0" width="700" height="50">
                
                <tr>
                    <td align="center">
                            <select id="listaColores" name="color" size="1">
                                <!-- SI NO INDICAMOS value PARA EL OPTION, SE COGERÁ EL TEXTO DELIMITADO POR ÉSTE COMO
                                        VALOR DEL PARÁMETRO PARA LA PETICIÓN HTTP ... <option value="ninguno">ninguno</option> -->
                                <option>ninguno</option> 
                            </select>
                    </td>
                    
                    <td align="center">
                        <div id="cajaTexto" style="font-size:0.5cm;text-align:center;border-style:solid;">
                            !!! SE UTILIZARA LA PROPIEDAD responseXML DEL NEGOCIADOR AJAX !!!
                        </div>
                    </td>
                    
                    <td align="center">
                        <table>
                            <tr>
                                <td>
                                    <!-- FUNCIÓN JS PARA ACTIVAR LA NEGOCIACIÓN AJAX -->
                                    <input type="button" id="botonCargarColores" value="CARGAR COLORES XML" onclick="f_cargarColores_responseXML();"/>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <!-- FUNCIÓN JS PARA COLOREAR EL TEXTO DE LA CAJA -->
                                    <input type="button" id="botonColorearTexto" value="COLOREAR TEXTO" onclick="f_colorearTexto();"/>
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>
            
            </table>

            <br/><br/>
                        
        </div>
    
    </body>

</html>