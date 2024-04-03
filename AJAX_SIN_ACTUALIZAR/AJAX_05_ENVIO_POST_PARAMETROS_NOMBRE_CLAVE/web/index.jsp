<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>


<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <script type="text/javascript">
                       
            // POST GUARDA LA INFORMACIÓN EN EL BODY DE LA PETICIÓN HTTP, MIENTRAS QUE GET LOS ENVÍA EN LA CABECERA (SON VISIBLES).
            // AUNQUE PROPORCIONA MAYOR SEGURIDAD QUE GET Y EL TAMAÑO DE LOS DATOS A ENVIAR NO ESTÁ LIMITADO, SIGUE SIENDO UNA
            // TRANSMISIÓN INSEGURA (CON UN SNIFFER SE PUEDEN CAPTURAR, MODIFICAR Y VOLVER A LANZAR). SÓLO EL USO DE SEGURIDAD
            // HTTPS (BASADO EN SSL - SOCKET SECURE LAYER) PERMITE INTEGRIDAD (ningún otro modifica los datos envíados originalmente)
            // Y CONFIDENCIALIDAD (nadie más lo va a ver) ENTRE CLIENTE Y SERVIDOR (actualmente ya se ha encontrado la forma de
            // romper este mecanismo cómo ya se hizo con anterioridad con el MD5, pero se requiere de mucho tiempo para hackear el
            // sistema y descubrir la clave de encriptación).
            


            function f_crearNegociador(nombre, clave) {                
                if(window.XMLHttpRequest) {
                    negociador = new XMLHttpRequest();
                } else {
                    negociador = new ActiveXObject("Microsoft.XMLHTTP");
                }
                
                if (negociador != null) {
                    f_configurarNegociador();
                    f_conectarNavegadorServidor(nombre, clave);
                }            
            }


            
            function f_configurarNegociador() {
                // AHORA NO NOS HARÁ FALTA AÑADIR LA INFORMACIÓN A LA URL EN LA FORMA ?x=1&y=2 TAL Y CÓMO SE
                // HIZO EN EL EJERCICIO ANTERIOR. LOS DATOS VIAJARÁN EN EL INTERIOR DE UNA CABECERA HTTP QUE
                // DEBEREMOS AÑADIR (el método del negociador Ajax, setRequestHeader(xxx,yyy) se encargará de
                // crearla, sin ella, no se recibirá nada en el servidor).
                
                var url = "ServletAccesoZonaPrivada";
                alert("URL QUE SE LANZA:\n" + url)
                negociador.open("POST",url); // UTILIZAR EL MODO POST AL CONFIGURAR EL NEGOCIADOR AJAX (método open).
                
                
                // PARA USAR POST CON LOS PARÁMETROS, DEBEREMOS COPIAR Y PEGAR LA SIGUIENTE LÍNEA TAL Y CÓMO ESTÁ DEFINIDA:
                negociador.setRequestHeader("Content-Type","application/x-www-form-urlencoded");

                // FUNCIÓN DE RETORNO EN LÍNEA O ANÓNIMA:
                negociador.onreadystatechange = function() {
                    if (negociador.readyState==4 && negociador.status==200) {
                        var codigoSecreto = negociador.responseText;
                        // EL CONTENIDO DE responseText SE GENERARÁ EN EL SERVLET Y DEPENDERÁ DE SI SE HA
                        // INTRODUCIDO CORRECTAMENTE EL USUARIO Y SU CONTRASEÑA, O NO.
                        document.getElementById("verCodigoSecreto").innerHTML = codigoSecreto;
                    }                    
                };
            }
            
            
            
            function f_conectarNavegadorServidor(nombre,clave) {
                alert("---> ENVIANDO PETICIÓN POST CON LOS DATOS: " + nombre + ", " + clave);

                // SERÁ EN EL MÉTODO send() DEL NEGOCIADOR AJAX DÓNDE COLOCAREMOS LOS PARÁMETROS A ENVIAR, LOS
                // CUALES VIAJARÁN DENTRO DE LA CABECERA ANTERIORMENTE CREADA CON EL MÉTODO setRequestHeader:
                //   
                //      negociador.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
                // 
                
                // SE CONFIGURA LA QUERY-STRING IGUAL QUE CUANDO USAMOS MODO EL GET, PERO SIN COLOCAR EL '?' INICIAL:
                // OBSERVAR COMO AHORA YA NO UTILIZAMOS 'null' ..... nombre=juan&clave=12345
                
                negociador.send("nombre="+nombre+"&"+"clave="+clave);
                
                // SI SE NECESITA UNA CABECERA DE TIPO XML, USAR: negociador.setRequestHeader("Content-Type", "text/xml");
                // MANDANDO LOS DATOS COMO: negociador.send("<datos><nombre>juan</nombre><clave>12345</clave></datos>");
                // RECIBIÉNDOSE MÁS TARDE EN EL SERVLET EN FORMA DE DOCUMENTO XML PARA PODER SER TRATADO COMO TAL,
                // MEDIANTE ALGÚN API DE PROGRAMACIÓN ESPECIALIZADA PARA TAL FIN (ej SAX).
            }
            
            
            //////////////////////////////////////////////////////////////////////////////////////////////////
            
       
            // VERIFICAR LA INFORMACIÓN INTRODUCIDA EN EL FORMULARIO ANTES DE ENVIAR LOS DATOS AL SERVIDOR.
            function f_comprobarCampos() {
                var cajaNombre = document.getElementById("nombre").value.trim();
                var cajaClave = document.getElementById("clave").value.trim();

                if(cajaNombre == "" || cajaClave == "") {
                    alert("ERROR, DEBES INTRODUCIR NOMBRE Y CLAVE");
                    return;
                }
                
                // LANZAR EL PROCESO AJAX.
                f_crearNegociador(cajaNombre,cajaClave);
            }   
                        
            
            function f_mostrarClave() {
                alert("DETECTAR SI EL CHECKBOX ESTA ACTIVO PARA MOSTRAR LA CONTRASEÑA");
                
                var mostrar = document.getElementById("checkboxClave").checked;
                
                alert("¿MOSTRAR LA CONTRASEÑA EN PANTALLA? ..... " + (mostrar?'SI':'NO'));
                
                if(mostrar) {
                    alert("CAMBIAR EL TIPO DE LA CAJA DE PASSWORD A TEXT");
                    document.getElementById("clave").type="text";
                } else {
                    alert("CAMBIAR EL TIPO DE LA CAJA DE TEXT A PASSWORD");
                    document.getElementById("clave").type="password";
                }
            }
            
        </script>
        
        
        <!-- ESTABLECER UN ESTILO POR DEFECTO PARA TODAS LAS CELDAS DE LA TABLA -->
        <style type="text/css">            
            td{text-align:center; width:8cm; height:1.5cm}
        </style>
              
    </head>

    
    
    <body onload="document.getElementById('nombre').focus();">
        
        <center>
        
            <h3 style="color:blue">*** INTRODUCE NOMBRE Y CLAVE Y PULSA ENTRAR ***</h3>

            <p style="color:green;font-size:10px">
                DADO QUE NO HAY RECARGA DE LA PAGINA, EL FORMULARIO CONSERVARA EL VALOR DE SUS CAMPOS
                <br/>
                Y LA URL DEL NAVEGADOR NO REGISTRARA NINGUN CAMBIO.                
            </p>

            <br><br>
            
            
            <table border="1" style="background-color:silver;"> 
                
                <tr style="background-color:greenyellow">            
                    <td>
                        NOMBRE:
                        <input type="text" id="nombre" value="" size="20" maxlength="15" style="color:blue;"/>
                    </td>
                    
                    <td>
                        CLAVE:
                        <input type="password" id="clave" value="" size="20" maxlength="15" style="color:red;"/>
                    </td>                
                </tr>

                <tr>
                    <td colspan="2">
                        <input type="button"
                               value="ENTRAR"
                               style="text-align:center;font-weight:bold;color:blue;background-color:gold;border-style:outset;"
                               onclick="f_comprobarCampos();"/>
                    </td>
                </tr>
                
            </table>
            
            <br/>
            
            MOSTRAR EL CAMPO CLAVE:
            <input type="checkbox" id="checkboxClave" onclick="f_mostrarClave();"/>
            
            
            <div id="verCodigoSecreto" style="border-style:solid;margin:1cm 1cm 1cm 1cm;text-align:center;font-size:0.6cm;">
                !!! ONLY FOR YOUR EYES !!!
            </div>
                        
            <p style="color:orange; font-size:12px">
                Introduce juan 12345 para acceder
            </p>
            
        </center>
    
    </body>

</html>