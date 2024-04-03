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
      out.write("        <style type=\"text/css\">\n");
      out.write("            #caja{color:blue; font-size:0.5cm; width:14cm; height:3cm; background-color:cyan;}\n");
      out.write("        </style>\n");
      out.write("\n");
      out.write("        <!-- CARGA DEL FICHERO EXTERNO JAVASCRIPT -->\n");
      out.write("        <script type=\"text/javascript\" src=\"negociador.js\"></script>\n");
      out.write("        \n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            \n");
      out.write("            function f_mostrarCoches() {                \n");
      out.write("                f_negociador(\"ServletConcesionario\", f_mostrar);\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("\n");
      out.write("            function f_mostrar(documentoXML) {\n");
      out.write("                \n");
      out.write("                var cajaTexto = document.getElementById(\"caja\");\n");
      out.write("                \n");
      out.write("                // BORRAR EL RESULTADO DE POSIBLES EJECUCIONES ANTERIORES.\n");
      out.write("                cajaTexto.innerHTML = \"\";\n");
      out.write("\n");
      out.write("                // OBTENER UN ARRAY (NodeList) DE ELEMENTOS <coche>.\n");
      out.write("                var coches = documentoXML.getElementsByTagName(\"coche\");\n");
      out.write("                \n");
      out.write("                // RECORRER EL ARRAY DE NODOS <coche>:\n");
      out.write("                for (contador=0; contador<coches.length; contador++) {\n");
      out.write("                    // OBTENER EL NOMBRE DEL COCHE ACTUAL ... [RENAULT LAGUNA 2007, AUDI TT 2013].\n");
      out.write("                                        \n");
      out.write("                    // EJEMPLO DE LO QUE ENCONTRAMOS EN EL XML RECIBIDO:\n");
      out.write("                    // <coche usado='SI' precio='12000'>\n");
      out.write("                    //    RENAULT LAGUNA 2007\n");
      out.write("                    // </coche>\n");
      out.write("                  \n");
      out.write("                    // OBTENER EL TEXTO DEL COCHE ACTUAL:\n");
      out.write("                    var cocheActual = coches[contador].firstChild.nodeValue;    // Ej: RENAULT LAGUNA 2007\n");
      out.write("                    \n");
      out.write("                    // OBTENER LOS ATRIBUTOS DEL COCHE ACTUAL Y SU VALOR.\n");
      out.write("                    var losAtributos = coches[contador].attributes;         // DEVUELVE UN \"named node map\" DE ATRIBUTOS (cada coche los suyos).\n");
      out.write("                    var usado = losAtributos.getNamedItem(\"usado\").value;   // OBTENER UN ATRIBUTO EN PARTICULAR INDICANDO SU NOMBRE.\n");
      out.write("                    var precio = losAtributos.getNamedItem(\"precio\").value; // SI NO EXISTE, DEVOLVERÁ null Y UN ERROR POR CONSOLA.\n");
      out.write("                                                                            // EL VALOR SE OBTIENE CON .value, NO SIRVE .nodeValue NI .data.\n");
      out.write("                    \n");
      out.write("                    cajaTexto.innerHTML += \"<br/>\" + cocheActual + \" ... USADO = \" + usado +\n");
      out.write("                                           \" // PRECIO = \" + precio + \"<br/>\";\n");
      out.write("                }\n");
      out.write("                \n");
      out.write("            }\n");
      out.write("            \n");
      out.write("        </script>\n");
      out.write("        \n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    \n");
      out.write("    \n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        <center>\n");
      out.write("        \n");
      out.write("            <h1> CONSULTAR ATRIBUTOS DE UN ELEMENTO/ETIQUETA XML </h1>\n");
      out.write("            \n");
      out.write("            <h2> - NAMED NODE MAP - </h2>\n");
      out.write("            \n");
      out.write("            <br/><br/>\n");
      out.write("            \n");
      out.write("            <input type=\"button\" value=\"MOSTRAR COCHES\" onclick=\"f_mostrarCoches();\"/>\n");
      out.write("            \n");
      out.write("            <br/><br/>\n");
      out.write("            \n");
      out.write("            <div id=\"caja\"/>\n");
      out.write("            \n");
      out.write("        </center>\n");
      out.write("    \n");
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
