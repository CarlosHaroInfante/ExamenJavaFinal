package edu.servicios;

/*
 * Autor Carlos Haro Infante 09/05/2024
 * Interfaz que contiente todo los metodos de los menús.
 * **/
public interface MenuInterfaz {

	/*
	 * Autor Carlos Haro Infante 09/05/2024
	 * Método encargado de la elección del menú del emplado.
	 * **/
	public int menuEmpleado();
	/*
	 * Autor Carlos Haro Infante 09/05/2024
	 * Método encargado de la elección del menú del paciente.
	 * **/
	public int menuPaciente();
	/*
	 * Autor Carlos Haro Infante 09/05/2024
	 * Método encargado de la elección del menú principal.
	 * **/
	public int eleccion();
	/*
	 * Autor Carlos Haro Infante 09/05/2024
	 * Método encargado de la elección del menú de citas.
	 * **/
	public int menuCitas();
}
