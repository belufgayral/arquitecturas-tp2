package entities;

import java.sql.Date;
import java.util.List;

public class Alumno {
	private int id;
	private String nombre;
	private String apellido;
	private Date fechaNacimiento;
	private String genero;
	private long dni;
	private String ciudad;
	private long legajo;
	private List<Carrera> carreras;
	
	
}
