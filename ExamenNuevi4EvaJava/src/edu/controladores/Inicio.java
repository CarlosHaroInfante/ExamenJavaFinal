package edu.controladores;
import java.util.ArrayList;
import java.util.List;

import edu.dtos.CitasDto;
import edu.dtos.PacienteDto;
import edu.servicios.FicheroInterfaz;
import edu.servicios.FicherosImplementacion;
import edu.servicios.MenuImplementacion;
import edu.servicios.MenuInterfaz;
import edu.servicios.OperativaImplementacion;
import edu.servicios.OperativaInterfaz;

/* 
 * Autor Carlos 09/03/2024
 * Clase principal del programa que contiene el main
 * **/
public class Inicio {

	public static List<PacienteDto> pacientes = new ArrayList<PacienteDto>();
	public static List<CitasDto> citas = new ArrayList<CitasDto>();
	/*
	 * Autor Carlos 09/03/2024 Método main que contienen las llamadas a metodos,
	 * menus, etc
	 **/

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MenuInterfaz menu = new MenuImplementacion();
		OperativaInterfaz operativa = new OperativaImplementacion();
		FicheroInterfaz fichero = new FicherosImplementacion();

		boolean cerrarMenu = false;
		String mensaje;

		try {

			while (!cerrarMenu) {
				int opcion = menu.eleccion();
				mensaje = "Se inicia el menu principal";
				fichero.ficheroLog(mensaje);
				switch (opcion) {
				case 0: {

					System.out.println("Se cierra el menu");
					mensaje = "Se cierra el menu";
					fichero.ficheroLog(mensaje);
					cerrarMenu = true;
					break;
				}
				case 1: {
					System.out.println("Menu de Empleado");
					mensaje = "Se accede al menu de Empleados";
					fichero.ficheroLog(mensaje);
					int opcionEmpleado = menu.menuEmpleado();
					switch (opcionEmpleado) {
					case 0: {
						System.out.println("Volver al menu de inicio");
						mensaje = "Se vuelve al menu de inicio";
						fichero.ficheroLog(mensaje);
						break;
					}
					case 1: {
						System.out.println("Validar nuevo paciente");
						mensaje = "Se valida un nuevo paciente";
						fichero.ficheroLog(mensaje);
						operativa.validarCliente(pacientes);
						break;
					}

					case 2: {
						System.out.println("Imprimir citas médicas para un día específico");
						mensaje = "Se imprimen las citas médicas para un día específico";
						fichero.ficheroLog(mensaje);
						operativa.imprimirCitas();
						break;
					}
					default:
						throw new IllegalArgumentException("Unexpected value: " + opcionEmpleado);
					}
					break;

				}

				case 2: {
					System.out.println("Menu de Paciente");
					mensaje = "Se accede al menú paciente";
					fichero.ficheroLog(mensaje);
					int opcionPaciente = menu.menuPaciente();
					switch (opcionPaciente) {
					case 0: {
						System.out.println("Volver al menu de inicio");
						mensaje = "Se vuelve al menú de inicio";
						fichero.ficheroLog(mensaje);
						break;
					}
					case 1: {
						System.out.println("Registro de cliente");
						mensaje = "Se registra un nuevo paciente";
						fichero.ficheroLog(mensaje);
						operativa.registroCliente(pacientes);
						break;
					}

					case 2: {
						System.out.println("Solicitud de cita médica");
						mensaje = "Se solicita una nueva cita  médica";
						fichero.ficheroLog(mensaje);
						operativa.SolicitudCitaMedica(citas, pacientes);
						break;
					}
					case 3: {
						System.out.println("Consultar citas médicas para un intervalo de tiempo");
						mensaje = "Se consultan las citas en el intervalo de tiempo especificado";
						fichero.ficheroLog(mensaje);
						operativa.entreFechas(citas, pacientes);
						break;
					}
					default:
						throw new IllegalArgumentException("Unexpected value: " + opcionPaciente);
					}
					break;

				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + opcion);
				}

			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en el inicio de la aplicación " + e.getMessage());
			mensaje = "Se ha producido un error al iniciar la aplicación";
			fichero.ficheroLog(mensaje);
		}
	}

}
