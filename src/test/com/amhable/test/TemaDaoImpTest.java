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

import com.amhable.dominio.CategoriaDto;
import com.amhable.dominio.TemaDto;
import com.amhable.exception.MyException;
import com.amhable.persistencia.TemaDao;


/**
 * Clase encargada de las pruebas unitarias para la clase TemaDao
 * 
 * @author Luisa
 *
 */
	
//Para indicardle que correr la prueba unitaria con lo que queda entre parentesis 
@RunWith(SpringJUnit4ClassRunner.class)

//es una prueba transactional
@Transactional

//Entre comillas debe ser la ruta del archivo de configuración xml
@ContextConfiguration(locations={"classpath:/SpringConfiguration.xml"})

public class TemaDaoImpTest {
	/**
	 * Objeto tipo CategoriaDto  para asignarlo a  un tema
	 * 
	 */
	CategoriaDto categoria;
	
	/**
	 * Objeto con el que se manejaran los datos de tema
	 * 
	 */
	private TemaDto tema;
	
	/**
	 * Inyeccion de dependencias
	 * 
	 */
	@Autowired
	TemaDao temaDao;
	
	/**
	 * Metodo para hacer prueba unitaria del metodo obtenerTemas
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
		tema=null;
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
		categoria= new CategoriaDto();
		categoria.setIdCategoria(5);
		categoria.setNombre("CategoriaParaLosTemas");
		tema = new TemaDto();
		tema.setIdTema(10);
		tema.setCategoria(categoria);
		tema.setNombre("pruebaTema");
		try{
			temaDao.guardar(tema);
			System.out.println("Tema guardado exitosamente: " + tema.getNombre());
		}catch(MyException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
		
	}
	
	/**
	 * Metodo para hacer prueba unitaria del metodo actualizar()  
	 * 
	 */
	
	@Test
	public void testActualizar() {
		try{
			tema=temaDao.obtenerTema(1);
			tema.setNombre("EjemploActualizado");
			temaDao.actualizar(tema);
			System.out.println("Tema actualizado exitosamente: " + tema.getNombre());
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
		tema=new TemaDto();
		tema.setIdTema(4);
		categoria= new CategoriaDto();
		categoria.setIdCategoria(5);
		categoria.setNombre("CategoriaParaLosTemas");
		tema.setCategoria(categoria);
		tema.setNombre("Otro");
		try{
			temaDao.eliminar(tema);
			System.out.println("Tema eliminado exitosamente: " + tema.getNombre());
			assertTrue(true);
		}catch(MyException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
		
	}
}


