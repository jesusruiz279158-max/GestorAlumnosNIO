/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestoralumnosnio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author abrah
 */
public class RegistrarAlumno {

    public static void main(String[] args) {
        // 1. Inicializar el Scanner
        Scanner scanner = new Scanner(System.in);
        Path ruta = Path.of("GestorAlumnosNIO.txt");

        // 2. Llamar al método
        registrarAlumno(scanner, ruta);

        // 3. Cerrar Scanner al finalizar en main
        scanner.close();
    }

    // Metodo para registrar alumnos
    public static void registrarAlumno(Scanner scanner, Path ruta) {
        String respuesta;
        do {
            System.out.println("\n============== Registro de Alumnos ==============");
            System.out.print("Ingrese el ID del alumno: ");
            int idAlumno = scanner.nextInt();
            scanner.nextLine(); // Limpiar salto de línea

            System.out.print("Ingrese el nombre completo del alumno: ");
            String nombreAlumno = scanner.nextLine();

            try {
                // Escribir en el archivo de texto
                String contenido = idAlumno + " - " + nombreAlumno.trim() + System.lineSeparator();
                Files.writeString(ruta, contenido, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                System.out.println("-> ¡Alumno guardado con éxito!");
            } catch (IOException e) {
                System.err.println("Error al escribir en el archivo: " + e.getMessage());
            }

            System.out.print("¿Desea registrar otro alumno? (s/n): ");
            respuesta = scanner.nextLine();

        } while (respuesta.equalsIgnoreCase("s"));
    }
}
    

