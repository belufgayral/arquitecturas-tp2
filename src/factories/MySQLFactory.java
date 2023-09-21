package factories;

import repositories.AlumnoCarreraRepository;
import repositories.AlumnoRepository;
import repositories.CarreraRepository;

import javax.persistence.EntityManagerFactory;

public class MySQLFactory extends Factory{
    public static MySQLFactory instance;
    private EntityManagerFactory emf;

    private static AlumnoRepository alumno;
    private static CarreraRepository carrera;
    private static AlumnoCarreraRepository alumnoCarrera;

    private MySQLFactory(){
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
            alumno = new AlumnoRepository();
        }
        return alumno;
    }

    @Override
    public CarreraRepository getCarreraRepository() {
        if(carrera == null){
            carrera = new CarreraRepository();
        }
        return carrera;
    }

    @Override
    public AlumnoCarreraRepository getAlumnoCarreraRepository() {
        if(alumnoCarrera == null){
            alumnoCarrera = new AlumnoCarreraRepository();
        }
        return alumnoCarrera;
    }
}
