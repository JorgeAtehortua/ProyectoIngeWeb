/**
 * 
 */
package com.amhable.logicaNegocio.imp;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;


import com.amhable.dominio.TemaDto;
import com.amhable.exception.MyException;
import com.amhable.logicaNegocio.TemaLN;
import com.amhable.persistencia.TemaDao;

/**
 * Clase que contiene la logica del negocio para realizar operaciones con la
 * tabla Categoria en la Base de datos
 * @author Luisa
 *19/06/2015
 */
public class TemaLNimp implements TemaLN{
	/**
	 * Objeto tipo TemaDto con el que se manejaran los datos de una categoria
	 */
	TemaDto tema;
	
	/**
	 * Inyeccion del objeto CategoriaDao para poder hacer operaciones en la base de datos
	 */
	TemaDao temaDao;
	
	/**
	 * @return the temaDao
	 */
	public TemaDao getTemaDao() {
		return temaDao;
	}

	/**
	 * @param temaDao the temaDao to set
	 */
	public void setTemaDao(TemaDao temaDao) {
		this.temaDao = temaDao;
	}
	

	/**
	 * Metodo en la logica del negocio mediante el cual se obtienen los temas
	 * @see com.amhable.logicaNegocio.TemaLN#obtenerTemas()
	 */
	@Override
	public List<TemaDto> obtenerTemas() throws MyException {
		List<TemaDto> temas= new ArrayList<TemaDto>();
		try{
			temas= temaDao.obtenerTemas();
		}catch(MyException e){
			Logger log=Logger.getLogger(this.getClass());
			log.error("Error obteniendo los temas");
		}
		return temas;
	}

	/**
	 * Metodo en la logica del negocio mediante el cual se obtiene un tema 
	 * @see com.amhable.logicaNegocio.TemaLN#obtenerTema(java.lang.Integer)
	 */
	@Override
	public TemaDto obtenerTema(Integer idTema) throws MyException {
		if(idTema==null || "".equals(idTema)){
			throw new MyException("El Identificador del tema no puede estar vacio");
		}
		try{
			tema= temaDao.obtenerTema(idTema);
		}catch(MyException e){
			Logger log=Logger.getLogger(this.getClass());
			log.error("Error obteniendo categoria");
		}
		return tema;
	}

	/**
	 * Metodo en la logica del negocio mediante el cual se guarda un tema
	 * @see com.amhable.logicaNegocio.TemaLN#guardar(java.lang.Integer, java.lang.String, java.lang.Integer)
	 */
	@Override
	public void guardar(Integer idTema, String nombre,
			Integer categoria_idCategoria) throws MyException {
		if(idTema==null || "".equals(idTema)){
			throw new MyException("El Identificador del tema no puede estar vacio");
		}
		if(nombre==null || "".equals(nombre)){
			throw new MyException("El nombre del tema no puede estar vacio");
		}
		if(categoria_idCategoria==null || "".equals(categoria_idCategoria)){
			throw new MyException("El nombre del tema no puede estar vacio");
		}
		tema=new TemaDto();
		tema.setCategoria_idCategoria(categoria_idCategoria);
		tema.setIdTema(idTema);
		tema.setNombre(nombre);
		
		try{
			temaDao.guardar(tema);
		}catch(MyException e){
			Logger log = Logger.getLogger(this.getClass());
			log.error("Error guardando tema: " + e);
			new MyException("Error guardando tema"+ e);
		}
		
	}

	/**
	 * Metodo en la logica del negocio mediante el cual se elimina un tema
	 * @see com.amhable.logicaNegocio.TemaLN#eliminar(java.lang.Integer, java.lang.String, java.lang.Integer)
	 */
	@Override
	public void eliminar(Integer idTema) throws MyException {
		if(idTema==null || "".equals(idTema)){
			throw new MyException("El Identificador del tema no puede estar vacio");
		}
		
		try{
			tema=temaDao.obtenerTema(idTema);
			temaDao.eliminar(tema);
		}catch(MyException e){
			Logger log = Logger.getLogger(this.getClass());
			log.error("Error eliminando tema: " + e);
			new MyException("Error eliminando tema"+ e);
		}
		
	}

	/**
	 * Metodo en la logica del negocio mediante el cual se actualiza un tema
	 * @see com.amhable.logicaNegocio.TemaLN#actualizar(java.lang.Integer, java.lang.String, java.lang.Integer)
	 */
	@Override
	public void actualizar(Integer idTema, String nombre,
			Integer categoria_idCategoria) throws MyException {
		if(idTema==null || "".equals(idTema)){
			throw new MyException("El Identificador del tema no puede estar vacio");
		}
		if(nombre==null || "".equals(nombre)){
			throw new MyException("El nombre del tema no puede estar vacio");
		}
		if(categoria_idCategoria==null || "".equals(categoria_idCategoria)){
			throw new MyException("El nombre del tema no puede estar vacio");
		}
		tema=new TemaDto();
		tema.setCategoria_idCategoria(categoria_idCategoria);
		tema.setIdTema(idTema);
		tema.setNombre(nombre);
		
		try{
			temaDao.actualizar(tema);
		}catch(MyException e){
			Logger log = Logger.getLogger(this.getClass());
			log.error("Error actualizando tema: " + e);
			new MyException("Error actualizando tema"+ e);
		}
		
	}
	

}
