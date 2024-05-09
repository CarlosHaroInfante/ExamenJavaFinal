package edu.servicios;

/*
 * Autor Carlos 09/03/2024
 * Interfaz donde se encuentran los métodos relacionados con ficheros.
 * **/
public interface FicheroInterfaz {

	/*
	 * Autor Carlos 09/03/2024
	 * Método que crea, escribe y cierra el fichero log.
	 * **/
	public void ficheroLog(String mensaje);
	
	/*
	 * Autor Carlos 09/03/2024
	 * Método que crea, escribe y cierra el fichero de informes con una fecha específica.
	 * **/
	public void informe(String fechaInforme);
}
