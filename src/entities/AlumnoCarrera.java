package entities;

import javax.persistence.*;


import java.sql.Date;

@Entity
public class AlumnoCarrera {
	@EmbeddedId
	private AlumnoCarreraId id;
	@Column
	private Date fechaInscripcion;
	@Column
	private boolean graduado;
	@Column
	private Date fechaGraduacion;
	
	public AlumnoCarrera() {
		super();
	}

	public AlumnoCarrera(AlumnoCarreraId id, Date fechaInscripcion, boolean graduado) {
		super();
		this.id = id;
		this.fechaInscripcion = fechaInscripcion;
		this.graduado = graduado;
	}

	public AlumnoCarrera(AlumnoCarreraId id, Date fechaInscripcion, boolean graduado, Date fechaGraduacion) {
		this.id = id;
		this.fechaInscripcion = fechaInscripcion;
		this.graduado = graduado;
		this.fechaGraduacion = fechaGraduacion;
	}

	public Date getFechaGraduacion() {
		return fechaGraduacion;
	}

	public void setFechaGraduacion(Date fechaGraduacion) {
		this.graduado = true;
		this.fechaGraduacion = fechaGraduacion;
	}

	public AlumnoCarreraId getId() {
		return id;
	}

	public Date getFechaInscripcion() {
		return fechaInscripcion;
	}

	public void setFechaInscripcion(Date fechaInscripcion) {
		this.fechaInscripcion = fechaInscripcion;
	}

	public boolean isGraduado() {
		return graduado;
	}

	public void setGraduado(boolean graduado) {
		this.graduado = graduado;
	}

	@Override
	public String toString() {
		String alumno = "AlumnoCarrera =>" +
				" Nombre: " + id.getAlumno().getNombre() +
				" " + id.getAlumno().getApellido() +
				", Carrera: " + id.getCarrera().getNombre() +
				", fechaInscripcion:" + fechaInscripcion +
				", graduado:" + graduado;
				if(fechaGraduacion!=null){
					alumno+= ", fecha graduacion: " + fechaGraduacion;
				}
		return alumno;
	}
}
