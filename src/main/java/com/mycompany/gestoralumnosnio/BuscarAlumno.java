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
public class BuscarAlumno {
    public static void main(String[] args) {
            //Crear instancia de Scanner
            Scanner scanner = new Scanner(System.in);
            
            //Ruta del arhivo .txt creado en RegistrarAlumno
            Path ruta = Path.of("GestorAlumnosNIO.txt");
            
            //Menu de BuscarAlumno
            System.out.println("============ Buscar Alumno por ID ============");
            System.out.println("Ingrese el ID del alumno que desea buscar: ");
            
            //Uso de scanner para recibir la informacion del usuario y almacenamiento en la varianle idBuscado
            int idBuscado = scanner.nextInt();
            
            buscarAlumno(ruta, idBuscado);
            scanner.close();
    }
    
    //Método que lee el archivo .txt y busca al alumno por el ID
    public static void buscarAlumno(Path rutaArchivo, int idBuscado) {
        if (!Files.exists(rutaArchivo)){
            System.out.println("El archivo de registros aun no existe");
            return;
            
        }
        
        try {
            // Lee todas las líneas del archivo y las guarda en una Lista de Strings
            List<String> lineas = Files.readAllLines(rutaArchivo);
            boolean encontrado = false;

            for (String linea : lineas) {
                // Si la línea está vacía, se ignora
                if (linea.trim().isEmpty()) {
                    continue;
                }

                // Se separa la línea usando el delimitador " - " que se uso al guardar
                // Partes[0] será el ID y Partes[1] será el Nombre
                String[] partes = linea.split(" - ");

                if (partes.length >= 2) {
                    try {
                        int idActual = Integer.parseInt(partes[0].trim());

                        if (idActual == idBuscado) {
                            System.out.println("\n¡Alumno encontrado!");
                            System.out.println("--------------------------------");
                            System.out.println("ID: " + partes[0].trim());
                            System.out.println("Nombre: " + partes[1].trim());
                            System.out.println("--------------------------------");
                            encontrado = true;
                            break; // Detener la búsqueda al encontrarlo
                        }
                    } catch (NumberFormatException e) {
                        // Ignora líneas que no tengan un número de ID válido al inicio
                    }
                }
            }
            
            if (!encontrado) {
                System.out.println("\nNo se encontró ningún alumno con el ID: " + idBuscado);
        }
    
    } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}