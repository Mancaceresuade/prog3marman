package com.redsocial;

import java.util.List;

/**
 * Clase principal que demuestra el uso de la RedSocial.
 * Crea una red social de ejemplo y muestra sus funcionalidades.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== DEMOSTRACIÓN DE RED SOCIAL CON GRAFO ===\n");
        
        // Crear una nueva red social
        RedSocial red = new RedSocial();
        
        // Agregamos usuarios
        System.out.println("Agregando usuarios...");
        red.agregarUsuario("Ana");
        red.agregarUsuario("Luis");
        red.agregarUsuario("Maria");
        red.agregarUsuario("Carlos");
        red.agregarUsuario("Elena");
        
        // Relaciones de "seguir"
        System.out.println("Estableciendo relaciones de seguimiento...");
        red.seguir("Ana", "Luis");
        red.seguir("Ana", "Maria");
        red.seguir("Luis", "Maria");
        red.seguir("Maria", "Ana");
        red.seguir("Carlos", "Ana");
        red.seguir("Carlos", "Luis");
        red.seguir("Elena", "Maria");
        red.seguir("Elena", "Carlos");
        
        // Mostrar red completa
        System.out.println("\n=== RED SOCIAL COMPLETA ===");
        red.mostrarRed();
        
        // Consultas específicas
        System.out.println("\n=== CONSULTAS ===");
        System.out.println("Ana sigue a: " + red.obtenerSeguidos("Ana"));
        System.out.println("Maria es seguida por: " + red.obtenerSeguidores("Maria"));
        System.out.println("Luis sigue a: " + red.obtenerSeguidos("Luis"));
        System.out.println("Carlos es seguido por: " + red.obtenerSeguidores("Carlos"));
        
        // Información adicional
        System.out.println("\n=== INFORMACIÓN ADICIONAL ===");
        System.out.println("Número total de usuarios: " + red.obtenerNumeroUsuarios());
        System.out.println("¿Existe el usuario 'Ana'? " + red.existeUsuario("Ana"));
        System.out.println("¿Existe el usuario 'Pedro'? " + red.existeUsuario("Pedro"));
        
        // Demostrar que se pueden agregar usuarios automáticamente
        System.out.println("\n=== AGREGANDO NUEVOS USUARIOS ===");
        red.seguir("Pedro", "Ana"); // Pedro se crea automáticamente
        red.seguir("Ana", "Pedro"); // Ana ahora sigue a Pedro también
        
        System.out.println("Después de agregar Pedro:");
        System.out.println("Número total de usuarios: " + red.obtenerNumeroUsuarios());
        System.out.println("Ana sigue a: " + red.obtenerSeguidos("Ana"));
        System.out.println("Pedro es seguido por: " + red.obtenerSeguidores("Pedro"));
        
        System.out.println("\n=== FIN DE LA DEMOSTRACIÓN ===");
    }
}
