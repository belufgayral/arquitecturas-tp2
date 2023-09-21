package interfaces;

import java.util.List;

public interface InterfaceAlumnoCarrera<AlumnoCarrera> {

    public void crearAlumnoCarrera(AlumnoCarrera ac);
    public void eliminarAlumnoCarrera(AlumnoCarrera ac);
    public void updateAlumnoCarrera(AlumnoCarrera ac);
    public List<AlumnoCarrera> listarAlumnosInscriptos();
}
