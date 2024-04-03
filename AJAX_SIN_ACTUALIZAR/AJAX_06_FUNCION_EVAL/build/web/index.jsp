<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>


<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <script type="text/javascript">

            function f_evaluar() {
                // RECORDAR: podemos usar los elementos definidos en el BODY una vez se
                // haya cargado éste. Si declaramos la siguiente línea fuera de la presente
                // función, la variable "caja" valdrá null, ya que estamos procesando el HEAD,
                // cuando aún no se ha cargado el BODY.
                
                // SECUENCIA DE CARGA: 1.HEAD -> 2.BODY -> 3.Evento onload().

                var suma = "5+7"; // Una simple cadena de texto.
                var resultado = eval(suma); // Mediante eval (evualuar) se podrá procesar el texto como si fuesen números.
                var texto = "El resultado de " + suma + " = " + resultado; 
                alert(texto);
                document.getElementById("caja").innerHTML = texto; // Depositar el resultado en la caja de mensajes.
            }


            ///////////////////////////////////////////////////////////////////////////////////////////////////


            function f_crearObjetoJavaScriptSuma() {
                // CREAMOS UNA VARIABLE TIPO TEXTO CON EL NOMBRE DEL MÉTODO Y SUS PARÁMETROS:
                // ESTE TEXTO PODRÍA HABER SIDO DEVUELTO DESDE EL SERVIDOR WEB A TRAVÉS DE LA PROPIEDAD
                // responseText DEL NEGOCIADOR AJAX, TAL Y CÓMO SE HACE EN EL EJEMPLO DE LA FUNCIÓN ALEATORIA
                // DE MÁS ABAJO (así, podemos crear objetos JavaScript desde el servidor web, en forma de texto,
                // para más tarde "activarlos" con la función eval).

                // Básicamente creamos un mapa propiedad - valor.
                // {propiedad_1:valor_1, propiedad_2:valor_2, ... , propiedad_n:valor_n}
                var textoObjeto = "{metodo:'f_sumar', x:3, y:8};"; // NO OLVIDAR LAS LLAVES QUE ENCIERRAN EL CONTENIDO.
                // 
                // Así, los nombres de las propiedades serán siempre texto y los valores texto o números:
                // metodo:'f_sumar'
                // x:3
                // y:8
                
                // NOTA: la función f_sumar debe ser definida externamente (se ha creado más abajo).
                
                alert(textoObjeto);
                
                // EVALUAMOS EL TEXTO ANTERIOR PARA CREAR UN OBJETO QUE ASIGNAREMOS A UNA VARIABLE.
                
                var objetoSumador; // CREAMOS LA VARIABLE ASIGNÁNDOLE UN NOMBRE ... objetoSumador.
                
                eval('objetoSumador = ' + textoObjeto); // eval PROCESARÁ EL TEXTO Y CARGARÁ LA VARIABLE CON EL OBJETO.
                // equivale a:
                // objetoSumador = {metodo:'f_sumar', x:3, y:8};

                alert(objetoSumador);
                
                // GENERAMOS LA LLAMADA A LA FUNCIÓN f_sumar(definida más abajo) A PARTIR DEL OBJETO CREADO:
                // Para poder obtener el valor de una determinada propiedad del objeto basta con utilizar la
                // notación del punto. Así, variable.propiedad nos devolverá el valor de la propiedad.
                
                // CREAMOS EL TEXTO DEL CÓDIGO QUE DESEAMOS SE EJECUTE:
                var ejecutar =  objetoSumador.metodo +
                                "(" +
                                objetoSumador.x +
                                "," +
                                objetoSumador.y +
                                ")" +
                                ";"
                                ;

                alert(ejecutar); // se obtiene ...     f_sumar(3,8);
                
                var resultadoSuma = eval(ejecutar); // evaluamos la cadena de texto que llamará a la función sumar.
                // equivale a:
                // var resultadoSuma = f_sumar(3,8);
                                
                alert(resultadoSuma);
                
            }


            // LA FUNCIÓN QUE SERÁ EMPLEADO POR EL OBJETO LA DEFINIMOS AQUÍ:
            function f_sumar(x,y) {
                var resultado = x + y;
                document.getElementById("caja").innerHTML = x + " + " + y + " = " + resultado;
                return resultado;
            }

            // VEMOS CÓMO DESDE EL SERVIDOR SE LE PODRÍA PEDIR AL CLIENTE QUE CREASE OBJETOS Y EJECUTASE
            // FUNCIONES JAVASCRIPT DEFINIDAS POR EL MISMO, SIMPLEMENTE ENVIÁNDOLE UNA CADENA TEXTO (la 
            // función elegida de forma aleatoria del siguiente ejemplo lo pone de manifiesto).


            ///////////////////////////////////////////////////////////////////////////////////////////////////


            function f_solicitarFuncionAleatoria() {
                
                var negociador;
                
                if(window.XMLHttpRequest) {
                    negociador = new XMLHttpRequest();
                } else {
                    negociador = new ActiveXObject("Microsoft.XMLHTTP");
                }
                
                if(negociador != null) {
                    negociador.open("GET","ServletFuncionAleatoria");
                    negociador.onreadystatechange = function() {
                        if (negociador.readyState==4 && negociador.status==200) {
                            var respuesta = negociador.responseText;
                            alert("EL SERVIDOR QUIERE QUE SE EJECUTE ... " + respuesta)
                            eval(respuesta);    // Mediante eval podemos llamar a la función indicada por el
                                                // texto de vuelta, la cual debe estar definida en el cliente.
                        }                            
                    };

                    // Lanzar la petición Ajax en modo GET.
                    negociador.send(null);
                }
            }


            // FUNCIONES JAVASCRIPT DECLARADAS EN EL CLIENTE.
            function f_aleatoriaImprimirDiaSemana() {
                var arrayDiasSemana = new Array("DOMINGO","LUNES","MARTES","MIERCOLES","JUEVES","VIERNES","SABADO");
                var numeroDia = new Date().getDay(); // 0 .. 6, siendo 0 el DOMINGO;
                var texto = "HOY ES ... " + arrayDiasSemana[numeroDia];
                alert(texto); 
                document.getElementById("caja").innerHTML = texto;
            }

            function f_aleatoriaImprimirAño() {
                var año = new Date().getFullYear();
                var texto = "EL AÑO ES ... " + año;
                alert(texto);
                document.getElementById("caja").innerHTML = texto;
            }


            // !!! IMPORTANTE !!!:
            // NO ES ACONSEJABLE QUE SEA EL SERVIDOR WEB EL QUE DECIDA EL CÓDIGO JAVASCRIPT
            // QUE SE VA A EJECUTAR EN EL CLIENTE. EL SERVIDOR DEBERÍA LIMITARSE A SIMPLEMENTE
            // ENVIAR DATOS, YA SEAN EN MODO TEXTO O XML, SIENDO EL PROPIO CLIENTE (NAVEGADOR) EL
            // QUE DECIDA QUÉ HACER CON ELLOS. (GOOGLE, CUANDO PRESENTA UN CONJUNTO DE PALABRAS A
            // MODO DE SUGERENCIA PARA LA BÚSQUEDA A REALIZAR, UTILIZA ESTE MÉTODO).

        </script>
    </head>

    
    
    <body>
        <center>
            
            <h2> UTILIZACION DE LA FUNCION eval DE JAVASCRIPT </h2>
            
            <br/><br/>
            
            <input type="button" value="SUMA DE CARACTERES CON eval('5+7')" onclick="f_evaluar();"/>
            <br/><br/>
            <input type="button" value="CREAR OBJETO JAVASCRIPT PARA SUMAR 3+8" onclick="f_crearObjetoJavaScriptSuma();"/>
            <br/><br/>
            <input type="button" value="EJECUTAR FUNCION ALEATORIA (DIA/AÑO) DESDE SERVIDOR WEB" onclick="f_solicitarFuncionAleatoria();"/>
            
            <br/><br/><br/><br/>

            <div id="caja" style="border-style:solid;border-width:thin;color:green;font-size:0.8cm;width:9cm;height:1.5cm">
                --- resultados ---
            </div>
            
        </center>
    </body>

</html>