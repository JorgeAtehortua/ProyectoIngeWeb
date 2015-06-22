package com.amhable.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.amhable.dominio.TemaDto;
import com.amhable.exception.MyException;
import com.amhable.persistencia.TemaDao;

//Para indicardle que correr la prueba unitaria con lo que queda entre parentesis 
@RunWith(SpringJUnit4ClassRunner.class)

//es una prueba transactional
@Transactional

//Entre comillas debe ser la ruta del archivo de configuración xml
@ContextConfiguration(locations={"classpath:/SpringConfiguration.xml"})


/**
 * Clase encargada de las pruebas unitarias para la clase TemaDao
 * 
 * @author luis
 *
 */
	
	

public class TemaDaoImpTest {
	
	@Autowired
	TemaDao temaDao;
	private TemaDto tema;
	
	/**
	 * Metodo para hacer prueba unitaria del metodo obtenerTemas() 
	 * 
	 */
	
	@Test
	public void testObtener() {
		List<TemaDto> temas=null;
		
		try{
			temas= temaDao.obtenerTemas();
			
			for(TemaDto tema: temas){
				System.out.println("Nombre tema:"+ tema.getNombre());
				
			}
			assertTrue(true);
			
		}catch(MyException e){
			fail(e.getMessage());
		}
		
	}
	/**
	 * Metodo para hacer prueba unitaria del metodo obtenerTema()  
	 * 
	 */
	@Test
	public void testObtenerTema() {
		TemaDto tema=null;
		
		try{
			//Prueba para obtener el tema
			tema= temaDao.obtenerTema(1);
			System.out.println("Nombre Tema:"+ tema.getNombre());
							
			assertTrue(true);
			
		}catch(MyException e){
			fail(e.getMessage());
		}
		
	}
	
	/**
	 * Metodo para hacer prueba unitaria del metodo guardar()  
	 * 
	 */
	@Test
	public void testGuardar() {
		tema = new TemaDto();
		tema.setIdTema(10);
		tema.setCategoria_idCategoria(2);
		tema.setNombre("pruebaTema");
		try{
			//Prueba para guardar
			 
		temaDao.guardar(tema);
		System.out.println("Tema guardada exitosamente: " + tema.getNombre());
		}catch(MyException e){
			fail(e.getMessage());
		}
		
	}
	
	/**
	 * Metodo para hacer prueba unitaria del metodo actualizar()  
	 * 
	 */
	
	@Test
	public void testActualizar() {
		TemaDto tema=new TemaDto();
		tema.setIdTema(1);
		tema.setCategoria_idCategoria(2);
		tema.setNombre("EjemploActualizado");
		
		try{
				 
			 temaDao.actualizar(tema);
			//
			 assertTrue(true);
		}catch(MyException e){
			fail(e.getMessage());
		}
		
	}
	
	/**
	 * Metodo para hacer prueba unitaria del metodo eliminar()  
	 * 
	 */
	@Test
	public void testEliminar() {
		TemaDto tema=new TemaDto();
		tema.setIdTema(1);
		tema.setCategoria_idCategoria(2);
		tema.setNombre("Psicologia del amor");
	
		
		try{
		temaDao.eliminar(tema);
		System.out.println("Tema eliminado exitosamente: " + tema.getNombre());
		assertTrue(true);
		}catch(MyException e){
			fail(e.getMessage());
		}
		
	}
}


