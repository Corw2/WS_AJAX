// EL CLIENTE ESPECIFICARÁ LA URL DEL RECURSO (SERVLET) + EL NOMBRE DE SU FUNCIÓN DE RETORNO.

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
                    funcionRetorno(negociador.responseXML);
            }
            
        };
                    
        negociador.send(null);

    }         

}