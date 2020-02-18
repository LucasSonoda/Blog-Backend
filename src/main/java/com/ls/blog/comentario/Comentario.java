package com.ls.blog.comentario;

import java.io.Serializable;

import com.ls.blog.login.User;

public class Comentario  implements Serializable{
	
	private String texto;
	private int puntaje;
	private User user;
	
	
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public int getPuntaje() {
		return puntaje;
	}
	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
