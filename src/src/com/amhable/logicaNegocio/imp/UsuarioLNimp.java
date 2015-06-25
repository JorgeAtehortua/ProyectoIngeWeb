/**
 * 
 */
package com.amhable.logicaNegocio.imp;


import org.apache.log4j.Logger;

import com.amhable.dominio.UsuarioDto;
import com.amhable.exception.MyException;
import com.amhable.logicaNegocio.UsuarioLN;
import com.amhable.persistencia.UsuarioDao;

/**Clase que contiene la logica del negocio para realizar operaciones con la
 * tabla Usuario en la Base de datos
 * @author Luisa
 *19/06/2015
 */
public class UsuarioLNimp implements UsuarioLN{
	
	/**
	 * Objeto tipo UsuarioDto donde se manejaran los datos de un usuario
	 */
	private UsuarioDto usuario;
	
	
	/**
	 * Inyeccion del objeto UsuarioDao para poder hacer operaciones en la base de datos
	 */
	
	private UsuarioDao usuarioDao;

	/**
	 * Metodo para obtener UsuarioDao
	 * @return the usuarioDao
	 */
	public UsuarioDao getUsuarioDao() {
		return usuarioDao;
	}

	/**
	 * Metodo para asignar UsuarioDao
	 * @param usuarioDao the usuarioDao to set
	 */
	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

	/** 
	 * Metodo en la logica del negocio mediante el cual se obtiene un usuario 
	 * @see com.amhable.logicaNegocio.UsuarioLN#obtenerUsuario(int)
	 */
	@Override
	public UsuarioDto obtenerUsuario(String idUsuario) throws MyException {
		
		try{
			usuario=usuarioDao.obtenerUsuario(idUsuario);
		}catch(MyException e){
			Logger log=Logger.getLogger(this.getClass());
			log.error("Error obteniendo Usuario");
		}
		return usuario;
	}

	/**
	 * Metodo en la logica del negocio mediante el cual se guarda un usuario 
	 * @see com.amhable.logicaNegocio.UsuarioLN#guardar(java.lang.String, java.lang.String)
	 */
	@Override
	public void guardar(String idUsuario, String contrasena) throws MyException {
		if(idUsuario==null || "".equals(idUsuario)){
			throw new MyException("El Identificador del usuario no puede estar vacio");
		}
		if(contrasena==null || "".equals(contrasena)){
			throw new MyException("La contraseña del usuario no puede ser vacia");
		}
		usuario=new UsuarioDto();
		usuario.setContrasena(contrasena);
		usuario.setIdUsuario(idUsuario);
		try{
			usuarioDao.guardar(usuario);
		}catch(MyException e){
			Logger log = Logger.getLogger(this.getClass());
			log.error("Error guardando usuario: " + e);
			new MyException("Error guardando usuario"+ e);
		}
		
		
		
	}

	/**
	 * Metodo en la logica del negocio mediante el cual se actualiza un usuario 
	 * @see com.amhable.logicaNegocio.UsuarioLN#actualizar(java.lang.String, java.lang.String)
	 */
	@Override
	public void actualizar(String idUsuario, String contrasena)
			throws MyException {
		usuario= new UsuarioDto();
		usuario.setContrasena(contrasena);
		usuario.setIdUsuario(idUsuario);
		try{
			usuarioDao.actualizar(usuario);
		}catch(MyException e){
			Logger log = Logger.getLogger(this.getClass());
			log.error("Error actualizando usuario: " + e);
			throw new MyException("Error actualizando un usuario en la BD"+ e);
			
		}
		usuario= new UsuarioDto();
		usuario.setContrasena(contrasena);
		usuario.setIdUsuario(idUsuario);
		try{
			usuarioDao.actualizar(usuario);
		}catch(MyException e){
			Logger log = Logger.getLogger(this.getClass());
			log.error("Error actualizando usuario: " + e);
			throw new MyException("Error actualizando un usuario en la BD"+ e);
			
		}
		// TODO Auto-generated method stub
		
	}

	
	
	

}