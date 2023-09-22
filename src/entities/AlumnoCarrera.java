package entities;

import javax.persistence.*;

import java.io.Serializable;
import java.sql.Date;

@Entity
public class AlumnoCarrera implements Serializable {
	@ManyToOne
	@JoinColumn(name = "idAlumno")
	@MapsId
	private Alumno alumno;
	@ManyToOne
	@JoinColumn(name = "idCarrera")
	@MapsId
	private Carrera carrera;
	@Column
	private Date fechaInscripcion;
	@Column
	private boolean graduado;

	public AlumnoCarrera() {
		super();
	}

	public AlumnoCarrera(Alumno alumno, Carrera carrera, Date fechaInscripcion, boolean graduado) {
		super();
		this.alumno = alumno;
		this.carrera = carrera;
		this.fechaInscripcion = fechaInscripcion;
		this.graduado = graduado;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Carrera getCarrera() {
		return carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
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
}
