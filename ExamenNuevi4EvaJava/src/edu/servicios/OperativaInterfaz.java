package edu.servicios;

import java.util.List;

import edu.dtos.CitasDto;
import edu.dtos.PacienteDto;
/**
 * Autor Carlos Haro Infante 09/05/2024
 * Interfaz donde se guardan los metodos relacionados con la operativa de la aplicación 
 * */
public interface OperativaInterfaz {

	/**
	 * Autor Carlos Haro Infante 09/05/2024
	 * Método que registra el paciente y lo añade a la listaPacientes.
	 * */
	public void registroCliente(List<PacienteDto> listaPacientes);
	
	/**
	 * Autor Carlos Haro Infante 09/05/2024
	 * Método que valida el cliente a través del campo dni.
	 * */
	public void validarCliente(List<PacienteDto> listaPacientes);
	
	/**
	 * Autor Carlos Haro Infante 09/05/2024
	 * Método que abre un menú, donde puedes pedir una cita en la especialidad deseada, solo poniendo el dia y hora.
	 * */
	public void SolicitudCitaMedica(List<CitasDto> listaCitas, List<PacienteDto> listaPacientes);
	
	/**
	 * Autor Carlos Haro Infante 09/05/2024
	 * Método que muestra las citas entre 2 fecha que indica el usuario.
	 * */
	
	public void entreFechas(List<CitasDto> listaCitas, List<PacienteDto> listaPacientes);
	
	/**
	 * Autor Carlos Haro Infante 09/05/2024
	 * Método que crea un string y lo  pasa  al método del ficheroInterfaz y ficheroImplementacion para que se realice el imprimir  citas de un dia específico.
	 * */
	public void imprimirCitas();
	
}
