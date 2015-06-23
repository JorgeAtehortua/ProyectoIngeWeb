package com.amhable.persistencia;

import java.util.List;

import com.amhable.dominio.ArchivoDto;
import com.amhable.dominio.CategoriaDto;
import com.amhable.dominio.TemaDto;
import com.amhable.exception.MyException;

/**
 * interface que contendra la definicion de los metodos para el manejo de las 
 * operaciones sobre los archivos
 * 
 * @author Jorge Atehortua
 *
 */
public interface ArchivoDao {
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
	 * @return un Archivo que coincida con el parametro ingresado.
	 * @throws MyException
	 */
	public List<ArchivoDto> obtenerArchivosPorCategoria(CategoriaDto categoria)throws MyException;
	/**
	 * Firma del metodo obtenerArchivoPorCategoriaYTema
	 * 
	 * @param la categoria  por la que se clasifica un archivo.
	 * @param el tema por la que se clasifica un archivo.
	 * @return un Archivo que coincida con los parametros ingresados.
	 * @throws MyException
	 */
	public List<ArchivoDto> obtenerArchivoPorCategoriaYTema(CategoriaDto categoria, TemaDto tema)throws MyException;
	/**
	 * Firma del metodo guardar
	 * 
	 * @param el archivo que sera guardado.
	 * @throws MyException
	 */
	public void guardar(ArchivoDto archivo)throws MyException;
	/**
	 * Firma del metodo eliminar
	 * 
	 * @param el archivo que se va a eliminar.
	 * @throws MyException
	 */
	public void eliminar(ArchivoDto archivo)throws MyException;
	/**
	 * Firma del metodo actualizar
	 * 
	 * @param el idArchivo del archivo que va actualizar.
	 * @param el archivo que se desea actualizar.
	 * @throws MyException
	 */
	public void actualizar(ArchivoDto archivo)throws MyException;

}