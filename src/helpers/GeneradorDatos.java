package helpers;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import entities.Alumno;
import entities.Carrera;

public class GeneradorDatos {
	
	@SuppressWarnings("deprecation")
	public static List<Alumno> crearDatosAlumno() {
		Alumno a1 = new Alumno("Agustin", "Menchon", new Date(1998,1,19), "masculino", 41873051, "tandil",12345);
	    Alumno a2 = new Alumno("belen", "Fernandez", new Date(1998,3,8), "femenino", 51239817, "tandil", 1234);
	    
	    List<Alumno> l = new ArrayList<Alumno>();
	    
	    l.add(a1);
	    l.add(a2);
	
	    return l;
	}
	
	public static List<Carrera> crearDatosCarrera() {
		Carrera c1 = new Carrera("tudai");
	    Carrera c2 = new Carrera("sistemas");
	    
	    List<Carrera> l = new ArrayList<Carrera>();
	    
	    l.add(c1);
	    l.add(c2);
	    
	    return l;
	}
}
