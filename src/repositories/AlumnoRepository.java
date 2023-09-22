package repositories;

import entities.Alumno;
import entities.Carrera;
import interfaces.InterfaceAlumno;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class AlumnoRepository implements InterfaceAlumno<Alumno> {
    @Override
    public void crearAlumno(Alumno a) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp_2");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(a);
        em.getTransaction().commit();

        em.close();
        emf.close();


    }

    @Override
    public void deleteAlumno(int dni) {

    }

    @Override
    public List<Alumno> listarAlumnos() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp_2");
        EntityManager em = emf.createEntityManager();

        TypedQuery<Alumno> query = em.createQuery("SELECT a " +
                "FROM Alumno a " +
                " ORDER BY a.nombre ASC "
                , Alumno.class);

        List<Alumno> alumnos = query.getResultList();


        em.close();
        emf.close();

        return alumnos;
    }

    @Override
    public Alumno buscarAlumno(long libretaUniversitaria) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp_2");
        EntityManager em = emf.createEntityManager();

        TypedQuery<Alumno> query = em.createQuery("SELECT a " +
                "FROM Alumno a " +
                "WHERE a.legajo = :libretaUniversitariaBuscada"
                , Alumno.class);
        query.setParameter("libretaUniversitariaBuscada", libretaUniversitaria);

        Alumno alumno = query.getSingleResult();

        em.close();
        emf.close();

        return alumno;

    }

    @Override
    public List<Alumno> buscarAlumnoPorGenero(String genero) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp_2");
        EntityManager em = emf.createEntityManager();

        TypedQuery<Alumno> query = em.createQuery("SELECT a " +
                "FROM Alumno a " +
                "WHERE a.genero = :generoBuscado"
                , Alumno.class);
        query.setParameter("generoBuscado", genero);

        List<Alumno> alumnos = query.getResultList();

        em.close();
        emf.close();
        return alumnos;
    }
    public List<Alumno> listarAlumnosPorCarreraFiltradoPor(Carrera c,String ciudad) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp_2");
        EntityManager em = emf.createEntityManager();

        TypedQuery<Alumno> query = em.createQuery("SELECT a , count(ac) AS inscriptos " +
                " FROM  Alumno a INNER JOIN AlumnoCarrera ac " +
                " WHERE :cc = ac.carrera AND :ciudad = a.ciudad" +
                " ORDER BY inscriptos DESC", Alumno.class);

        query.setParameter("cc", c);
        query.setParameter("ciudad", ciudad);
        List<Alumno> alumnos = query.getResultList();

        em.close();
        emf.close();
        return alumnos;
    }
}
