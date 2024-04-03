<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>


<html>

    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title> 

        <!-- PARA "PEGAR" UN DOCUMENTO JAVASCRIPT EXTERNO: NO CERRAR CON /> NI INTRODUCIR CÓDIGO EN SU ETIQUETA <script> -->
        <script type="text/javascript" src="negociador.js"></script>
        
        <script type="text/javascript">  
            
            function f_verXML(enTexto) {
                // EN FUNCIÓN DEL VALOR DE LA VARIABLE DE ENTRADA enTexto DEVOLVEREMOS EL RESULTADO DEL 
                // SERVIDOR EN FORMATO TEXTO PLANO (true) O EN FORMATO XML (false).
                
                // HACEMOS USO DE LA FUNCIÓN [f_negociador(url,f_retorno,enTexto)] DEL FICHERO EXTERNO negociador.js.
                // PARA CONFIGURAR EL NEGOCIADOR.
                f_negociador("ServletLetras", funcionRetorno, enTexto);
            }
            
            
            // LA FUNCIÓN QUE HEMOS INDICADO AL NEGOCIADOR QUE USE.
            function funcionRetorno(datosXML,enTexto) {
                
                alert("SE HAN RECIBIDO LOS DATOS. PULSA ACEPTAR PARA VERLOS");
                
                if(enTexto) { // enTexto == true.
                    //
                    // SE RECIBE UN DOCUMENTO DE TEXTO SIMPLE QUE SIMBOLIZA A LAS ETIQUETAS XML EL CUAL,
                    // NO PERMITIRÁ UTILIZAR PROCESAMIENTO DEL DOM.
                    alert(datosXML);
                    // SI INTENTAMOS IMPRIMIR EN PANTALLA EL CONTENIDO DEL DOCUMENTO MOSTRARÁ "AZ", EL VALOR DE LOS NODOS.
                    // document.write("........ " + datosXML.toString());
                
                } else { // enTexto == false.

                    // SE RECIBE UN DOCUMENTO XML
                    
                    /*
                            <?xml version='1.0'?>
                            <datos>
                                <letras>
                                    <vocal>A</vocal>
                                    <consonante>Z</consonante>
                                </letras>
                            </datos>
                    */ 
                   
                   
                    // RECORRER EL DOM MEDIANTE EL USO DE PROPIEDADES.

                    // OBTENER UNA REFERENCIA AL NODO RAÍZ DEL DOCUMENTO XML:
                    
                    var nodoRaiz = datosXML.documentElement; // <datos> ... EL NODO RAÍZ O INICIAL DEL DOCUMENTO.                
                    alert("nodoRaiz = " + nodoRaiz.nodeName);
                    
                    
                    var nodoHijoNivel1 = nodoRaiz.firstChild; // <letras>.                    
                    alert("nodoHijoNivel1 = " + nodoHijoNivel1.nodeName);


                    var nodosHijosNivel2 = nodoHijoNivel1.childNodes; // DEVUELVE UN NodeList O ARRAY DE NODOS [<vocal><consonante>].
                    for(x=0; x<nodosHijosNivel2.length; x++) {
                        alert("nodoHijoNivel2, en posicion " + x + " ... " + nodosHijosNivel2[x].nodeName); // <vocal>, <consonante>.
                    }


                    var nodoHijoNivel2Posicion0 = nodosHijosNivel2[0]; // <vocal>.
                    var nodoHijoNivel2Posicion1 = nodosHijosNivel2[1]; // <consonante>.
                    
                    var vocal       = nodoHijoNivel2Posicion0.firstChild; // A ... es un NodeText.
                    var consonante  = nodoHijoNivel2Posicion1.firstChild; // Z ... es un NodeText.
                    
                    // PARA OBTENER EL TEXTO DEL NODO, HAY QUE EXTRAER SU VALOR HACIENDO USO DE LA PROPIEDAD .nodeValue.
                    alert("Valor del primer hijo del nodoHijoNivel2Posicion0 ... " + vocal.nodeValue);      // "A" ... es texto simple.
                    alert("Valor del primer hijo del nodoHijoNivel2Posicion1 ... " + consonante.nodeValue); // "Z" ... es texto simple. 
                    

                    var cajaTexto = document.getElementById("caja");
                    cajaTexto.innerHTML = "NODO RAÍZ ... " + nodoRaiz.nodeName + "<br/>" +
                                          "NODO NIVEL 1 ... " +  nodoHijoNivel1.nodeName + "<br/>" +
                                          "NODO NIVEL 2a ... " + nodosHijosNivel2[0].nodeName + " ... valor de la vocal = " + vocal.nodeValue + "<br/>" + 
                                          "NODO NIVEL 2b ... " + nodosHijosNivel2[1].nodeName + " ... valor de la consonante = " + consonante.nodeValue + "<br/>";
                }
            
            }
            
        </script>
        
    </head>    

    
    
    <body>
        
        <center>
        
            <h2> OBTENER ELEMENTOS DEL FICHERO XML MEDIANTE EL USO DE PROPIEDADES DOM </h2>

            <br/><br/>
            
            <input type="button" value="VER TEXTO" onclick="f_verXML(true);"/>
            <input type="button" value="VER XML" onclick="f_verXML(false);"/>

            <br/><br/>

            <div id="caja" style="border-style:solid; border-width:2px"></div>

        </center>
    
    </body>

</html>