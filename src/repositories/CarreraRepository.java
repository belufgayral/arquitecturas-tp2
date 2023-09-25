package repositories;

import DTO.CarrerasInscriptosDTO;
import DTO.ReporteCarrerasDTO;
import entities.Alumno;
import entities.Carrera;
import interfaces.InterfaceCarrera;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
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

    public List<ReporteCarrerasDTO> reporteDeCarreras(){
    	String querysql = """
    			SELECT nombre AS carrera,anio, MAX(cant_inscriptos) AS cant_inscriptos, MAX(cant_graduados) AS cant_egresados
    			FROM (
    			        SELECT c.nombre, YEAR(fechaGraduacion) as anio, COUNT(fechaGraduacion) AS cant_graduados, 0 AS cant_inscriptos
    			        FROM Carrera c LEFT JOIN AlumnoCarrera ac ON ac.idcarrera = c.id
    			        WHERE fechaGraduacion IS NOT NULL
    			        GROUP BY c.id, fechaGraduacion
    			        UNION (
    			                SELECT c.nombre, YEAR(ac.fechaInscripcion), 0, COUNT(YEAR(ac.fechaInscripcion)) AS cant_inscriptos
    			                FROM Carrera c LEFT JOIN AlumnoCarrera ac ON ac.idcarrera = c.id
    			                GROUP BY c.id, YEAR(ac.fechaInscripcion))) graduados_inscriptos
    			GROUP BY nombre, anio
    			ORDER BY nombre, anio;
    			""";
    	
        Query query = em.createNativeQuery(querysql);
        List<Object[]> carreras = query.getResultList();

        List<ReporteCarrerasDTO> dtos = new ArrayList<>();
        for (Object[] fila:carreras){
            ReporteCarrerasDTO newDTO = new ReporteCarrerasDTO();
            // NOMBRE CARRERA
            newDTO.setNombreCarrera((String) fila[0]);

            // FECHA
            Date fecha = (Date) fila[1];
            java.util.Calendar calendar = java.util.Calendar.getInstance();
            calendar.setTime(fecha);
            int anio = (Integer) calendar.get(java.util.Calendar.YEAR);
            newDTO.setAnio(anio);

            //INSCRIPTOS
            java.math.BigInteger bigInteger = (BigInteger) fila[2];
            int entero = (Integer) bigInteger.intValue();
            newDTO.setInscriptos(entero);


            //GRADUADOS
            java.math.BigInteger bigInteger2 = (BigInteger) fila[3];
            int entero2 = (Integer) bigInteger2.intValue();
            newDTO.setEgresados(entero2);

            dtos.add(newDTO);
        }
        
        return dtos;
    }

}
