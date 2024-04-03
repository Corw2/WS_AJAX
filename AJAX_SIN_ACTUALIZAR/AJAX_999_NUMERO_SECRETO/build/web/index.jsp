<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>


<html>
    
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MASTER JAVA</title>
        
        <script type="text/javascript">
            
            function f_ajaxComprobar() {
                var negociador              = new XMLHttpRequest(); // Lo creamos directamente, sin comprobación previa.
                var servletInvocado         = "ServletComprobar";
                var numero                  = document.getElementById("cajaNumero").value;
                var urlRecursoSolicitado    = servletInvocado + "?"+ "numero" + "=" + numero; // GET
                
                //alert("RECURSO PEDIDO ... " + urlRecursoSolicitado);
                
                // CONFIGURAR EL NEGOCIADOR A LA IDA.
                negociador.open("GET",urlRecursoSolicitado);

                // CONFIGURAR EL NEGOCIADOR PARA CUANDO VUELVA ... ¿QUÉ TIENE QUE HACER?.
                negociador.onreadystatechange = function() {
                    if(negociador.readyState==4 && negociador.status==200) {
                        //alert("MENSAJE = " + negociador.responseText);
                        document.getElementById("capaResultado").innerHTML = negociador.responseText;
                    }
                };
                
                // ENVIAR EL NEGOCIADOR.
                negociador.send(null); // POST ...     .send(numero=6);
            }
            
        </script>
        
    </head>
    
    
    
    <body onload="document.getElementById('cajaNumero').focus();">
        
        <center>
            
            <br/>

            <hr/>
            
            <h2> INTRODUCE UN NUMERO ENTRE EL 1 Y 9 </h2>
            
            <hr/>
            
            <br/>
            
            <input type="text" id="cajaNumero" value="" size="1" maxlength="1"/>
            
            <br/><br/>
            
            <input type="button" value="COMPROBAR" onclick="f_ajaxComprobar()"/>
        
            <br/><br/><br/>
            
            <div id="capaResultado" style="color:blue;font-size:18px"/>
                    
        </center>
    
    </body>

</html>