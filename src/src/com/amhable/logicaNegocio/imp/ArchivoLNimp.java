/**
 * 
 */
package com.amhable.logicaNegocio.imp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.amhable.dominio.ArchivoDto;
import com.amhable.dominio.CategoriaDto;
import com.amhable.dominio.TemaDto;
import com.amhable.exception.MyException;
import com.amhable.logicaNegocio.ArchivoLN;
import com.amhable.persistencia.ArchivoDao;
import com.amhable.persistencia.CategoriaDao;
import com.amhable.persistencia.TemaDao;

/**
 * Clase que contiene la logica del negocio para realizar operaciones con la
 * tabla Archivo en la Base de datos
 * 
 * @author Luisa 19/06/2015
 */
public class ArchivoLNimp implements ArchivoLN {
	Logger log = Logger.getLogger(this.getClass());
	/**
	 * Objeto tipo ArchivoDto con el que se manejaran los datos de una categoria
	 */
	ArchivoDto archivo;
	/**
	 * Inyeccion del objeto TemaDao para poder hacer operaciones en la base de
	 * datos
	 */
	TemaDao temaDao;

	/**
	 * Inyeccion del objeto CategoriaDao para poder hacer operaciones en la base
	 * de datos
	 */
	CategoriaDao categoriaDao;

	/**
	 * Inyeccion del objeto ArchivoDao para poder hacer operaciones en la base
	 * de datos
	 */
	ArchivoDao archivoDao;

	/**
	 * @return the archivoDao
	 */
	public ArchivoDao getArchivoDao() {
		return archivoDao;
	}

	/**
	 * @param archivoDao
	 *            the archivoDao to set
	 */
	public void setArchivoDao(ArchivoDao archivoDao) {
		this.archivoDao = archivoDao;
	}

	/**
	 * @return the temaDao
	 */
	public TemaDao getTemaDao() {
		return temaDao;
	}

	/**
	 * @param temaDao
	 *            the temaDao to set
	 */
	public void setTemaDao(TemaDao temaDao) {
		this.temaDao = temaDao;
	}

	/**
	 * @return the categoriaDao
	 */
	public CategoriaDao getCategoriaDao() {
		return categoriaDao;
	}

	/**
	 * @param categoriaDao
	 *            the categoriaDao to set
	 */
	public void setCategoriaDao(CategoriaDao categoriaDao) {
		this.categoriaDao = categoriaDao;
	}

	/**
	 * Metodo en la logica del negocio mediante el cual se obtienen una lista de
	 * archivos
	 * 
	 * @see com.amhable.logicaNegocio.ArchivoLN#obtener()
	 */
	@Override
	public List<ArchivoDto> obtener() throws MyException {
		List<ArchivoDto> archivos = new ArrayList<ArchivoDto>();
		try {
			archivos = archivoDao.obtener();
		} catch (MyException e) {
			Logger log = Logger.getLogger(this.getClass());
			log.error("Error obteniendo los archivos");
		}
		return archivos;
	}

	/**
	 * Metodo en la logica del negocio mediante el cual se obtiene un archivo
	 * segun el identificador
	 * 
	 * @see com.amhable.logicaNegocio.ArchivoLN#obtenerArchivo(java.lang.Integer)
	 */
	@Override
	public ArchivoDto obtenerArchivo(Integer idArchivo) throws MyException {
		if (idArchivo == null || "".equals(idArchivo)) {
			throw new MyException(
					"El Identificador del archivo no puede estar vacio");
		}
		try {
			archivo = archivoDao.obtenerArchivo(idArchivo);
		} catch (MyException e) {
			Logger log = Logger.getLogger(this.getClass());
			log.error("Error obteniendo archivo por idArchivo");
		}
		return archivo;
	}

	/**
	 * Metodo en la logica del negocio mediante el cual se obtiene un archivo
	 * segun el nombre
	 * 
	 * @see com.amhable.logicaNegocio.ArchivoLN#obtenerArchivoPorNombre(java.lang.String)
	 */
	@Override
	public ArchivoDto obtenerArchivoPorNombre(String nombre) throws MyException {
		if (nombre == null || "".equals(nombre)) {
			throw new MyException("El nombre del archivo no puede estar vacio");
		}
		try {
			archivo = archivoDao.obtenerArchivoPorNombre(nombre);
		} catch (MyException e) {
			Logger log = Logger.getLogger(this.getClass());
			log.error("Error obteniendo archivo por nombre");
		}
		return archivo;
	}

	/**
	 * Metodo en la logica del negocio mediante el cual se obtienen una lista de
	 * archivos segun la categoria
	 * 
	 * @see com.amhable.logicaNegocio.ArchivoLN#obtenerArchivosPorCategoria(java.lang.Integer)
	 */
	@Override
	public List<ArchivoDto> obtenerArchivosPorCategoria(Integer idCategoria)
			throws MyException {
		List<ArchivoDto> archivos = new ArrayList<ArchivoDto>();
		CategoriaDto categoria = new CategoriaDto();
		if (idCategoria == null || "".equals(idCategoria)) {
			throw new MyException(
					"El Identificador de la categoria a la que pertenece el archivo no puede estar vacio");
		}
		
		try {
			categoria=categoriaDao.obtenerCategoria(idCategoria);
			archivos = archivoDao.obtenerArchivosPorCategoria(categoria);
		} catch (MyException e) {
			Logger log = Logger.getLogger(this.getClass());
			log.error("Error obteniendo archivo por categoria");
		}
		return archivos;
	}

	/**
	 * Metodo en la logica del negocio mediante el cual se obtienen una lista de
	 * archivos segun la categoria y el tema
	 * 
	 * @see com.amhable.logicaNegocio.ArchivoLN#obtenerArchivoPorCategoriaYTema(java.lang.Integer,
	 *      java.lang.Integer)
	 */
	@Override
	public List<ArchivoDto> obtenerArchivoPorCategoriaYTema(
			Integer idCategoria, Integer idTema) throws MyException {
		CategoriaDto categoria = new CategoriaDto();
		TemaDto tema = new TemaDto();

		List<ArchivoDto> archivos = new ArrayList<ArchivoDto>();
		if (idCategoria == null || "".equals(idCategoria)) {
			throw new MyException(
					"El Identificador de la categoria a la que pertenece el archivo no puede estar vacio");
		}
		if (idTema == null || "".equals(idTema)) {
			throw new MyException(
					"El Identificador del tema a la que pertenece el archivo no puede estar vacio");
		}
		try {
			categoria=categoriaDao.obtenerCategoria(idCategoria);
			tema=temaDao.obtenerTema(idTema);
			archivos = archivoDao.obtenerArchivoPorCategoriaYTema(categoria,tema);
		} catch (MyException e) {
			Logger log = Logger.getLogger(this.getClass());
			log.error("Error obteniendo archivo por categoria y tema");
		}
		return archivos;
	}

	/**
	 * Metodo en la logica del negocio mediante el cual se guarda un archivo
	 * 
	 * @see com.amhable.logicaNegocio.ArchivoLN#guardar(com.amhable.dominio.ArchivoDto)
	 */
	@Override
	public void guardar(Integer idArchivo, String nombre, Date fecha,
			String contrasena, String rutaArchivo, Integer idCategoria,
			Integer idTema) throws MyException {
		if (idArchivo == null || "".equals(idArchivo)) {
			throw new MyException(
					"El Identificador del archivo no puede estar vacio");
		}
		if (nombre == null || "".equals(nombre)) {
			throw new MyException("El nombre del archivo no puede estar vacio");
		}
		if (fecha == null || "".equals(fecha)) {
			throw new MyException(
					"la fecha de creacion del archivo no puede estar vacio");
		}
		if (contrasena == null || "".equals(contrasena)) {
			throw new MyException(
					"La contraseña del archivo no puede estar vacio");
		}
		if (rutaArchivo == null || "".equals(rutaArchivo)) {
			throw new MyException("La ruta del archivo no puede estar vacio");
		}
		if (idCategoria == null || "".equals(idCategoria)) {
			throw new MyException(
					"La categoria a la que pertenece el archivo no puede estar vacio");
		}
		if (idTema == null || "".equals(idTema)) {
			throw new MyException(
					"El tema al que pertenece el archivo no puede estar vacio");
		}
		archivo = new ArchivoDto();
		CategoriaDto categoria = new CategoriaDto();
		TemaDto tema = new TemaDto();
		archivo.setcontrasena(contrasena);
		archivo.setFecha(fecha);
		archivo.setIdArchivo(idArchivo);
		archivo.setNombre(nombre);
		archivo.setRutaArchivo(rutaArchivo);

		try {
			categoria = categoriaDao.obtenerCategoria(idCategoria);
			archivo.setCategoria_idCategoria(categoria);
			tema = temaDao.obtenerTema(idTema);
			archivo.setTema_idTema(tema);
			archivoDao.guardar(archivo);
		} catch (MyException e) {
			Logger log = Logger.getLogger(this.getClass());
			log.error("Error guardando archivo ");
		}

	}

	/**
	 * Metodo en la logica del negocio mediante el cual se elimina un archivo
	 * 
	 * @see com.amhable.logicaNegocio.ArchivoLN#eliminar(com.amhable.dominio.ArchivoDto)
	 */
	@Override
	public void eliminar(Integer idArchivo) throws MyException {
		if (idArchivo == null || "".equals(idArchivo)) {
			throw new MyException(
					"El Identificador del archivo no puede estar vacio");
		}

		try {
			archivo = archivoDao.obtenerArchivo(idArchivo);
			archivoDao.eliminar(archivo);
		} catch (MyException e) {
			
			log.error("Error eliminando archivo ");
		}

	}

	/**
	 * Metodo en la logica del negocio mediante el cual se actualizar un archivo
	 * 
	 * @see com.amhable.logicaNegocio.ArchivoLN#actualizar(com.amhable.dominio.ArchivoDto)
	 */
	@Override
	public void actualizar(Integer idArchivo, String nombre, Date fecha,
			String contrasena, String rutaArchivo, Integer idCategoria,
			Integer idTema) throws MyException {
		if (idArchivo == null || "".equals(idArchivo)) {
			throw new MyException(
					"El Identificador del archivo no puede estar vacio");
		}
		if (nombre == null || "".equals(nombre)) {
			throw new MyException("El nombre del archivo no puede estar vacio");
		}
		if (fecha == null || "".equals(fecha)) {
			throw new MyException(
					"la fecha de creacion del archivo no puede estar vacio");
		}
		if (contrasena == null || "".equals(contrasena)) {
			throw new MyException(
					"La contraseña del archivo no puede estar vacio");
		}
		if (rutaArchivo == null || "".equals(rutaArchivo)) {
			throw new MyException("La ruta del archivo no puede estar vacio");
		}
		if (idCategoria == null || "".equals(idCategoria)) {
			throw new MyException(
					"La categoria a la que pertenece el archivo no puede estar vacio");
		}
		if (idTema == null || "".equals(idTema)) {
			throw new MyException(
					"El tema al que pertenece el archivo no puede estar vacio");
		}
		archivo = new ArchivoDto();
		CategoriaDto categoria = new CategoriaDto();
		TemaDto tema = new TemaDto();

		
		try {
			categoria = categoriaDao.obtenerCategoria(idCategoria);
			archivo.setCategoria_idCategoria(categoria);
			tema = temaDao.obtenerTema(idTema);
			archivo.setTema_idTema(tema);
			archivo.setcontrasena(contrasena);
			archivo.setFecha(fecha);
			archivo.setIdArchivo(idArchivo);
			archivo.setNombre(nombre);
			archivo.setRutaArchivo(rutaArchivo);
			
			archivoDao.actualizar(archivo);
		} catch (MyException e) {
			Logger log = Logger.getLogger(this.getClass());
			log.error("Error actualizando archivo ");
		}
	}

}