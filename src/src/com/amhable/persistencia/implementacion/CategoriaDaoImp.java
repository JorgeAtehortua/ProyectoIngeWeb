package com.amhable.persistencia.implementacion;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.amhable.dominio.CategoriaDto;
import com.amhable.exception.MyException;
import com.amhable.persistencia.CategoriaDao;
/**
 * Clase encargada de implementar los metodos definidos
 * en la interface CategoriaDao
 * 
 * @author Jorge Atehortua
 *
 */

public class CategoriaDaoImp extends HibernateDaoSupport  implements CategoriaDao{
	Logger log = Logger.getLogger(this.getClass());

	/**
	 * metodo obtenerCategoria(Integer idcategoria) encargado de obtener una categoria
	 * de la base de datos buscado por idCategoria
	 * 
	 * @param idCategoria que se va obtener
	 * @return Categoria que coincide con el parametro de busqueda
	 * @throws MyException
	 */

	public CategoriaDto obtenerCategoria(Integer idCategoria) throws MyException {
		
		
		try {
			Session session=null;
			CategoriaDto categoria = null;
			session=getSession();
			categoria = (CategoriaDto)session.get(CategoriaDto.class, idCategoria);
			return categoria;
		}catch(HibernateException e){
			
			log.error("ERROR obteniendo categoria: ", e);
			throw new MyException(e);			
		}finally{
			
			
		}
		
	}
	
	/**
	 *Metodo guardarCategoria(CategoriaDto categoria) encargado de guardar la categoria enviada como
	 *parametro en la base de datos
	 * 
	 * @param categoria que se va guardar
	 * @throws MyException
	 */

	public void guardar(CategoriaDto categoria) throws MyException {
		Session session = null;
		
		try {
			session =getSession();
			Transaction tx = session.beginTransaction();
			session.save(categoria);
			tx.commit();
			
		} catch(HibernateException e){
			e.printStackTrace();
			log.error("ERROR guardando categoria: ", e);
			throw new MyException(e);			
		}finally{
			
		}
	}

	/**
	 * Metododo obtenerCategorias() encargado de obtener una lista con las categorias
	 * existentes en la base de datos
	 * 
	 * @return Listado de las categorias en la base de datos
	 * @throws MyException
	 */
	@SuppressWarnings("unchecked")
	public List<CategoriaDto> obtenerCategorias() throws MyException {
		Session session=null;
		List<CategoriaDto> categorias=null;
		
		try{
			session=getSession(); 
			Criteria criteria=session.createCriteria(CategoriaDto.class);
			categorias=criteria.list();
		}catch(HibernateException e){
			e.printStackTrace();
			log.error("ERROR obteniendo lista de categorias: ", e);
			throw new MyException(e);			
		}finally{
			
			
		}
		return categorias;
	}
	
	/**
	 * ActualizarCategoria(categoriaDto categoria) actualiza la categoria que se
	 * pasa como parametro
	 * 
	 * @param categoria que se va actualizar
	 * @throws MyException
	 */
	public void actualizar(CategoriaDto categoria) throws MyException {
		Session session = null;
		
		try {
			session = getSession();
			Transaction tx = session.beginTransaction();
			session.update(categoria);
			tx.commit();
			
		} catch(HibernateException e){
			e.printStackTrace();
			log.error("ERROR actualizando categoria: ", e);
			throw new MyException(e);			
		}finally{
		
		}
	}
	
	/**
	 * Metodo eliminar sera el encargado de eliminar una 
	 * categoria de la base de datos.
	 * 
	 * @param la categoria que se va a eliminar.
	 * @throws MyException 
	 */

	public void eliminar(CategoriaDto categoria) throws MyException {
		Session session = null;
		
		try {
			session = getSession();
			
			Transaction tx = session.beginTransaction();
			session.delete(categoria);
			tx.commit();
			
		} catch(HibernateException e){
			e.printStackTrace();
			log.error("ERROR eliminando categoria: ", e);
			throw new MyException(e);			
		}finally{
			
		}
	}
	

	}
