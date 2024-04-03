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
      out.write("\n");
      out.write("            // VARIABLE GLOBAL QUE ALMACENARÁ EL NEGOCIADOR AJAX.\n");
      out.write("            var negociador;\n");
      out.write("            \n");
      out.write("            \n");
      out.write("            // 1. OBTENER EL NEGOCIADOR AJAX.            \n");
      out.write("            function f_crearNegociador() {\n");
      out.write("                // CREAR EL OBJETO XMLHttpRequest (EL OBJETO AJAX QUE ACTÚA DE NEGOCIADOR ENTRE EL NAVEGADOR CLIENTE Y\n");
      out.write("                // EL SERVIDOR WEB. MOZILLA Y MICROSOFT EXPLORER CREAN EL NEGOCIADOR DE FORMA DISTINTA, PERO UNA VEZ\n");
      out.write("                // CONSTITUÍDO, EL FUNCIONAMIENTO (MÉTODOS A LLAMAR Y PROPIEDADES DEL OBJETO) DEBERÍAN SER IGUALES.\n");
      out.write("                // *** IMPORTANTE ... PARA MICROSOFT EXPLORER V7 VALEN LAS DOS FORMAS, PERO MOZILLA NO ADMITE LOS ActiveXObject.\n");
      out.write("\n");
      out.write("                // DETECTAR EL TIPO DE NAVEGADOR. DEBEMOS PREGUNTAR POR UNA PROPIEDAD AL OBJETO window. SI window LA\n");
      out.write("                // TIENE, LA SENTENCIA 'if' INTERPRETARÁ 'true' LO QUE NOS PERMITE DEDUCIR QUÉ TIPO DE NAVEGADOR ES.\n");
      out.write("                // \n");
      out.write("                // --- PROCESO MECÁNICO ---\n");
      out.write("\n");
      out.write("                // DETECTAR SI EL OBJETO window DISPONE DE LA PROPIEDAD XMLHttpRequest (de ser así se trarará de MOZILLA):\n");
      out.write("                if(window.XMLHttpRequest) {\n");
      out.write("                    alert(\"ESTAS USANDO MOZILLA O COMPATIBLE\");                    \n");
      out.write("                    // GENERAR EL NEGOCIADOR PARA MOZILLA (objeto de JavaScript):\n");
      out.write("                    negociador = new XMLHttpRequest();\n");
      out.write("                } else {\n");
      out.write("                    alert(\"ESTAS USANDO MICROSOFT EXPLORER\");\n");
      out.write("                    // GENERAR EL NEGOCIADOR PARA EXPLORER:\n");
      out.write("                    negociador = new ActiveXObject(\"Microsoft.XMLHTTP\");\n");
      out.write("                }\n");
      out.write("                \n");
      out.write("                // COMPROBAR QUE DE UNA U OTRA MANERA, EL NEGOCIADOR SE HA CREADO.\n");
      out.write("                if (negociador != null) {\n");
      out.write("                    alert(\"SE HA CREADO EL OBJETO NEGOCIADOR DE AJAX\");\n");
      out.write("                    return true;\n");
      out.write("                } else {\n");
      out.write("                    alert(\"ERROR. NO SE HA PODIDO CREAR EL NEGOCIADOR DE AJAX\");\n");
      out.write("                    return false;\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("\n");
      out.write("            // 2. CONFIGURAR EL NEGOCIADOR (prepararlo para más tarde poder ser lanzado o envíado contra el servidor).\n");
      out.write("            function f_configurarNegociador() {\n");
      out.write("\n");
      out.write("                // AJUSTAR LA FORMA DE ENVIAR LA PETICIÓN AL SERVIDOR WEB (GET/POST) Y SU URL.\n");
      out.write("                // ESTAMOS USANDO URL RELATIVA (EL FICHERO mensaje.txt ESTÁ EN EL MISMO LUGAR QUE index.jsp).\n");
      out.write("                // ESTABLECER ... [MODO GET/POST - URL DEL RECURSO - ENVÍO ASÍNCRONO/SÍNCRONO].         \n");
      out.write("                // \n");
      out.write("                // 2A:\n");
      out.write("                negociador.open(\"GET\",\"mensaje.txt\",true); // Por defecto la petición es asíncrona, luego 'true' es opcional.\n");
      out.write("                // NOTA: podemos usar método GET y añadir parámetros en la url en la forma \"url?param1=valor1&param2=valor2\",\n");
      out.write("                //          aunque lo más adecuado es utilizar POST (requiere de una cabecera especial) cuando se desee enviar\n");
      out.write("                //          información al servidor desde el cliente.\n");
      out.write("\n");
      out.write("\n");
      out.write("                // AJUSTAR LA FUNCIÓN DE RETORNO, AQUELLA QUE SERÁ LLAMADA CADA VEZ QUE CAMBIE EL ESTADO DEL NEGOCIADOR,\n");
      out.write("                // (EL VALOR DE SU PROPIEDAD readystatechange). UTILIZAREMOS UNA FUNCIÓN ANÓNIMA(sin nombre, usar y tirar),\n");
      out.write("                // TAMBIÉN LLAMADA \"EN LÍNEA\".\n");
      out.write("                // \n");
      out.write("                // 2B:\n");
      out.write("                negociador.onreadystatechange = function() {\n");
      out.write("                    if (negociador.readyState==4 && negociador.status==200) {\n");
      out.write("                        // readyState   == 4 DENOTA QUE LA RECEPCIÓN DE DATOS DEL SERVIDOR HA CONCLUÍDO (\"el paquete ha llegado a casa ... \").\n");
      out.write("                        // status       == 200 CABECERA DE ESTADO HTTP QUE CONFIRMA QUE LOS DATOS HAN LLEGADO CORRECTAMENTE (\"... y no hay nada roto\").\n");
      out.write("                        \n");
      out.write("                        // HAN DE CONFIRMARSE LAS DOS CONDICIONES. DE SER ASÍ, LEER LA PROPIEDAD responseText DEL NEGOCIADOR\n");
      out.write("                        // PARA OBTENER EL CONTENIDO DEL FICHERO DE TEXTO LEÍDO DEL SERVIDOR WEB (procesamos los datos de respuesta).\n");
      out.write("                        // CON DICHOS DATOS ACTUALIZAR LA PÁGINA USANDO DHTML: FUNCIÓN document.getElementById(\"xxx\"), ACTUANDO SOBRE LA PROPIEDAD\n");
      out.write("                        // 'innerHTML' DEL CONTROL GRÁFICO (creará los nodos necesarios en el DOM).\n");
      out.write("                        // \n");
      out.write("                        // 2C:\n");
      out.write("                        // VERTER LOS DATOS RECUPERADOS POR AJAX EN LA CAJA QUE LOS VISUALIZARÁ EN PANTALLA.\n");
      out.write("                        document.getElementById(\"cajaTexto\").innerHTML = negociador.responseText;\n");
      out.write("                        document.getElementById(\"cajaTexto\").style.backgroundColor = \"cyan\";\n");
      out.write("                        alert(\"CARGA DE DATOS COMPLETA ... SIN FLICKER-REFRESCO DE PÁGINA!!!\");\n");
      out.write("                    }                    \n");
      out.write("                };\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            // 3. CONECTAR EL NEGOCIADOR CON EL SERVIDOR (ACTIVARLO/LANZARLO).\n");
      out.write("            function f_conectarNavegadorServidor() {\n");
      out.write("                // ESTE MÉTODO ES EL QUE REALMENTE LANZA LA PETICIÓN ASÍNCRONA CONTRA EL SERVIDOR.\n");
      out.write("                negociador.send(null);  // Indicamos null porque en este ejemplo no le vamos a enviar nada al servidor\n");
      out.write("                                        // de aplicaciones según el modo POST.\n");
      out.write("            }\n");
      out.write("\n");
      out.write("\n");
      out.write("            /////////////////////////////////////////////////////////////////////////////////////////////////\n");
      out.write("\n");
      out.write("\n");
      out.write("            // FINALMENTE, LA FUNCIÓN QUE ENGLOBA LOS DISTINTOS PASOS PARA HACER USO DE AJAX\n");
      out.write("            // (comentar todos los alert tras comprobar funcionamiento para verificar la fluidez de la página):\n");
      out.write("            function f_rellenar() {\n");
      out.write("                \n");
      out.write("                // REFERENCIA A LA CAPA QUE ACTUALIZAREMOS CON LA INFORMACIÓN OBTENIDA DEL SERVIDOR POR AJAX.\n");
      out.write("                \n");
      out.write("                // Borrar su posible contenido anterior.\n");
      out.write("                document.getElementById(\"cajaTexto\").innerHTML = \"\";\n");
      out.write("                \n");
      out.write("                if(f_crearNegociador()) {               // 1. CREAR EL NEGOCIADOR AJAX.\n");
      out.write("                    f_configurarNegociador();           // 2. CONFIGURAR SU MODO (GET/POST),URL Y FUNCIÓN DE RETORNO.\n");
      out.write("                    f_conectarNavegadorServidor();      // 3. LANZAR LA PETICIÓN HTTP ASÍNCRONA AL SERVIDOR (PEDIR UN RECURSO).\n");
      out.write("                }\n");
      out.write("\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("        </script>\n");
      out.write("        \n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    \n");
      out.write("    \n");
      out.write("    <body>\n");
      out.write("        <center>\n");
      out.write("            \n");
      out.write("            <h3 style=\"color:blue\">*** OBTENER DATOS DEL SERVIDOR WEB SIN RECARGAR LA PAGINA *** </h3>\n");
      out.write("            <br> OBSERVAR COMO LA BARRA DE NAVEGACION NO CAMBIA (peticion asincrona) </br>\n");
      out.write("            \n");
      out.write("            <br><br>\n");
      out.write("            \n");
      out.write("            <div id=\"cajaTexto\" style=\"font-size:0.7cm;text-align:center;border-style:double;margin:2cm 2cm 2cm 2cm\">\n");
      out.write("                pulsa el boton.\n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("            <br/><br/>\n");
      out.write("            \n");
      out.write("            <!-- AL PULSARSE ESTE BOTÓN SE DESENCADENARÁ TODO EL PROCESO AJAX -->\n");
      out.write("            <input type=\"button\" value=\"RELLENAR\" onclick=\"f_rellenar();\"/>\n");
      out.write("\n");
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
