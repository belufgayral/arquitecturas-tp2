package repositories;

import DTO.CarrerasInscriptosDTO;
import DTO.carreraAnioDTO;
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
    }

    @Override
    public void eliminarCarrera(Carrera c) {
        //TODO
    }

    @Override
    public void updateCarrera(Carrera c) {
    //TODO
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
        TypedQuery<Carrera> query = em.createQuery(
                "SELECT c " +
                        "FROM Carrera c", Carrera.class);

        List<Carrera> carreras = query.getResultList();

        return carreras;
    }


    //2)f)
    public List<CarrerasInscriptosDTO> listarCarrerasConAlumnosIncriptos() {
        TypedQuery<CarrerasInscriptosDTO> query = em.createQuery(
                "SELECT NEW DTO.CarrerasInscriptosDTO(c.nombre, COUNT(ac.id.carrera)) " +
                        "FROM AlumnoCarrera ac JOIN ac.id.carrera c " +
                        "GROUP BY c " +
                        "ORDER BY COUNT(ac.id.carrera) DESC", CarrerasInscriptosDTO.class);

        List<CarrerasInscriptosDTO> carreras = query.getResultList();

        return carreras;
    }

    //3)
//    public List<carreraAnioDTO> reporteDeCarreras(){
//        TypedQuery<carreraAnioDTO> query = ""
//
//
//        List<carreraAnioDTO> carreras = query.getResultList();
//        return carreras;
//
//    }

}
