package com.amhable.dominio;
/**
 * 
 * @author luisa
 * 
 *Clase dto para los datos de tema
 *
 *Un archivo se puede clasificar por categorias 
 *y por cada categoria por tema
 */
public class TemaDto {
	/**
	 * Identificador del tema
	 */
	private int idTema;
	/**
	 * Nombre del tema
	 */
	private String nombre;
	/**
	 * Identificador de la categoria a la que pertenece el tema
	 */
	private int categoria_idCategoria;
	/**
	 * @return the idTema
	 */
	public int getIdTema() {
		return idTema;
	}
	/**
	 * @param idTema the idTema to set
	 */
	public void setIdTema(int idTema) {
		this.idTema = idTema;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the categoria_idCategoria
	 */
	public int getCategoria_idCategoria() {
		return categoria_idCategoria;
	}
	/**
	 * @param categoria_idCategoria the categoria_idCategoria to set
	 */
	public void setCategoria_idCategoria(int categoria_idCategoria) {
		this.categoria_idCategoria = categoria_idCategoria;
	}
	
	

}
