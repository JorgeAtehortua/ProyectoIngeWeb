package com.amhable.logicaNegocio;

import java.util.List;

import com.amhable.dominio.CategoriaDto;
import com.amhable.exception.MyException;

/**
 * Interface que contiene la logica del negocio que se va a implementar sobre la tabla Categoria 
 * en la Base de Datos
 * @author Luisa
 *18/06/2015
 */
public interface CategoriaLN {

	/**
	 * Firma del metodo guardar
	 * 
	 * @param identificador de la categoria que se va guardar
	 * @param nombre de la categoria que se va guardar
	 * @throws MyException
	 */
	public void guardar(Integer idCategoria, String nombre) throws MyException;
	
	/**
	 * Firma del metododo obtenerCategorias
	 * 
	 * @return Listado de las categorias en la base de datos
	 * @throws MyException
	 */
	public List<CategoriaDto> obtenerCategorias()throws MyException;
	/**
	 * Firma del metodo obtenerCategoria
	 * 
	 * @param idCategoria que se va obtener
	 * @return Categoria que coincide con el parametro de busqueda
	 * @throws MyException
	 */
	public CategoriaDto obtenerCategoria(Integer idCategoria)throws MyException;
	/**
	 * Firma del metodo actualizar
	 * 
	 * @param identificador de la categoria que se va a actualizar
	 * @param nombre de la categoria que se va a actualizar
	 * @throws MyException
	 */
	
	public void actualizar(Integer idCategoria, String nombre)throws MyException;
	/**
	 * Firma del metodo eliminar
	 * 
	 * @param identificador de la categoria que se va a eliminar
	 * @throws MyException
	 */
	public void eliminar(Integer idCategoria)throws MyException;
}
