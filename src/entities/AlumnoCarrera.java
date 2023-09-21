package entities;

import javax.persistence.*;
import java.sql.Date;
@Entity
public class AlumnoCarrera {
	@Id
	@ManyToOne
	@JoinColumn(name = "idAlumno")
	private Alumno alumno;
	@Id
	@ManyToOne
	@JoinColumn(name = "idCarrera")
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
