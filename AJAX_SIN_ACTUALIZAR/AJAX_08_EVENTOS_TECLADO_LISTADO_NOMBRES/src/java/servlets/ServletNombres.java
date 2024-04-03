package servlets;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletNombres extends HttpServlet {

    // Definir una colección que almacenará los nombres registrados (tipo Set, no admite repetidos).
    // Es un atributo del Servlet (sólo se instanciará 1 vez), de forma que tendrá un comportamiento
    // ESTÁTICO para todos sus hilos cliente.    
    private final Set<String> nombresAlmacenadosSet;

    
    // CONSTRUCTOR PÚBLICO SIN ARGUMENTOS.
    public ServletNombres() {
        System.out.println("SE CREA EL HASHSET(no repetidos) DE NOMBRES");
        
        // NOTA: No olvidar rellenar la referencia global o al ejecutar obtendremos NullPointerException.
        nombresAlmacenadosSet = new HashSet<String>();
        
        // VALORES POR DEFECTO:
        System.out.println("SE RELLENA POR DEFECTO CON Ana, Alberto y Antonio, PARA REALIZAR PRUEBAS");
        nombresAlmacenadosSet.add("Ana");
        nombresAlmacenadosSet.add("Alberto");
        nombresAlmacenadosSet.add("Antonio");
    }

    
    // MÉTODOS DE NEGOCIO SOBRE LA COLECCIÓN SET DE NOMBRES.
    private void añadir(String nuevoNombre) {
        // Añadir un nuevo nombre al HashSet.
        nombresAlmacenadosSet.add(nuevoNombre);
    }
    
    private void borrarTodo() {
        // Vaciar el HashSet.
        nombresAlmacenadosSet.clear();
    }
    
    

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        
        // UNA ARQUITECTURA MVC PODRÍA SIMPLIFICAR EL CÓDIGO REPARTIENDO LAS TAREAS BORRAR, ALTA Y CONSULTA ENTRE
        // DIVERSOS SERVLETS DESPACHADORES, EN LUGAR DE HACERLO TODO EN EL ACTUAL. AQUÍ SE HACE USO DE UNA SERIE
        // DE PARÁMETROS QUE SE AÑADEN A LA URL CON LA QUE SE LLAMA AL SERVLET PARA DETECTAR LA OPERACIÓN QUE SE
        // DESEA REALIZAR.
        
        // PARÁMETRO:
        //      borrarTodo      ... elimina todos los nombres registrados en la colección (Set - no repetidos).
        //      nuevoNombre     ... añade un nuevo nombre a la colección de los ya registrados (Set).
        //      'si ninguno'    ... devuelve una nueva colección con los nombres registrados coincidentes (List).
        
        // BORRAR TODO ... DETECTAR SI VIENE EN LA PETICIÓN EL PARÁMETRO "borrarTodo":
        if(request.getParameter("borrarTodo") != null) {
            borrarTodo();
            return;     // SALIR.
        } 
        
                
        // OBTENER DE LA PETICIÓN EL VALOR DE LA CAJA DE TEXTO "nombre":
        String nombre = request.getParameter("nombre");
                       
        // AGREGAR ... DETECTAR SI VIENE EN LA PETICIÓN EL PARÁMETRO "nuevoNombre", SI NO, LO QUE SE ESTÁ PIDIENDO
        // ES UNA CONSULTA DE LOS NOMBRES ALMACENADOS QUE SEAN COINCIDENTES CON EL TEXTO ESCRITO EN LA CAJA NOMBRE:
        if (request.getParameter("nuevoNombre") != null) {
            añadir(nombre);
            return;
        }

        // IMPRIMIR LISTADO DE NOMBRES COINCIDENTES:
        // Creamos una variable local al método service, luego se ubicará ésta en la pila de ejecución de
        // cada hilo cliente y con cada petición que haga. Se destruirá al finalizar dicha petición (todos
        // son independientes entre si). Marcamos con género <String> para evitar la necesidad de casting y
        // conseguir homogeneidad en los datos almacenados en la colección. 

        // EN ESTE CASO SE UTILIZARÁ UN LIST EN LUGAR DE UN SET (los datos no son repetidos puesto que se han
        // obtenido de un Set).
        List<String> nombresCoincidentesList = new ArrayList<String>();        
        
        // Obtener todos los nombres ya almacenados/registrados en la colección HashSet.
        Iterator<String> it = nombresAlmacenadosSet.iterator();
        
        while(it.hasNext()) {
            // Se revisan los nombres almacenados uno por uno.
            String nombreAlmacenado = it.next();
            System.out.println("COMPROBANDO NOMBRE ALMACENADO EN EL HASHSET ---> " + nombreAlmacenado);

            // COMPROBAR QUE EL NOMBRE YA ALMACENADO NO ES MÁS CORTO QUE EL QUE ENVÍA EL CLIENTE (SI LO
            // CORTAMOS GENERARÍA UNA EXCEPCIÓN).
            
            // EJ: El usuario escribe "Ana" y tenemos en el HashSet "Ana Maria" y "Ana Isabel" ... ambos
            // valores se deben mostrar.
            
            // Si ahora recibieramos "Ana M", no se deberían cortar los nombres ya almacenados de longitud
            // inferior a 5 ("Ana" por  ejemplo), ya que daría error. Así, cortar sólo los nombres almacenados
            // de longitud igual o superior al entrante (los más pequeños quedan descartados).

            if(nombreAlmacenado.length() >= nombre.length()) {
                
                // NO PEDIR MÁS DE LO QUE SE HA RECIBIDO POR EL PARÁMETRO nombre.
                String letras = nombreAlmacenado.substring(0,nombre.length());
                
                // COMPROBAR SI COINCIDEN (no importan mayúsculas o minúsculas).
                if(nombre.equalsIgnoreCase(letras)) {
                    
                    // MOSTRAREMOS TODOS LOS NOMBRES ALMACENADOS CUYAS LETRAS INICIALES COINCIDAN
                    // CON LAS DEL NOMBRE ENTRANTE, EL ESCRITO EN LA CAJA DE TEXTO "nombre".
                    // (Es un efecto similar al del buscador de Google). PARA ELLO, RELLENAMOS UNA NUEVA
                    // COLECCIÓN DE TIPO ArrayList<String> CON AQUELLOS NOMBRES ALMACENADOS QUE COINCIDAN
                    // CON EL ENTRANTE (se compara letra a letra hasta llegar a la longitud del nombre
                    // entrante sin que en este caso importen las mayúsculas/minúsculas).
                    
                    System.out.println("(+) EL NOMBRE ALMACENADO ... " + nombreAlmacenado +
                                            " ... SE HA AÑADIDO A LA LISTA DE LOS COINCIDENTES");                    
                    
                    nombresCoincidentesList.add(nombreAlmacenado);
                
                } else {
                    System.out.println(">>>>> EL NOMBRE ALMACENADO ... " + nombreAlmacenado +
                                            " ... SE HA DESCARTADO POR CONTENIDO");
                }
                
            } else {
                System.out.println(">>>>> EL NOMBRE ALMACENADO ... " + nombreAlmacenado + 
                                            " ... SE HA DESCARTADO POR LONGITUD");
            }
            
        }

        System.out.println("===================================================");

        System.out.println("LISTADO DE LOS QUE COINCIDEN CON  " + nombre + " ---> " + nombresCoincidentesList);
        
        System.out.println("===================================================");

        
        // CREAR EL XML CON LOS DATOS ... NOMBRES QUE COINCIDEN CON LO QUE HA ESCRITO EL CLIENTE.
        
        response.setContentType("text/xml");
        
        PrintWriter escritor = response.getWriter();        

        // NO DEBEMOS AÑADIR ESPACIOS EN BLANCO NI SALTOS DE LÍNEA PORQUE FORMAN NODOS EN EL DOM DE XML,
        // LO QUE HARÁ QUE NO PODAMOS LEERLO CON SENCILLEZ EN EL NAVEGADOR CLIENTE (JavaScript).
        
        // Documento XML a ser envíado al cliente.
        escritor.print("<?xml version='1.0' encoding='UTF-8'?>");
    
        // Etiqueta raíz.
        escritor.print("<datos>");
        
        // Obtener los nombres coincidentes 1 a 1 y envolverlos con un elemento <nombre>.
        it = nombresCoincidentesList.iterator();
        
        while(it.hasNext()) {
            escritor.print("<nombre>");
            escritor.print(it.next());
            escritor.print("</nombre>");    
        }        
        
        // Cierre de la etiqueta raíz.
        escritor.print("</datos>");

        // Enviar del documento.
        escritor.flush();
        escritor.close();
        
    }

}