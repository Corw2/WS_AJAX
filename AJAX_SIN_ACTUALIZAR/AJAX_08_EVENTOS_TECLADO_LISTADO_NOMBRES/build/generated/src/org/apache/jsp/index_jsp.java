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
      out.write("    \n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        \n");
      out.write("        <title>JSP Page</title>\n");
      out.write("\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("\n");
      out.write("            function f_crearNegociador(URL) {\n");
      out.write("\n");
      out.write("                // NEGOCIADOR AJAX DEFINIDO LOCALMENTE.\n");
      out.write("                var negociador;\n");
      out.write("                \n");
      out.write("                if(window.XMLHttpRequest) {\n");
      out.write("                    negociador = new XMLHttpRequest();\n");
      out.write("                } else {\n");
      out.write("                    negociador = new ActiveXObject(\"Microsoft.XMLHTTP\");\n");
      out.write("                }\n");
      out.write("               \n");
      out.write("                if(negociador != null) {\n");
      out.write("\n");
      out.write("                    //alert(\"CREADO NEGOCIADOR ... URL = \" + URL);\n");
      out.write("\n");
      out.write("                    negociador.open(\"GET\",URL);\n");
      out.write("                    \n");
      out.write("                    negociador.onreadystatechange = function() {\n");
      out.write("                        if (negociador.readyState==4 && negociador.status==200) {\n");
      out.write("                            \n");
      out.write("                            var datosXML = negociador.responseXML;\n");
      out.write("                            var nombres = datosXML.getElementsByTagName(\"nombre\"); // array de <nombre>XXX</nombre>\n");
      out.write("                            var texto = \"\";\n");
      out.write("                            \n");
      out.write("                            // Comprobar que hay nodos nombre para actualizar con ellos la capa \"cajaNombresCoincidentes\".\n");
      out.write("                            if(nombres != null && nombres.length > 0) {\n");
      out.write("                                for(var x=0; x<nombres.length; x++) {\n");
      out.write("                                    // Recuperar el valor de texto de cada nodo y añadirle un salto de línea.\n");
      out.write("                                    // Observar como la siguiente línea se repite a lo largo de los distintos ejercicios,\n");
      out.write("                                    // utilizándose para recuperar el valor final (texto) del nodo:\n");
      out.write("                                    texto += nombres[x].firstChild.data + \"<br/>\";\n");
      out.write("                                }\n");
      out.write("                            \n");
      out.write("                                // Actualizar la caja de nombres coincidentes.\n");
      out.write("                                document.getElementById(\"cajaNombresCoincidentes\").innerHTML = texto;\n");
      out.write("                            }\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("\n");
      out.write("                    // LANZAR EL NEGOCIADOR CONTRA EL SERVLET DEL SERVIDOR (modo GET, los parámetros en la URL).\n");
      out.write("                    negociador.send(null);\n");
      out.write("\n");
      out.write("                }                                \n");
      out.write("            }\n");
      out.write("\n");
      out.write("\n");
      out.write("            function f_comprobarNombres(evento) {\n");
      out.write("\n");
      out.write("                // TECLA BORRAR ... keyCode = 8\n");
      out.write("\n");
      out.write("                //alert(\"parametro evento --> \" + evento);      // FUNCIONA EN MOZILLA Y EN EXPLORER.\n");
      out.write("                //alert(\"window.event ---> \" + window.event);   // SÓLO FUNCIONA EN EXPLORER.\n");
      out.write("                //alert(\"tipo evento = \" + evento.type);        // DETECTAR EL TIPO DE EVENTO (le quita el on) onkeyup -> keyup.\n");
      out.write("                //alert(\"codigo keyCode = \" + evento.keyCode);  // DETECTAR LA TECLA PULSADA ... indica un número ('DELETE' == 8).\n");
      out.write("                      \n");
      out.write("                // Si la caja del nombre está vacia y la tecla pulsada es borrar (keyCode 8), entonces\n");
      out.write("                // borrar el contenido de la caja de coincidentes y dar el foco a la caja del nombre.\n");
      out.write("                if(document.getElementById(\"cajaNombre\").value.trim() == \"\" && evento.keyCode == 8) { \n");
      out.write("                    document.getElementById(\"cajaNombresCoincidentes\").innerHTML = \"\";\n");
      out.write("                    document.getElementById(\"cajaNombre\").focus();\n");
      out.write("                    return;\n");
      out.write("                }\n");
      out.write("                \n");
      out.write("                // Si la caja del nombre aún no está vacia y/o la tecla pulsada es borrar, comprobar si hay\n");
      out.write("                // nombres coincidentes con el texto que quede. Así, YA SEA INTRODUCIENDO NUEVO TEXTO EN LA CAJA\n");
      out.write("                // DEL NOMBRE O BORRANDO PARTE DEL YA ESCRITO, SE HABRÁ DE LANZAR LA COMPROBACIÓN DE COINCIDENTES\n");
      out.write("                // CONTRA EL SERVLET.\n");
      out.write("                \n");
      out.write("                // Obtener el valor actual de la caja del nombre (borrar espacios blancos al inicio y al final).\n");
      out.write("                var valorCajaNombre = document.getElementById(\"cajaNombre\").value.trim();\n");
      out.write("\n");
      out.write("                // La URL lanzada contendrá por GET el parámetro con el valor actual de la caja del nombre.\n");
      out.write("                // MODO GET CON PARÁMETROS EN LA URL.\n");
      out.write("                var URL = \"ServletNombres?nombre=\" + valorCajaNombre;\n");
      out.write("                               \n");
      out.write("                // Se enviará la petición automáticamente, de forma que cada vez que cambie el contenido de la\n");
      out.write("                // caja de nombre (escribimos algo en ella), se genere la comprobación de nombres.\n");
      out.write("                // No resulta útil el control del evento ONCHANGE ya que éste no se activará hasta que la caja\n");
      out.write("                // pierda el foco (evento ONBLUR).\n");
      out.write("                f_crearNegociador(URL);\n");
      out.write("\n");
      out.write("            }\n");
      out.write("\n");
      out.write("\n");
      out.write("            function f_agregarNuevoNombre() {\n");
      out.write("                \n");
      out.write("                if(document.getElementById(\"cajaNombre\").value.trim() == \"\") {\n");
      out.write("                    alert(\"ERROR. DEBES INTRODUCIR TEXTO EN EL CAMPO NOMBRE\");\n");
      out.write("                    document.getElementById(\"cajaNombre\").value=\"\"; // reset.\n");
      out.write("                    document.getElementById(\"cajaNombre\").focus();\n");
      out.write("                    return;\n");
      out.write("                }\n");
      out.write("\n");
      out.write("                // Obtener el nombre que queremos almacenar. El servidor comprobará si está repetido.\n");
      out.write("                var valorCajaNombre = document.getElementById(\"cajaNombre\").value.trim();\n");
      out.write("               \n");
      out.write("                // Si llegados al Servlet se detectase la presencia del parámetro nuevoNombre en la petición,\n");
      out.write("                // se procederá a guardar el mismo en la colección de tipo Set<String>.\n");
      out.write("                alert(\"INTENTO GUARDAR UN NUEVO NOMBRE ... \" + valorCajaNombre);\n");
      out.write("\n");
      out.write("                var URL = \"ServletNombres?nombre=\" + valorCajaNombre + \"&nuevoNombre=true\"; // PARÁMETRO DE OPERACIÓN.\n");
      out.write("                document.getElementById(\"cajaNombre\").value = \"\";\n");
      out.write("                document.getElementById(\"cajaNombre\").focus();\n");
      out.write("            \n");
      out.write("                f_crearNegociador(URL);\n");
      out.write("\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            \n");
      out.write("            function f_borrarTodo() {\n");
      out.write("\n");
      out.write("                // Si llegados al Servlet se detectase la presencia del parámetro \"borrarTodo\" en la petición,\n");
      out.write("                // se invocará al método clear() sobre el Set<String> del servidor, eliminándose todos los nombres\n");
      out.write("                // almacenados actualmente en la lista.\n");
      out.write("                \n");
      out.write("                var URL = \"ServletNombres?borrarTodo=true\"; // PARÁMETROD DE OPERACIÓN.\n");
      out.write("                document.getElementById(\"cajaNombre\").value = \"\";                \n");
      out.write("                document.getElementById(\"cajaNombre\").focus();\n");
      out.write("                f_crearNegociador(URL);                \n");
      out.write("\n");
      out.write("            }\n");
      out.write("\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    \n");
      out.write("    \n");
      out.write("    <body onload=\"document.getElementById('cajaNombre').focus();\">        \n");
      out.write("      \n");
      out.write("        <center>\n");
      out.write("            \n");
      out.write("            <h2> LISTADO DE NOMBRES DE PERSONAS COINCIDENTES </h2>\n");
      out.write("\n");
      out.write("            <br/><br/>\n");
      out.write("\n");
      out.write("            <!-- PODEMOS COLOCAR event COMO PARÁMETRO DE LLAMADA A LA FUNCIÓN (EL EVENTO GENERADO CADA VEZ QUE SE\n");
      out.write("                 LIBERA, SE SUELTA LA TECLA PULSADA). DE ESTA FORMA, SABREMOS CUÁL FUÉ REALMENTE LA TECLA QUE SE\n");
      out.write("                 PULSÓ. EVENTO \"onkeyup\". -->\n");
      out.write("            \n");
      out.write("            NOMBRE (Mayusc/minusc): <input type=\"text\" id=\"cajaNombre\" value=\"\" size=\"20\" maxlength=\"18\" onkeyup=\"f_comprobarNombres(event);\"/>\n");
      out.write("\n");
      out.write("            <br/><br/>\n");
      out.write("\n");
      out.write("            <input type=\"button\" value=\"AGREGAR UN NUEVO NOMBRE\" onclick=\"f_agregarNuevoNombre();\">\n");
      out.write("\n");
      out.write("            <br/><br/>\n");
      out.write("\n");
      out.write("            <input type=\"button\" value=\"BORRAR TODO\" onclick=\"f_borrarTodo();\">\n");
      out.write("\n");
      out.write("            <br/><br/>        \n");
      out.write("\n");
      out.write("            <div id=\"cajaNombresCoincidentes\" style=\"color:blue;width:8cm;height:4cm;border-style:solid\"/>\n");
      out.write("\n");
      out.write("        </center>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("        \n");
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
