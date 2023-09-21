package entities;

import javax.persistence.*;
import java.sql.Date;
@Entity
public class AlumnoCarrera {
	@Id
	@ManyToOne
	@JoinColumn(name = "idAlumno")
	private int idAlumno;
	@Id
	@ManyToOne
	@JoinColumn(name = "idCarrera")
	private int idCarrera;
	@Column
	private Date fechaInscripcion;
	@Column
	private boolean graduado;
}
