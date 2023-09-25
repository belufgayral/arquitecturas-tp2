package helpers;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import entities.Alumno;
import entities.Carrera;

public class GeneradorDatos {
	
	@SuppressWarnings("deprecation")
	public static List<Alumno> crearDatosAlumno() {
		Alumno a1 = new Alumno("Agustin", "Menchon", new Date(1999-1900,07-1,12), "masculino", 41873051, "tandil",1234);
	    Alumno a2 = new Alumno("belen", "Fernandez", new Date(1998-1900,3-1,8), "femenino", 51239817, "tandil", 12345);
		Alumno a3 = new Alumno("Ezequiel", "Martinez", new Date(1998-1900,3-1,8), "masculino", 51239817, "tandil", 123456);
		Alumno a4 = new Alumno("Tano", "Mengarelli Yespersen", new Date(2000-1900,3-1,8), "masculino", 51239817, "tandil", 1234567);
	    
	    List<Alumno> l = new ArrayList<Alumno>();
	    
	    l.add(a1);
	    l.add(a2);
		l.add(a3);
		l.add(a4);
	
	    return l;
	}
	
	public static List<Carrera> crearDatosCarrera() {
		Carrera c1 = new Carrera("tudai");
	    Carrera c2 = new Carrera("sistemas");
		Carrera c3 = new Carrera("economicas");
	    
	    List<Carrera> l = new ArrayList<Carrera>();
	    
	    l.add(c1);
	    l.add(c2);
		l.add(c3);
	    
	    return l;
	}
}
