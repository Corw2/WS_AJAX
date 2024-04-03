<%@page contentType="text/html" pageEncoding="UTF-8" import="java.util.Date"%>


<!DOCTYPE html>


<html>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MASTER JAVA</title>

        <script type="text/javascript">
            
            // Crear la variable.
            var miObjeto;
            
            // Asignarle a la anterior variable el objeto creado (se contruye mediante {propiedad1:valor1,p2:v2, ...}).
            eval("miObjeto = {color:'rojo', cantidad:6};");

            alert("OBJETO = " + miObjeto);
            alert("color = " + miObjeto.color);
            alert("cantidad = " + miObjeto.cantidad);
         
        </script>

    </head>

    
    <body>
    
        <center>
    
            <br/><br/>
            
            <h1> CREACION DE UN OBJETO EN JAVASCRIPT MEDIANTE LA FUNCION eval() </h1>
            
            <br/><br/>
            
            COLOR = <script>document.write(miObjeto.color);</script>
            <br/><br/>
            CANTIDAD = <script>document.write(miObjeto.cantidad);</script>
        
        </center>
    
    </body>

</html>