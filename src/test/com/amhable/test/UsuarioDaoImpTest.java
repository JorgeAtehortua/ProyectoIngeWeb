package com.amhable.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.amhable.dominio.UsuarioDto;
import com.amhable.exception.MyException;
import com.amhable.persistencia.UsuarioDao;

/**
 * Clase encargada de las pruebas unitarias para la clase UsuarioDaoImpTest
 * 
 * @author luisa
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
//para decirle que voy a correr la prueba con lo que queda entre parentesis

@Transactional
//es una prueba transactional

@ContextConfiguration(locations={"classpath:/SpringConfiguration.xml"})
//Entre comillas debe ser la ruta del archivo de configuración xml


public class UsuarioDaoImpTest {
	
	
	/**
	 * Objeto tipo UsuarioDto  con el que se manejaran los datos de un usuario
	 */
	UsuarioDto usuario;
	
	/**
	 * Inyeccion de dependencias
	 */
	@Autowired
	UsuarioDao usuarioDao;

	/**
	 * Metodo para hacer prueba unitaria del metodo obtenerUsuario 
	 * 
	 */
	@Test
	public void testObtenerUsuario() {
		usuario=null;
		try{
			usuario= usuarioDao.obtenerUsuario("Nelson");
			System.out.println(usuario.getIdUsuario()+ " :" + usuario.getContrasena());
			assertTrue(true);
		}catch(MyException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	/**
	 * Metodo para hacer prueba unitaria del metodo guardar 
	 * 
	 */
	@Test
	public void testGuardar() {
		usuario=new UsuarioDto();
		usuario.setIdUsuario("Usuario");
		usuario.setContrasena("123456");
		try{
			usuarioDao.guardar(usuario);
			System.out.println("Usuario guarado exitosamente");
			assertTrue(true);
		}catch(MyException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	/**
	 * Metodo para hacer prueba unitaria del metodo actualizar  
	 * 
	 */
	@Test
	public void testActualizar() {
		UsuarioDto usuario=new UsuarioDto();
		try{
			usuario = usuarioDao.obtenerUsuario("Nelson");
			usuario.setContrasena("cambiocontrasena");
			usuarioDao.actualizar(usuario);
			System.out.println("Usuario actualizado exitosamente");
			assertTrue(true);
		}catch(MyException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
}
