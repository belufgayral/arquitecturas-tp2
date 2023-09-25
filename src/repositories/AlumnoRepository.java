package repositories;

import DTO.AlumnoDTO;
import entities.Alumno;
import entities.Carrera;
import interfaces.InterfaceAlumno;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class AlumnoRepository implements InterfaceAlumno<Alumno> {
    private EntityManager em;
    
    public AlumnoRepository(EntityManager e){
        this.em=e;
    }
    
    @Override
    public void crearAlumno(Alumno a) {
    	em.getTransaction().begin();
        em.persist(a);
        em.getTransaction().commit();
    }

    @Override
    public List<Alumno> listarAlumnos() {
        TypedQuery<Alumno> query = em.createQuery("SELECT a " +
                        "FROM Alumno a " +
                        "ORDER BY a.nombre ASC "
                , Alumno.class);

        List<Alumno> alumnos = query.getResultList();
        
        return alumnos;
    }

    @Override
    public Alumno buscarAlumno(long libretaUniversitaria) {
    	TypedQuery<Alumno> query = em.createQuery("SELECT a " +
                        "FROM Alumno a " +
                        "WHERE a.legajo = :libretaUniversitariaBuscada"
                , Alumno.class);
        query.setParameter("libretaUniversitariaBuscada", libretaUniversitaria);

        Alumno alumno = query.getSingleResult();

        return alumno;
    }

    @Override
    public List<Alumno> buscarAlumnoPorGenero(String genero) {
        TypedQuery<Alumno> query = em.createQuery("SELECT a " +
                        "FROM Alumno a " +
                        "WHERE a.genero = :generoBuscado"
                , Alumno.class);
        query.setParameter("generoBuscado", genero);

        List<Alumno> alumnos = query.getResultList();

        return alumnos;
    }

    public List<AlumnoDTO> listarAlumnosPorCarreraFiltradoPor(Carrera c,String ciudad) {
        TypedQuery<AlumnoDTO> query = em.createQuery(
                "SELECT new DTO.AlumnoDTO(a.legajo, a.dni, a.nombre, a.apellido, a.ciudad, c.nombre) " +
                "FROM AlumnoCarrera ac JOIN ac.id.alumno a JOIN ac.id.carrera c " +
                "WHERE c.id = :cc AND a.ciudad  = :ciudad " +
                "ORDER BY a.apellido DESC", AlumnoDTO.class);

        query.setParameter("cc", c.getId());
        query.setParameter("ciudad", ciudad);
        List<AlumnoDTO> alumnos = query.getResultList();

        return alumnos;
    }

}