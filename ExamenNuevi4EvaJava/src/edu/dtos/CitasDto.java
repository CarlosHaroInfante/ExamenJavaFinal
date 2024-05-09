package edu.dtos;

import java.time.LocalDateTime;

/*
 * Autor Carlos 09/03/2024
 * Dto que contiene los campos, getters y setters  y el constructor vacío de las citas.
 * **/
public class CitasDto {

	long idCita;
	
	String especialidad = "aaaaa";
	
	LocalDateTime fechaCita = LocalDateTime.of(9999, 12, 31, 0, 0);
	

	public long getIdCita() {
		return idCita;
	}

	public void setIdCita(long idCita) {
		this.idCita = idCita;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public LocalDateTime getFechaCita() {
		return fechaCita;
	}

	public void setFechaCita(LocalDateTime fechaCita) {
		this.fechaCita = fechaCita;
	}
	

	public CitasDto() {
		
	}
}
