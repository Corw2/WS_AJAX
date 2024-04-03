<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>


<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <script type="text/javascript">
            
            var negociador;                                                 // EL NEGOCIADOR.
            
            function f_crearNegociador() {                
                if(window.XMLHttpRequest) {
                    negociador = new XMLHttpRequest();                      // MOZILLA.
                } else {
                    negociador = new ActiveXObject("Microsoft.XMLHTTP");    // EXPLORER.
                }
                
                if (negociador != null) {
                    return true;
                } else {
                    return false;
                }            

            }
            
            
            function f_configurarNegociador(imagen) {                
                // Generaremos las URL's:  "advertencia.txt"  -   "firefox.txt"    -   "disco.txt".

                // Url del fichero .txt que corresponde a la imagen sobre la que está el ratón
                // en estos momentos.
                urlImagen = imagen + ".txt"; 

                // Por defecto la petición es de tipo asíncrono, por lo que no es necesario indicarlo.

                negociador.open("GET",urlImagen);
                                
                negociador.onreadystatechange = function() {    // Función de retorno anónima.
                    if (negociador.readyState==4 && negociador.status==200) {
                        // Rellenar la caja de texto con el mensaje leído del servidor (propiedad responseText del negociador).
                        document.getElementById("cajaTexto").innerHTML = negociador.responseText;
                    }                    
                };
            }
            
            
            function f_conectarNavegadorServidor() {
                negociador.send(null);
            }
            
                        
            function f_preguntar(imagen) {
                //document.getElementById("cajaTexto").innerHTML = imagen;
                if(f_crearNegociador()) {
                    // Usamos el nombre de la imAgen actual para seleccionar el fichero de texto en el servidor.
                    f_configurarNegociador(imagen);                    
                    // Lanzar la petición contra el servidor.
                    f_conectarNavegadorServidor();
                }
            }
            

            function f_salir() {
                document.getElementById("cajaTexto").innerHTML = "!!! Situa el raton sobre otra imagen !!!";                
            }
        
        </script>

    </head>



    <body>

        <center>

            <h3 style="color:blue"> *** ¿QUE IMAGEN ES? ... PASA EL RATON SOBRE UNA DE ELLAS *** </h3>

            <br><br>

            <table border="0" width="500" height="50">
                
                <tr>
                
                    <td align="center">
                        
                        <!-- ASIGNACIÓN DE EVENTOS AL CONTROL GRÁFICO. CADA IMAGEN ENVIARÁ COMO PARÁMETRO SU TEXTO IDENTIFICATIVO -->                        
                        <img src="advertencia.png" style="width:70px;"
                             onmouseover="f_preguntar('advertencia');"
                             onmouseout="f_salir();"/>
                    </td>

                    <td align="center">
                        <img src="firefox.png" style="width:70px;"
                             onmouseover="f_preguntar('firefox');"
                             onmouseout="f_salir();"/>
                    </td>

                    <td align="center">
                        <img src="disco.png" style="width:70px;"
                             onmouseover="f_preguntar('disco');"
                             onmouseout="f_salir();"/>
                    </td>

                </tr>
                
            </table>

            <br/><br/>

            <div id="cajaTexto" style="font-size:0.7cm;text-align:center;border-style:double;margin:2cm 2cm 2cm 2cm">
                --- esperando ---
            </div>

        </center>

    </body>

</html>