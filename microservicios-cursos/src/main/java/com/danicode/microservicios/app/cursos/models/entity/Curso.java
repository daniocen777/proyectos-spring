package com.danicode.microservicios.app.cursos.models.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.danicode.microservicios.commons.alumnos.models.entity.Alumno;

@Entity
@Table(name = "cursos")
public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nombre;

	@Column(name = "create_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createAt;

	// Lista de alumnos
	@OneToMany(fetch = FetchType.LAZY)
	private List<Alumno> alumnos;

	// Antes de crear
	@PrePersist
	public void prePersist() {
		this.createAt = new Date();
	}

	public Curso() {
		this.alumnos = new ArrayList<>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public List<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	public void addAlumno(Alumno alumno) {
		this.alumnos.add(alumno);
	}

	public void removeAlumno(Alumno alumno) {
		/**
		 * Para remover, se necesita una comparación entre el objeto de la lista y lo
		 * que se envía => Sobreescribir el método "equals" de Alumno
		 */
		this.alumnos.remove(alumno);
	}
}
