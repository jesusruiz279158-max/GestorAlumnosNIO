/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestoralumnosnio;

import static com.mycompany.gestoralumnosnio.RegistrarAlumno.registrarAlumno;
import java.nio.file.Path;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author abrah
 */
public class MenuGestorAlumnosNIO {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
        Path ruta = Path.of("GestorAlumnosNIO.txt");
        
        int opcion = 0;

        do {
            System.out.println("\n========================================");
            System.out.println("     SISTEMA DE GESTIÓN DE ALUMNOS      ");
            System.out.println("========================================");
            System.out.println("1. Registrar nuevo alumno");
            System.out.println("2. Ver todos los alumnos");
            System.out.println("3. Buscar alumno por ID");
            System.out.println("4. Modificar alumno");
            System.out.println("5. Eliminar alumno");
            System.out.println("6. Salir");
            System.out.println("----------------------------------------");
            System.out.print("Seleccione una opción (1-6): ");

            try {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar el salto de línea del búfer

                switch (opcion) {
                    case 1 -> registrarAlumno(scanner, ruta);
                    
                    case 2 -> VerTodosAlumnos.verTodosAlumnos(scanner, ruta); // Solo recibe la ruta
                    
                    case 3 -> {
                        System.out.println("\n============ Buscar Alumno por ID ============");
                        System.out.print("Ingrese el ID del alumno que desea buscar: ");
                        int idBuscado = scanner.nextInt();
                        scanner.nextLine();
                        BuscarAlumno.buscarAlumno(ruta, idBuscado);
                    }
                    
                    case 4 -> {
                        System.out.println("\n============ Modificar Alumno ============");
                        System.out.print("Ingrese el ID del alumno que desea modificar: ");
                        int idMod = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Ingrese el nuevo nombre completo del alumno: ");
                        String nuevoNombre = scanner.nextLine();
                        ModificarAlumno.modificarAlumno(ruta, idMod, nuevoNombre);
                    }
                    
                    case 5 -> EliminarAlumno.menuEliminar(scanner, ruta);
                    
                    case 6 -> System.out.println("\nGracias por usar el sistema! Hasta luego.");
                    
                    default -> System.out.println("\nOpcion no valida. Intente nuevamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("\n[!] Error: Debe ingresar un número entero valido.");
                scanner.nextLine(); // Limpiar entrada erronea
            }

        } while (opcion != 6);

        scanner.close();
        
    }
    
}
