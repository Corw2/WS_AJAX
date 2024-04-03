<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>


<html>

    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>JSP Page</title>

        <script type="text/javascript">
            
            // NEGOCIADOR GLOBAL, EL MISMO PARA TODAS LAS PETICIONES ... GENERARÁ PROBLEMAS SI
            // AÚN NO SE HA RECIBIDO LA RESPUESTA DE UNA PETICIÓN ANTERIOR Y SOLICITAMOS UNA NUEVA.
            
            // *** ES VARIABLE GLOBAL (comportamiento estático ... el mismo negociador para todos los clientes) ***
            // ÉSTA NO ES LA FORMA ADECUADA DE PROGRAMAR. CADA CLIENTE DEBERÍA TENER SU PROPIO NEGOCIADOR AJAX, AÚN
            // A PESAR DE QUE PUEDA HABER UN ELEVADO CONSUMO DE RECURSOS (1 POR CLIENTE EN LUGAR DE 1 PARA TODOS).
            // 
            // LA ÚLTIMA PETICIÓN CLIENTE QUE USE EL CANAL DE ENVÍO DEL NEGOCIADOR GLOBAL "MACHARÁ" LOS DATOS DEL
            // ANTERIOR CLIENTE QUE NO HAYA COMPLETADO SU PETICIÓN (SE USA EL RETARDO PARA SIMULARLO). ASÍ, SI
            // PULSAMOS RÁPIDAMENTE EL BOTÓN DE ENVÍO GLOBAL, VEREMOS CÓMO POR EJEMPLO, PASAMOS DEL 1 AL 5,
            // PERDIÉNDOSE LAS RESPUESTAS DEL 2,3 Y 4 ... VERIFICAR EL COMPORTAMIENTO EN DISTINTOS NAVEGADORES.
            
            // RESPECTO AL SERVLET, POR CADA PETICIÓN CLIENTE SE CREARÁ UN HILO DE EJECUCIÓN PARA ATENDERLA. SÓLO SE
            // CREARÁ UNA INSTANCIA DEL SERVLET (salvo si se implementa la interfaz SingleThreadModel - deprecated),
            // QUE SERÁ USADA POR TODOS Y CADA UNO DE DICHOS HILOS CLIENTE.
            
            
            
            ///// 1. NEGOCIADOR AJAX GLOBAL /////
            
            // SE DECLARA LA VARIABLE COMO GLOBAL. UN SOLO CANAL DE RESPUESTA COMPARTIDO POR TODOS.
            
            var negociadorGlobal;

            
            function f_crearNegociadorGlobal() {
                
                if(window.XMLHttpRequest) {
                    negociadorGlobal = new XMLHttpRequest();
                } else {
                    negociadorGlobal = new ActiveXObject("Microsoft.XMLHTTP");
                }
                
                if(negociadorGlobal != null) {
                    negociadorGlobal.open("GET","ServletContadorNegociadorGlobal");
                    negociadorGlobal.onreadystatechange = function() {
                        if (negociadorGlobal.readyState==4 && negociadorGlobal.status==200) {
                            var respuesta = negociadorGlobal.responseText;
                            // CONCATENAR EL CONTENIDO ACTUAL CON EL NUEVO CORRESPONDIENTE A LA RESPUESTA.
                            document.getElementById("cajaNegociadorGlobal").innerHTML += respuesta;
                        }
                    };
                    
                    negociadorGlobal.send(null);                                
                }
            
            }





            ///// 2. NEGOCIADOR AJAX LOCAL /////

            // NEGOCIADOR LOCAL ... UN OBJETO XmlHttpRequest POR CADA PETICIÓN.
            // SE CONSIGUE SIMPLEMENTE UTILIZANDO LA VARIABLE NEGOCIADOR DE FORMA
            // LOCAL, DECLARÁNDOLA DENTRO DE LA FUNCIÓN.

            function f_crearNegociadorLocal() {

                // *** ES VARIABLE LOCAL (cada petición cliente tiene su propio negociador) ***                

                // CADA CLIENTE TIENE SU PROPIO CANAL DE RESPUESTA.

                var negociadorLocal; 

                if(window.XMLHttpRequest) {
                    negociadorLocal = new XMLHttpRequest();
                } else {
                    negociadorLocal = new ActiveXObject("Microsoft.XMLHTTP");
                }
                
                if(negociadorLocal != null) {
                    negociadorLocal.open("GET","ServletContadorNegociadorLocal");
                    negociadorLocal.onreadystatechange = function() {
                        if (negociadorLocal.readyState==4 && negociadorLocal.status==200) {
                            var respuesta = negociadorLocal.responseText;
                            // CONCATENAR EL CONTENIDO ACTUAL CON EL NUEVO CORRESPONDIENTE A LA RESPUESTA.
                            document.getElementById("cajaNegociadorLocal").innerHTML += respuesta;
                        }
                    }                                
                    negociadorLocal.send(null);
                }
            }
            
        </script>
        
    </head>

    
    
    <body>

        <div align="center">

            <h1> NEGOCIADORES AJAX: GLOBAL - INDIVIDUAL </h1>

            <h3> PULSA LOS BOTONES LENTA Y RAPIDAMENTE OBSERVANDO EN CADA CASO EL RESULTADO </h3>
            
            <br/><br/>

            <input type="button" value="NEGOCIADOR GLOBAL" onclick="f_crearNegociadorGlobal();"/>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="button" value="NEGOCIADOR INDIVIDUAL" onclick="f_crearNegociadorLocal();"/>

            <br/><br/>
            
            <div id="cajaNegociadorGlobal" style="border-style:solid;border-color:red;border-width:0.2cm"></div>
            
            <br/><br/>
            
            <div id="cajaNegociadorLocal" style="border-style:solid;border-color:greenyellow;border-width:0.2cm"></div>
            
            <br/><br/><br/>
            
            <p> REALIZAR UN DEPLOY DE LA APLICACION (elimina los Servlets) PARA VOLVERLO A PROBAR </p>

            
            
        </div>

    </body>

</html>