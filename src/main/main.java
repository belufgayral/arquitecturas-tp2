package main;

import java.sql.Date;

import entities.Alumno;
import entities.Carrera;
import factories.Factory;
import factories.MySQLFactory;
import repositories.AlumnoCarreraRepository;
import repositories.AlumnoRepository;
import repositories.CarreraRepository;

public class Main {

    public static void main(String[] args) {		
        Factory mysql = MySQLFactory.getInstance();

        AlumnoRepository alumnoRep = mysql.getAlumnoRepository();
        CarreraRepository carreraRep = mysql.getCarreraRepository();
        AlumnoCarreraRepository alumnoCarreraRep = mysql.getAlumnoCarreraRepository();
        
        @SuppressWarnings("deprecation")
		Date d1 = new Date(1998,1,19);

		Alumno a1 = new Alumno("Agustin", "Menchon", d1, "masculino", 41873051, "tandil",12345);
        Alumno a2 = new Alumno("belen", "Fernandez", d1, "femenino", 51239817, "tandil", 1234);

        Carrera c1 = new Carrera("tudai");
        
        //alumnoCarreraRep.matricularAlumno(a1, c1);
        //alumnoCarreraRep.matricularAlumno(a2, c1); 
        //alumnoCarreraRep.listarAlumnosInscriptos();
        
        alumnoRep.crearAlumno(a1);
        alumnoRep.crearAlumno(a2);
        carreraRep.crearCarrera(c1);
        
        mysql.closeConnection();
    }
}
