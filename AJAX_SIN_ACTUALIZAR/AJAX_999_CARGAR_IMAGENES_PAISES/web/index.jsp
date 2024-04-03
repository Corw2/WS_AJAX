<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>


<html>

    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <script type="text/javascript">
            
            var negociador; // NEGOCIADOR AJAX DECLARADO GLOBAL.
            
            
            function f_crearNegociador() {
                
                if(window.XMLHttpRequest) {
                    negociador = new XMLHttpRequest();
                } else {
                    negociador = new ActiveXObject("Microsoft.XMLHTTP");
                }
                
                if (negociador != null) {
                    return true;
                } else {
                    return false;
                }
            
            }
            
            
            function f_configurarNegociador(pais) {

                pais += ".txt";
                
                // LA URL QUE SOLICITAREMOS NO ES MÁS QUE UN FICHERO DE TEXTO QUE INDICARÁ LA IMAGEN A CARGAR DESDE
                // EL SERVIDOR (el navegador cliente lanzará un petición oculta para obtenerla ... datos binarios).
                
                // EL SERVIDOR ENTREGARÁ UNA DE LAS SIGUIENTES LÍNEAS QUE SE ESCRIBIRÁN EN LA CAPA "cajaImagen":
                //      <img src="imagenes/EstatuaLibertad.jpg"/>
                //      <img src="imagenes/CatedralSantiago.jpg"/>
                
                negociador.open("GET",pais);
                
                negociador.onreadystatechange = function() {
                
                    if (negociador.readyState==4 && negociador.status==200) {
                        //alert("NEGOCIADOR = " + negociador.responseText);
                        
                        // COLOCAR LA IMAGEN DENTRO DE LA CAPA.
                        document.getElementById("cajaImagen").innerHTML = negociador.responseText;
                    }
                    
                };
            
            }
            
            
            function f_conectarNavegadorServidor() {
                // NO ENVIAMOS NADA AL SERVIDOR (MODO GET).
                negociador.send(null);
            }
            
                        
            function f_cargarImagen(pais) {
                
                // El parámetro pais determinará el nombre del fichero a solicitarse al servidor y por tanto, la
                // imagen a ser mostrada.
                
                // MOSTRAR EL NOMBRE DEL PAÍS EN MAYÚSCULAS A PARTIR DEL TEXTO DEL PARÁMETRO DE ENTRADA.
                document.getElementById("descripcion").innerHTML = pais.toUpperCase();
                
                if(f_crearNegociador()) {
                    f_configurarNegociador(pais);
                    f_conectarNavegadorServidor();
                }

            }
        
        </script>

        
        <!-- ESTILOS CSS -->
        
        <style type="text/css">
            /* DEFINICIÓN DE UN ESTILO COMÚN PARA TODAS LAS CELDAS */
            td {
                width:200px;
                height:30px;
                text-align:center;
                color:red;
            }
        </style>
        
    </head>

    

    <body style="background-color:black">

        <center>
            
            <h3 style="color:blue"> - ELEMENTOS REPRESENTATIVOS DE UN PAIS - </h3>
            
            <table border="5">
                <tr>
                    <td colspan="2" style="height:260px">
                        <div id="cajaImagen">
                            - - - PULSA UN BOTON - - -  
                        </div>
                    </td>
                </tr>

                <tr>
                    <td colspan="2">
                        <p id="descripcion"></p>
                    </td>
                </tr>
                
                <tr>                
                    <td>
                        <input type="button" value="ESTADOS UNIDOS" onclick="f_cargarImagen('estados_unidos');"/>
                    </td>

                    <td>
                        <input type="button" value="ESPAÑA" onclick="f_cargarImagen('españa');"/>
                    </td>
                </tr>                

            </table>
            
        </center>

    </body>

</html>