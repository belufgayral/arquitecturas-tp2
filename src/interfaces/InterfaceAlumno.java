package interfaces;

import DTO.AlumnoDTO;
import entities.Carrera;

import java.util.List;

public interface InterfaceAlumno<Alumno> {
    public void crearAlumno(Alumno a);

    public List<Alumno> listarAlumnos();

    public Alumno buscarAlumno(long legajo);

    public List<Alumno> buscarAlumnoPorGenero(String genero);

    public List<AlumnoDTO> listarAlumnosPorCarreraFiltradoPor(Carrera c, String ciudad);
}
