// EL CLIENTE ESPECIFICARÁ LA URL DEL RECURSO (SERVLET) + EL NOMBRE DE SU FUNCIÓN DE RETORNO.
// LA PETICIÓN SE REALIZARÁ EN MODO GET ( send(null) ). 
// LA DEVOLUCIÓN SE REALIZARÁ EN FORMATO XML (propiedad responseXml del negociador).

function f_negociador(url,funcionRetorno) {

    var negociador;
                
    if(window.XMLHttpRequest) {
        negociador = new XMLHttpRequest();
    } else {
        negociador = new ActiveXObject("Microsoft.XMLHTTP");
    }
                
    if(negociador != null) {
        
        negociador.open("GET",url);
                
        negociador.onreadystatechange = function() {  
            
            if (negociador.readyState==4 && negociador.status==200) {
                
                    // SE ENVÍA LA RESPUESTA EN FORMATO XML A LA FUNCIÓN DEFINIDA Y ELEGIDA
                    // POR EL CLIENTE (DELEGACIÓN).
                    funcionRetorno(negociador.responseXML);
            
            }
            
        };
                    
        negociador.send(null);

    }             

}