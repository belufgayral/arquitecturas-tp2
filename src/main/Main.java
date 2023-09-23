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

    @SuppressWarnings("deprecation")
	public static void main(String[] args) {
        Factory mysql = MySQLFactory.getInstance();

        AlumnoRepository alumnoRep = mysql.getAlumnoRepository();
        CarreraRepository carreraRep = mysql.getCarreraRepository();
        AlumnoCarreraRepository alumnoCarreraRep = mysql.getAlumnoCarreraRepository();
        

        //buscar por legajo universitario
        System.out.println("Alumnos por LU: 12345");
        Alumno a3 = alumnoRep.buscarAlumno(12345);
        System.out.println(a3.toString());
        System.out.println("---------------");

        //Alumnos por genero
        System.out.println("Alumnos por genero: femenino");
        List<Alumno> l1 = alumnoRep.buscarAlumnoPorGenero("femenino");
        for(Alumno a: l1){
            System.out.println(a.toString());
        }
        System.out.println("---------------");


        //LISTAR TODOS LOS ALUMNOS
        System.out.println("LISTAR TODOS LOS ALUMNOS");
        List<Alumno> alumnos = alumnoRep.listarAlumnos();
        for(Alumno a: alumnos){
            System.out.println(a.toString());
        }
        System.out.println("---------------");

        //LISTAR TODOS LAS CARRERAS, NO ANDA!
        /**System.out.println("LISTAR TODOS LAS CARRERAS");
        List<Carrera> carreras = carreraRep.listarCarrerasConAlumnosIncriptos();
        for(Carrera c: carreras){
            System.out.println(c.toString());
        }
        System.out.println("---------------");**/

        //alumnoCarreraRep.listarAlumnosInscriptos();

        mysql.closeConnection();
    }
}
