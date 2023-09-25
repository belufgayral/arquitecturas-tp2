package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Alumno {
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
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
	
	public Alumno() {
		super();
	}

	public Alumno(String nombre, String apellido, Date fechaNacimiento, String genero, long dni, String ciudad,
			long legajo) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.genero = genero;
		this.dni = dni;
		this.ciudad = ciudad;
		this.legajo = legajo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public long getDni() {
		return dni;
	}

	public void setDni(long dni) {
		this.dni = dni;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public long getLegajo() {
		return legajo;
	}

	public void setLegajo(long legajo) {
		this.legajo = legajo;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Alumno{" +
				"nombre='" + nombre + '\'' +
				", apellido='" + apellido + '\'' +
				", fechaNacimiento=" + fechaNacimiento +
				", genero='" + genero + '\'' +
				", dni=" + dni +
				", ciudad='" + ciudad + '\'' +
				", legajo=" + legajo +
				'}';
	}
}
