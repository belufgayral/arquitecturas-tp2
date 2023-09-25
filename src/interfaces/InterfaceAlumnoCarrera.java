package interfaces;

import entities.Alumno;
import entities.AlumnoCarrera;
import entities.AlumnoCarreraId;
import entities.Carrera;

import java.sql.Date;
import java.util.List;

public interface InterfaceAlumnoCarrera<AlumnoCarrera> {

    public void matricularAlumno(Alumno a, Carrera c);
    public void GraduarAlumno(Date today, entities.AlumnoCarrera ac);
    public AlumnoCarrera buscarAlumnoID(AlumnoCarreraId id);

}
