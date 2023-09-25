package repositories;

import DTO.CarrerasInscriptosDTO;
import entities.Alumno;
import entities.AlumnoCarrera;
import entities.AlumnoCarreraId;
import entities.Carrera;
import interfaces.InterfaceAlumnoCarrera;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

public class AlumnoCarreraRepository implements InterfaceAlumnoCarrera<AlumnoCarrera> {

    private EntityManager em;
    
    public AlumnoCarreraRepository(EntityManager e){
        this.em=e;
    }


    @Override
    public void matricularAlumno(Alumno a, Carrera c) {
        em.getTransaction().begin();

        Date today = new Date(System.currentTimeMillis());
        AlumnoCarrera ac = new AlumnoCarrera(new AlumnoCarreraId(a, c), today,  false);

        em.persist(ac);
        em.getTransaction().commit();
    }

    @Override
    public void GraduarAlumno(Date today, AlumnoCarrera ac) {
        ac.setFechaGraduacion(today);
    }

    @Override
    public AlumnoCarrera buscarAlumnoID(AlumnoCarreraId id) {
        TypedQuery<AlumnoCarrera> query = em.createQuery("SELECT ac " +
                        "FROM AlumnoCarrera ac " +
                        "WHERE ac.id = :acId"
                , AlumnoCarrera.class);
        query.setParameter("acId", id);

        return query.getSingleResult();
    }

    public AlumnoCarrera buscarAlumnoID(int id) {
        TypedQuery<AlumnoCarrera> query = em.createQuery("SELECT ac " +
                        "FROM AlumnoCarrera ac " +
                        "WHERE ac.id.alumno.id = :acId"
                , AlumnoCarrera.class);
        query.setParameter("acId", id);

        return query.getSingleResult();
    }
}