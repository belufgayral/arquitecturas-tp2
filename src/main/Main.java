package main;

import java.sql.Date;
import java.util.List;

import DTO.AlumnoDTO;
import DTO.CarrerasInscriptosDTO;
import DTO.ReporteCarrerasDTO;
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

		// Implementación de consultas
		// 2) A. Dar de alta un estudiante
		System.out.println("DAR DE ALTA UN ESTUDIANTE");
		Alumno a1 = new Alumno("Juan", "Pérez", new Date(1997 - 1900, 6 - 1, 20), "masculino", 36758625, "tandil",
				12345678);
		alumnoRep.crearAlumno(a1);
		System.out.println(alumnoRep.buscarAlumno(12345678));
		System.out.println("---------------");

		// 2) B. Matricular un estudiante en una carrera
		System.out.println("MATRICULAR UN ESTUDIANTE EN UNA CARRERA");
		Carrera carrera = carreraRep.buscarCarreraPorNombre("economicas");
		//MATRICULANDO A JUAN PEREZ EN ECONOMICAS.
		alumnoCarreraRep.matricularAlumno(a1, carrera);
		System.out.println("---------------");

		//2) C. Recuperar todos los estudiantes y especificar algún criterio de ordenamiento simple.
		System.out.println("LISTAR TODOS LOS ALUMNOS");
		List<Alumno> alumnos = alumnoRep.listarAlumnos();
		for (Alumno a : alumnos) {
			System.out.println(a);
		}
		System.out.println("---------------");

		// 2) D. Recuperar un estudiante, en base a su número de libreta universitaria.
		System.out.println("ALUMNOS POR LU: 12345");
		Alumno a3 = alumnoRep.buscarAlumno(12345);
		System.out.println(a3);
		System.out.println("---------------");

		//2) E. Recuperar todos los estudiantes, en base a su género.
		System.out.println("ALUMNOS POR GÉNERO FEMENINO");
		List<Alumno> l1 = alumnoRep.buscarAlumnoPorGenero("femenino");
		for (Alumno a : l1) {
			System.out.println(a);
		}
		System.out.println("---------------");

		// 2) F. Recuperar las carreras con estudiantes inscriptos y ordenar por cantidad de inscriptos.
		System.out.println("TODAS LAS CARRERAS CON ALUMNOS INSCRIPTOS");
		List<CarrerasInscriptosDTO> carreras2 = carreraRep.listarCarrerasConAlumnosIncriptos();
		for (CarrerasInscriptosDTO c : carreras2) {
			System.out.println(c);
		}
		System.out.println("---------------");

		// 2) G. Recuperar los estudiantes de una determinada carrera filtrado por ciudad de residencia.
		System.out.println("TODOS LOS ESTUDIANTES DE LA CARRERA TUDAI EN TANDIL");
		Carrera c5 = carreraRep.buscarCarreraPorNombre("tudai");
		List<AlumnoDTO> listarAlumnosPorCarrera = alumnoRep.listarAlumnosPorCarreraFiltradoPor(c5, "tandil");
		for (AlumnoDTO a : listarAlumnosPorCarrera) {
			System.out.println(a);
		}
		System.out.println("---------------");
		
		// 3) Generar un reporte de las carreras, que para cada carrera incluya información de los
		//	  inscriptos y egresados por año. Se deben ordenar las carreras alfabéticamente, y presentar
		//	  los años de manera cronológica.
		
		System.out.println("REPORTE DE LAS CARRERAS");
		List<ReporteCarrerasDTO> reporte = carreraRep.reporteDeCarreras();
		for (ReporteCarrerasDTO r : reporte) {
			System.out.println(r);
		}
		System.out.println("---------------");

		mysql.closeConnection();
	}
}
