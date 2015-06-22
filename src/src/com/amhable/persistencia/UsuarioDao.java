package com.amhable.persistencia;


import com.amhable.dominio.UsuarioDto;
import com.amhable.exception.MyException;

/**
 * 
 * @author Luis Galeano
 *
 */
public interface UsuarioDao {
	
	/**
	 * Firma del metodo obtenerUsuarios
	 * 
	 * @return Lista con los usuarios en la base de datos
	 * @throws MyException
	*/
	//public List<UsuarioDto> obtenerUsuarios() throws MyException;
	 
	
	/**
	 * Firma del metodo obtenerUsuario
	 * 
	 * @param idUsuario
	 * @return UsuarioDto
	 * @throws MyException
	 */
	
	public UsuarioDto obtenerUsuario(String idUsuario) throws MyException;
	
	/**
	 * Firma del metodo guardar
	 * 
	 * @param usuario que se va a guardar en la base de datos
	 * @throws MyException
	 */
	public void guardar(UsuarioDto usuario) throws MyException;
	
	/**
	 * Firma del metodo eliminar
	 * 
	 * @param usuario que se va a eliminar
	 * @throws MyException
	 */
	//public void eliminar(UsuarioDto usuario) throws MyException;
	
	
	/**
	 * Firma del metodo actualizar
	 * 
	 * @param usuario que se va a actualizar
	 * @throws MyException
	 */
	
	public void actualizar(UsuarioDto usuario) throws MyException;
}