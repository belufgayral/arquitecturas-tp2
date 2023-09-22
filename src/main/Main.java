package main;

import java.sql.Array;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

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
        

        alumnoRep.crearAlumno(a1);
        alumnoRep.crearAlumno(a2);
        carreraRep.crearCarrera(c1);


        //buscar por legajo universitario
        System.out.println("Alumnos por LU: 12345");
        Alumno a3 = alumnoRep.buscarAlumno(12345);
        System.out.println(a3.toString());
        System.out.println("---------------");

        //Alumnos por genero
        System.out.println("Alumnos por genero: femenino");
        ArrayList<Alumno> l1 = (ArrayList<Alumno>) alumnoRep.buscarAlumnoPorGenero("femenino");
        for(Alumno a: l1){
            System.out.println(a.toString());
        }
        System.out.println("---------------");


        //LISTAR TODOS LOS ALUMNOS
        System.out.println("LISTAR TODOS LOS ALUMNOS");
        ArrayList<Alumno> alumnos = (ArrayList<Alumno>) alumnoRep.listarAlumnos();
        for(Alumno a: alumnos){
            System.out.println(a.toString());
        }
        System.out.println("---------------");

        //LISTAR TODOS LAS CARRERAS
//        System.out.println("LISTAR TODOS LAS CARRERAS");
//        ArrayList<Carrera> carreras = (ArrayList<Carrera>) carreraRep.listarCarrerasConAlumnosIncriptos();
//        for(Carrera c: carreras){
//            System.out.println(c.toString());
//        }
//        System.out.println("---------------");

        alumnoCarreraRep.matricularAlumno(a1, c1);
        alumnoCarreraRep.matricularAlumno(a2, c1);
        //alumnoCarreraRep.listarAlumnosInscriptos();

        mysql.closeConnection();
    }
}
