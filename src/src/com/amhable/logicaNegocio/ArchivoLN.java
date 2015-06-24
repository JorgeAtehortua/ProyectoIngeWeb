/**
 * 
 */
package com.amhable.logicaNegocio;

import java.util.Date;
import java.util.List;

import com.amhable.dominio.ArchivoDto;
import com.amhable.dominio.CategoriaDto;
import com.amhable.dominio.TemaDto;
import com.amhable.exception.MyException;

/**
 * Interface que contiene la logica del negocio que se va a implementar sobre la tabla Archivo 
 * en la Base de Datos
 * @author Luisa
 *18/06/2015
 */
public interface ArchivoLN {
	/**
	 * Firma del metodo obtener
	 * 
	 * @return lista de archivos
	 * @throws MyException
	 */
	public  List<ArchivoDto> obtener() throws MyException;
	/**
	 * Firma del metodo obtenerArchivo
	 * 
	 * @param el idArchivo con el cual se realizara la busqueda.
	 * @return un Archivo que coincida con el parametro ingresado.
	 * @throws MyException
	 */
	public ArchivoDto obtenerArchivo(Integer idArchivo)throws MyException;
	/**
	 * Firma del metodo obtenerArchivoPorNombre
	 * 
	 * @param el nombre del archivo con el cual se realizara la busqueda.
	 * @return un Archivo que coincida con el parametro ingresado.
	 * @throws MyException
	 */
	public ArchivoDto obtenerArchivoPorNombre(String nombre)throws MyException;
	/**
	 * Firma del metodo obtenerArchivosPorCategoria
	 * 
	 * @param la categoria por la que se clasifica un archivo.
	 * @return Una lista de archivos que coincidan con el parametro ingresado.
	 * @throws MyException
	 */
	public List<ArchivoDto> obtenerArchivosPorCategoria(Integer idCategoria)throws MyException;
	/**
	 * Firma del metodo obtenerArchivoPorCategoriaYTema
	 * 
	 * @param la categoria  por la que se clasifica un archivo.
	 * @param el tema por la que se clasifica un archivo.
	 * @return Una lista de archivos que coincidan con los parametros ingresados.
	 * @throws MyException
	 */
	public List<ArchivoDto> obtenerArchivoPorCategoriaYTema(Integer idCategoria, Integer idTema)throws MyException;
	/**
	 * Firma del metodo con el cual se guardaran los archivos en la base de datos.
	 * 
	 * @param idArchivo del archivo a guardar
	 * @param nombre del archivo a guardar
	 * @param fecha del archivo a guardar
	 * @param contrasena del archivo a guardar
	 * @param rutaArchivo del archivo a guardar
	 * @param categoria_idCategoria del archivo a guardar
	 * @param tema_idTema del archivo a guardar
	 * @throws MyException del archivo a guardar
	 */
	public void guardar(Integer idArchivo, String nombre, Date fecha, String contrasena, String rutaArchivo, 
			CategoriaDto categoria_idCategoria, TemaDto tema_idTema)throws MyException;
	/**
	 * Firma del metodo con el cual se eliminaran archivos de la base de datos.
	 * 
	 * @param idArchivo del archivo a eliminar
	 * @throws MyException del archivo a eliminar
	 */
	public void eliminar(Integer idArchivo)throws MyException;
	/**
	 * Firma del metodo con el cual se realizaran las actualizacion de los archivos de la base de datos
	 * 
	 * @param idArchivo del archivo a actualizar
	 * @param nombre del archivo a actualizar
	 * @param fecha del archivo a actualizar
	 * @param contrasena del archivo a actualizar
	 * @param rutaArchivo del archivo a actualizar
	 * @param categoria_idCategoria del archivo a actualizar
	 * @param tema_idTema del archivo a actualizar
	 * @throws MyException del archivo a actualizar
	 */
	public void actualizar(Integer idArchivo, String nombre, Date fecha, String contrasena, String rutaArchivo, 
			CategoriaDto categoria_idCategoria, TemaDto tema_idTema)throws MyException;

}