package org.iesalandalus.programacion.biblioteca.mvc.controlador;

import java.time.LocalDate;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.biblioteca.mvc.modelo.Modelo;
import org.iesalandalus.programacion.biblioteca.mvc.modelo.dominio.Alumno;
import org.iesalandalus.programacion.biblioteca.mvc.modelo.dominio.Libro;
import org.iesalandalus.programacion.biblioteca.mvc.modelo.dominio.Prestamo;
import org.iesalandalus.programacion.biblioteca.mvc.vista.Vista;

public class Controlador {

	/*********ATRIBUTOS*********/
	
	private Vista vista;
	private Modelo modelo;
	
	
	/*******CONSTRUCTOR*******/
	
	/**
	 * Constructor con parámetros.
	 * @param modelo
	 * @param vista
	 */
	public Controlador(Modelo modelo, Vista vista) {
		if (modelo == null) {
			throw new IllegalArgumentException("ERROR: El modelo no puede ser nulo.");
		}
		if (vista == null) {
			throw new IllegalArgumentException("ERROR: La vista no puede ser nula.");
		}
		this.modelo = modelo;
		this.vista = vista;
		this.vista.setControlador(this);
	}
	
	
	/********OTROS MÉTODOS********/
	
	/**
	 * Método que llama a otro de la clase Vista para ejecutar la aplicación. 
	 */
	public void comenzar() {
		vista.comenzar();
	}
	
	/**
	 * Método que llama a otro de la clase Vista para terminar la aplicación. 
	 */
	public void terminar() {
		vista.terminar();
	}
	
	/**
	 * Método que llama a otro de la clase Modelo para insertar un alumno. 
	 * @param alumno
	 * @throws OperationNotSupportedException
	 */
	public void insertar(Alumno alumno) throws OperationNotSupportedException {
		modelo.insertar(alumno);
	}
	
	/**
	 * Método que llama a otro de la clase Modelo para insertar un libro. 
	 * @param libro
	 * @throws OperationNotSupportedException
	 */
	public void insertar(Libro libro) throws OperationNotSupportedException {
		modelo.insertar(libro);
	}
	
	/**
	 * Método que llama a otro de la clase Modelo para realizar un préstamo. 
	 * @param prestamo
	 * @throws OperationNotSupportedException
	 */
	public void prestar(Prestamo prestamo) throws OperationNotSupportedException {
		modelo.prestar(prestamo);
	}
	
	/**
	 * Método que llama a otro de la clase Modelo para realizar una devolución. 
	 * @param prestamo
	 * @param fechaDevolucion
	 * @throws OperationNotSupportedException
	 */
	public void devolver(Prestamo prestamo, LocalDate fechaDevolucion) throws OperationNotSupportedException {
		modelo.devolver(prestamo, fechaDevolucion);
	}
	
	/**
	 * Método que llama a otro de la clase Modelo para buscar un alumno. 
	 * @param alumno
	 */
	public void buscar(Alumno alumno) {
		modelo.buscar(alumno);
	}
	
	/**
	 * Método que llama a otro de la clase Modelo para buscar un libro. 
	 * @param libro
	 */
	public void buscar(Libro libro) {
		modelo.buscar(libro);
	}
	
	/**
	 * Método que llama a otro de la clase Modelo para buscar un préstamo. 
	 * @param prestamo
	 */
	public void buscar(Prestamo prestamo) {
		modelo.buscar(prestamo);
	}
	
	/**
	 * Método que llama a otro de la clase Modelo para borrar un alumno. 
	 * @param alumno
	 * @throws OperationNotSupportedException
	 */
	public void borrar(Alumno alumno) throws OperationNotSupportedException {
		modelo.borrar(alumno);
	}
	
	/**
	 * Método que llama a otro de la clase Modelo para borrar un libro. 
	 * @param libro
	 * @throws OperationNotSupportedException
	 */
	public void borrar(Libro libro) throws OperationNotSupportedException {
		modelo.borrar(libro);
	}
	
	/**
	 * Método que llama a otro de la clase Modelo para borrar un préstamo. 
	 * @param prestamo
	 * @throws OperationNotSupportedException
	 */
	public void borrar(Prestamo prestamo) throws OperationNotSupportedException {
		modelo.borrar(prestamo);
	}
	
	/**
	 * Método que llama a otro de la clase Modelo para mostrar los alumnos. 
	 * @return alumnos
	 */
	public Alumno[] getAlumnos() {
		return modelo.getAlumnos();
	}
	
	/**
	 * Método que llama a otro de la clase Modelo para mostrar los libros. 
	 * @return libros
	 */
	public Libro[] getLibros() {
		return modelo.getLibros();
	}
	
	/**
	 * Método que llama a otro de la clase Modelo para mostrar los préstamos. 
	 * @return prestamos
	 */
	public Prestamo[] getPrestamos() {
		return modelo.getPrestamos();
	}
	
	/**
	 * Método que llama a otro de la clase Modelo para mostrar los préstamos de un alumno. 
	 * @param alumno
	 * @return prestamos
	 */
	public Prestamo[] getPrestamos(Alumno alumno) {
		return modelo.getPrestamos(alumno);
	}
	
	/**
	 * Método que llama a otro de la clase Modelo para mostrar los préstamos de un libro. 
	 * @param libro
	 * @return prestamos
	 */
	public Prestamo[] getPrestamos(Libro libro) {
		return modelo.getPrestamos(libro);
	}
	
	/**
	 * Método que llama a otro de la clase Modelo para mostrar los préstamos por fecha. 
	 * @param fecha
	 * @return prestamos
	 */
	public Prestamo[] getPrestamos(LocalDate fecha) {
		return modelo.getPrestamos(fecha);
	}
	
}
