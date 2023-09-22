package repositories;

import entities.Carrera;
import interfaces.InterfaceCarrera;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class CarreraRepository implements InterfaceCarrera<Carrera> {
    private EntityManager em;
    public CarreraRepository(EntityManager e){
        this.em=e;
    }
    @Override
    public void crearCarrera(Carrera c) {

    }

    @Override
    public void eliminarCarrera(Carrera c) {

    }

    @Override
    public void updateCarrera(Carrera c) {

    }

    @Override
    public List<Carrera> listarCarreras() {
        return null;
    }

    public List<Carrera> listarCarrerasConAlumnosIncriptos() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp_2");
        EntityManager em = emf.createEntityManager();

        TypedQuery<Carrera> query = em.createQuery("SELECT c , count(ac) AS inscriptos " +
                " FROM  Carrera c INNER JOIN AlumnoCarrera ac " +
                " WHERE ac.carrera = c" +
                " GROUP BY c" +
                " ORDER BY inscriptos DESC", Carrera.class);

        List<Carrera> carreras = query.getResultList();

        em.close();
        emf.close();
        return carreras;
    }
}
