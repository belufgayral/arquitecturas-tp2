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
}
