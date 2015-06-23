package com.amhable.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.amhable.dominio.CategoriaDto;
import com.amhable.exception.MyException;
import com.amhable.persistencia.CategoriaDao;

// Para indicardle que correr la prueba unitaria con lo que queda entre parentesis 
@RunWith(SpringJUnit4ClassRunner.class)

//es una prueba transactional
@Transactional

//Entre comillas debe ser la ruta del archivo de configuración xml
@ContextConfiguration(locations={"classpath:/SpringConfiguration.xml"})

/**
 * Clase encargada de las pruebas unitarias para la clase CategoriaDao
 * 
 * @author luis
 *
 */
@Component
public class CategoriaDaoImpTest {
	/**
	 * Objeto con el que se manejaran los datos de una categoria
	 */
	CategoriaDto categoria;
	/**
	 * Inyeccion de dependencias
	 */
	@Autowired 
	CategoriaDao categoriaDao;
	/**
	 * Metodo para hacer prueba unitaria del metodo obtenerCategorias()  
	 * 
	 */
	@Test
	public void testObtener() {
		List<CategoriaDto> categorias=null;
		try{
			categorias= categoriaDao.obtenerCategorias();
			for(CategoriaDto categoria: categorias){
				System.out.println("Nombre categoria:"+ categoria.getNombre());
			}
			assertTrue(true);
		}catch(MyException e){
			fail(e.getMessage());
		}
		
	}
	
	/**
	 * Metodo para hacer prueba unitaria del metodo obtenerCategoria()  
	 * 
	 */
	@Test
	public void testObtenerCategoria() {
		categoria=null;
		try{
			//Prueba para obtener el categoria
			categoria= categoriaDao.obtenerCategoria(1);
			System.out.println("Nombre categoria:"+ categoria.getNombre());
			assertTrue(true);
		}catch(MyException e){
			fail(e.getMessage());
		}
		
	}
	
	/**
	 * Metodo para hacer prueba unitaria del metodo guardar
	 * 
	 */
	@Test
	public void testGuardar() {
		categoria=new CategoriaDto();
		categoria.setIdCategoria(110);
		categoria.setNombre("CategoriaPrueba2");
		try{
			categoriaDao.guardar(categoria);
			System.out.println("Categoria guardada exitosamente: " + categoria.getNombre()); 
			assertTrue(true);
		}catch(MyException e){
			fail(e.getMessage());
		}
		
	}
	
	/**
	 * Metodo para hacer prueba unitaria del metodo actualizar
	 */
	
	@Test
	public void testActualizar() {
		categoria=new CategoriaDto();
		categoria.setIdCategoria(1);
		categoria.setNombre("Actualizado");
		try{
			categoriaDao.actualizar(categoria);
			System.out.println("Categoria actualizada exitosamente: " + categoria.getNombre()); 
			assertTrue(true);
		}catch(MyException e){
			fail(e.getMessage());
		}
		
	}
	
	/**
	 * Metodo para hacer prueba unitaria del metodo eliminar  
	 * 
	 */
	@Test
	public void testEliminar() {
		categoria=new CategoriaDto();
		try{
			categoria=categoriaDao.obtenerCategoria(110);
			categoriaDao.eliminar(categoria);
			System.out.println("Categoria eliminada exitosamente: " + categoria.getNombre()); 
			assertTrue(true);
		}catch(MyException e){
			fail(e.getMessage());
		}
		
	}
}
