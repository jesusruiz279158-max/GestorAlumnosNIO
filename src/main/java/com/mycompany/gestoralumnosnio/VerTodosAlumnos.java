/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestoralumnosnio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author abrah
 */
public class VerTodosAlumnos {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Path ruta = Path.of("GestorAlumnosNIO.txt");
        
        verTodosAlumnos(scanner, ruta);
        
        scanner.close();
    }

    
    // Método que lee e imprime todos los alumnos registrados en el archivo .txt
    public static void verTodosAlumnos(Scanner scanner, Path rutaArchivo) {
        // 1. Validar si el archivo existe
        if (!Files.exists(rutaArchivo)) {
            System.out.println("El archivo de registros aún no existe.");
            pausar(scanner);
            return;
        }

        try {
            // 2. Leer todas las líneas del archivo
            List<String> lineas = Files.readAllLines(rutaArchivo);

            // 3. Verificar si el archivo está vacío
            if (lineas.isEmpty()) {
                System.out.println("No hay alumnos registrados actualmente.");
                pausar(scanner);
                return;
            }

            // 4. Mostrar el encabezado e imprimir cada línea
            System.out.println("\n============ Lista de Alumnos ============");
            System.out.println("ID - Nombre del Alumno");
            System.out.println("----------------------------------------");

            int contador = 0;
            for (String linea : lineas) {
                // Ignorar líneas en blanco
                if (!linea.trim().isEmpty()) {
                    System.out.println(linea);
                    contador++;
                }
            }

            System.out.println("----------------------------------------");
            System.out.println("Total de alumnos registrados: " + contador);

        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }

        // Pausa para mantener el encabezado y la lista visibles antes de regresar al menú
        pausar(scanner);
    }
    //Metodo para pausar el programa y no avance lo suficientemente rapido como para interferir en las otras funciones
    private static void pausar(Scanner scanner) {
        System.out.println("\nPresione ENTER para regresar al menu principal...");
        scanner.nextLine();
    }
}

