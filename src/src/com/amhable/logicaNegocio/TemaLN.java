/**
 * 
 */
package com.amhable.logicaNegocio;

import java.util.List;

import com.amhable.dominio.CategoriaDto;
import com.amhable.dominio.TemaDto;
import com.amhable.exception.MyException;

/**
 * Interface que contiene la logica del negocio que se va a implementar sobre la tabla Tema 
 * en la Base de Datos
 * @author Luisa
 *18/06/2015
 */
public interface TemaLN {
	/**
	 * Firma el metodo obtenerTemas
	 * 
	 * @return Lista de los temas en la base de datos
	 * @throws MyException
	 */
	public List<TemaDto> obtenerTemas() throws MyException;
	
	/**
	 * Firma el metodo obtenerTema
	 * 
	 * @param idTema que se va a obtener
	 * @return Archivo con idArchivo pasado como parametro
	 * @throws MyException
	 */
	public TemaDto obtenerTema(Integer idTema) throws MyException;
	
	/**
	 * Firma del metodo guardar
	 * 
	 * @param identificador del tema que se va a guardar 
	 * @param nombre del tema que se va a guardar 
	 * @param el identificador de la categoria a la que pertenece el tema que se va a guardar 
	 * @throws MyException
	 */
	public void guardar(Integer idTema, String nombre, Integer categoria) throws MyException;
	
	/**
	 * Firma del metodo eliminar
	 * @param identificador del tema que se va a eliminar 
	 * @throws MyException
	 */
	public void eliminar(Integer idTema) throws MyException;
	
	/**
	 * Firma del metodo actualizar
	 * @param identificador del tema que se va a actualizar 
	 * @param nombre del tema que se va a actualizar 
	 * @param el identificador de la categoria a la que pertenece el tema que se va a actualizar
	 * @throws MyException
	 */
	public void actualizar(Integer idTema, String nombre, Integer categoria) throws MyException;

}
