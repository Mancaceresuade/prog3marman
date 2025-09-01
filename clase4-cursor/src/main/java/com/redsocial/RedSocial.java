package com.redsocial;

import java.util.*;

/**
 * Clase que representa una red social usando un grafo con listas de adyacencia.
 * Cada usuario tiene una lista de usuarios a los que sigue.
 */
public class RedSocial {
    // Grafo con lista de adyacencia: cada usuario -> lista de los que sigue
    private Map<String, List<String>> grafo;
    
    /**
     * Constructor de la red social.
     * Inicializa el grafo como un HashMap vacío.
     */
    public RedSocial() {
        grafo = new HashMap<>();
    }
    
    /**
     * Agregar un nuevo usuario a la red.
     * Si el usuario ya existe, no hace nada.
     * 
     * @param usuario El nombre del usuario a agregar
     */
    public void agregarUsuario(String usuario) {
        grafo.putIfAbsent(usuario, new ArrayList<>());
    }
    
    /**
     * Un usuario empieza a seguir a otro.
     * Si alguno de los usuarios no existe, se crea automáticamente.
     * 
     * @param seguidor El usuario que va a seguir
     * @param seguido El usuario que va a ser seguido
     */
    public void seguir(String seguidor, String seguido) {
        if (!grafo.containsKey(seguidor)) {
            agregarUsuario(seguidor);
        }
        if (!grafo.containsKey(seguido)) {
            agregarUsuario(seguido);
        }
        grafo.get(seguidor).add(seguido);
    }
    
    /**
     * Obtener la lista de personas que sigue un usuario.
     * 
     * @param usuario El usuario del cual queremos obtener sus seguidos
     * @return Lista de usuarios que sigue el usuario especificado
     */
    public List<String> obtenerSeguidos(String usuario) {
        return grafo.getOrDefault(usuario, new ArrayList<>());
    }
    
    /**
     * Obtener la lista de seguidores de un usuario.
     * 
     * @param usuario El usuario del cual queremos obtener sus seguidores
     * @return Lista de usuarios que siguen al usuario especificado
     */
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
    
    /**
     * Mostrar toda la red social en consola.
     * Imprime cada usuario y a quién sigue.
     */
    public void mostrarRed() {
        for (var entry : grafo.entrySet()) {
            System.out.println(entry.getKey() + " sigue a " + entry.getValue());
        }
    }
    
    /**
     * Obtener el número total de usuarios en la red.
     * 
     * @return Número de usuarios en la red
     */
    public int obtenerNumeroUsuarios() {
        return grafo.size();
    }
    
    /**
     * Verificar si un usuario existe en la red.
     * 
     * @param usuario El usuario a verificar
     * @return true si el usuario existe, false en caso contrario
     */
    public boolean existeUsuario(String usuario) {
        return grafo.containsKey(usuario);
    }
}
