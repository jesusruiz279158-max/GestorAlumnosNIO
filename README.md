# Sistema de Gestión de Alumnos (Java NIO)

Un sistema de consola desarrollado en Java utilizando (`java.nio.file`) para gestionar registros de alumnos almacenados en un archivo de texto plano (`GestorAlumnosNIO.txt`).

# Estructura del Proyecto

* `MenuGestorAlumnosNIO.java`: Clase principal con el menú interactivo.
* `RegistrarAlumno.java`: Agrega nuevos alumnos al archivo `.txt`.
* `VerTodosAlumnos.java`: Muestra la lista completa de alumnos y el total registrado.
* `BuscarAlumno.java`: Busca un alumno en el archivo mediante su ID.
* `ModificarAlumno.java`: Actualiza el nombre de un alumno existente filtrando por su ID.
* `EliminarAlumno.java`: Permite eliminar registros por ID o por nombre completo.

# Guía de Uso del Menú Principal
Al ejecutar la aplicación, se desplegará el siguiente menú:
========================================
     SISTEMA DE GESTIÓN DE ALUMNOS      
========================================
1. Registrar nuevo alumno
2. Ver todos los alumnos
3. Buscar alumno por ID
4. Modificar alumno
5. Eliminar alumno
6. Salir
----------------------------------------

# Opciones disponibles:
## 1.- Registrar nuevo alumno:
    -Solicita el ID y el Nombre completo.
    -Guarda los datos en el archivo GestorAlumnosNIO.txt con el formato ID - Nombre.
    -Permite registrar múltiples alumnos en secuencia (s/n).
## 2.- Ver todos los alumnos:
    -Lee el archivo y lista todos los registros existentes.
    -Muestra la cantidad total de alumnos registrados.
    -Requiere presionar ENTER para regresar al menú principal.
## 3.- Buscar alumno por ID:
    -Solicita un ID numérico.
    -Si existe, muestra el ID y Nombre del alumno en pantalla.
## 4.- Modificar alumno:
    -Solicita el ID del alumno que se desea actualizar.
    -Solicita el nuevo nombre completo y actualiza el archivo automáticamente.
## 5.- Eliminar alumno:
    -Despliega un submenú con dos opciones de eliminación:
    -Eliminar por ID: Busca por número de ID y elimina el registro.
    -Eliminar por Nombre completo: Busca coincidencia de texto e ignora mayúsculas/minúsculas.
## 6.- Salir:
    -Finaliza la ejecución del programa de forma segura.

# Formato del Archivo de Datos
  101 - Juan Pérez
  102 - María López
  103 - Carlos Gómez
