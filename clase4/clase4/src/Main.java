import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class RedSocial {
   // Grafo con lista de adyacencia: cada usuario -> lista de los que sigue
   private Map<String, List<String>> grafo;
   public RedSocial() {
       grafo = new HashMap<>();
   }
   // Agregar un nuevo usuario a la red
   public void agregarUsuario(String usuario) {
       grafo.putIfAbsent(usuario, new ArrayList<>());
   }
   // Un usuario empieza a seguir a otro
   public void seguir(String seguidor, String seguido) {
       if (!grafo.containsKey(seguidor)) {
           agregarUsuario(seguidor);
       }
       if (!grafo.containsKey(seguido)) {
           agregarUsuario(seguido);
       }
       grafo.get(seguidor).add(seguido);
   }
   // Obtener la lista de personas que sigue un usuario
   public List<String> obtenerSeguidos(String usuario) {
       return grafo.getOrDefault(usuario, new ArrayList<>());
   }
   // Obtener la lista de seguidores de un usuario
   public List<String> obtenerSeguidores(String usuario) {
       List<String> seguidores = new ArrayList<>();
       for (var entry : grafo.entrySet()) {
           String u = entry.getKey();
           List<String> seguidos = entry.getValue();
           if (seguidos.contains(usuario)) {
               seguidores.add(u);
           }
       }
       return seguidores;
   }
   // Mostrar toda la red
   public void mostrarRed() {
       for (var entry : grafo.entrySet()) {
           System.out.println(entry.getKey() + " sigue a " + entry.getValue());
       }
   }
}
public class Main {
   public static void main(String[] args) {
       RedSocial red = new RedSocial();
       // Agregamos usuarios
       red.agregarUsuario("Ana");
       red.agregarUsuario("Luis");
       red.agregarUsuario("Maria");
       // Relaciones de "seguir"
       red.seguir("Ana", "Luis");
       red.seguir("Ana", "Maria");
       red.seguir("Luis", "Maria");
       red.seguir("Maria", "Ana");
       // Mostrar red completa
       red.mostrarRed();
       // Consultas
       System.out.println("\nAna sigue a: " + red.obtenerSeguidos("Ana"));
       System.out.println("Maria es seguida por: " + red.obtenerSeguidores("Maria"));
   }
}