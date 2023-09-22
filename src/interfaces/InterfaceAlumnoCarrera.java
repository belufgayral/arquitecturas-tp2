package interfaces;
import entities.Alumno;
import entities.Carrera;
import java.util.List;

public interface InterfaceAlumnoCarrera<AlumnoCarrera> {

    public void crearAlumnoCarrera(Alumno a, Carrera c);
    public void eliminarAlumnoCarrera(AlumnoCarrera ac);
    public void updateAlumnoCarrera(AlumnoCarrera ac);
    public List<AlumnoCarrera> listarAlumnosInscriptos();
}
