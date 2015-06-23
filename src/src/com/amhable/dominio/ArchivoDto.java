package com.amhable.dominio;



import java.util.Date;

/**
 *  
 * Clase dto para los datos del archivo
 * 
 * @author luisa
 */
public class ArchivoDto {
	/**
	 * Identificador del archivo
	 */
	private int idArchivo;
	/**
	 * nombre o titulo del archivo
	 */
	private String nombre;
	/**
	 * Fecha de subida del archivo
	 */
	private Date fecha;
	/**
	 * contrasena asignada para descargar el archivo
	 */
	private String contrasena;
	/**
	 * Ruta del archivo en el servidor
	 */
	private String rutaArchivo;
	/**
	 * Identificador de la categoria a la que pertenece el archivo
	 */
	private CategoriaDto categoria_idCategoria;
	/**
	 * Identificador del tema al que eprtenece el archivo
	 */
	private TemaDto tema_idTema;
	/**
	 * @return the idArchivo
	 */
	public int getIdArchivo() {
		return idArchivo;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}
	/**
	 * @return the contrase�a
	 */
	public String getcontrasena() {
		return contrasena;
	}
	/**
	 * @return the ruta
	 */
	public String getRutaArchivo() {
		return rutaArchivo;
	}
	/**
	 * @return the idCategoria
	 */
	public CategoriaDto getCategoria_idCategoria() {
		return categoria_idCategoria;
	}
	/**
	 * @return the idTema
	 */
	public TemaDto getTema_idTema() {
		return tema_idTema;
	}
	/**
	 * @param idArchivo the idArchivo to set
	 */
	public void setIdArchivo(int idArchivo) {
		this.idArchivo = idArchivo;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	/**
	 * @param contrasena the contrase�a to set
	 */
	public void setcontrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	/**
	 * @param ruta the ruta to set
	 */
	public void setRutaArchivo(String ruta) {
		this.rutaArchivo = ruta;
	}
	/**
	 * @param idCategoria the idCategoria to set
	 */
	public void setCategoria_idCategoria(CategoriaDto idCategoria) {
		this.categoria_idCategoria = idCategoria;
	}
	/**
	 * @param idTema the idTema to set
	 */
	public void setTema_idTema(TemaDto idTema) {
		this.tema_idTema = idTema;
	}

}