package com.amhable.persistencia;

import java.util.List;

import com.amhable.dominio.TemaDto;
import com.amhable.exception.MyException;

/**
 * 
 * @author luis Galeano
 * Clase interface que define los metodor para realizar operaciones
 * sobre los temas
 * 
 *
 *
 */
public interface TemaDao {

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
	 * @param tema que se va a guardar en la base de datos
	 * @throws MyException
	 */
	public void guardar(TemaDto tema) throws MyException;
	
	/**
	 * Firma del metodo eliminar
	 * 
	 * @param tema que se va a eliminar de la base de datos
	 * @throws MyException
	 */
	public void eliminar(TemaDto tema) throws MyException;
	
	/**
	 * Firma del metodo actualizar
	 * 
	 * @param tema que se quiere actualizar
	 * @throws MyException
	 */
	public void actualizar(TemaDto tema) throws MyException;

}