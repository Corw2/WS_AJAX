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
      out.write("        \n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        \n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            \n");
      out.write("            var negociador; // NEGOCIADOR AJAX DECLARADO GLOBAL.\n");
      out.write("            \n");
      out.write("            \n");
      out.write("            function f_crearNegociador() {\n");
      out.write("                \n");
      out.write("                if(window.XMLHttpRequest) {\n");
      out.write("                    negociador = new XMLHttpRequest();\n");
      out.write("                } else {\n");
      out.write("                    negociador = new ActiveXObject(\"Microsoft.XMLHTTP\");\n");
      out.write("                }\n");
      out.write("                \n");
      out.write("                if (negociador != null) {\n");
      out.write("                    return true;\n");
      out.write("                } else {\n");
      out.write("                    return false;\n");
      out.write("                }\n");
      out.write("            \n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            \n");
      out.write("            function f_configurarNegociador(pais) {\n");
      out.write("\n");
      out.write("                pais += \".txt\";\n");
      out.write("                \n");
      out.write("                // LA URL QUE SOLICITAREMOS NO ES MÁS QUE UN FICHERO DE TEXTO QUE INDICARÁ LA IMAGEN A CARGAR DESDE\n");
      out.write("                // EL SERVIDOR (el navegador cliente lanzará un petición oculta para obtenerla ... datos binarios).\n");
      out.write("                \n");
      out.write("                // EL SERVIDOR ENTREGARÁ UNA DE LAS SIGUIENTES LÍNEAS QUE SE ESCRIBIRÁN EN LA CAPA \"cajaImagen\":\n");
      out.write("                //      <img src=\"imagenes/EstatuaLibertad.jpg\"/>\n");
      out.write("                //      <img src=\"imagenes/CatedralSantiago.jpg\"/>\n");
      out.write("                \n");
      out.write("                negociador.open(\"GET\",pais);\n");
      out.write("                \n");
      out.write("                negociador.onreadystatechange = function() {\n");
      out.write("                \n");
      out.write("                    if (negociador.readyState==4 && negociador.status==200) {\n");
      out.write("                        //alert(\"NEGOCIADOR = \" + negociador.responseText);\n");
      out.write("                        \n");
      out.write("                        // COLOCAR LA IMAGEN DENTRO DE LA CAPA.\n");
      out.write("                        document.getElementById(\"cajaImagen\").innerHTML = negociador.responseText;\n");
      out.write("                    }\n");
      out.write("                    \n");
      out.write("                };\n");
      out.write("            \n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            \n");
      out.write("            function f_conectarNavegadorServidor() {\n");
      out.write("                // NO ENVIAMOS NADA AL SERVIDOR (MODO GET).\n");
      out.write("                negociador.send(null);\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("                        \n");
      out.write("            function f_cargarImagen(pais) {\n");
      out.write("                \n");
      out.write("                // El parámetro pais determinará el nombre del fichero a solicitarse al servidor y por tanto, la\n");
      out.write("                // imagen a ser mostrada.\n");
      out.write("                \n");
      out.write("                // MOSTRAR EL NOMBRE DEL PAÍS EN MAYÚSCULAS A PARTIR DEL TEXTO DEL PARÁMETRO DE ENTRADA.\n");
      out.write("                document.getElementById(\"descripcion\").innerHTML = pais.toUpperCase();\n");
      out.write("                \n");
      out.write("                if(f_crearNegociador()) {\n");
      out.write("                    f_configurarNegociador(pais);\n");
      out.write("                    f_conectarNavegadorServidor();\n");
      out.write("                }\n");
      out.write("\n");
      out.write("            }\n");
      out.write("        \n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("        \n");
      out.write("        <!-- ESTILOS CSS -->\n");
      out.write("        \n");
      out.write("        <style type=\"text/css\">\n");
      out.write("            /* DEFINICIÓN DE UN ESTILO COMÚN PARA TODAS LAS CELDAS */\n");
      out.write("            td {\n");
      out.write("                width:200px;\n");
      out.write("                height:30px;\n");
      out.write("                text-align:center;\n");
      out.write("                color:red;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("        \n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    \n");
      out.write("\n");
      out.write("    <body style=\"background-color:black\">\n");
      out.write("\n");
      out.write("        <center>\n");
      out.write("            \n");
      out.write("            <h3 style=\"color:blue\"> - ELEMENTOS REPRESENTATIVOS DE UN PAIS - </h3>\n");
      out.write("            \n");
      out.write("            <table border=\"5\">\n");
      out.write("                <tr>\n");
      out.write("                    <td colspan=\"2\" style=\"height:260px\">\n");
      out.write("                        <div id=\"cajaImagen\">\n");
      out.write("                            - - - PULSA UN BOTON - - -  \n");
      out.write("                        </div>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td colspan=\"2\">\n");
      out.write("                        <p id=\"descripcion\"></p>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                \n");
      out.write("                <tr>                \n");
      out.write("                    <td>\n");
      out.write("                        <input type=\"button\" value=\"ESTADOS UNIDOS\" onclick=\"f_cargarImagen('estados_unidos');\"/>\n");
      out.write("                    </td>\n");
      out.write("\n");
      out.write("                    <td>\n");
      out.write("                        <input type=\"button\" value=\"ESPAÑA\" onclick=\"f_cargarImagen('españa');\"/>\n");
      out.write("                    </td>\n");
      out.write("                </tr>                \n");
      out.write("\n");
      out.write("            </table>\n");
      out.write("            \n");
      out.write("        </center>\n");
      out.write("\n");
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
