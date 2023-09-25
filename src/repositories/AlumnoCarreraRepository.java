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

    //problemas con este metodo.
    @Override
    public void matricularAlumno(Alumno a, Carrera c) {
        em.getTransaction().begin();

        //AlumnoCarreraId acId = new AlumnoCarreraId(a, c);
        Date today = new Date(System.currentTimeMillis());
        AlumnoCarrera ac = new AlumnoCarrera(new AlumnoCarreraId(a, c), today,  false);

        em.persist(ac);
        em.getTransaction().commit();

        //em.close();
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

        //return query.getResultList();
        return query.getSingleResult();
    }
}