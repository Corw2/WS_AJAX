package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Date;

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
      out.write("    </head>\n");
      out.write("\n");
      out.write("    \n");
      out.write("    <body>\n");
      out.write("        <center>\n");
      out.write("\n");
      out.write("            <h1> RECURSO EXTERNO EN FUNCIONAMIENTO </h1>\n");
      out.write("            \n");
      out.write("            <br/><br/><br/>\n");
      out.write("            \n");
      out.write("            <p style=\"font-size:2cm;color:blue;\">\n");
      out.write("                \n");
      out.write("                \n");
      out.write("                ");
                     
                    // INTRODUCIMOS DIRECTAMENTE CÓDIGO JAVA EN LA PÁGINA (VISTA) MEDIANTE EL USO DE
                    //      SCRIPTLET's ... ES UNA TÉCNICA OBSOLETA Y TOTALMENTE DESACONSEJABLE DE
                    //      CARA A MANTENIMIENTO. EN SU LUGAR, DEBERIAMOS UTILIZAR ACCIONES JSP, J.S.T.L,
                    //      EXPRESIONES DEL LENGUAJE, CUSTOM-TAGS ... etc, ALGO QUE SE VERÁ EN LOS EJERCICIOS
                    //      CORRESPONDIENTES AL MÓDULO DE JSP's.

                    // TODO EL CONTENIDO DE LA PÁGINA SERÁ INCLUÍDO COMO RECURSO EXTERNO ALLÍ DÓNDE SE SOLICITE.
                                              
                    response.setContentType("text/html");
                    
                    // Observar la importación del objeto java.util.Date en la directiva de página.
                    // Los métodos de Date están deprecados pero son de fácil uso:
                    Date fecha = new Date();
                    String hora = fecha.getHours() + " : " + fecha.getMinutes();
                    out.println("HORA: <br/>" + hora);
                
      out.write("\n");
      out.write("                \n");
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
