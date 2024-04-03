package servlets;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletFuncionAleatoria extends HttpServlet {

    private final String FUNCION_ALEATORIA_I    = "f_aleatoriaImprimirDiaSemana()";
    private final String FUNCION_ALEATORIA_II   = "f_aleatoriaImprimirAño()";

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String funcionAleatoria;

        int aleatorio = (int) (Math.random() * 2) + 1; // 1 .. n ---> [1],[2].

        System.out.println("HA SALIDO EL ..." + aleatorio);

        if (aleatorio == 1) {
            funcionAleatoria = FUNCION_ALEATORIA_I;
        } else {
            funcionAleatoria = FUNCION_ALEATORIA_II;        
        }

        System.out.println("FUNCION ALEATORIA ELEGIDA POR SERVIDOR -> " + funcionAleatoria);

        response.setContentType("text/html");
        PrintWriter escritor = response.getWriter();
        escritor.print(funcionAleatoria);
        escritor.flush();
        escritor.close();

    }

}