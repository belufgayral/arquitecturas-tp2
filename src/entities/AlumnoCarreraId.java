package entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Embeddable
public class AlumnoCarreraId implements Serializable {
	@ManyToOne
	@JoinColumn(name = "idAlumno")
	private Alumno alumno;
	
	@ManyToOne
	@JoinColumn(name = "idCarrera")
	private Carrera carrera;

	public AlumnoCarreraId(Alumno alumno, Carrera carrera) {
		super();
		this.alumno = alumno;
		this.carrera = carrera;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public Carrera getCarrera() {
		return carrera;
	}
}
