package factories;

import repositories.AlumnoCarreraRepository;
import repositories.AlumnoRepository;
import repositories.CarreraRepository;

import helpers.GeneradorDatos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Alumno;
import entities.Carrera;

public class MySQLFactory extends Factory{
    public static MySQLFactory instance;
    private static EntityManagerFactory emf;
    private static EntityManager em;

    private static AlumnoRepository alumno;
    private static CarreraRepository carrera;
    private static AlumnoCarreraRepository alumnoCarrera;

    private MySQLFactory(){
    	this.poblarTablaAlumnos();
    	this.poblarTablaCarreras();
    	this.poblarTablaAlumnosCarreras();
    }

    public static EntityManager getConnection (){
        if(em == null) {
            emf = Persistence.createEntityManagerFactory("tp2");
            em = emf.createEntityManager();
        }
        return em;
    }
    
    public void closeConnection() {
    	em.close();
    	emf.close();
    }

    public static Factory getInstance(){
        if(instance == null){
            instance = new MySQLFactory();
        }
        return instance;
    }

    //creacion de los repositories
    public AlumnoRepository getAlumnoRepository(){
        if(alumno == null){
            alumno = new AlumnoRepository(this.getConnection());
        }
        return alumno;
    }

    @Override
    public CarreraRepository getCarreraRepository() {
        if(carrera == null){
            carrera = new CarreraRepository(this.getConnection());
        }
        return carrera;
    }

    @Override
    public AlumnoCarreraRepository getAlumnoCarreraRepository() {
        if(alumnoCarrera == null){
            alumnoCarrera = new AlumnoCarreraRepository(this.getConnection());
        }
        return alumnoCarrera;
    }
    
    public void poblarTablaAlumnos() {
    	List<Alumno> l = new ArrayList<Alumno>(GeneradorDatos.crearDatosAlumno());
    	
    	for (Alumno alumno : l) {
    		this.getAlumnoRepository().crearAlumno(alumno);
    	}
    }
    
    public void poblarTablaCarreras() {
    	List<Carrera> l = new ArrayList<Carrera>(GeneradorDatos.crearDatosCarrera());
    	
    	for (Carrera carrera : l) {
    		this.getCarreraRepository().crearCarrera(carrera);
    	}
    }
    
    public void poblarTablaAlumnosCarreras() {
    	this.getAlumnoCarreraRepository().matricularAlumno(this.getAlumnoRepository().buscarAlumno(1234), this.getCarreraRepository().buscarCarreraPorNombre("tudai"));
    	this.getAlumnoCarreraRepository().matricularAlumno(this.getAlumnoRepository().buscarAlumno(12345), this.getCarreraRepository().buscarCarreraPorNombre("tudai"));
        this.getAlumnoCarreraRepository().matricularAlumno(this.getAlumnoRepository().buscarAlumno(123456), this.getCarreraRepository().buscarCarreraPorNombre("sistemas"));
        this.getAlumnoCarreraRepository().matricularAlumno(this.getAlumnoRepository().buscarAlumno(1234567), this.getCarreraRepository().buscarCarreraPorNombre("economicas"));
    }
}
