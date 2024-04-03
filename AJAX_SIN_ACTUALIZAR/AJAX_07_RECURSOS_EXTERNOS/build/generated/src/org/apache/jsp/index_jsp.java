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
      out.write("            \n");
      out.write("            function f_queHoraEs() {\n");
      out.write("\n");
      out.write("                var negociador;\n");
      out.write("                \n");
      out.write("                if(window.XMLHttpRequest) {\n");
      out.write("                    negociador = new XMLHttpRequest();\n");
      out.write("                } else {\n");
      out.write("                    negociador = new ActiveXObject(\"Microsoft.XMLHTTP\");\n");
      out.write("                }\n");
      out.write("                \n");
      out.write("                if(negociador != null) {\n");
      out.write("                    // Elegir el puerto correcto en cada caso (ejecutar AJAX_07ext_RECURSOS_EXTERNOS y observar\n");
      out.write("                    //      en la URL del navegador cuál es el número de puerto que realmente utiliza):\n");
      out.write("                    //var puerto = 8080;\n");
      out.write("                    //var puerto = 8686;\n");
      out.write("                    var puerto = 7070;\n");
      out.write("                    \n");
      out.write("                    // Llamamos directamente a una página JSP y el código HTML estático que generará es el que\n");
      out.write("                    // recogeremos a través de negociador.responseText. Así, el negociador contendrá el flujo\n");
      out.write("                    // de etiquetas HTML que se enviarían hacia el navegador cliente.\n");
      out.write("                    \n");
      out.write("                    // EL RESULTADO ES BÁSICAMENTE EL MISMO QUE EL OBTENIDO AL LLAMAR, POR EJEMPLO, A UN SERVLET.\n");
      out.write("                    // EN ESTE CASO UTILIZAMOS UN JSP (SERVLET DESTINADO A GENERAR LA VISTA) QUE ADEMÁS SE ENCUENTRA EN\n");
      out.write("                    // UNA APLICACIÓN QUE NO ES LA DIRECTAMENTE USADA POR EL CLIENTE, MOTIVO POR EL QUE LO DENOMINAMOS\n");
      out.write("                    // COMO RECURSO EXTERNO.\n");
      out.write("                    \n");
      out.write("                    // OBSERVAR COMO SOLICITAMOS LA PÁGINA DE INICIO DE OTRA APLICACIÓN.\n");
      out.write("                    var url = \"http://localhost:\" + puerto + \"/AJAX_07ext_RECURSOS_EXTERNOS/index.jsp\";\n");
      out.write("                    \n");
      out.write("                    negociador.open(\"GET\", url);\n");
      out.write("                    \n");
      out.write("                    negociador.onreadystatechange = function() { \n");
      out.write("                        // COMPROBAR QUE LA PÁGINA HA SIDO ENCONTRADA. EL PUERTO DEBE SER EL QUE UTILICE EL RECURSO,\n");
      out.write("                        // DE LO CONTRARIO, NO SE GENERARÁ UN ERROR 404 SINO QUE EL NAVEGADOR ENTRARÁ EN UN BUCLE SIN\n");
      out.write("                        // FIN, EN ESPERA DE ENCONTRAR LA PÁGINA SOLICITADA.\n");
      out.write("                        \n");
      out.write("                        // VERIFICAMOS SI SE PRODUCE UN ERROR 404:\n");
      out.write("                        if(negociador.status==404) {\n");
      out.write("                            alert(\"----> ESTADO HTTP DEL NEGOCIADOR = \" + negociador.status + \"\\n\" +\n");
      out.write("                                  \" !!! EL SERVIDOR RESPONDE, PERO EL RECURSO NO SE HA ENCONTRADO !!!\");                        \n");
      out.write("                            document.getElementById(\"cajaTexto\").style.color=\"red\";\n");
      out.write("                            document.getElementById(\"cajaTexto\").innerHTML = \"RECURSO NO ENCONTRADO!!!.\" + \n");
      out.write("                                                     \"<br/><br/>DEBES DESPLEGAR LA APLICACION AJAX_07ext_RECURSOS_EXTERNOS - puerto = \" + puerto;\n");
      out.write("                        }\n");
      out.write("                        \n");
      out.write("                        // SI LA PÁGINA ESTÁ FINALMENTE DISPONIBLE (los datos solicitados):\n");
      out.write("                        if (negociador.readyState==4 && negociador.status==200) {\n");
      out.write("                            document.getElementById(\"cajaTexto\").style.color=\"green\";\n");
      out.write("                            var respuesta = negociador.responseText; // EL CÓDIGO HTML ESTÁTICO DE LA PÁGINA CON LA HORA ACTUAL.\n");
      out.write("                            alert(\"EL CÓDIGO ESTÁTICO HTML QUE GENERA EL JSP/SERVLET index.jsp\\n\" + respuesta);\n");
      out.write("                            // EL NAVEGADOR MOSTRARÁ UN DOCUMENTO HTML COMPLETO DENTRO DE OTRO (podemos quitar al externo las partes\n");
      out.write("                            // que no son propias de los datos de la respuesta, pero las conservamos para demostrar cómo lo navegadores\n");
      out.write("                            // actuales son capaces de renderizar ambas páginas anidadas sin problemas).\n");
      out.write("                            document.getElementById(\"cajaTexto\").innerHTML = respuesta;\n");
      out.write("                        }                            \n");
      out.write("                    }\n");
      out.write("                    \n");
      out.write("                    negociador.send(null);\n");
      out.write("\n");
      out.write("                }\n");
      out.write("                \n");
      out.write("            }\n");
      out.write("            \n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    \n");
      out.write("    \n");
      out.write("    <body>\n");
      out.write("        <center>\n");
      out.write("\n");
      out.write("            <h1> SOLICITAR RECURSOS EXTERNOS </h1>\n");
      out.write("            \n");
      out.write("            <br/><br/>\n");
      out.write("            \n");
      out.write("            <input type=\"button\" value=\"-DIME LA HORA-\" onclick=\"f_queHoraEs();\"/>\n");
      out.write("            \n");
      out.write("            <br/><br/>\n");
      out.write("            \n");
      out.write("            <div id=\"cajaTexto\" style=\"width:20cm;height:8cm;border-style:outset;border-width:0.4cm\">\n");
      out.write("                <br/>AQUI COLOCAREMOS LA RESPUESTA DEL RECURSO EXTERNO ... index.jsp (su servlet index_jsp) EL CUAL \n");
      out.write("                GENERA HTML ESTÁTICO. <br/><br/> EJECUTAR EN PRIMER LUGAR LA APLICACIÓN AJAX_07ext_RECURSOS_EXTERNOS \n");
      out.write("                Y COMPROBAR EL PUERTO QUE ESTA UTILIZA, YA QUE SI LA PAGINA SE ENCUENTRA PERO NO COINCIDEN LOS PUERTOS\n");
      out.write("                SE ENTRARA EN UN BUCLE INFINITO.\n");
      out.write("            </div>\n");
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
