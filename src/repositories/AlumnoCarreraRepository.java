package repositories;

import entities.Alumno;
import entities.AlumnoCarrera;
import entities.AlumnoCarreraId;
import entities.Carrera;
import interfaces.InterfaceAlumnoCarrera;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.sql.Date;
import java.util.List;

public class AlumnoCarreraRepository implements InterfaceAlumnoCarrera<AlumnoCarrera> {

    private EntityManager em;
    
    public AlumnoCarreraRepository(EntityManager e){
        this.em=e;
    }

    //problemas con este metodo.
    @Override
    public void matricularAlumno(Alumno a, Carrera c) {
        em.getTransaction().begin();

        AlumnoCarreraId acId = new AlumnoCarreraId(a, c);
        Date today = new Date(2023,12,30);
        AlumnoCarrera ac = new AlumnoCarrera(acId, today, false);

        em.persist(ac);
        em.getTransaction().commit();

        //em.close();
    }

    @Override
    public void eliminarAlumnoCarrera(AlumnoCarrera ac) {

    }

    @Override
    public void updateAlumnoCarrera(AlumnoCarrera ac) {

    }

    @Override
    public List<AlumnoCarrera> listarAlumnosInscriptos() {

        return null;
    }
}