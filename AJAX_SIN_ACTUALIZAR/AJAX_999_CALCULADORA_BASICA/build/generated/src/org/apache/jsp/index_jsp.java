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
      out.write("    \n");
      out.write("    <head>        \n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>MASTER JAVA</title>\n");
      out.write("        \n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            \n");
      out.write("            function f_ajaxComprobar() {\n");
      out.write("                var negociador              = new XMLHttpRequest();\n");
      out.write("                var servletInvocado         = \"ServletComprobar\";\n");
      out.write("                var numero                  = document.getElementById(\"cajaNumero\").value;\n");
      out.write("                var urlRecursoSolicitado    = servletInvocado + \"?\"+ \"numero\" + \"=\" + numero; // GET\n");
      out.write("                \n");
      out.write("                //alert(\"RECURSO PEDIDO ... \" + urlRecursoSolicitado);\n");
      out.write("                \n");
      out.write("                // CONFIGURAR EL NEGOCIADOR A LA IDA.\n");
      out.write("                negociador.open(\"GET\",urlRecursoSolicitado);\n");
      out.write("\n");
      out.write("                // CONFIGURAR EL NEGOCIADOR PARA CUANDO VUELVA ... ¿QUÉ TIENE QUE HACER?.\n");
      out.write("                negociador.onreadystatechange = function() {\n");
      out.write("                    if(negociador.readyState==4 && negociador.status==200) {\n");
      out.write("                        //alert(\"MENSAJE = \" + negociador.responseText);\n");
      out.write("                        document.getElementById(\"capaResultado\").innerHTML = negociador.responseText;\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("                \n");
      out.write("                // ENVIAR EL NEGOCIADOR.\n");
      out.write("                negociador.send(null); // POST ...     .send(numero=6);\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("        </script>        \n");
      out.write("    </head>\n");
      out.write("    \n");
      out.write("    \n");
      out.write("    \n");
      out.write("    <body>\n");
      out.write("        <center>\n");
      out.write("            \n");
      out.write("            <br/><br/><br/>\n");
      out.write("\n");
      out.write("            <h2> INTRODUCE UN NUMERO ENTRE EL 1 Y 9 </h2>\n");
      out.write("            \n");
      out.write("            <input type=\"text\" id=\"cajaNumero\" value=\"\" size=\"1\" maxlength=\"1\"/>\n");
      out.write("            \n");
      out.write("            <br/><br/>\n");
      out.write("            \n");
      out.write("            <input type=\"button\" value=\"COMPROBAR\" onclick=\"f_ajaxComprobar()\"/>\n");
      out.write("        \n");
      out.write("            <br/><br/><br/>\n");
      out.write("            \n");
      out.write("            <div id=\"capaResultado\" style=\"color:blue;font-size:22px\"/>\n");
      out.write("            \n");
      out.write("        \n");
      out.write("        </center>\n");
      out.write("    </body>\n");
      out.write("\n");
      out.write("</html>\n");
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
