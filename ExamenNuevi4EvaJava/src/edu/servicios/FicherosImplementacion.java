package edu.servicios;

import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import edu.controladores.Inicio;
import edu.dtos.CitasDto;
import edu.dtos.PacienteDto;

public class FicherosImplementacion implements FicheroInterfaz{

	public void ficheroLog(String mensaje) {
		
		try {
		LocalDate fechaHoy = LocalDate.now();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
		
		String FechaDeHoy = formatter.format(fechaHoy);
		
		String ficheroLog = "C:\\Users\\Carlos\\Desktop\\log-" + FechaDeHoy + ".txt";
		
		
		FileWriter escribe = new FileWriter(ficheroLog, true);
		
		escribe.write(mensaje + "\n");
		escribe.close();
		
		
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al crear/escribir en el fichero log " + e.getMessage());
		}
		
	}
	
	public void informe(String fechaInformes) {
		
		
		String ficheroInforme = "C:\\Users\\Carlos\\Desktop\\informe-" + fechaInformes + ".txt";
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate fechaInformesFormateada = LocalDate.parse(fechaInformes, formatter);
		try {
			
			FileWriter escribe = new FileWriter(ficheroInforme, true);
			
			for (CitasDto citas : Inicio.citas) {
				LocalDateTime fechaCita = citas.getFechaCita();
				LocalDate fechaCitaLocalDate = fechaCita.toLocalDate();
				
				if(fechaCitaLocalDate.equals(fechaInformesFormateada)) {
					for(PacienteDto paciente : Inicio.pacientes) {
						System.out.println(paciente.getDni() + ";" + paciente.getNombreCompleto() + ";" + citas.getEspecialidad());
						escribe.write(paciente.getDni() + ";" + paciente.getNombreCompleto() + ";" + citas.getEspecialidad());
						escribe.close();
					}
				}
				else {
					System.out.println("No hay información que mostrar");
				}
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al crear/escribir en el fichero fichero de  informes " + e.getMessage());
		}
	}
	
}
