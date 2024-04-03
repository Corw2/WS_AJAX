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
      out.write("        \n");
      out.write("        <title>JSP Page</title>\n");
      out.write("\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            \n");
      out.write("            // NEGOCIADOR GLOBAL, EL MISMO PARA TODAS LAS PETICIONES ... GENERARÁ PROBLEMAS SI\n");
      out.write("            // AÚN NO SE HA RECIBIDO LA RESPUESTA DE UNA PETICIÓN ANTERIOR Y SOLICITAMOS UNA NUEVA.\n");
      out.write("            \n");
      out.write("            // *** ES VARIABLE GLOBAL (comportamiento estático ... el mismo negociador para todos los clientes) ***\n");
      out.write("            // ÉSTA NO ES LA FORMA ADECUADA DE PROGRAMAR. CADA CLIENTE DEBERÍA TENER SU PROPIO NEGOCIADOR AJAX, AÚN\n");
      out.write("            // A PESAR DE QUE PUEDA HABER UN ELEVADO CONSUMO DE RECURSOS (1 POR CLIENTE EN LUGAR DE 1 PARA TODOS).\n");
      out.write("            // \n");
      out.write("            // LA ÚLTIMA PETICIÓN CLIENTE QUE USE EL CANAL DE ENVÍO DEL NEGOCIADOR GLOBAL \"MACHARÁ\" LOS DATOS DEL\n");
      out.write("            // ANTERIOR CLIENTE QUE NO HAYA COMPLETADO SU PETICIÓN (SE USA EL RETARDO PARA SIMULARLO). ASÍ, SI\n");
      out.write("            // PULSAMOS RÁPIDAMENTE EL BOTÓN DE ENVÍO GLOBAL, VEREMOS CÓMO POR EJEMPLO, PASAMOS DEL 1 AL 5,\n");
      out.write("            // PERDIÉNDOSE LAS RESPUESTAS DEL 2,3 Y 4 ... VERIFICAR EL COMPORTAMIENTO EN DISTINTOS NAVEGADORES.\n");
      out.write("            \n");
      out.write("            // RESPECTO AL SERVLET, POR CADA PETICIÓN CLIENTE SE CREARÁ UN HILO DE EJECUCIÓN PARA ATENDERLA. SÓLO SE\n");
      out.write("            // CREARÁ UNA INSTANCIA DEL SERVLET (salvo si se implementa la interfaz SingleThreadModel - deprecated),\n");
      out.write("            // QUE SERÁ USADA POR TODOS Y CADA UNO DE DICHOS HILOS CLIENTE.\n");
      out.write("            \n");
      out.write("            \n");
      out.write("            \n");
      out.write("            ///// 1. NEGOCIADOR AJAX GLOBAL /////\n");
      out.write("            \n");
      out.write("            // SE DECLARA LA VARIABLE COMO GLOBAL. UN SOLO CANAL DE RESPUESTA COMPARTIDO POR TODOS.\n");
      out.write("            \n");
      out.write("            var negociadorGlobal;\n");
      out.write("\n");
      out.write("            function f_crearNegociadorGlobal() {\n");
      out.write("                \n");
      out.write("                if(window.XMLHttpRequest) {\n");
      out.write("                    negociadorGlobal = new XMLHttpRequest();\n");
      out.write("                } else {\n");
      out.write("                    negociadorGlobal = new ActiveXObject(\"Microsoft.XMLHTTP\");\n");
      out.write("                }\n");
      out.write("                \n");
      out.write("                if(negociadorGlobal != null) {\n");
      out.write("                    negociadorGlobal.open(\"GET\",\"ServletContadorNegociadorGlobal\");\n");
      out.write("                    negociadorGlobal.onreadystatechange = function() {\n");
      out.write("                        if (negociadorGlobal.readyState==4 && negociadorGlobal.status==200) {\n");
      out.write("                            var respuesta = negociadorGlobal.responseText;\n");
      out.write("                            // CONCATENAR EL CONTENIDO ACTUAL CON EL NUEVO CORRESPONDIENTE A LA RESPUESTA.\n");
      out.write("                            document.getElementById(\"cajaNegociadorGlobal\").innerHTML += respuesta;\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                    negociadorGlobal.send(null);                                \n");
      out.write("                }\n");
      out.write("            \n");
      out.write("            }\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            ///// 2. NEGOCIADOR AJAX LOCAL /////\n");
      out.write("\n");
      out.write("            // NEGOCIADOR LOCAL ... UN OBJETO XmlHttpRequest POR CADA PETICIÓN.\n");
      out.write("            // SE CONSIGUE SIMPLEMENTE UTILIZANDO LA VARIABLE NEGOCIADOR DE FORMA\n");
      out.write("            // LOCAL, DECLARÁNDOLA DENTRO DE LA FUNCIÓN.\n");
      out.write("\n");
      out.write("            function f_crearNegociadorLocal() {\n");
      out.write("\n");
      out.write("                // *** ES VARIABLE LOCAL (cada petición cliente tiene su propio negociador) ***                \n");
      out.write("\n");
      out.write("                // CADA CLIENTE TIENE SU PROPIO CANAL DE RESPUESTA.\n");
      out.write("\n");
      out.write("                var negociadorLocal; \n");
      out.write("\n");
      out.write("                if(window.XMLHttpRequest) {\n");
      out.write("                    negociadorLocal = new XMLHttpRequest();\n");
      out.write("                } else {\n");
      out.write("                    negociadorLocal = new ActiveXObject(\"Microsoft.XMLHTTP\");\n");
      out.write("                }\n");
      out.write("                \n");
      out.write("                if(negociadorLocal != null) {\n");
      out.write("                    negociadorLocal.open(\"GET\",\"ServletContadorNegociadorLocal\");\n");
      out.write("                    negociadorLocal.onreadystatechange = function() {\n");
      out.write("                        if (negociadorLocal.readyState==4 && negociadorLocal.status==200) {\n");
      out.write("                            var respuesta = negociadorLocal.responseText;\n");
      out.write("                            // CONCATENAR EL CONTENIDO ACTUAL CON EL NUEVO CORRESPONDIENTE A LA RESPUESTA.\n");
      out.write("                            document.getElementById(\"cajaNegociadorLocal\").innerHTML += respuesta;\n");
      out.write("                        }\n");
      out.write("                    }                                \n");
      out.write("                    negociadorLocal.send(null);\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("        </script>\n");
      out.write("        \n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    \n");
      out.write("    \n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <center>\n");
      out.write("\n");
      out.write("            <h1> NEGOCIADORES AJAX: GLOBAL - INDIVIDUAL </h1>\n");
      out.write("\n");
      out.write("            <h3> PULSA LOS BOTONES LENTA Y RAPIDAMENTE OBSERVANDO EN CADA CASO EL RESULTADO </h3>\n");
      out.write("            \n");
      out.write("            <br/><br/>\n");
      out.write("\n");
      out.write("            <input type=\"button\" value=\"NEGOCIADOR GLOBAL\" onclick=\"f_crearNegociadorGlobal();\"/>\n");
      out.write("            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n");
      out.write("            <input type=\"button\" value=\"NEGOCIADOR INDIVIDUAL\" onclick=\"f_crearNegociadorLocal();\"/>\n");
      out.write("\n");
      out.write("            <br/><br/>\n");
      out.write("            \n");
      out.write("            <div id=\"cajaNegociadorGlobal\" style=\"border-style:solid;border-color:red;border-width:0.2cm\"></div>\n");
      out.write("            \n");
      out.write("            <br/><br/>\n");
      out.write("            \n");
      out.write("            <div id=\"cajaNegociadorLocal\" style=\"border-style:solid;border-color:greenyellow;border-width:0.2cm\"></div>\n");
      out.write("            \n");
      out.write("            <br/><br/><br/>\n");
      out.write("            \n");
      out.write("            <p> REALIZAR UN DEPLOY DE LA APLICACION (elimina los Servlets) PARA VOLVERLO A PROBAR </p>\n");
      out.write("\n");
      out.write("            \n");
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
