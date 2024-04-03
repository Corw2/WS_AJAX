<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>


<html>

    <head>
    
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>JSP Page</title>

        <script type="text/javascript">

            function f_crearNegociador(URL) {

                // NEGOCIADOR AJAX DEFINIDO LOCALMENTE.
                var negociador;
                
                if(window.XMLHttpRequest) {
                    negociador = new XMLHttpRequest();
                } else {
                    negociador = new ActiveXObject("Microsoft.XMLHTTP");
                }
               
                if(negociador != null) {

                    //alert("CREADO NEGOCIADOR ... URL = " + URL);

                    negociador.open("GET",URL);
                    
                    negociador.onreadystatechange = function() {
                        if (negociador.readyState===4 && negociador.status===200) {
                            
                            var datosXML = negociador.responseXML;
                            var nombres = datosXML.getElementsByTagName("nombre"); // array de <nombre>XXX</nombre>
                            var texto = "";
                                                        
                            // Comprobar que hay nodos nombre para actualizar con ellos la capa "cajaNombresCoincidentes".
                                        
                            if(nombres !== null && nombres.length > 0) {
                                for(var x=0; x<nombres.length; x++) {
                                    // Recuperar el valor de texto de cada nodo y añadirle un salto de línea.
                                    // Observar como la siguiente línea se repite a lo largo de los distintos ejercicios,
                                    // utilizándose para recuperar el valor final (texto) del nodo:
                                    texto += nombres[x].firstChild.data + "<br/>";
                                }
                            
                                // Actualizar la caja de nombres coincidentes.
                                document.getElementById("cajaNombresCoincidentes").innerHTML = texto;
                            }
                        }
                    };

                    // LANZAR EL NEGOCIADOR CONTRA EL SERVLET DEL SERVIDOR (modo GET, los parámetros en la URL).
                    negociador.send(null);

                }                                
            }


            function f_comprobarNombres(evento) {

                // TECLA BORRAR ... keyCode = 8

                //alert("parametro evento --> " + evento);      // FUNCIONA EN MOZILLA Y EN EXPLORER.
                //alert("window.event ---> " + window.event);   // SÓLO FUNCIONA EN EXPLORER.
                //alert("tipo evento = " + evento.type);        // DETECTAR EL TIPO DE EVENTO (le quita el on) onkeyup -> keyup.
                //alert("codigo keyCode = " + evento.keyCode);  // DETECTAR LA TECLA PULSADA ... indica un número ('DELETE' == 8).
                      
                // Si la caja del nombre está vacia y la tecla pulsada es borrar (keyCode 8), entonces
                // borrar el contenido de la caja de coincidentes y dar el foco a la caja del nombre.
                
        
                // Detectar si la caja de nombre está o no vacia y si se pulsa o no la tecla de borrado.
                if(document.getElementById("cajaNombre").value.trim() === "" && evento.keyCode === 8) { 
                    document.getElementById("cajaNombresCoincidentes").innerHTML = "";
                    document.getElementById("cajaNombre").focus();
                    return;
                }
        
                if(document.getElementById("cajaNombre").value.trim() === "") {
                    return;
                }
        
        
                // Si la caja del nombre aún no está vacia y/o la tecla pulsada es borrar, comprobar si hay
                // nombres coincidentes con el texto que quede. Así, YA SEA INTRODUCIENDO UN NUEVO TEXTO EN LA CAJA
                // DEL NOMBRE O BORRANDO PARTE DEL YA ESCRITO, SE HABRÁ DE LANZAR LA COMPROBACIÓN DE COINCIDENTES
                // CONTRA EL SERVLET.
                
                // Obtener el valor actual de la caja del nombre (borrar espacios blancos al inicio y al final).
                var valorCajaNombre = document.getElementById("cajaNombre").value.trim();
                
                // Realizar un reset de la caja de nombres coincidentes.
                document.getElementById("cajaNombresCoincidentes").innerHTML = "";
                
                // La URL lanzada contendrá por GET el parámetro con el valor actual de la caja del nombre.
                // MODO GET CON PARÁMETROS EN LA URL.
                var URL = "ServletNombres?nombre=" + valorCajaNombre;
                               
                // Se enviará la petición automáticamente, de forma que cada vez que cambie el contenido de la
                // caja de nombre (escribimos algo en ella), se genere la comprobación de nombres.
                // No resulta útil el control del evento ONCHANGE ya que éste no se activará hasta que la caja
                // pierda el foco (evento ONBLUR).
                f_crearNegociador(URL);

            }


            function f_agregarNuevoNombre() {
                
                // Obtener el nombre que queremos almacenar. El servidor comprobará si está repetido.
                var valorCajaNombre = document.getElementById("cajaNombre").value.trim();                
                
                if(valorCajaNombre === "") {
                    alert("ERROR. DEBES INTRODUCIR TEXTO EN EL CAMPO NOMBRE");
                    document.getElementById("cajaNombre").value=""; // reset.
                    document.getElementById("cajaNombre").focus();
                    return;
                }

               
                // Si llegados al Servlet se detectase la presencia del parámetro nuevoNombre en la petición,
                // se procederá a guardar el mismo en la colección de tipo Set<String>.
                alert("INTENTO GUARDAR UN NUEVO NOMBRE ... " + valorCajaNombre);

                var URL = "ServletNombres?nombre=" + valorCajaNombre + "&nuevoNombre=true"; // PARÁMETRO DE OPERACIÓN.
                document.getElementById("cajaNombre").value = "";
                document.getElementById("cajaNombre").focus();
            
                f_crearNegociador(URL);

            }

            
            function f_borrarTodo() {

                // Si llegados al Servlet se detectase la presencia del parámetro "borrarTodo" en la petición,
                // se invocará al método clear() sobre el Set<String> del servidor, eliminándose todos los nombres
                // almacenados actualmente en la lista.
                
                var URL = "ServletNombres?borrarTodo=true"; // PARÁMETRO DE OPERACIÓN.
                document.getElementById("cajaNombre").value = "";                
                document.getElementById("cajaNombre").focus();
                f_crearNegociador(URL);                

            }

        </script>

    </head>

    
    
    <body onload="document.getElementById('cajaNombre').focus();">        
      
        <center>
            
            <h2> LISTADO DE NOMBRES DE PERSONAS COINCIDENTES </h2>

            <br/><br/>

            <!-- PODEMOS COLOCAR event COMO PARÁMETRO DE LLAMADA A LA FUNCIÓN (EL EVENTO GENERADO CADA VEZ QUE SE
                 LIBERA, SE SUELTA LA TECLA PULSADA). DE ESTA FORMA, SABREMOS CUÁL FUÉ REALMENTE LA TECLA QUE SE
                 PULSÓ. EVENTO "onkeyup". -->
            
            NOMBRE (Mayusc/minusc): <input type="text" id="cajaNombre" value="" size="20" maxlength="18" onkeyup="f_comprobarNombres(event);"/>

            <br/><br/>

            <input type="button" value="AGREGAR UN NUEVO NOMBRE" onclick="f_agregarNuevoNombre();">

            <br/><br/>

            <input type="button" value="BORRAR TODO" onclick="f_borrarTodo();">

            <br/><br/>        

            <div id="cajaNombresCoincidentes" style="color:blue;width:8cm;height:4cm;border-style:solid"/>

        </center>

    </body>
        
</html>