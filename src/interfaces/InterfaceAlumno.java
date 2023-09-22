package interfaces;

import java.util.List;

public interface InterfaceAlumno<Alumno> {
    public void crearAlumno(Alumno a);

    public void deleteAlumno(int dni);

    public List<Alumno> listarAlumnos();

    public Alumno buscarAlumno(long legajo);

    public List<Alumno> buscarAlumnoPorGenero(String genero);
}
