package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Carrera {
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	private int id;
	@Column
	private String nombre;

	public Carrera() {
		super();
	}

	public Carrera(String nombre) {
		super();
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

	@Override
	public String toString() {
		return "Carrera{" +
				"id=" + id +
				", nombre='" + nombre + '\'' +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		Carrera c1 = (Carrera) o;
		if (this.id == c1.id) {
			return true;
		}
		return false;
	}

}
