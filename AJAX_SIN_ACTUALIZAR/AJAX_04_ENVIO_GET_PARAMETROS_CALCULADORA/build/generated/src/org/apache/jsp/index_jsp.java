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
      out.write("\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        \n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("\n");
      out.write("\n");
      out.write("            function f_crearNegociador(x,y) {\n");
      out.write("\n");
      out.write("                // COMPROBAR PRIMERO SI LOS NÚMEROS SON CORRECTOS.\n");
      out.write("                                \n");
      out.write("                if(\"\"==x || \"\"==y) {\n");
      out.write("                    alert(\"ERROR, LOS CAMPOS X,Y NO PUEDEN ESTAR VACIOS\");\n");
      out.write("                    return;\n");
      out.write("                }\n");
      out.write("                \n");
      out.write("                if(isNaN(x) || isNaN(y)) {\n");
      out.write("                    alert(\"ERROR, DEBES INTRODUCIR VALOR NUMÉRICO EN X,Y\");\n");
      out.write("                    return;\n");
      out.write("                }\n");
      out.write("\n");
      out.write("                if(y==0) {\n");
      out.write("                    alert(\"ERROR, EL DIVISOR NO PUEDE SER 0\");\n");
      out.write("                    return;\n");
      out.write("                }\n");
      out.write("\n");
      out.write("                alert(\"VALORES CORRECTOS ... X = \" + x + \" , \" + \"Y = \" + y);                \n");
      out.write("                \n");
      out.write("                if(window.XMLHttpRequest) {\n");
      out.write("                    negociador = new XMLHttpRequest();\n");
      out.write("                } else {\n");
      out.write("                    negociador = new ActiveXObject(\"Microsoft.XMLHTTP\");\n");
      out.write("                }\n");
      out.write("                \n");
      out.write("                if (negociador != null) {\n");
      out.write("                    f_configurarNegociador(x,y);\n");
      out.write("                    f_conectarNavegadorServidor();\n");
      out.write("                }\n");
      out.write("                \n");
      out.write("            }\n");
      out.write("\n");
      out.write("\n");
      out.write("            \n");
      out.write("            function f_configurarNegociador(x,y) {\n");
      out.write("                \n");
      out.write("                // AÑADIR LOS PARÁMETROS A LA URL DE LA PETICIÓN EN FORMA DE QUERY-STRING (?x=1&y=2).\n");
      out.write("              \n");
      out.write("                // NOTA: LO MÁS CONVENIENTE SERÍA REALIZAR EL ENVÍO EN MODO POST (REQUIERE DE UNA CABECERA HTTP),\n");
      out.write("                // ALGO QUE SE MOSTRARÁ EN EL SIGUIENTE EJERCICIO (EL PRESENTE HACE USO DEL MODO GET CON LO QUE\n");
      out.write("                // NO PODREMOS INTRODUCIR NINGÚN PARÁMETRO EN EL MÉTODO send() DEL NEGOCIADOR).\n");
      out.write("\n");
      out.write("                // CONSTRUIR LA URL A SER LANZADA POR AJAX (es aquí dónde están los parámetros ... send(null)).\n");
      out.write("                var url = \"ServletCalculadoraXML\" + \"?\" + \"x=\" + x + \"&\" + \"y=\" + y;\n");
      out.write("                alert(\"URL QUE SE LANZA:\\n\" + url)\n");
      out.write("                negociador.open(\"GET\",url);\n");
      out.write("                \n");
      out.write("                // FUNCIÓN DE RETORNO (sólo cuando los datos estén disponibles se procesará la respuesta):\n");
      out.write("                // SE CARGA UNA PROPIEDAD DEL OBJETO XmlHttpRequest CON UNA FUNCIÓN.\n");
      out.write("                negociador.onreadystatechange = function() {\n");
      out.write("                    if (negociador.readyState==4 && negociador.status==200) {                       \n");
      out.write("                        // Crear un objeto que represente el fichero XML devuelto por el Servlet.\n");
      out.write("                        // Se obtendrá éste de la propiedad responseXML del negociador Ajax.\n");
      out.write("                        var xml = negociador.responseXML;\n");
      out.write("                        \n");
      out.write("                        // Datos de la respuesta del servidor ... un conjunto de etiquetas obtenidas del anterior fichero XML.\n");
      out.write("                        var arrayResultados         = xml.getElementsByTagName(\"resultados\");\n");
      out.write("                        \n");
      out.write("                        // Referenciar los elementos <label> de la página del cliente (se rellenarán respetando el orden de escritura).\n");
      out.write("                        // En total son 4, uno para cada operación + - * / (también les podríamos haber dado un id a cada uno de ellos,\n");
      out.write("                        // pero se busca el practicar cómo recorrer los elementos dentro del array).\n");
      out.write("                        var arrayLabelsDocumento    = document.getElementsByTagName(\"label\");\n");
      out.write("\n");
      out.write("                        for(var x=0; x < arrayResultados.length; x++) {\n");
      out.write("                            // Utilizamos los elementos obtenidos a partir del documento de respuesta XML\n");
      out.write("                            // para dar valor a las etiquetas <label> de la página. Recorrer el array.\n");
      out.write("                            \n");
      out.write("                            // Ejemplo: Si elegimos como datos de la petición x=3 y=2:\n");
      out.write("                            //      EL PRIMER LABEL (SUMA),\n");
      out.write("                            //      RELLENARLO CON EL VALOR DEL PRIMER NODE (<resultados>5</resultados>) ... \"5\".\n");
      out.write("\n");
      out.write("                            // Rellenar el valor del nodo de tipo <label> con el resultado de la suma (valor del primer nodo\n");
      out.write("                            // <resultados> del XML recuperado):\n");
      out.write("                            arrayLabelsDocumento[x].innerHTML = arrayResultados[x].firstChild.nodeValue;\n");
      out.write("                            \n");
      out.write("                            // El uso de .data es más aconsejable que .nodeValue por eficiencia, pero a su vez, .nodeValue\n");
      out.write("                            // supera a la opción .data en lo relacionado con temas de COMPATIBILIDAD entre navegadores:\n");
      out.write("                            \n");
      out.write("                            /*\n");
      out.write("                             The nodeValue property is the best way of manipulating the value of nodes - preferable\n");
      out.write("                             over more specialized properties, such as data or value, because of various browser issues.\n");
      out.write("                \n");
      out.write("                             The nodeValue field is defined for all Nodes and maps to different things depending on the\n");
      out.write("                             node type. The data field is defined on Nodes that inherit from CharacterData, which is to\n");
      out.write("                             say Text, CDATASection, and Comment nodes. For those three node types, nodeValue maps straight\n");
      out.write("                             to data. I know it's weird, but the DOM does have quite a few such irrelevant duplication due \n");
      out.write("                             to trying to make the vendors happy back then.                \n");
      out.write("                            */\n");
      out.write("                        }\n");
      out.write("\n");
      out.write("                    }\n");
      out.write("                    \n");
      out.write("                }\n");
      out.write("                \n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            \n");
      out.write("            \n");
      out.write("            function f_calcular() {\n");
      out.write("                // OBTENER EL VALOR DE LOS PARÁMETROS A ENVIAR AL SERVLET, PARA AÑADIRLOS A LA URL LANZADA.\n");
      out.write("                var x = document.getElementById(\"cajaX\").value.trim();\n");
      out.write("                var y = document.getElementById(\"cajaY\").value.trim();                \n");
      out.write("                f_crearNegociador(x,y);\n");
      out.write("            }\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            function f_conectarNavegadorServidor() {\n");
      out.write("                negociador.send(null);\n");
      out.write("            }\n");
      out.write("\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("        \n");
      out.write("        <!-- ESTILO COMÚN DE LAS CELDAS DE LA TABLA - USO DE UN ESTILO \"INCRUSTADO\" O DECLARADO EN EL HEAD DEL DOCUMENTO -->\n");
      out.write("        <style type=\"text/css\">\n");
      out.write("            td{text-align:center; width:3cm; height:1.5cm;}\n");
      out.write("            label{color:red;font-weight:bold}\n");
      out.write("        </style>\n");
      out.write("        \n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    \n");
      out.write("    \n");
      out.write("    <body onload=\"document.getElementById('cajaX').focus();\">\n");
      out.write("\n");
      out.write("        <center>\n");
      out.write("            \n");
      out.write("            <h3 style=\"color:blue\">\n");
      out.write("                *** INTRODUCE 2 VALORES Y LUEGO PULSA CALCULAR ***\n");
      out.write("            </h3>\n");
      out.write("            \n");
      out.write("            <h5 style=\"color:blue\">\n");
      out.write("                *** ENVIO DE PARAMETROS USANDO GET (no cambia la url del navegador\n");
      out.write("                        porque no hay recarga de pagina) ***\n");
      out.write("            </h5>\n");
      out.write("            \n");
      out.write("            <br><br>\n");
      out.write("            \n");
      out.write("            <!-- 4 columnas de ancho -->\n");
      out.write("            <table border=\"1\" style=\"background-color:silver;\">\n");
      out.write("                \n");
      out.write("                <tr style=\"background-color:orange\">\n");
      out.write("                    <td colspan=\"2\">\n");
      out.write("                        <!-- Para hacer uso de las cajas X e Y usaremos el identificador id (cajaX, cajaY) -->\n");
      out.write("                        <!-- RECORDAR QUE HEMOS COLOCADO LOS PARÁMETROS DIRECTAMENTE EN LA URL DE AJAX PORQUE USAMOS GET -->\n");
      out.write("                        X: <input type=\"text\" id=\"cajaX\" value=\"\" size=\"3\" maxlength=\"3\" style=\"color:red;\"/>\n");
      out.write("                    </td>\n");
      out.write("                    <td colspan=\"2\">\n");
      out.write("                        Y: <input type=\"text\" id=\"cajaY\" value=\"\" size=\"3\" maxlength=\"3\" style=\"color:red;\"/>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td>\n");
      out.write("                        <!-- Depositaremos los valores de las operaciones en las siguientes etiquetas <label>, sin hacer uso\n");
      out.write("                                de id. En su lugar usaremos document.getElementsByTagName(\"label\") y su orden de escritura\n");
      out.write("                                en el documento -->\n");
      out.write("                        SUMA: <label></label>\n");
      out.write("                    </td>\n");
      out.write("                    \n");
      out.write("                    <td>\n");
      out.write("                        RESTA: <label></label>\n");
      out.write("                    </td>\n");
      out.write("                    \n");
      out.write("                    <td>\n");
      out.write("                        MULT: <label></label>                        \n");
      out.write("                    </td>\n");
      out.write("                    \n");
      out.write("                    <td>\n");
      out.write("                        DIV: <label></label>                        \n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td colspan=\"4\">\n");
      out.write("                        <input type=\"button\"\n");
      out.write("                               value=\"CALCULAR\"\n");
      out.write("                               style=\"text-align:center;font-weight:bold;color:blue;background-color:gold;border-style:outset;\"\n");
      out.write("                               onclick=\"f_calcular();\"/>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                \n");
      out.write("            </table>\n");
      out.write("            \n");
      out.write("            <br/><br/>\n");
      out.write("                        \n");
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
