package com.amhable.dominio;
/**
 *Clase dto para los datos de las categorias.
 *
 *Un archivo se puede clasificar por categoria.
 * 
 * @author luisa.
 */
public class CategoriaDto {
	/**
	 * Codigo de la categoria
	 */
	private int idCategoria;
	/**
	 * Nombre de la categoria
	 */
	private String nombre;
	/**
	 * getIdCategoria sera el encargado de acceder a la variable privada idCategoria
	 * @return idCategoria
	 */
	public int getIdCategoria() {
		return idCategoria;
	}
	/**
	 * setIdCategoria sera la encargada de almacenar el idCategoria en la variable.
	 * @param idCategoria
	 */
	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}
	/**
	 * getNombre sera el encargado de acceder a la variable privada nombre
	 * @return nombre de la categoria
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * setNombre sera la encargada de almacenar el nombre en la variable.
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
}
