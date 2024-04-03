// PODEMOS CREAR NUESTRAS PROPIAS FUNCIONES A MODO DE FRAMEWORK PARA NO TENER QUE ESTAR
// ESCRIBIÉNDOLAS EN TODAS LA PÁGINAS DÓNDE SEAN NECESARIAS.

// PARA AÑADIR ESTE CÓDIGO A UNA PÁGINA, UTILIZAR LA LÍNEA TAL Y CÓMO APARECE A CONTINUACIÓN (no hacer auto-cierre):
// <script type="text/javascript" src="negociador.js"></script>


function f_negociador(url,funcionRetorno,enTexto) {
    
    var negociador; // DEFINIDO COMO GLOBAL.
                
    if(window.XMLHttpRequest) {
        // NAVEGADOR MOZILLA:
        negociador = new XMLHttpRequest();
    } else {
        // NAVEGADOR EXPLORER:
        negociador = new ActiveXObject("Microsoft.XMLHTTP");
    }
                
    if(negociador != null) {
        negociador.open("GET",url); // MODO GET.
                    
        negociador.onreadystatechange = function() {                    
            if (negociador.readyState==4 && negociador.status==200) {
                
                // LA FUNCIÓN DE RETORNO DEBERÁ ESTAR DEFINIDA EN LA PÁGINA DEL CLIENTE CON LA SIGUIENTE FIRMA:
                // function funcionRetorno(datosXML,enTexto) { ... }
                // RECORDAR QUE EN JAVASCRIPT NO HAY QUE ESPECIFICAR LOS TIPOS COMO EN JAVA.
                
                // DEPENDIENDO DE SI QUEREMOS TRATAR LA RESPUESTA COMO TEXTO NORMAL O COMO XML, ENVÍAREMOS A LA
                // FUNCIÓN DE RETORNO EL VALOR negociador.responseText o negociador.responseXML:
                if(enTexto) {   // SI true TRATARLO COMO TEXTO NORMAL.
                    funcionRetorno(negociador.responseText,enTexto); // es la función indicada en el parámetro de entrada.
                } else {        // SI false TRATARLO COMO UN DOCUMENTO XML.
                    funcionRetorno(negociador.responseXML,enTexto);
                }
            }                            
        };
        
        // ACTIVAR EL NEGOCIAR - HABÍAMOS INDICADO MODO GET, LUEGO NO ENVÍAMOS PARÁMETROS AL SERVIDOR.
        negociador.send(null);

    }                

}