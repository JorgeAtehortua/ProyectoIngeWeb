package com.amhable.test;



import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.amhable.dominio.ArchivoDto;
import com.amhable.dominio.CategoriaDto;
import com.amhable.dominio.TemaDto;
import com.amhable.exception.MyException;
import com.amhable.persistencia.ArchivoDao;


/**
 * Clase encargada de las pruebas unitarias para la clase ArchivoDaoImp
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


public class ArchivoDaoImpTest {
	
	/**
	 * Objeto tipo CategoriaDto para asignarlo a  un archivo
	 * 
	 */
	CategoriaDto categoria;
	
	/**
	 * Objeto tipo TemaDto para asignarlo a  un archivo
	 * 
	 */
	private TemaDto tema;
	/**
	 * Inyeccion de dependencias
	 */
	@Autowired
	ArchivoDao archivoDao;

	
	/**
	 * Metodo para hacer prueba unitaria del metodo obtener() 
	 * 
	 */
	@Test
	public void testObtener() {
		List<ArchivoDto> archivos=null;
		try{
			archivos= archivoDao.obtener();
			
			for(ArchivoDto archivo: archivos){
				System.out.println("Nombre archivo:"+ archivo.getNombre());
				
			}
			assertTrue(true);
			
		}catch(MyException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
		
	}
	
	/**
	 * Metodo para hacer prueba unitaria del metodo obtenerArchivo(Integer idArchivo)  
	 * 
	 */
	@Test
	public void testObtenerArchivo() {
		ArchivoDto archivo=null;
		
		try{
			
			archivo= archivoDao.obtenerArchivo(1);
			System.out.println("Nombre archivo:"+ archivo.getNombre());
			assertTrue(true);
			
		}catch(MyException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
		
	}
	
	
	/**
	 * Metodo para hacer prueba unitaria del metodo obtenerArchivosPorCategoria(Integer idCategoria)
	 * 
	 */
	@Test
	public void testObtenerArchivosPorCategoria() {
		List<ArchivoDto> archivos=null;
		ArchivoDto archivo= new ArchivoDto();
		categoria= new CategoriaDto();
		
		try{
			archivo=archivoDao.obtenerArchivo(1);
			categoria=archivo.getCategoria_idCategoria();
			archivos= archivoDao.obtenerArchivosPorCategoria(categoria);
			
			for(ArchivoDto arch: archivos){
				System.out.println("Nombre archivo:"+ arch.getNombre());
				
			}
			assertTrue(true);
			
		}catch(MyException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
		
	}
	
	/**
	 * Metodo para hacer prueba unitaria del metodo obtenerArchivoPorCategoriaYTema(Integer idCategoria, Integer idTema) 
	 * 
	 */
	@Test
	public void testObtenerArchivoPorCategoriaYTema() {
		List<ArchivoDto> archivos=null;
		ArchivoDto archivo= new ArchivoDto();
		categoria= new CategoriaDto();
		tema= new TemaDto();
		try{
			archivo=archivoDao.obtenerArchivo(1);
			categoria=archivo.getCategoria_idCategoria();
			tema=archivo.getTema_idTema();
			archivos= archivoDao.obtenerArchivoPorCategoriaYTema(categoria, tema);
			
			for(ArchivoDto arch: archivos){
				System.out.println("Nombre archivo:"+ arch.getNombre());
				
			}
			assertTrue(true);
			
		}catch(MyException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
		
	}
	
	/**
	 * Metodo para hacer prueba unitaria del metodo obtenerArchivoPorNombre(String nombre)
	 * 
	 */
	//@Test
	public void testObtenerArchivoPorNombre() {
		ArchivoDto archivo=null;
		try{
			archivo= archivoDao.obtenerArchivoPorNombre("Articulo 1");
			System.out.println("Nombre archivo:"+ archivo.getNombre());
			assertTrue(true);
			
		}catch(MyException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
		
	}
	
	/**
	 * Metodo para hacer prueba unitaria del metodo guardar(ArchivoDto archivo)
	 * 
	 */
	@Test
	public void testGuardar() {
		ArchivoDto archivo=new ArchivoDto();
		ArchivoDto archivoAux=new ArchivoDto();
		categoria=new CategoriaDto();
		tema= new TemaDto();
		try{
			archivoAux=archivoDao.obtenerArchivo(1);
			categoria=archivoAux.getCategoria_idCategoria();
			tema=archivoAux.getTema_idTema();
			archivo.setCategoria_idCategoria(categoria);
			archivo.setTema_idTema(tema);
			archivo.setcontrasena("root");
			archivo.setFecha(new Date());
			archivo.setIdArchivo(302);
			archivo.setNombre("Archivoguardado");
			archivo.setRutaArchivo("RutaArchivo");
			archivoDao.guardar(archivo);			
			System.out.println("Archivo guardado exitosamente: " + archivo.getNombre());
			assertTrue(true);
		}catch(MyException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
		
	}
	
	/**
	 * Metodo para hacer prueba unitaria del metodo eliminar(ArchivoDto archivo) 
	 * 
	 */
	@Test
	public void testEliminar() {
		ArchivoDto archivo=new ArchivoDto();
		archivo.setIdArchivo(999);
		archivo.setNombre("EjemploGuardar");
		archivo.setFecha(new Date());
		
		try{
			
			archivoDao.eliminar(archivo);			
			System.out.println("Archivo eliminado exitosamente");
							
			assertTrue(true);
			
		}catch(MyException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
		
	}
	
	/**
	 * Metodo para hacer prueba unitaria del metodo actualizar(ArchivoDto archivo)
	 * 
	 */
	@Test
	public void testActualizar() {
		ArchivoDto archivo=new ArchivoDto();
		
		
		try{
			archivo=archivoDao.obtenerArchivo(2);
			archivo.setNombre("Actualizacion");
			archivo.setFecha(new Date());
			archivoDao.actualizar(archivo);
			System.out.println("Archivo actualizado exitosamente");
			assertTrue(true);
		}catch(MyException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
		
	}
		
		
}
