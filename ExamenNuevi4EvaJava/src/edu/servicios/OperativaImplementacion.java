package edu.servicios;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import edu.dtos.CitasDto;
import edu.dtos.PacienteDto;

public class OperativaImplementacion implements OperativaInterfaz{

	Scanner sc = new Scanner(System.in);
	FicheroInterfaz fichero = new FicherosImplementacion();
	String mensajeFicheroLog;
	public void registroCliente(List<PacienteDto> listaPacientes) {
		
		
		try {
			System.out.println("Registrar nuevo cliente");
			//PacienteDto pacienteNuevo = new PacienteDto();
			
			
			System.out.println("Apellidos del cliente");
			String apellidosPaciente = sc.nextLine();
			
			System.out.println("Nombre del cliente");
			String nombrePaciente = sc.next();
			
			
			System.out.println("Dni del cliente");
			String dniPaciente = sc.next();
			
			LocalDateTime fechaAhora = LocalDateTime.now();
			
			
			
			long idPaciente = idAunto(listaPacientes);
			
			PacienteDto paciente = new PacienteDto(idPaciente, dniPaciente, nombrePaciente, apellidosPaciente, fechaAhora);
			
			listaPacientes.add(paciente);
			
			for (PacienteDto pacienteN : listaPacientes) {
				System.out.println(pacienteN.getId() + ";" + paciente.getDni() + ";"+ paciente.getApellidos() + "" +paciente.getNombre());
			}
			

			mensajeFicheroLog = "Se ha registrado un nuevo paciente";
			fichero.ficheroLog(mensajeFicheroLog);
			
			
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Error al registrar el paciente" + e.getMessage());
				mensajeFicheroLog = "Se ha producido un error al registrar el paciente";
				fichero.ficheroLog(mensajeFicheroLog);
			}
			
			
			
		}
	
	public void SolicitudCitaMedica(List<CitasDto> listaCitas, List<PacienteDto> listaPacientes) {
		try {
		MenuInterfaz menu = new MenuImplementacion();
		
		boolean cerrarMenu = false;
		
		System.out.println("inserte su dni");
		String dniCliente = sc.next();
		sc.nextLine();
		
		for (PacienteDto dniValido : listaPacientes) {
			
			if(dniValido.getDni().equals(dniCliente) && dniValido.isEsValido() == true) {
				
				int num = menu.menuCitas();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
				switch (num) {
					case 0: {
						System.out.println("Se cierrar el menú");
						mensajeFicheroLog = "Se cierra el menú de solicitud de citas médicas";
						fichero.ficheroLog(mensajeFicheroLog);
						cerrarMenu = true;
						break;
					}
					case 1: {
						System.out.println("Psicología");
						
						CitasDto citasNuevas = new CitasDto();
							
						citasNuevas.setEspecialidad("Psicología");
						citasNuevas.setIdCita(idAuntoCita(listaCitas));
						System.out.println("Fecha y hora de la cita dd-MM-yyyy HH:mm");
						LocalDateTime fecha = LocalDateTime.parse(sc.nextLine(), formatter);
						citasNuevas.setFechaCita(fecha);
						listaCitas.add(citasNuevas);
						mensajeFicheroLog = "Se ha añadido una cita médica para Psicología";
						fichero.ficheroLog(mensajeFicheroLog);
						break;
						
						
					}
					
					case 2:{
						System.out.println("Traumatología");
						
							CitasDto citasNuevas = new CitasDto();
							citasNuevas.setEspecialidad("Traumatología");
							citasNuevas.setIdCita(idAuntoCita(listaCitas));
							System.out.println("Fecha y hora de la cita dd-MM-yyyy HH:mm");
							LocalDateTime fecha = LocalDateTime.parse(sc.nextLine(), formatter);
							citasNuevas.setFechaCita(fecha);
							listaCitas.add(citasNuevas);
							mensajeFicheroLog = "Se ha añadido una cita médica para Traumatología";
							fichero.ficheroLog(mensajeFicheroLog);
							break;
						
					}
					
					case 3:{
							System.out.println("Fisioterapia");
						
							CitasDto citasNuevas = new CitasDto();
							citasNuevas.setEspecialidad("Fisioterapia");
							citasNuevas.setIdCita(idAuntoCita(listaCitas));
							System.out.println("Fecha y hora de la cita dd-MM-yyyy HH:mm");
							LocalDateTime fecha = LocalDateTime.parse(sc.nextLine(), formatter);
							citasNuevas.setFechaCita(fecha);
							listaCitas.add(citasNuevas);
							mensajeFicheroLog = "Se ha añadido una cita médica para Fisioterapia";
							fichero.ficheroLog(mensajeFicheroLog);
							break;
							}
						
					
					
					
					default:
						throw new IllegalArgumentException("Unexpected value: " + num);
						
					}
				
				}
			else {
				System.out.println("DNI no validado o no existente");
				mensajeFicheroLog = "El paciente no existe o no tiene el dni validado";
				fichero.ficheroLog(mensajeFicheroLog);
			}
			for (CitasDto citas : listaCitas) {
					
				System.out.println(citas.getEspecialidad() + " ; " + citas.getFechaCita());
			}
	
			
		
		
		}	
		
		
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("Fallo al mostrar la cita médica" + e.getMessage());
		mensajeFicheroLog = "Error al pedir la cita del paciente";
		fichero.ficheroLog(mensajeFicheroLog);
	}
		
}
	
	public void entreFechas(List<CitasDto> listaCitas, List<PacienteDto> listaPacientes) {
		
		try {
			
			
			System.out.println("inserte su dni");
			String dniCliente = sc.next();
			sc.nextLine();
			
			System.out.println("Fecha Inicio dd-MM-yyyy HH:mm:ss");
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
			LocalDateTime fechaInicio = LocalDateTime.parse(sc.nextLine(), formatter);
			
			
			System.out.println("Fecha Fin");
			LocalDateTime fechaFin = LocalDateTime.parse(sc.nextLine(), formatter);
			
			
			for (PacienteDto paciente : listaPacientes) {
				
				if(paciente.getDni().equals(dniCliente) && paciente.isEsValido() == true) {
				
					for (CitasDto citas : listaCitas) {
					
					LocalDateTime fechaCita = LocalDateTime.parse(citas.getFechaCita().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm")), DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"));
						
					if(citas.getFechaCita().isBefore(fechaFin) && citas.getFechaCita().isAfter(fechaInicio)) {	
					
						System.out.println("El paciente "+ paciente.getNombreCompleto() + " tiene la cita de: " +  citas.getEspecialidad() + " el dia y hora " + citas.getFechaCita());
						mensajeFicheroLog = "El paciente ha mostrado sus citas en un intervalo de tiempo específico";
						fichero.ficheroLog(mensajeFicheroLog);
					
					}
					else {
						System.out.println("El paciente " + paciente.getNombreCompleto() + " no tiene ninguna cita entre " + fechaInicio + " y " + fechaFin);
						mensajeFicheroLog = "El paciente no tiene citas entre el intervalo de fechas especificado por el mismo";
						fichero.ficheroLog(mensajeFicheroLog);
					}
				
				}
			}
				else {
					System.out.println("El paciente no es válido o inserto incorrectamente su dni");
					mensajeFicheroLog = "El paciente proporcionó incorrectamente su dni o no es válido";
					fichero.ficheroLog(mensajeFicheroLog);
				}
				
			}
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al mostrar la cita médica entre fechas" + e.getMessage());
			mensajeFicheroLog = "Error al escribir por consola las citas de un paciente entre un intervalo de fechas especificadas por el mismo";
			fichero.ficheroLog(mensajeFicheroLog);
		}
		
	}
	
	public void validarCliente(List<PacienteDto> listaPacientes) {
		
		try {
			
			for (PacienteDto pacientesNovalidados : listaPacientes) {
				
				if(pacientesNovalidados.isEsValido() == false) {
				System.out.println(pacientesNovalidados.getDni() + " - " + pacientesNovalidados.getApellidos() + ", " + pacientesNovalidados.getNombre());
				System.out.println("Dni del paciente que quieres validar");
				String dniValido = sc.next();
				
					if(pacientesNovalidados.getDni().equals(dniValido)) {
						pacientesNovalidados.setEsValido(true);
						System.out.println("Se valida el paciente con dni "  + dniValido);
						mensajeFicheroLog = "Se valida el dni del paciente " + dniValido;
						fichero.ficheroLog(mensajeFicheroLog);
					}
					else {
						System.out.println("Ningun paciente con dni"  + dniValido);
						mensajeFicheroLog = "Ningun paciente con dni"  + dniValido;
						fichero.ficheroLog(mensajeFicheroLog);
					}
					
				}
				else {
					System.out.println("Ningún paciente sin el dni válido");
					mensajeFicheroLog = "Ningun paciente sin dni validado";
					fichero.ficheroLog(mensajeFicheroLog);
				}
				
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al validar el paciente" + e.getMessage());
			mensajeFicheroLog = "Error al validar el paciente";
			fichero.ficheroLog(mensajeFicheroLog);
		}
	}

		public void imprimirCitas(){
			System.out.println("Fecha de las citas");
			String fechaInformes = sc.next();
			fichero.informe(fechaInformes);
		}

		/**
		 * Autor Carlos Haro Infante 09/05/2024
		 * Método privado que hace que si se añade mas de un paciente se aumente el id.
		 * */

		private long idAunto(List<PacienteDto> listaPacientes) {
			
			long idN = 0;
			int tamanioLista = listaPacientes.size();
			
			if(tamanioLista > 0) {
				idN = listaPacientes.get(tamanioLista - 1).getId() + 1;
			}
			else {
				idN = 1;
			}
			
			return idN;
			
		}
		/**
		 * Autor Carlos Haro Infante 09/05/2024
		 * Método privado que hace que si se añade mas de una cita se aumente el id.
		 * */
		private long idAuntoCita(List<CitasDto> listaCitas) {
			
			long idN = 0;
			int tamanioLista = listaCitas.size();
			
			if(tamanioLista > 0) {
				idN = listaCitas.get(tamanioLista - 1).getIdCita() + 1;
			}
			else {
				idN = 1;
			}
			
			return idN;
			
		}
		}
