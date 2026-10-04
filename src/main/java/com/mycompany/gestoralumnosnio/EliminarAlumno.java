/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestoralumnosnio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author abrah
 */
public class EliminarAlumno {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Path ruta = Path.of("GestorAlumnosNIO.txt");
        
    }
    public static void menuEliminar(Scanner scanner, Path ruta) {
        System.out.println("\n============ Eliminar Alumno ============");
        System.out.println("1. Eliminar por ID");
        System.out.println("2. Eliminar por Nombre completo");
        System.out.print("Seleccione una opción (1 o 2): ");

        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar el salto de línea pendiente

        switch (opcion) {
            case 1 -> {
                System.out.print("Ingrese el ID del alumno a eliminar: ");
                int id = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer
                eliminarPorId(ruta, id);
            }
            case 2 -> {
                System.out.print("Ingrese el nombre completo del alumno a eliminar: ");
                String nombre = scanner.nextLine();
                eliminarPorNombre(ruta, nombre);
            }
            default -> System.out.println("Opcion no valida.");
        }
    }

    //Elimina registros comparando el ID del alumno.
     
    public static void eliminarPorId(Path rutaArchivo, int idEliminar) {
        if (!Files.exists(rutaArchivo)) {
            System.out.println("El archivo de registros aun no existe.");
            return;
        }

        try {
            List<String> lineas = Files.readAllLines(rutaArchivo);
            List<String> lineasRestantes = new ArrayList<>();
            boolean encontrado = false;

            for (String linea : lineas) {
                if (linea.trim().isEmpty()) {
                    continue;
                }

                String[] partes = linea.split(" - ");
                if (partes.length >= 2) {
                    try {
                        int idActual = Integer.parseInt(partes[0].trim());
                        // Si coincide el ID, se omitime para no guardarlo
                        if (idActual == idEliminar) {
                            encontrado = true;
                            continue; 
                        }
                    } catch (NumberFormatException e) {
                        // Ignorar líneas con formato inválido
                    }
                }
                lineasRestantes.add(linea);
            }

            if (encontrado) {
                // Sobrescribir el archivo con la nueva lista sin el alumno eliminado
                Files.write(rutaArchivo, lineasRestantes, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
                System.out.println("\n-> Alumno con ID " + idEliminar + " eliminado con exito.");
            } else {
                System.out.println("\nNo se encontro ningun alumno con el ID: " + idEliminar);
            }

        } catch (IOException e) {
            System.err.println("Error al modificar el archivo: " + e.getMessage());
        }
    }

    
    //Elimina registros comparando el nombre completo del alumno.
     
    public static void eliminarPorNombre(Path rutaArchivo, String nombreEliminar) {
        if (!Files.exists(rutaArchivo)) {
            System.out.println("El archivo de registros aun no existe.");
            return;
        }

        try {
            List<String> lineas = Files.readAllLines(rutaArchivo);
            List<String> lineasRestantes = new ArrayList<>();
            boolean encontrado = false;

            for (String linea : lineas) {
                if (linea.trim().isEmpty()) {
                    continue;
                }

                String[] partes = linea.split(" - ");
                if (partes.length >= 2) {
                    String nombreActual = partes[1].trim();
                    // Compara ignorando mayúsculas y minúsculas
                    if (nombreActual.equalsIgnoreCase(nombreEliminar.trim())) {
                        encontrado = true;
                        continue; 
                    }
                }
                lineasRestantes.add(linea);
            }

            if (encontrado) {
                Files.write(rutaArchivo, lineasRestantes, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
                System.out.println("\n-> Alumno '" + nombreEliminar + "' eliminado con exito.");
            } else {
                System.out.println("\nNo se encontro ningun alumno con el nombre: " + nombreEliminar);
            }

        } catch (IOException e) {
            System.err.println("Error al modificar el archivo: " + e.getMessage());
        }
    }
}
