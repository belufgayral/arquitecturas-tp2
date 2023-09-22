package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Carrera {
	@Id
	private int id;
	@Column
	private String nombre;
	
	public Carrera() {
		super();
	}
	public Carrera(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getId() {
		return id;
	}
}
