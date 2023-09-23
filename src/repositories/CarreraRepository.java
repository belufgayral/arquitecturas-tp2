package repositories;

import entities.Alumno;
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
    	em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
        //em.close();
    }

    @Override
    public void eliminarCarrera(Carrera c) {

    }

    @Override
    public void updateCarrera(Carrera c) {

    }
    
    public Carrera buscarCarreraPorNombre(String c) {
    	TypedQuery<Carrera> query = em.createQuery("SELECT c " +
                					"FROM Carrera c " +
                					"WHERE c.nombre = :carreraBuscada"
                					, Carrera.class);
    	query.setParameter("carreraBuscada", c);

    	Carrera carrera = query.getSingleResult();

    	return carrera;
    }

    @Override
    public List<Carrera> listarCarreras() {
        return null;
    }

    //no anda
    public List<Carrera> listarCarrerasConAlumnosIncriptos() {
       TypedQuery<Carrera> query = em.createQuery(
               "SELECT c, COUNT(ac) AS inscriptos " +
                "FROM Carrera c JOIN c.carrera ac " +
                "WHERE ac.id.carrera = c " +
                "GROUP BY c " +
                "ORDER BY inscriptos DESC", Carrera.class);

        List<Carrera> carreras = query.getResultList();

        return carreras;
    }
}
