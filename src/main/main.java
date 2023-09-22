package main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Alumno;
import factories.Factory;
import factories.MySQLFactory;
import repositories.AlumnoCarreraRepository;
import repositories.AlumnoRepository;
import repositories.CarreraRepository;

public class Main {

    public static void main(String[] args) {
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp2");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
        //Factory mysql = MySQLFactory.getInstance();

        //AlumnoRepository alumnoRep = mysql.getAlumnoRepository();
        //CarreraRepository carreraRep = mysql.getCarreraRepository();
        //AlumnoCarreraRepository alumnoCarreraRep = mysql.getAlumnoCarreraRepository();

    }
}
