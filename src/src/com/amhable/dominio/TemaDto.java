package com.amhable.dominio;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Clase dto para los datos de tema
 *
 *Un archivo se puede clasificar por categorias 
 *y por cada categoria por tema
 * @author luisa
 * 
 */
@XmlRootElement
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
	private CategoriaDto categoria;
	/**
	 * @return the categoria
	 */
	public CategoriaDto getCategoria() {
		return categoria;
	}
	/**
	 * @param categoria the categoria to set
	 */
	public void setCategoria(CategoriaDto categoria) {
		this.categoria = categoria;
	}
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

	

}
