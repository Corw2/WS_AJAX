<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>


<html>
    
    <head>        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MASTER JAVA</title>
        
        <script type="text/javascript">
         
            function f_ajax(queSolicitar) {
                
                var negociador = new XMLHttpRequest();
                
                negociador.open("GET",queSolicitar);
                
                negociador.onreadystatechange = function() {
                    document.getElementById("capaResultado").innerHTML = negociador.responseText;
                };
                
                negociador.send(null);
                
            }
            
        </script>        

    </head>
    
    
    
    <body>
        
        <center>
            
            <br/>
            <hr/>
            
            <p style="color:blueviolet; font-size:42px"> CARGA ASINCRONA AJAX </p>
            
            <hr/><br/>
            
            <input type="button" value="DESPEDIR" onclick="f_ajax('despedir.txt')"/>
            &nbsp;&nbsp;&nbsp;
            <input type="button" value="SALUDAR" onclick="f_ajax('saludar.txt')"/>
        
            <br/><br/><br/>
            
            <div id="capaResultado" style="color:blue;font-size:22px"/>            
        
        </center>
    
    </body>

</html>