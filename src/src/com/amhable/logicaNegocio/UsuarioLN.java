package com.amhable.logicaNegocio;

import com.amhable.dominio.UsuarioDto;
import com.amhable.exception.MyException;

/**
 * Interface que contiene la logica del negocio que se va a implementar sobre la tabla Usuario 
 * en la Base de Datos
 * @author Luisa
 *18/06/2015
 */

public interface UsuarioLN {
	
	/**
	 * Firma del metodo obtenerUsuario
	 * 
	 *@param identificador del usuario que se va a obtener 
	 * @return UsuarioDto
	 * @throws MyException
	 */
	
	public UsuarioDto obtenerUsuario(String idUsuario) throws MyException;
	
	/**
	 * Firma del metodo guardar
	 * 
	 * @param identificador del usuario que se va a guardar 
	 * @param contraseña del usuario que se va a guardar
	 * @throws MyException
	 */
	public void guardar(String idUsuario, String contrasena) throws MyException;
	
		
	/**
	 * Firma del metodo actualizar
	 * 
	 * @param identificador del usuario que se va a actualizar 
	 * @param contraseña del usuario que se va a actualizar
	 * @throws MyException
	 */
	
	public void actualizar(String idUsuario, String contrasena) throws MyException;
}