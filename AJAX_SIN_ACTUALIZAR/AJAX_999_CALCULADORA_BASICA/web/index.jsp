<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>


<html>
    
    <head>        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MASTER JAVA</title>
        
        <script type="text/javascript">
            
            function f_ajaxSumar() {
               
                //alert("SUMAR");
                
                var correcto = f_comprobarNumeros();
                //alert("CORRECTO = " + correcto);              
                
                if(!correcto) {
                    return;
                }
                
                f_ajaxSumarRestar("ServletSumador"); // El parámetro indicará el servlet a ser llamado.

            }


            function f_ajaxRestar() {

                //alert("RESTAR");
                
                var correcto = f_comprobarNumeros();
                //alert("CORRECTO = " + correcto);
                
                if(!correcto) {
                    return;
                }

                f_ajaxSumarRestar("ServletRestador");                                
            }
            
                        
            function f_comprobarNumeros() {
                
                // ELIMINAR ESPACIOS EN BLANCO DE LOS EXTREMOS.
                var x = document.getElementById("x").value.trim();
                var y = document.getElementById("y").value.trim();
                
                //alert("LONGITUD DE X = " + x.length);
                //alert("LONGITUD DE Y = " + y.length);
                
                if(""==x || ""==y) {
                    document.getElementById("capaResultado").innerHTML = "ERROR. DEBES RELLENAR LOS CAMPOS";
                    return false;
                }
                
                if(isNaN(x) || isNaN(y)) {
                    document.getElementById("capaResultado").innerHTML = "ERROR. DEBES INTRODUCIR VALORES CORRECTOS";
                    return false;
                }
                
                // SI LA VALIDACIÓN FUE COMPLETAMENTE CORRECTA PROCEDER A PREPARAR EL NEGOCIADOR AJAX.
                return true;
                
            }
            
            
            function f_ajaxSumarRestar(operacion) {

                // UNA VEZ VALIDADOS LOS DATOS, CONSTITUIR EL NEGOCIADOR AJAX.
                var negociador = new XMLHttpRequest();
                
                var x = document.getElementById("x").value;
                var y = document.getElementById("y").value;
                
                // DEFINIR LA URL EN BASE AL SERVLET A SER LLAMADO Y LOS PARÁMETROS X Y.
                var url = operacion+"?x="+x+"&y="+y;
                
                //alert("URL = " + url);
                
                // CONFIGURAR EL NEGOCIADOR A LA IDA.
                negociador.open("GET",url);

                // CONFIGURAR EL NEGOCIADOR PARA CUANDO VUELVA ... ¿QUÉ TIENE QUE HACER?.
                negociador.onreadystatechange = function() {
                    if(negociador.readyState==4 && negociador.status==200) {
                        //alert("MENSAJE = " + negociador.responseText);
                        document.getElementById("capaResultado").innerHTML = negociador.responseText;
                    }
                };
                
                // ENVIAR EL NEGOCIADOR EN MODO GET.
		// NOTA: SI SE UTILIZASE "POST", INVOCARÍAMOS A .send(operacion=ServletSumador&x=6&y=4);
                // LO QUE REQUIERE UNA CABECERA ADICIONAL PARA EL TRANSPORTE DE LOS DATOS.
                negociador.send(null);                 
		
            }
            
        </script>
        
    </head>
    
    
    
    <body onload="document.getElementById('x').focus();">
        
        <center>
            
            <br/>

            <h2> CALCULADORA AJAX </h2>

            <br/><br/>           
            
            <!-- NO NECESITAMOS HACER USO DE name PORQUE LOS DATOS VIAJAN EN LA URL EMPLEADO POR AJAX -->
            
            X: <input type="text" id="x" value="" size="6" maxlength="5"/>
            <br/><br/>
            Y: <input type="text" id="y" value="" size="6" maxlength="5"/>
            
            <br/><br/><br/>
            
            <input type="button" value="RESTAR" onclick="f_ajaxRestar()"/>
            &nbsp;&nbsp;&nbsp;
            <input type="button" value="SUMAR" onclick="f_ajaxSumar()"/>
        
            <br/><br/><br/>
            
            <!-- CAPA PARA MOSTRAR LOS MENSAJES CON EL RESULTADO -->
            <div id="capaResultado" style="color:blue;font-size:22px"/>            
        
        </center>
    
    </body>

</html>