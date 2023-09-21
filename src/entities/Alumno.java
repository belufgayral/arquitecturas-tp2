package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import java.util.List;
@Entity
public class Alumno {
	@Id
	private int id;
	@Column
	private String nombre;
	@Column
	private String apellido;
	@Column
	private Date fechaNacimiento;
	@Column
	private String genero;
	@Column
	private long dni;
	@Column
	private String ciudad;
	@Column
	private long legajo;
	
	
}
