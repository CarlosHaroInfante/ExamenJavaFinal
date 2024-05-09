package edu.dtos;

import java.time.LocalDateTime;

/*
 * Autor Carlos 09/03/2024
 * Dto que contiene los campos, getters y setters  y el constructor con campos específicos de los pacientes.
 * **/
public class PacienteDto {

	long id;
	
	String nombre = "aaaaa";
	
	String apellido1 = "aaaaa";
	
	String apellido2 = "aaaaa";
	
	String apellidos = "aaaaa";
	
	String nombreCompleto = "aaaaa";
	
	String dni = "aaaaa";
	
	LocalDateTime fecha = LocalDateTime.of(9999, 12, 31, 0, 0);
	
	boolean esValido = false;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public boolean isEsValido() {
		return esValido;
	}

	public void setEsValido(boolean esValido) {
		this.esValido = esValido;
	}

	
	public PacienteDto(long id, String dni, String nombre, String apellidos, LocalDateTime fecha) {
		
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.fecha = fecha;
		String[] apellidosJuntos = apellidos.split(" ");
		this.apellido1 = apellidosJuntos[0];
		this.apellido2 = apellidosJuntos[1];
		this.nombreCompleto = apellidos + ", " + nombre;
	}
	
	
}
