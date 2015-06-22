package com.amhable.dominio;
/**
 * 
 * @author luisa
 * 
 *Clase dto para los datos del Usuario
 *
 *Esta tabla solo es requerida para el login del administrador, 
 *pues no esta entre los requisitos que los usuarios se logueen
 */
public class UsuarioDto {
	/**
	 * Identificador de cada usuario
	 */
	private String idUsuario;
	/**
	 * contraseña de cada usuario
	 */
	private String contrasena;
	/**
	 * Metodo para retornar el idUsuario.
	 * @return the idUsuario
	 */
	public String getIdUsuario() {
		return idUsuario;
	}
	/**
	 * Metodo para asignar el idUsuario.
	 * @param idUsuario the idUsuario to set
	 */
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	/**
	 * Metodo para retornar la contraseña del usuario.
	 * @return the contrasena
	 */
	public String getContrasena() {
		return contrasena;
	}
	/**
	 * Metodo para asignar la contraseña al usuario.
	 * @param contrasena the contrasena to set
	 */
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	
	
}