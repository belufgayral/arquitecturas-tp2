package factories;

import repositories.AlumnoCarreraRepository;
import repositories.AlumnoRepository;
import repositories.CarreraRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MySQLFactory extends Factory{
    public static MySQLFactory instance;
    private static EntityManager em;

    private static AlumnoRepository alumno;
    private static CarreraRepository carrera;
    private static AlumnoCarreraRepository alumnoCarrera;

    private MySQLFactory(){
    }

    public static EntityManager getConnection (){
        if(em == null) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp2");
            em = emf.createEntityManager();
        }
        return em;
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
}
