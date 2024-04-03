<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>


<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <script type="text/javascript">

            // VARIABLE GLOBAL QUE ALMACENARÁ EL NEGOCIADOR AJAX.
            var negociador;
            
            
            // 1. OBTENER EL NEGOCIADOR AJAX.            
            function f_crearNegociador() {
                // CREAR EL OBJETO XMLHttpRequest (EL OBJETO AJAX QUE ACTÚA DE NEGOCIADOR ENTRE EL NAVEGADOR CLIENTE Y
                // EL SERVIDOR WEB. MOZILLA Y MICROSOFT EXPLORER CREAN EL NEGOCIADOR DE FORMA DISTINTA, PERO UNA VEZ
                // CONSTITUÍDO, EL FUNCIONAMIENTO (MÉTODOS A LLAMAR Y PROPIEDADES DEL OBJETO) DEBERÍAN SER IGUALES.
                // *** IMPORTANTE ... PARA MICROSOFT EXPLORER V7 VALEN LAS DOS FORMAS, PERO MOZILLA NO ADMITE LOS ActiveXObject.

                // DETECTAR EL TIPO DE NAVEGADOR. DEBEMOS PREGUNTAR POR UNA PROPIEDAD AL OBJETO window. SI window LA
                // TIENE, LA SENTENCIA 'if' INTERPRETARÁ 'true' LO QUE NOS PERMITE DEDUCIR QUÉ TIPO DE NAVEGADOR ES.
                // 
                // --- PROCESO MECÁNICO ---

                // DETECTAR SI EL OBJETO window DISPONE DE LA PROPIEDAD XMLHttpRequest (de ser así se trarará de MOZILLA):
                if(window.XMLHttpRequest) {
                    alert("ESTAS USANDO MOZILLA O COMPATIBLE");                    
                    // GENERAR EL NEGOCIADOR PARA MOZILLA (objeto de JavaScript):
                    negociador = new XMLHttpRequest();
                } else {
                    alert("ESTAS USANDO MICROSOFT EXPLORER");
                    // GENERAR EL NEGOCIADOR PARA EXPLORER:
                    negociador = new ActiveXObject("Microsoft.XMLHTTP");
                }
                
                // COMPROBAR QUE DE UNA U OTRA MANERA, EL NEGOCIADOR SE HA CREADO.
                if (negociador != null) {
                    alert("SE HA CREADO EL OBJETO NEGOCIADOR DE AJAX");
                    return true;
                } else {
                    alert("ERROR. NO SE HA PODIDO CREAR EL NEGOCIADOR DE AJAX");
                    return false;
                }
            }
            

            // 2. CONFIGURAR EL NEGOCIADOR (prepararlo para más tarde poder ser lanzado o envíado contra el servidor).
            function f_configurarNegociador() {

                // AJUSTAR LA FORMA DE ENVIAR LA PETICIÓN AL SERVIDOR WEB (GET/POST) Y SU URL.
                // ESTAMOS USANDO URL RELATIVA (EL FICHERO mensaje.txt ESTÁ EN EL MISMO LUGAR QUE index.jsp).
                // ESTABLECER ... [MODO GET/POST - URL DEL RECURSO - ENVÍO ASÍNCRONO/SÍNCRONO].         
                // 
                // 2A:
                negociador.open("GET","mensaje.txt",true); // Por defecto la petición es asíncrona, luego 'true' es opcional.
                // NOTA: podemos usar método GET y añadir parámetros en la url en la forma "url?param1=valor1&param2=valor2",
                //          aunque lo más adecuado es utilizar POST (requiere de una cabecera especial) cuando se desee enviar
                //          información al servidor desde el cliente.


                // AJUSTAR LA FUNCIÓN DE RETORNO, AQUELLA QUE SERÁ LLAMADA CADA VEZ QUE CAMBIE EL ESTADO DEL NEGOCIADOR,
                // (EL VALOR DE SU PROPIEDAD readystatechange). UTILIZAREMOS UNA FUNCIÓN ANÓNIMA(sin nombre, usar y tirar),
                // TAMBIÉN LLAMADA "EN LÍNEA".
                // 
                // 2B:
                negociador.onreadystatechange = function() {
                    if (negociador.readyState==4 && negociador.status==200) {
                        // readyState   == 4 DENOTA QUE LA RECEPCIÓN DE DATOS DEL SERVIDOR HA CONCLUÍDO ("el paquete ha llegado a casa ... ").
                        // status       == 200 CABECERA DE ESTADO HTTP QUE CONFIRMA QUE LOS DATOS HAN LLEGADO CORRECTAMENTE ("... y no hay nada roto").
                        
                        // HAN DE CONFIRMARSE LAS DOS CONDICIONES. DE SER ASÍ, LEER LA PROPIEDAD responseText DEL NEGOCIADOR
                        // PARA OBTENER EL CONTENIDO DEL FICHERO DE TEXTO LEÍDO DEL SERVIDOR WEB (procesamos los datos de respuesta).
                        // CON DICHOS DATOS ACTUALIZAR LA PÁGINA USANDO DHTML: FUNCIÓN document.getElementById("xxx"), ACTUANDO SOBRE LA PROPIEDAD
                        // 'innerHTML' DEL CONTROL GRÁFICO (creará los nodos necesarios en el DOM).
                        // 
                        // 2C:
                        // VERTER LOS DATOS RECUPERADOS POR AJAX EN LA CAJA QUE LOS VISUALIZARÁ EN PANTALLA.
                        document.getElementById("cajaTexto").innerHTML = negociador.responseText;
                        document.getElementById("cajaTexto").style.backgroundColor = "cyan";
                        alert("CARGA DE DATOS COMPLETA ... SIN FLICKER-REFRESCO DE PÁGINA!!!");
                    }                    
                };
            }
            
            // 3. CONECTAR EL NEGOCIADOR CON EL SERVIDOR (ACTIVARLO/LANZARLO).
            function f_conectarNavegadorServidor() {
                // ESTE MÉTODO ES EL QUE REALMENTE LANZA LA PETICIÓN ASÍNCRONA CONTRA EL SERVIDOR.
                negociador.send(null);  // Indicamos null porque en este ejemplo no le vamos a enviar nada al servidor
                                        // de aplicaciones según el modo POST.
            }


            /////////////////////////////////////////////////////////////////////////////////////////////////


            // FINALMENTE, LA FUNCIÓN QUE ENGLOBA LOS DISTINTOS PASOS PARA HACER USO DE AJAX
            // (comentar todos los alert tras comprobar funcionamiento para verificar la fluidez de la página):
            function f_rellenar() {
                
                // REFERENCIA A LA CAPA QUE ACTUALIZAREMOS CON LA INFORMACIÓN OBTENIDA DEL SERVIDOR POR AJAX.
                
                // Borrar su posible contenido anterior.
                document.getElementById("cajaTexto").innerHTML = "";
                
                if(f_crearNegociador()) {               // 1. CREAR EL NEGOCIADOR AJAX.
                    f_configurarNegociador();           // 2. CONFIGURAR SU MODO (GET/POST),URL Y FUNCIÓN DE RETORNO.
                    f_conectarNavegadorServidor();      // 3. LANZAR LA PETICIÓN HTTP ASÍNCRONA AL SERVIDOR (PEDIR UN RECURSO).
                }

            }
            
        </script>
        
    </head>

    
    
    <body>
        <center>
            
            <h3 style="color:blue">*** OBTENER DATOS DEL SERVIDOR WEB SIN RECARGAR LA PAGINA *** </h3>
            <br> OBSERVAR COMO LA BARRA DE NAVEGACION NO CAMBIA (peticion asincrona) </br>
            
            <br><br>
            
            <div id="cajaTexto" style="font-size:0.7cm;text-align:center;border-style:double;margin:2cm 2cm 2cm 2cm">
                pulsa el boton.
            </div>
            
            <br/><br/>
            
            <!-- AL PULSARSE ESTE BOTÓN SE DESENCADENARÁ TODO EL PROCESO AJAX -->
            <input type="button" value="RELLENAR" onclick="f_rellenar();"/>

        </center>
    </body>

</html>