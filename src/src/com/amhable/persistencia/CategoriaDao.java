package com.amhable.persistencia;

import java.util.List;

import com.amhable.dominio.CategoriaDto;
import com.amhable.exception.MyException;

/**
 * La siguiente interface sera la engargada de definir los diferentes 
 * metodos para el manejo de las categorias.
 * 
 * @author Jorge Atehortua
 *
 */

public interface CategoriaDao {
	
	/**
	 * Firma del metodo guardar
	 * 
	 * @param categoria que se va guardar
	 * @throws MyException
	 */
	public void guardar(CategoriaDto categoria) throws MyException;
	
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
	 * @param categoria que se va actualizar
	 * @throws MyException
	 */
	
	public void actualizar(CategoriaDto categoria)throws MyException;
	/**
	 * Firma del metodo eliminar
	 * 
	 * @param categoria que se va eliminar
	 * @throws MyException
	 */
	public void eliminar(CategoriaDto categoria)throws MyException;
	
}