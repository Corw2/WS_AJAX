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
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        \n");
      out.write("        <style type=\"text/css\">\n");
      out.write("            #caja{color:green; font-size:0.6cm; width:10cm; height:4cm;background-color:yellow;}\n");
      out.write("        </style>\n");
      out.write("        \n");
      out.write("        <script type=\"text/javascript\" src=\"negociador.js\"></script>\n");
      out.write("        \n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            \n");
      out.write("            function f_listarRiquezas() {   \n");
      out.write("                // Generar la petición Ajax, la cual usará como función de retorno la función js f_listar recibiéndo\n");
      out.write("                // la respuesta en formato xml del negociador.\n");
      out.write("                f_negociador(\"ServletRiquezas\", f_listar);\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            function f_listar(documentoXML) {\n");
      out.write("                // LIMPIAR CONTENIDO DE EJECUCIONES ANTERIORES.\n");
      out.write("                document.getElementById(\"caja\").innerHTML = \"\";\n");
      out.write("                \n");
      out.write("                // VARIABLE QUE ACUMULARA EL VALOR TOTAL DE LAS RIQUEZAS.\n");
      out.write("                var valorTotal = 0;\n");
      out.write("                // REFERENCIA A LA CAJA DE TEXTO EN LA QUE SE INDICARÁN LAS RIQUEZAS.\n");
      out.write("                var cajaTexto = document.getElementById(\"caja\");\n");
      out.write("                // BUSQUEDA DE LAS ETIQUETAS DEL DOM (el documento XML recibido) CUYO TIPO SEA <valor>\n");
      out.write("                var valores = documentoXML.getElementsByTagName(\"valor\");\n");
      out.write("\n");
      out.write("                alert(\"DOCUMENTO XML: \\n\" + documentoXML);\n");
      out.write("                alert(\"cuantas etiquetas valor = \" + valores.length);\n");
      out.write("                \n");
      out.write("                for(contador=0; contador<valores.length; contador++) {                    \n");
      out.write("                    alert(\"padre: \" + valores[contador].parentNode.nodeName);\n");
      out.write("                    alert(\"precio = \" + valores[contador].firstChild.nodeValue);\n");
      out.write("                \n");
      out.write("                    // VAMOS OBTENIENDO EL TEXTO DE LAS ETIQUETAS <valor> Y LO PARSEAMOS A UN NÚMERO ENTERO.\n");
      out.write("                    var valor = parseInt(valores[contador].firstChild.nodeValue);\n");
      out.write("                    // SE PUEDE OBTENER LA ETIQUETA PADRE A PARTIR DE UNA HIJA DADA.\n");
      out.write("                    // ASÍ, A PARTIR DEL VALOR LA RIQUEZA A LA QUE CORRESPONDE COMO POR EJEMPLO:\n");
      out.write("                    // 500000 ... <diamantes>\n");
      out.write("                    var nombrePadre = valores[contador].parentNode.nodeName;                    \n");
      out.write("                    // SE MUESTRA POR PANTALLA EN LA CAJA DE TEXTO EL TIPO DE RIQUEZA Y SU VALOR.\n");
      out.write("                    cajaTexto.innerHTML += nombrePadre + \" ... \" + valor + \"<br/>\";\n");
      out.write("                    // SE VA SUMANDO EL VALOR TOTAL.\n");
      out.write("                    valorTotal += valor;\n");
      out.write("                }\n");
      out.write("                \n");
      out.write("                // SE MUESTRA POR PANTALLA EL VALOR TOTAL.\n");
      out.write("                cajaTexto.innerHTML += \"<hr/>\" + \"VALOR TOTAL = \" + valorTotal;\n");
      out.write("                alert(\"PRECIO TOTAL: \" + valorTotal);\n");
      out.write("            }            \n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    \n");
      out.write("    \n");
      out.write("    <body>\n");
      out.write("        <center>\n");
      out.write("            <h1> XML - OBTENER ELEMENTOS CON getElementsByTagName </h1>\n");
      out.write("            \n");
      out.write("            <input type=\"button\" onclick=\"f_listarRiquezas();\" value=\"LISTAR RIQUEZAS\"/>\n");
      out.write("            \n");
      out.write("            <br/><br/>\n");
      out.write("            \n");
      out.write("            <div id=\"caja\"></div>            \n");
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
