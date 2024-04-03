package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        \n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("                       \n");
      out.write("            // POST GUARDA LA INFORMACIÓN EN EL BODY DE LA PETICIÓN HTTP, MIENTRAS QUE GET LOS ENVÍA EN LA CABECERA (SON VISIBLES).\n");
      out.write("            // AUNQUE PROPORCIONA MAYOR SEGURIDAD QUE GET Y EL TAMAÑO DE LOS DATOS A ENVIAR NO ESTÁ LIMITADO, SIGUE SIENDO UNA\n");
      out.write("            // TRANSMISIÓN INSEGURA (CON UN SNIFFER SE PUEDEN CAPTURAR, MODIFICAR Y VOLVER A LANZAR). SÓLO EL USO DE SEGURIDAD\n");
      out.write("            // HTTPS (BASADO EN SSL - SOCKET SECURE LAYER) PERMITE INTEGRIDAD (ningún otro modifica los datos envíados originalmente)\n");
      out.write("            // Y CONFIDENCIALIDAD (nadie más lo va a ver) ENTRE CLIENTE Y SERVIDOR (actualmente ya se ha encontrado la forma de\n");
      out.write("            // romper este mecanismo cómo ya se hizo con anterioridad con el MD5, pero se requiere de mucho tiempo para hackear el\n");
      out.write("            // sistema y descubrir la clave de encriptación).\n");
      out.write("            \n");
      out.write("\n");
      out.write("\n");
      out.write("            function f_crearNegociador(nombre, clave) {                \n");
      out.write("                if(window.XMLHttpRequest) {\n");
      out.write("                    negociador = new XMLHttpRequest();\n");
      out.write("                } else {\n");
      out.write("                    negociador = new ActiveXObject(\"Microsoft.XMLHTTP\");\n");
      out.write("                }\n");
      out.write("                \n");
      out.write("                if (negociador != null) {\n");
      out.write("                    f_configurarNegociador();\n");
      out.write("                    f_conectarNavegadorServidor(nombre, clave);\n");
      out.write("                }            \n");
      out.write("            }\n");
      out.write("\n");
      out.write("\n");
      out.write("            \n");
      out.write("            function f_configurarNegociador() {\n");
      out.write("                // AHORA NO NOS HARÁ FALTA AÑADIR LA INFORMACIÓN A LA URL EN LA FORMA ?x=1&y=2 TAL Y CÓMO SE\n");
      out.write("                // HIZO EN EL EJERCICIO ANTERIOR. LOS DATOS VIAJARÁN EN EL INTERIOR DE UNA CABECERA HTTP QUE\n");
      out.write("                // DEBEREMOS AÑADIR (el método del negociador Ajax, setRequestHeader(xxx,yyy) se encargará de\n");
      out.write("                // crearla, sin ella, no se recibirá nada en el servidor).\n");
      out.write("                \n");
      out.write("                var url = \"ServletAccesoZonaPrivada\";\n");
      out.write("                alert(\"URL QUE SE LANZA:\\n\" + url)\n");
      out.write("                negociador.open(\"POST\",url); // UTILIZAR EL MODO POST AL CONFIGURAR EL NEGOCIADOR AJAX (método open).\n");
      out.write("                \n");
      out.write("                \n");
      out.write("                // PARA USAR POST CON LOS PARÁMETROS, DEBEREMOS COPIAR Y PEGAR LA SIGUIENTE LÍNEA TAL Y CÓMO ESTÁ DEFINIDA:\n");
      out.write("                negociador.setRequestHeader(\"Content-Type\",\"application/x-www-form-urlencoded\");\n");
      out.write("\n");
      out.write("                // FUNCIÓN DE RETORNO EN LÍNEA O ANÓNIMA:\n");
      out.write("                negociador.onreadystatechange = function() {\n");
      out.write("                    if (negociador.readyState==4 && negociador.status==200) {\n");
      out.write("                        var codigoSecreto = negociador.responseText;\n");
      out.write("                        // EL CONTENIDO DE responseText SE GENERARÁ EN EL SERVLET Y DEPENDERÁ DE SI SE HA\n");
      out.write("                        // INTRODUCIDO CORRECTAMENTE EL USUARIO Y SU CONTRASEÑA, O NO.\n");
      out.write("                        document.getElementById(\"verCodigoSecreto\").innerHTML = codigoSecreto;\n");
      out.write("                    }                    \n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            \n");
      out.write("            \n");
      out.write("            function f_conectarNavegadorServidor(nombre,clave) {\n");
      out.write("                alert(\"---> ENVIANDO PETICIÓN POST CON LOS DATOS: \" + nombre + \", \" + clave);\n");
      out.write("\n");
      out.write("                // SERÁ EN EL MÉTODO send() DEL NEGOCIADOR AJAX DÓNDE COLOCAREMOS LOS PARÁMETROS A ENVIAR, LOS\n");
      out.write("                // CUALES VIAJARÁN DENTRO DE LA CABECERA ANTERIORMENTE CREADA CON EL MÉTODO setRequestHeader:\n");
      out.write("                //   \n");
      out.write("                //      negociador.setRequestHeader(\"Content-Type\",\"application/x-www-form-urlencoded\");\n");
      out.write("                // \n");
      out.write("                \n");
      out.write("                // SE CONFIGURA LA QUERY-STRING IGUAL QUE CUANDO USAMOS MODO EL GET, PERO SIN COLOCAR EL '?' INICIAL:\n");
      out.write("                // OBSERVAR COMO AHORA YA NO UTILIZAMOS 'null' ..... nombre=juan&clave=12345\n");
      out.write("                \n");
      out.write("                negociador.send(\"nombre=\"+nombre+\"&\"+\"clave=\"+clave);\n");
      out.write("                \n");
      out.write("                // SI SE NECESITA UNA CABECERA DE TIPO XML, USAR: negociador.setRequestHeader(\"Content-Type\", \"text/xml\");\n");
      out.write("                // MANDANDO LOS DATOS COMO: negociador.send(\"<datos><nombre>juan</nombre><clave>12345</clave></datos>\");\n");
      out.write("                // RECIBIÉNDOSE MÁS TARDE EN EL SERVLET EN FORMA DE DOCUMENTO XML PARA PODER SER TRATADO COMO TAL,\n");
      out.write("                // MEDIANTE ALGÚN API DE PROGRAMACIÓN ESPECIALIZADA PARA TAL FIN (ej SAX).\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            \n");
      out.write("            //////////////////////////////////////////////////////////////////////////////////////////////////\n");
      out.write("            \n");
      out.write("       \n");
      out.write("            // VERIFICAR LA INFORMACIÓN INTRODUCIDA EN EL FORMULARIO ANTES DE ENVIAR LOS DATOS AL SERVIDOR.\n");
      out.write("            function f_comprobarCampos() {\n");
      out.write("                var cajaNombre = document.getElementById(\"nombre\").value.trim();\n");
      out.write("                var cajaClave = document.getElementById(\"clave\").value.trim();\n");
      out.write("\n");
      out.write("                if(cajaNombre == \"\" || cajaClave == \"\") {\n");
      out.write("                    alert(\"ERROR, DEBES INTRODUCIR NOMBRE Y CLAVE\");\n");
      out.write("                    return;\n");
      out.write("                }\n");
      out.write("                \n");
      out.write("                // LANZAR EL PROCESO AJAX.\n");
      out.write("                f_crearNegociador(cajaNombre,cajaClave);\n");
      out.write("            }   \n");
      out.write("                        \n");
      out.write("            \n");
      out.write("            function f_mostrarClave() {\n");
      out.write("                alert(\"DETECTAR SI EL CHECKBOX ESTA ACTIVO PARA MOSTRAR LA CONTRASEÑA\");\n");
      out.write("                \n");
      out.write("                var mostrar = document.getElementById(\"checkboxClave\").checked;\n");
      out.write("                \n");
      out.write("                alert(\"¿MOSTRAR LA CONTRASEÑA EN PANTALLA? = \" + (mostrar?'SI':'NO'));\n");
      out.write("                \n");
      out.write("                if(mostrar) {\n");
      out.write("                    alert(\"CAMBIAR EL TIPO DE LA CAJA DE PASSWORD A TEXT\");\n");
      out.write("                    document.getElementById(\"clave\").type=\"text\";\n");
      out.write("                } else {\n");
      out.write("                    alert(\"CAMBIAR EL TIPO DE LA CAJA DE TEXT A PASSWORD\");\n");
      out.write("                    document.getElementById(\"clave\").type=\"password\";\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("        </script>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        <!-- ESTABLECER UN ESTILO POR DEFECTO PARA TODAS LAS CELDAS DE LA TABLA -->\n");
      out.write("        <style type=\"text/css\">            \n");
      out.write("            td{text-align:center; width:8cm; height:1.5cm}\n");
      out.write("        </style>\n");
      out.write("              \n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    \n");
      out.write("    \n");
      out.write("    <body onload=\"document.getElementById('nombre').focus();\">\n");
      out.write("        \n");
      out.write("        <center>\n");
      out.write("        \n");
      out.write("            <h3 style=\"color:blue\">*** INTRODUCE NOMBRE Y CLAVE Y PULSA ENTRAR ***</h3>\n");
      out.write("\n");
      out.write("            <p style=\"color:green;font-size:10px\">\n");
      out.write("                DADO QUE NO HAY RECARGA DE LA PAGINA, EL FORMULARIO CONSERVARA EL VALOR DE SUS CAMPOS\n");
      out.write("                <br/>\n");
      out.write("                Y LA URL DEL NAVEGADOR NO CAMBIARA.                \n");
      out.write("            </p>\n");
      out.write("\n");
      out.write("            <br><br>\n");
      out.write("            \n");
      out.write("            \n");
      out.write("            <table border=\"1\" style=\"background-color:silver;\"> \n");
      out.write("                \n");
      out.write("                <tr style=\"background-color:greenyellow\">            \n");
      out.write("                    <td>\n");
      out.write("                        NOMBRE:\n");
      out.write("                        <input type=\"text\" id=\"nombre\" value=\"\" size=\"20\" maxlength=\"20\" style=\"color:blue;\"/>\n");
      out.write("                    </td>\n");
      out.write("                    \n");
      out.write("                    <td>\n");
      out.write("                        CLAVE:\n");
      out.write("                        <input type=\"password\" id=\"clave\" value=\"\" size=\"20\" maxlength=\"20\" style=\"color:red;\"/>\n");
      out.write("                    </td>                \n");
      out.write("                </tr>\n");
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td colspan=\"2\">\n");
      out.write("                        <input type=\"button\"\n");
      out.write("                               value=\"ENTRAR\"\n");
      out.write("                               style=\"text-align:center;font-weight:bold;color:blue;background-color:gold;border-style:outset;\"\n");
      out.write("                               onclick=\"f_comprobarCampos();\"/>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                \n");
      out.write("            </table>\n");
      out.write("            \n");
      out.write("            <br/>\n");
      out.write("            \n");
      out.write("            MOSTRAR EL CAMPO CLAVE:\n");
      out.write("            <input type=\"checkbox\" id=\"checkboxClave\" onclick=\"f_mostrarClave();\"/>\n");
      out.write("            \n");
      out.write("            \n");
      out.write("            <div id=\"verCodigoSecreto\" style=\"border-style:solid;margin:1cm 1cm 1cm 1cm;text-align:center;font-size:0.6cm;\">\n");
      out.write("                !!! ONLY FOR YOUR EYES !!!\n");
      out.write("            </div>\n");
      out.write("                        \n");
      out.write("            <p style=\"color:orange; font-size:12px\">\n");
      out.write("                Introduce juan 12345 para acceder\n");
      out.write("            </p>\n");
      out.write("            \n");
      out.write("        </center>\n");
      out.write("    </body>\n");
      out.write("\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
