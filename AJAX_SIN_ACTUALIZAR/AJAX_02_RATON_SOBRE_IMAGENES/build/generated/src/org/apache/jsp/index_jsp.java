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
      out.write("\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            \n");
      out.write("            var negociador;                                                 // EL NEGOCIADOR.\n");
      out.write("            \n");
      out.write("            function f_crearNegociador() {                \n");
      out.write("                if(window.XMLHttpRequest) {\n");
      out.write("                    negociador = new XMLHttpRequest();                      // MOZILLA.\n");
      out.write("                } else {\n");
      out.write("                    negociador = new ActiveXObject(\"Microsoft.XMLHTTP\");    // EXPLORER.\n");
      out.write("                }\n");
      out.write("                \n");
      out.write("                if (negociador != null) {\n");
      out.write("                    return true;\n");
      out.write("                } else {\n");
      out.write("                    return false;\n");
      out.write("                }            \n");
      out.write("\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            \n");
      out.write("            function f_configurarNegociador(imagen) {                \n");
      out.write("                // Generaremos las URL's:  \"advertencia.txt\"  -   \"firefox.txt\"    -   \"disco.txt\".\n");
      out.write("\n");
      out.write("                // Url del fichero .txt que corresponde a la imagen sobre la que está el ratón\n");
      out.write("                // en estos momentos.\n");
      out.write("                urlImagen = imagen + \".txt\"; \n");
      out.write("\n");
      out.write("                // Por defecto la petición es de tipo asíncrono, por lo que no es necesario indicarlo.\n");
      out.write("\n");
      out.write("                negociador.open(\"GET\",urlImagen);\n");
      out.write("                                \n");
      out.write("                negociador.onreadystatechange = function() {    // Función de retorno anónima.\n");
      out.write("                    if (negociador.readyState==4 && negociador.status==200) {\n");
      out.write("                        // Rellenar la caja de texto con el mensaje leído del servidor (propiedad responseText del negociador).\n");
      out.write("                        document.getElementById(\"cajaTexto\").innerHTML = negociador.responseText;\n");
      out.write("                    }                    \n");
      out.write("                };\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            \n");
      out.write("            function f_conectarNavegadorServidor() {\n");
      out.write("                negociador.send(null);\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("                        \n");
      out.write("            function f_preguntar(imagen) {\n");
      out.write("                //document.getElementById(\"cajaTexto\").innerHTML = imagen;\n");
      out.write("                if(f_crearNegociador()) {\n");
      out.write("                    // Usamos el nombre de la imAgen actual para seleccionar el fichero de texto en el servidor.\n");
      out.write("                    f_configurarNegociador(imagen);                    \n");
      out.write("                    // Lanzar la petición contra el servidor.\n");
      out.write("                    f_conectarNavegadorServidor();\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("\n");
      out.write("            function f_salir() {\n");
      out.write("                document.getElementById(\"cajaTexto\").innerHTML = \"!!! Situa el raton sobre otra imagen !!!\";                \n");
      out.write("            }\n");
      out.write("        \n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <center>\n");
      out.write("\n");
      out.write("            <h3 style=\"color:blue\"> *** ¿QUE IMAGEN ES? ... PASA EL RATON SOBRE UNA DE ELLAS *** </h3>\n");
      out.write("\n");
      out.write("            <br><br>\n");
      out.write("\n");
      out.write("            <table border=\"0\" width=\"500\" height=\"50\">\n");
      out.write("                \n");
      out.write("                <tr>\n");
      out.write("                \n");
      out.write("                    <td align=\"center\">\n");
      out.write("                        \n");
      out.write("                        <!-- ASIGNACIÓN DE EVENTOS AL CONTROL GRÁFICO. CADA IMAGEN ENVIARÁ COMO PARÁMETRO SU TEXTO IDENTIFICATIVO -->                        \n");
      out.write("                        <img src=\"advertencia.png\" style=\"width:70px;\"\n");
      out.write("                             onmouseover=\"f_preguntar('advertencia');\"\n");
      out.write("                             onmouseout=\"f_salir();\"/>\n");
      out.write("                    </td>\n");
      out.write("\n");
      out.write("                    <td align=\"center\">\n");
      out.write("                        <img src=\"firefox.png\" style=\"width:70px;\"\n");
      out.write("                             onmouseover=\"f_preguntar('firefox');\"\n");
      out.write("                             onmouseout=\"f_salir();\"/>\n");
      out.write("                    </td>\n");
      out.write("\n");
      out.write("                    <td align=\"center\">\n");
      out.write("                        <img src=\"disco.png\" style=\"width:70px;\"\n");
      out.write("                             onmouseover=\"f_preguntar('disco');\"\n");
      out.write("                             onmouseout=\"f_salir();\"/>\n");
      out.write("                    </td>\n");
      out.write("\n");
      out.write("                </tr>\n");
      out.write("                \n");
      out.write("            </table>\n");
      out.write("\n");
      out.write("            <br/><br/>\n");
      out.write("\n");
      out.write("            <div id=\"cajaTexto\" style=\"font-size:0.7cm;text-align:center;border-style:double;margin:2cm 2cm 2cm 2cm\">\n");
      out.write("                --- esperando ---\n");
      out.write("            </div>\n");
      out.write("\n");
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
