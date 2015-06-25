package com.amhable.persistencia.implementacion;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


import com.amhable.dominio.TemaDto;
import com.amhable.exception.MyException;
import com.amhable.persistencia.TemaDao;

/**
 * 
 * @author jorge
 *
 */
public class TemaDaoImp extends HibernateDaoSupport  implements TemaDao{
	Logger log = Logger.getLogger(this.getClass());
	/**
	 * Metododo obtenerTemas() encargado de obtener una lista con los temas
	 * existentes en la base de datos
	 * 
	 * @return Listado de los temas en la base de datos
	 * @throws MyException
	 */
	@SuppressWarnings("unchecked")
	public List<TemaDto> obtenerTemas() throws MyException {
		Session session=null;
		List<TemaDto> temas=null;
		try{
			session=getSession(); 
			Criteria criteria=session.createCriteria(TemaDto.class);
			temas=criteria.list();
		}catch(HibernateException e){
			e.printStackTrace();
			log.error("ERROR obteniendo lista de temas: ", e);
			throw new MyException(e);			
		}finally{
			
			
		}
		return temas;
	}
	
	/**
	 * metodo obtenerTemas(Integer idTema) encargado de obtener un tema
	 * de la base de datos buscado por idTema
	 * 
	 * @param idTema que se va obtener
	 * @return tema que coincide con el parametro de busqueda
	 * @throws MyException
	 */
	public TemaDto obtenerTema(Integer idTema) throws MyException {
		Session session=null;
		TemaDto tema = null;
		
		try {
			session=getSession();
			tema = (TemaDto)session.get(TemaDto.class, idTema);
		
		}catch(HibernateException e){
			log.error("ERROR obteniendo tema: ", e);
			throw new MyException(e);			
		}finally{
			
			
		}
		return tema;
	}
	
	/**
	 *Metodo guardar(TemaDto tema) encargado de guardar el tema enviado como
	 *parametro en la base de datos
	 * 
	 * @param tema que se va guardar
	 * @throws MyException
	 */
	public void guardar(TemaDto tema) throws MyException {
		Session session = null;
		
		try {
			session =getSession();
			Transaction tx = session.beginTransaction();
			session.save(tema);
			tx.commit();
			
		} catch(HibernateException e){
			log.error("ERROR guardando tema: ", e);
			throw new MyException(e);			
		}finally{
			
		}
		
	}
	/**
	 * Metodo eliminar(TemaDto tema) sera el encargado de eliminar un 
	 * Tema de la base de datos.
	 * 
	 * @param el Tema que se va a eliminar.
	 * @throws MyException 
	 */

	public void eliminar(TemaDto tema) throws MyException {
		Session session = null;
		
		try {
			session = getSession();
			
			Transaction tx = session.beginTransaction();
			session.delete(tema);
			tx.commit();
			
		} catch(HibernateException e){
			e.printStackTrace();
			log.error("ERROR eliminando tema: ", e);
			throw new MyException(e);			
		}finally{
			
		}
	}
	/**
	 * Metodo actualizar(TemaDto tema) sera el encargado de actualizar un 
	 * Tema de la base de datos, el cual se pasa comoparametro.
	 * 
	 * @param el Tema que se va a actualizar.
	 * @throws MyException 
	 */


	public void actualizar(TemaDto tema) throws MyException {
		Session session = null;
		
		try {
			session = getSession();
			Transaction tx = session.beginTransaction();
			session.update(tema);
			tx.commit();
			
		} catch(HibernateException e){
			log.error("ERROR actualizando tema: ", e);
			throw new MyException(e);			
		}finally{
			
		}
	}
	

}
