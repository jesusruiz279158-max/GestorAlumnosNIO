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
public class ModificarAlumno {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Path ruta = Path.of("GestorAlumnosNIO.txt");

        System.out.println("============ Modificar Alumno ============");
        System.out.print("Ingrese el ID del alumno que desea modificar: ");
        int idBuscado = scanner.nextInt();
        scanner.nextLine(); // Limpiar el salto de línea pendiente

        System.out.print("Ingrese el nuevo nombre completo del alumno: ");
        String nuevoNombre = scanner.nextLine();

        modificarAlumno(ruta, idBuscado, nuevoNombre);

        scanner.close();
    }

    
    //Método que busca un alumno por su ID y actualiza su nombre en el archivo .txt
    
    public static void modificarAlumno(Path rutaArchivo, int idBuscado, String nuevoNombre) {
        if (!Files.exists(rutaArchivo)) {
            System.out.println("El archivo de registros aun no existe.");
            return;
        }

        try {
            List<String> lineas = Files.readAllLines(rutaArchivo);
            List<String> lineasActualizadas = new ArrayList<>();
            boolean encontrado = false;

            for (String linea : lineas) {
                if (linea.trim().isEmpty()) {
                    continue;
                }

                String[] partes = linea.split(" - ");

                if (partes.length >= 2) {
                    try {
                        int idActual = Integer.parseInt(partes[0].trim());

                        // Si encontramos el ID, creamos la línea modificada
                        if (idActual == idBuscado) {
                            String lineaModificada = idActual + " - " + nuevoNombre.trim();
                            lineasActualizadas.add(lineaModificada);
                            encontrado = true;
                            continue; // Pasamos a la siguiente línea
                        }
                    } catch (NumberFormatException e) {
                        // Ignorar líneas con formato inválido
                    }
                }
                
                // Si no es el alumno buscado, conservamos la línea sin cambios
                lineasActualizadas.add(linea);
            }

            if (encontrado) {
                // Se reemplaza el contenido del archivo con las líneas actualizadas
                Files.write(rutaArchivo, lineasActualizadas, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
                System.out.println("\n-> Alumno modificado con exito!");
            } else {
                System.out.println("\nNo se encontro ningun alumno con el ID: " + idBuscado);
            }

        } catch (IOException e) {
            System.err.println("Error al modificar el archivo: " + e.getMessage());
        }
    }
}
