/**
 * 
 */
package com.amhable.logicaNegocio.imp;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.amhable.dominio.CategoriaDto;
import com.amhable.exception.MyException;
import com.amhable.logicaNegocio.CategoriaLN;
import com.amhable.persistencia.CategoriaDao;

/**
 * Clase que contiene la logica del negocio para realizar operaciones con la
 * tabla Categoria en la Base de datos
 * @author Luisa
 *19/06/2015
 */
public class CategoriaLNimp implements CategoriaLN{
	
	/**
	 * Objeto tipo CategortiaDto con el que se manejaran los datos de una categoria
	 */
	
	CategoriaDto categoria;
	
	/**
	 * Inyeccion del objeto CategoriaDao para poder hacer operaciones en la base de datos
	 */
	CategoriaDao categoriaDao;

	/**
	 * @return the categoriaDao
	 */
	public CategoriaDao getCategoriaDao() {
		return categoriaDao;
	}

	/**
	 * @param categoriaDao the categoriaDao to set
	 */
	public void setCategoriaDao(CategoriaDao categoriaDao) {
		this.categoriaDao = categoriaDao;
	}

	/** 
	 * Metodo en la logica del negocio mediante el cual se guarda una categoria 
	 * @see com.amhable.logicaNegocio.CategoriaLN#guardar(int, java.lang.String)
	 */
	@Override
	public void guardar(Integer idCategoria, String nombre) throws MyException {
		if(idCategoria==null || "".equals(idCategoria)){
			throw new MyException("El Identificador de la categoria no puede estar vacio");
		}
		if(nombre==null || "".equals(nombre)){
			throw new MyException("El nombre de la categoria no puede estar vacio");
		}
		categoria=new CategoriaDto();
		categoria.setIdCategoria(idCategoria);
		categoria.setNombre(nombre);
		try{
			categoriaDao.guardar(categoria);
		}catch(MyException e){
			Logger log = Logger.getLogger(this.getClass());
			log.error("Error guardando categoria: " + e);
			new MyException("Error guardando categoria"+ e);
		}
		
	}

	/** 
	 * Metodo en la logica del negocio mediante el cual se obtienen las categorias
	 * @see com.amhable.logicaNegocio.CategoriaLN#obtenerCategorias()
	 */
	@Override
	public List<CategoriaDto> obtenerCategorias() throws MyException {
		List<CategoriaDto> categorias= new ArrayList<CategoriaDto>();
		try{
			categorias= categoriaDao.obtenerCategorias();
		}catch(MyException e){
			Logger log=Logger.getLogger(this.getClass());
			log.error("Error obteniendo las categorias");
		}
		return categorias;
	}

	/** 
	 * Metodo en la logica del negocio mediante el cual se obtiene una categoria
	 * @see com.amhable.logicaNegocio.CategoriaLN#obtenerCategoria(java.lang.Integer)
	 */
	@Override
	public CategoriaDto obtenerCategoria(Integer idCategoria)
			throws MyException {
		if(idCategoria==null || "".equals(idCategoria)){
			throw new MyException("El Identificador de la categoria no puede estar vacio");
		}
		try{
			categoria= categoriaDao.obtenerCategoria(idCategoria);
		}catch(MyException e){
			Logger log=Logger.getLogger(this.getClass());
			log.error("Error obteniendo categoria");
		}
		return categoria;
	}

	/** 
	 * Metodo en la logica del negocio mediante el cual se actualiza una categoria
	 * @see com.amhable.logicaNegocio.CategoriaLN#actualizar(int, java.lang.String)
	 */
	@Override
	public void actualizar(Integer idCategoria, String nombre) throws MyException {
		if(idCategoria==null || "".equals(idCategoria)){
			throw new MyException("El Identificador de la categoria no puede estar vacio");
		}
		if(nombre==null || "".equals(nombre)){
			throw new MyException("El nombre de la categoria no puede estar vacio");
		}
		categoria=new CategoriaDto();
		categoria.setIdCategoria(idCategoria);
		categoria.setNombre(nombre);
		try{
			categoriaDao.actualizar(categoria);
		}catch(MyException e){
			Logger log = Logger.getLogger(this.getClass());
			log.error("Error actualizando categoria: " + e);
			new MyException("Error actualizando categoria"+ e);
		}
	}

	/** 
	 * Metodo en la logica del negocio mediante el cual se obtiene
	 * @see com.amhable.logicaNegocio.CategoriaLN#eliminar(java.lang.Integer)
	 */
	@Override
	public void eliminar(Integer idCategoria) throws MyException {
		if(idCategoria==null || "".equals(idCategoria)){
			throw new MyException("El Identificador de la categoria no puede estar vacio");
		}
						
		try{
			categoria=categoriaDao.obtenerCategoria(idCategoria);
			categoriaDao.eliminar(categoria);
		}catch(MyException e){
			Logger log = Logger.getLogger(this.getClass());
			log.error("Error eliminando categoria: " + e);
			new MyException("Error eliminando categoria"+ e);
		}
	}
	
	
	
}
