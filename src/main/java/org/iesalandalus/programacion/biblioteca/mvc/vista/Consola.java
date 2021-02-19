package org.iesalandalus.programacion.biblioteca.mvc.vista;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.iesalandalus.programacion.biblioteca.mvc.modelo.dominio.Alumno;
import org.iesalandalus.programacion.biblioteca.mvc.modelo.dominio.Curso;
import org.iesalandalus.programacion.biblioteca.mvc.modelo.dominio.Libro;
import org.iesalandalus.programacion.biblioteca.mvc.modelo.dominio.Prestamo;
import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {

	/**
	 * Constructor.
	 * Evita que se puedan crear instancias de esta clase.
	 */
	private Consola() {
		
	}
	
	/**
	 * Método que muestra el menú de opciones.
	 */
	public static void mostrarMenu() {
		System.out.println("MENÚ DE OPCIONES");
		for (Opcion opcion : Opcion.values()) {
			System.out.println(opcion);
		}
	}
	
	/**
	 * Método que muestra la cabecera de la aplicación. 
	 * @param mensaje
	 */
	public static void mostrarCabecera(String mensaje) {
		System.out.printf("%n%s&n", mensaje);
		String formatoStr = "%0" + mensaje.length() + "d%n";
		System.out.println(String.format(formatoStr, 0).replace("0", "-"));
	}
	
	/**
	 * Método para elegir una de las opciones del menú.
	 * @return opcion
	 */
	public static int elegirOpcion() {
		int opcion;
		do {
			System.out.println("\nElige una opción: ");
			opcion = Entrada.entero();
			if (!Opcion.esOrdinalValido(opcion)) {
				System.out.println("La opción escogida no es válida. Elige una opción: ");
			}
		} while (!Opcion.esOrdinalValido(opcion));
		return opcion;
	}
	
	/**
	 * Método para introducir los datos de un alumno.
	 * @return Alumno
	 */
	public static Alumno leerAlumno() {
		System.out.println("Introduce el nombre del alumno");
		String nombre = Entrada.cadena();
		System.out.println("Introduce el correo del alumno: ");
		String correo = Entrada.cadena();
		
		int numeroCurso;
		Curso curso = null;
		
		do {
			System.out.println("Introduce el curso del alumno: ");
			numeroCurso = Entrada.entero();
		} while (numeroCurso<1 || numeroCurso>4);
		
		switch(numeroCurso) {
		case 1:
			curso = Curso.PRIMERO;
			break;
		case 2: 
			curso = Curso.SEGUNDO;
			break;
		case 3: 
			curso = Curso.TERCERO;
			break;
		case 4: 
			curso = Curso.CUARTO;
			break;
		}
		return new Alumno(nombre, correo, curso);
	}
	
	/**
	 * Método para introducir los datos de un alumno ficticio.
	 * @return alumnoFicticio
	 */
	public static Alumno leerAlumnoFicticio() {
		System.out.print("Introduce el correo del alumno: ");
		return Alumno.getAlumnoFicticio(Entrada.cadena());
	}
	
	/**
	 * Método para introducir los datos de un libro.
	 * @return Libro
	 */
	public static Libro leerLibro() {
		System.out.println("Introduce el título del libro: ");
		String titulo = Entrada.cadena();
		System.out.println("Introduce el autor del libro: ");
		String autor = Entrada.cadena();
		System.out.println("Introduce el número de páginas del libro: ");
		int numPaginas = Entrada.entero();
		return new Libro(titulo, autor, numPaginas);
	}
	
	/**
	 * Método para introducir los datos de un libro ficticio.
	 * @return libroFicticio
	 */
	public static Libro leerLibroFicticio() {
		System.out.println("\nIntroduce el título del libro: ");
		String titulo = Entrada.cadena();
		System.out.println("Introduce el autor del libro: ");
		String autor = Entrada.cadena();
		return Libro.getLibroFicticio(titulo, autor);
	}
	
	/**
	 * Método para introducir los datos de un préstamo.
	 * @return Prestamo
	 */
	public static Prestamo leerPrestamo() {
		return new Prestamo(leerAlumno(), leerLibro(), leerFecha());
	}
	
	/**
	 * Método para introducir los datos de un préstamo ficticio.
	 * @return prestamoFicticio
	 */
	public static Prestamo leerPrestamoFicticio() {
		return Prestamo.getPrestamoFicticio(leerAlumnoFicticio(), leerLibroFicticio());
	}
	
	/**
	 * Método para introducir la fecha de un préstamo.
	 * @return fecha
	 */
	public static LocalDate leerFecha() {
		LocalDate fecha = null;
		String cadenaFormato = "dd/MM/yyyy";
		DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern(cadenaFormato);
		System.out.printf("Introduce la fecha del préstamo (%s): ", formatoFecha);
		String diaLeido = Entrada.cadena();
		try {
			fecha = LocalDate.parse(diaLeido, formatoFecha);
		} catch (DateTimeException e) {
			System.out.println("ERROR: El formato de la fecha no es correcto.");
		}
		return fecha;
	}
}
