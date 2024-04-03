<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>


<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <script type="text/javascript">
            
            function f_queHoraEs() {

                var negociador;
                
                if(window.XMLHttpRequest) {
                    negociador = new XMLHttpRequest();
                } else {
                    negociador = new ActiveXObject("Microsoft.XMLHTTP");
                }
                
                if(negociador != null) {
                    // Elegir el puerto correcto en cada caso (ejecutar AJAX_07ext_RECURSOS_EXTERNOS y observar
                    //      en la URL del navegador cuál es el número de puerto que realmente utiliza):
                    //var puerto = 8080;
                    //var puerto = 8686;
                    var puerto = 7070;
                    
                    // Llamamos directamente a una página JSP y el código HTML estático que generará es el que
                    // recogeremos a través de negociador.responseText. Así, el negociador contendrá el flujo
                    // de etiquetas HTML que se enviarían hacia el navegador cliente.
                    
                    // EL RESULTADO ES BÁSICAMENTE EL MISMO QUE EL OBTENIDO AL LLAMAR, POR EJEMPLO, A UN SERVLET.
                    // EN ESTE CASO UTILIZAMOS UN JSP (SERVLET DESTINADO A GENERAR LA VISTA) QUE ADEMÁS SE ENCUENTRA EN
                    // UNA APLICACIÓN QUE NO ES LA DIRECTAMENTE USADA POR EL CLIENTE, MOTIVO POR EL QUE LO DENOMINAMOS
                    // COMO RECURSO EXTERNO.
                    
                    // OBSERVAR COMO SOLICITAMOS LA PÁGINA DE INICIO DE OTRA APLICACIÓN.
                    var url = "http://localhost:" + puerto + "/AJAX_07ext_RECURSOS_EXTERNOS/index.jsp";
                    
                    negociador.open("GET", url);
                    
                    negociador.onreadystatechange = function() { 
                        // COMPROBAR QUE LA PÁGINA HA SIDO ENCONTRADA. EL PUERTO DEBE SER EL QUE UTILICE EL RECURSO,
                        // DE LO CONTRARIO, NO SE GENERARÁ UN ERROR 404 SINO QUE EL NAVEGADOR ENTRARÁ EN UN BUCLE SIN
                        // FIN, EN ESPERA DE ENCONTRAR LA PÁGINA SOLICITADA.
                        
                        // VERIFICAMOS SI SE PRODUCE UN ERROR 404:
                        if(negociador.status==404) {
                            alert("----> ESTADO HTTP DEL NEGOCIADOR = " + negociador.status + "\n" +
                                  " !!! EL SERVIDOR RESPONDE, PERO EL RECURSO NO SE HA ENCONTRADO !!!");                        
                            document.getElementById("cajaTexto").style.color="red";
                            document.getElementById("cajaTexto").innerHTML = "RECURSO NO ENCONTRADO!!!." + 
                                                     "<br/><br/>DEBES DESPLEGAR LA APLICACION AJAX_07ext_RECURSOS_EXTERNOS - puerto = " + puerto;
                        }
                        
                        // SI LA PÁGINA ESTÁ FINALMENTE DISPONIBLE (los datos solicitados):
                        if (negociador.readyState==4 && negociador.status==200) {
                            document.getElementById("cajaTexto").style.color="green";
                            var respuesta = negociador.responseText; // EL CÓDIGO HTML ESTÁTICO DE LA PÁGINA JSP CON LA HORA ACTUAL.
                            alert("EL CODIGO ESTATICO HTML QUE GENERA EL JSP/SERVLET index.jsp\n" + respuesta);
                            
                            // EL NAVEGADOR MOSTRARÁ UN DOCUMENTO HTML COMPLETO DENTRO DE OTRO (podemos quitar al externo las partes
                            // que no son propias de los datos de la respuesta, pero las conservamos para demostrar cómo lo navegadores
                            // actuales son capaces de renderizar ambas páginas anidadas sin problemas).
                            document.getElementById("cajaTexto").innerHTML = respuesta;
                        }                            
                    };
                    
                    negociador.send(null);

                }
                
            }
            
        </script>
    </head>

    
    
    <body>
        <center>

            <h1> SOLICITAR RECURSOS EXTERNOS </h1>
            
            <br/><br/>
            
            <input type="button" value="-DIME LA HORA-" onclick="f_queHoraEs();"/>
            
            <br/><br/>
            
            <div id="cajaTexto" style="width:20cm;height:8cm;border-style:outset;border-width:0.4cm">
                <br/>AQUI COLOCAREMOS LA RESPUESTA DEL RECURSO EXTERNO ... index.jsp (su servlet index_jsp) EL CUAL 
                GENERA HTML ESTATICO. <br/><br/> EJECUTAR EN PRIMER LUGAR LA APLICACION AJAX_07ext_RECURSOS_EXTERNOS 
                Y COMPROBAR EL PUERTO QUE ESTA UTILIZA, YA QUE SI LA PAGINA SE ENCUENTRA PERO NO COINCIDEN LOS PUERTOS
                SE ENTRARA EN UN BUCLE INFINITO DE BUSQUEDA SIN RESPUESTA.
            </div>
            
        </center>
    </body>

</html>