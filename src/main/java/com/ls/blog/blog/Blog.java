package com.ls.blog.blog;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.ls.blog.comentario.Comentario;

@Document(collection = "blog")
@JsonPropertyOrder({"id","titulo","contenido","comentarios"})
public class Blog implements Serializable{

	@Id
	@NotNull
	private String id;
	@NotNull
	private String titulo;
	@NotNull
	private String contenido;
	private List<Comentario> comentarios;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getContenido() {
		return contenido;
	}
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	public List<Comentario> getComentarios() {
		return comentarios;
	}
	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}
