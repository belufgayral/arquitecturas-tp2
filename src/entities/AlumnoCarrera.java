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
	
	public AlumnoCarrera() {
		super();
	}

	public AlumnoCarrera(AlumnoCarreraId id, Date fechaInscripcion, boolean graduado) {
		super();
		this.id = id;
		this.fechaInscripcion = fechaInscripcion;
		this.graduado = graduado;
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
}
