package main;

import java.util.List;

import DTO.AlumnoDTO;
import DTO.CarrerasInscriptosDTO;
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
        System.out.println("LISTAR TODOS LAS CARRERAS");
        List<Carrera> carreras = carreraRep.listarCarreras();
        for(Carrera c: carreras){
            System.out.println(c.toString());
        }
        System.out.println("---------------");


        System.out.println("LISTAR TODOS LAS CARRERAS");
        List<CarrerasInscriptosDTO> carreras2 = carreraRep.listarCarrerasConAlumnosIncriptos();
        for(CarrerasInscriptosDTO c: carreras2){
            System.out.println(c.toString());
        }
        System.out.println("---------------");


        System.out.println("Listar todos los alumnos filtrado por tudai y tandil");
        Carrera c5 = carreraRep.buscarCarreraPorNombre("tudai");
        List<AlumnoDTO> listarAlumnosPorCarrera = alumnoRep.listarAlumnosPorCarreraFiltradoPor(c5, "tandil");
        for(AlumnoDTO a: listarAlumnosPorCarrera){
            System.out.println(a.toString());
        }
        System.out.println("---------------");

        mysql.closeConnection();
    }
}
