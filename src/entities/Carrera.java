package entities;

import javax.persistence.Column;
import javax.persistence.Id;

public class Carrera {
	@Id
	private int id;
	@Column
	private String nombre;
}
