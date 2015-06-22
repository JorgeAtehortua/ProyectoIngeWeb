package com.amhable.persistencia.implementacion;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.amhable.dominio.ArchivoDto;
import com.amhable.exception.MyException;
import com.amhable.persistencia.ArchivoDao;




/**
 * Clase encargada de implementar los metodos que se definieron en la interface
 * ArchivoDao.
 * 
 * @author Jorge Atehortua
 *
 */
public class ArchivoDaoImp extends HibernateDaoSupport  implements ArchivoDao{
	Logger log = Logger.getLogger(this.getClass());
	/**
	 * Metodo obtener() sera el encargado de retornar la lista de archivos
	 * que se encuentren presentes en la base de datos.
	 * @return lista de archivos
	 * @throws MyException 
	 */
	@SuppressWarnings("unchecked")
	public List<ArchivoDto> obtener() throws MyException {
		Session session=null;
		
		try{
			List<ArchivoDto> archivos=null;
			session=getSession(); 
			Criteria criteria=session.createCriteria(ArchivoDto.class);
			archivos=criteria.list();
			return archivos;
		}catch(HibernateException e){
			log.error("ERROR obteniendo lista de archivos: ", e);
			throw new MyException(e);			
		}finally{
			
		}
		
	}
	/**
	 * Metodo obtenerArchivo(Integer idArchivo) sera el encargado de obtener
	 * un archivo desde la base de datos buscando por idArchivo.
	 * 
	 * @param el idArchivo con el cual se realizara la busqueda.
	 * @return un Archivo que coincida con el parametro ingresado.
	 * @throws MyException
	 */
	public ArchivoDto obtenerArchivo(Integer idArchivo) throws MyException {
		Session session=null;
		
		
		try {
			ArchivoDto archivo = null;
			session=getSession();
			archivo = (ArchivoDto)session.get(ArchivoDto.class, idArchivo);
			return archivo;
		}catch(HibernateException e){
			log.error("ERROR obteniendo archivo: ", e);
			throw new MyException(e);			
		}finally{
//			if(session!=null){
//				session.close();
//			}
			
		}
		
	}
	/**
	 * Metodo obtenerArchivosPorCategoria(Integer idCategoria) sera el encargado de obtener
	 * una lista de archivos buscando por idCategoria.
	 * 
	 * @param el idCategoria con el cual se realizara la busqueda.
	 * @return un Archivo que coincida con el parametro ingresado.
	 * @throws MyException
	 */
	@SuppressWarnings("unchecked")
	public List<ArchivoDto> obtenerArchivosPorCategoria(Integer idCategoria)throws MyException {
		Session session=null;
		List<ArchivoDto> archivos=null;

		try{
			session=getSession(); 
			Criteria criteria=session.createCriteria(ArchivoDto.class).add(Restrictions.eq("categoria.idCategoria", idCategoria));
			archivos=criteria.list();
		}catch(HibernateException e){
			log.error("ERROR obteniendo lista de archivos por categoria: ", e);
			throw new MyException(e);			
		}finally{
//			if(session!=null){
//				session.close();
//			}
			
		}
		return archivos;
	}
	
	/**
	 * Metodo obtenerArchivoPorCategoriaYTema(Integer idCategoria, Integer idTema) sera el encargado de obtener
	 * una lista de archivos buscando por idCategoria y idTema.
	 * 
	 * @param el idCategoria con el cual se realizara la busqueda.
	 * @param el idTema con el cual se realizara la busqueda.
	 * @return un Archivo que coincida con el parametro ingresado.
	 * @throws MyException
	 */
	@SuppressWarnings("unchecked")
	public List<ArchivoDto> obtenerArchivoPorCategoriaYTema(Integer idCategoria, Integer idTema) throws MyException {
		Session session=null;
		List<ArchivoDto> archivos=null;

		try{
			session=getSession(); 
			Criteria criteria=session.createCriteria(ArchivoDto.class).add(Restrictions.eq("categoria.idCategoria", idCategoria)).add(Restrictions.eq("tema.idTema", idTema));
			archivos=criteria.list();
		}catch(HibernateException e){
			log.error("ERROR obteniendo lista de archivos por categoria: ", e);
			throw new MyException(e);			
		}finally{
//			if(session!=null){
//				session.close();
//			}
			
		}
		return archivos;
	}
	/**
	 * Metodo obtenerArchivo(String nombre) sera el encargado de obtener
	 * un archivo desde la base de datos buscando por nombre.
	 * 
	 * @param el nombre del archivo con el cual se realizara la busqueda.
	 * @return un Archivo que coincida con el parametro ingresado.
	 * @throws MyException
	 */
	public ArchivoDto obtenerArchivo(String nombre) throws MyException {
		Session session=null;
		ArchivoDto archivo = null;
		
		try {
			session=getSession();
			archivo = (ArchivoDto)session.get(ArchivoDto.class, nombre);
		
		}catch(HibernateException e){
			log.error("ERROR obteniendo archivo: ", e);
			throw new MyException(e);			
		}finally{
//			if(session!=null){
//				session.close();
//			}
			
		}
		return archivo;
	}
	/**
	 * Metodo guardar encargado de guardar una archivo en la bases de datos.
	 * 
	 * @param el archivo que sera guardado.ArchivoDaoImp
	 * @throws MyException
	 */
	public void guardar(ArchivoDto archivo) throws MyException {
		Session session = null;
		
		try {
			session =getSession();
			Transaction tx = session.beginTransaction();
			session.save(archivo);
			session.flush();
			tx.commit();
			
		} catch(HibernateException e){
			log.error("ERROR guardando archivo: ", e);
			throw new MyException(e);			
		}finally{
//			if(session!=null){
//				session.close();
//			}
		}
		
	}
	/**
	 * Metodo eliminar sera el encargado de eliminar un archivo de la base de datos.
	 * 
	 * @param el archivo que se va a eliminar.
	 * @throws MyException 
	 */
	public void eliminar(ArchivoDto archivo) throws MyException {
		Session session = null;
		
		try {
			session = getSession();
			
			Transaction tx = session.beginTransaction();
			session.delete(archivo);
			tx.commit();
			
		} catch(HibernateException e){
			log.error("ERROR eliminando archivo: ", e);
			throw new MyException(e);			
		}finally{
//			if(session!=null){
//				session.close();
//			}
		}
	}
	/**
	 * Metodo actualizar sera el encargado de actualizar un archivo en la base de datos.
	 * 
	 * @param el archivo que se desea actualizar.
	 * @throws MyException 
	 */
	
	public void actualizar(ArchivoDto archivo) throws MyException {
		Session session = null;
		
		try {
			session = getSession();
			Transaction tx = session.beginTransaction();
			session.update(archivo);
			tx.commit();
			
		} catch(HibernateException e){
			log.error("ERROR: ", e);
			throw new MyException(e);			
		}finally{
//			if(session!=null){
//				session.close();
//			}
		}
		
	}
	/**
	 * Metodo obtenerArchivoPorNombre(String nombre) sera el encargado de obtener
	 * un archivo desde la base de datos buscando por nombre.
	 * 
	 * @param el nombre del archivo con el cual se realizara la busqueda.
	 * @return un Archivo que coincida con el parametro ingresado.
	 * @throws MyException
	 */
	public ArchivoDto obtenerArchivoPorNombre(String nombre) throws MyException {
		Session session=null;
		ArchivoDto archivo = null;
		
		try {
			session=getSession();
			archivo = (ArchivoDto)session.get(ArchivoDto.class, nombre);
		
		}catch(HibernateException e){
			log.error("ERROR obteniendo archivo: ", e);
			throw new MyException(e);			
		}finally{
//			if(session!=null){
//			session.close();
//		}
		}
		return archivo;
	}
	
	
}
