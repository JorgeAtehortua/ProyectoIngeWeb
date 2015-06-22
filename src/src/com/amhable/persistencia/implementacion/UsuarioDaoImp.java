package com.amhable.persistencia.implementacion;



import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.amhable.dominio.UsuarioDto;
import com.amhable.exception.MyException;
import com.amhable.persistencia.UsuarioDao;
/**
 * Clase que implementara los metodos de la interfaz UsuarioDao.
 * 
 * @author Luisa Suarez
 *
 */

public class UsuarioDaoImp extends HibernateDaoSupport implements UsuarioDao{
	Logger log = Logger.getLogger(this.getClass());
	
	/**
	 * Metodo obtenerUsuario(Integer idusuario) encargado de obtener un usuario 
	 * de la base de datos buscado por idUsuario
	 *
	 * @param idUsuario que se va obtener
	 * @return usuario que coincide con el parametro de busqueda
	 * @throws MyException
	 */
	public UsuarioDto obtenerUsuario(String idUsuario) throws MyException {
		Session session=null;
		UsuarioDto usuario = null;
		try {
			session=getSession();
			usuario = (UsuarioDto)session.get(UsuarioDto.class, idUsuario);
		
		}catch(HibernateException e){
			log.error("ERROR obteniendo usuario: ", e);
			throw new MyException(e);			
		}finally{
			
			
		}
		return usuario;
	}

	/**
	 *Metodo guardar(usuarioDto usuario) encargado de guardar el usuario 
	 *enviado como parametro en la base de datos
	 * 
	 * @param usuario que se va guardar
	 * @throws MyException
	 */
	@SuppressWarnings("deprecation")
	public void guardar(UsuarioDto usuario) throws MyException {
		Session session = null;
		Transaction tx=null;
		
		try {
			session =getSession();
			session.save(usuario);
			tx = session.beginTransaction();
			tx.commit();
		
		} catch(HibernateException e){
			log.error("ERROR guardando usuario: ", e);
			
			throw new MyException(e);			
		}finally{
		
		}
		
		
	}
	
	/**
	 *Metodo actualizar(usuarioDto usuario)encargado de actualizar el usuario enviado como parametro
	 * 
	 * @param usuario que se va a actualizar
	 * @throws MyException
	 */

	public void actualizar(UsuarioDto usuario) throws MyException {
		Session session = null;
		
		try {
			session = getSession();
			Transaction tx = session.beginTransaction();
			session.update(usuario);
			tx.commit();
			
		} catch(HibernateException e){
			log.error("ERROR actualizando usuario: ", e);
			throw new MyException(e);			
		}finally{
			
		}
	}

}