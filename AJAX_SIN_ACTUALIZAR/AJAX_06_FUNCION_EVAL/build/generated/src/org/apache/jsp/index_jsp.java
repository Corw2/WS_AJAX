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
      out.write("\n");
      out.write("            function f_evaluar() {\n");
      out.write("                // RECORDAR: podemos usar los elementos definidos en el BODY una vez se\n");
      out.write("                // haya cargado éste. Si declaramos la siguiente línea fuera de la presente\n");
      out.write("                // función, la variable \"caja\" valdrá null, ya que estamos procesando el HEAD,\n");
      out.write("                // cuando aún no se ha cargado el BODY.\n");
      out.write("                \n");
      out.write("                // SECUENCIA DE CARGA: 1.HEAD -> 2.BODY -> 3.Evento onload().\n");
      out.write("\n");
      out.write("                var suma = \"5 + 7\"; // Una simple cadena de texto.\n");
      out.write("                var resultado = eval(suma); // Mediante eval (evualuar) se podrá procesar el texto como si fuesen números.\n");
      out.write("                var texto = \"El resultado de \" + suma + \" = \" + resultado; \n");
      out.write("                alert(texto);\n");
      out.write("                document.getElementById(\"caja\").innerHTML = texto; // Depositar el resultado en la caja de mensajes.\n");
      out.write("            }\n");
      out.write("\n");
      out.write("\n");
      out.write("            ///////////////////////////////////////////////////////////////////////////////////////////////////\n");
      out.write("\n");
      out.write("\n");
      out.write("            function f_crearObjetoJavaScriptSuma() {\n");
      out.write("                // CREAMOS UNA VARIABLE TIPO TEXTO CON EL NOMBRE DEL METODO Y SUS PARÁMETROS:\n");
      out.write("                // ESTE TEXTO PODRÍA HABER SIDO DEVUELTO DESDE EL SERVIDOR WEB A TRAVÉS DE LA PROPIEDAD\n");
      out.write("                // responseText DEL NEGOCIADOR AJAX, TAL Y CÓMO SE HACE EN EL EJEMPLO DE LA FUNCIÓN ALEATORIA\n");
      out.write("                // DE MÁS ABAJO (así, podemos crear objetos JavaScript desde el servidor web, en forma de texto,\n");
      out.write("                // para más tarde \"activarlos\" con la función eval).\n");
      out.write("\n");
      out.write("                // Básicamente creamos un mapa propiedad - valor.\n");
      out.write("                // {propiedad_1:valor_1, propiedad_2:valor_2, ... , propiedad_n:valor_n}\n");
      out.write("                var textoObjeto = \"{metodo:'f_sumar', x:3, y:8};\"; // NO OLVIDAR LAS LLAVES QUE ENCIERRAN EL CONTENIDO.\n");
      out.write("                // \n");
      out.write("                // Así, los nombres de las propiedades serán siempre texto y los valores texto o números:\n");
      out.write("                // metodo:'f_sumar'\n");
      out.write("                // x:3\n");
      out.write("                // y:8\n");
      out.write("                               \n");
      out.write("                alert(textoObjeto);\n");
      out.write("                \n");
      out.write("                // EVALUAMOS EL TEXTO ANTERIOR PARA CREAR UN OBJETO QUE ASIGNAREMOS A UNA VARIABLE.                 \n");
      out.write("                var objetoSumador; // CREAMOS LA VARIABLE ASIGNÁNDOLE UN NOMBRE ... objetoSumador.\n");
      out.write("                \n");
      out.write("                eval('objetoSumador = ' + textoObjeto); // eval PROCESARÁ EL TEXTO Y CARGARÁ LA VARIABLE CON EL OBJETO.\n");
      out.write("                // equivale a:\n");
      out.write("                // objetoSumador = {metodo:'f_sumar', x:3, y:8};\n");
      out.write("\n");
      out.write("                alert(objetoSumador);\n");
      out.write("                \n");
      out.write("                // GENERAMOS LA LLAMADA A LA FUNCIÓN f_sumar(definida más abajo) A PARTIR DEL OBJETO CREADO:\n");
      out.write("                // Para poder obtener el valor de una determinada propiedad del objeto basta con utilizar la\n");
      out.write("                // notación del punto. Así, variable.propiedad nos devolverá el valor de la propiedad:\n");
      out.write("                var ejecutar =  objetoSumador.metodo +\n");
      out.write("                                \"(\" +\n");
      out.write("                                objetoSumador.x +\n");
      out.write("                                \",\" +\n");
      out.write("                                objetoSumador.y +\n");
      out.write("                                \")\" +\n");
      out.write("                                \";\"\n");
      out.write("                                ;\n");
      out.write("\n");
      out.write("                alert(ejecutar); // se obtiene ...     f_sumar(3,8);\n");
      out.write("                \n");
      out.write("                var resultadoSuma = eval(ejecutar); // evaluamos la cadena de texto que llamará a la función sumar.\n");
      out.write("                // equivale a:\n");
      out.write("                // var resultadoSuma = f_sumar(3,8);\n");
      out.write("                                \n");
      out.write("                alert(resultadoSuma);\n");
      out.write("            }\n");
      out.write("\n");
      out.write("\n");
      out.write("            // LA FUNCIÓN QUE SERÁ EMPLEADO POR EL OBJETO LA DEFINIMOS AQUÍ:\n");
      out.write("            function f_sumar(x,y) {\n");
      out.write("                var resultado = x + y;\n");
      out.write("                document.getElementById(\"caja\").innerHTML = x + \" + \" + y + \" = \" + resultado;\n");
      out.write("                return resultado;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            // VEMOS CÓMO DESDE EL SERVIDOR SE LE PODRÍA PEDIR AL CLIENTE QUE CREASE OBJETOS Y EJECUTASE\n");
      out.write("            // FUNCIONES JAVASCRIPT DEFINIDAS POR EL MISMO, SIMPLEMENTE ENVIÁNDOLE UNA CADENA TEXTO (la \n");
      out.write("            // función elegida de forma aleatoria del siguiente ejemplo lo pone de manifiesto).\n");
      out.write("\n");
      out.write("\n");
      out.write("            ///////////////////////////////////////////////////////////////////////////////////////////////////\n");
      out.write("\n");
      out.write("\n");
      out.write("            function f_solicitarFuncionAleatoria() {\n");
      out.write("                \n");
      out.write("                var negociador;\n");
      out.write("                \n");
      out.write("                if(window.XMLHttpRequest) {\n");
      out.write("                    negociador = new XMLHttpRequest();\n");
      out.write("                } else {\n");
      out.write("                    negociador = new ActiveXObject(\"Microsoft.XMLHTTP\");\n");
      out.write("                }\n");
      out.write("                \n");
      out.write("                if(negociador != null) {\n");
      out.write("                    negociador.open(\"GET\",\"ServletFuncionAleatoria\");\n");
      out.write("                    negociador.onreadystatechange = function() {\n");
      out.write("                        if (negociador.readyState==4 && negociador.status==200) {\n");
      out.write("                            var respuesta = negociador.responseText;\n");
      out.write("                            alert(\"EL SERVIDOR QUIERE QUE SE EJECUTE ... \" + respuesta)\n");
      out.write("                            eval(respuesta);    // Mediante eval podemos llamar a la función indicada por el\n");
      out.write("                                                // texto de vuelta, la cual debe estar definida en el cliente.\n");
      out.write("                        }                            \n");
      out.write("                    }\n");
      out.write("\n");
      out.write("                    // Lanzar la petición Ajax en modo GET.\n");
      out.write("                    negociador.send(null);\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("\n");
      out.write("\n");
      out.write("            // FUNCIONES JAVASCRIPT DECLARADAS EN EL CLIENTE.\n");
      out.write("            function f_aleatoriaImprimirDiaSemana() {\n");
      out.write("                var arrayDiasSemana = new Array(\"DOMINGO\",\"LUNES\",\"MARTES\",\"MIERCOLES\",\"JUEVES\",\"VIERNES\",\"SABADO\");\n");
      out.write("                var numeroDia = new Date().getDay(); // 0 .. 6, siendo 0 el DOMINGO;\n");
      out.write("                var texto = \"HOY ES ... \" + arrayDiasSemana[numeroDia];\n");
      out.write("                alert(texto); \n");
      out.write("                document.getElementById(\"caja\").innerHTML = texto;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            function f_aleatoriaImprimirAño() {\n");
      out.write("                var año = new Date().getFullYear();\n");
      out.write("                var texto = \"EL AÑO ES ... \" + año;\n");
      out.write("                alert(texto);\n");
      out.write("                document.getElementById(\"caja\").innerHTML = texto;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("\n");
      out.write("            // !!! IMPORTANTE !!!:\n");
      out.write("            // NO ES ACONSEJABLE QUE SEA EL SERVIDOR WEB EL QUE DECIDA EL CÓDIGO JAVASCRIPT\n");
      out.write("            // QUE SE VA A EJECUTAR EN EL CLIENTE. EL SERVIDOR DEBERÍA LIMITARSE A SIMPLEMENTE\n");
      out.write("            // ENVIAR DATOS, YA SEAN EN MODO TEXTO O XML, SIENDO EL PROPIO CLIENTE (NAVEGADOR) EL\n");
      out.write("            // QUE DECIDA QUÉ HACER CON ELLOS. (GOOGLE, CUANDO PRESENTA UN CONJUNTO DE PALABRAS A\n");
      out.write("            // MODO DE SUGERENCIA PARA LA BÚSQUEDA A REALIZAR, UTILIZA ESTE MÉTODO).\n");
      out.write("\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    \n");
      out.write("    \n");
      out.write("    <body>\n");
      out.write("        <center>\n");
      out.write("            \n");
      out.write("            <h2> UTILIZACION DE LA FUNCION eval DE JAVASCRIPT </h2>\n");
      out.write("            \n");
      out.write("            <br/><br/>\n");
      out.write("            \n");
      out.write("            <input type=\"button\" value=\"SUMA DE CARACTERES CON eval('5+7')\" onclick=\"f_evaluar();\"/>\n");
      out.write("            <br/><br/>\n");
      out.write("            <input type=\"button\" value=\"CREAR OBJETO JAVASCRIPT PARA SUMAR 3+8\" onclick=\"f_crearObjetoJavaScriptSuma();\"/>\n");
      out.write("            <br/><br/>\n");
      out.write("            <input type=\"button\" value=\"EJECUTAR FUNCION ALEATORIA (DIA/AÑO) DESDE SERVIDOR WEB\" onclick=\"f_solicitarFuncionAleatoria();\"/>\n");
      out.write("            \n");
      out.write("            <br/><br/><br/><br/>\n");
      out.write("\n");
      out.write("            <div id=\"caja\" style=\"border-style:solid;border-width:thin;color:green;font-size:0.8cm;width:9cm;height:1.5cm\">\n");
      out.write("                --- resultados ---\n");
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
