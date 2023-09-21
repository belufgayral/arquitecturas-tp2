package repositories;

import entities.Alumno;
import interfaces.InterfaceAlumno;

import java.util.List;

public class AlumnoRepository implements InterfaceAlumno<Alumno> {
    @Override
    public void crearAlumno(Alumno a) {

    }

    @Override
    public void deleteAlumno(int dni) {

    }

    @Override
    public List listarAlumnos() {
        return null;
    }

    @Override
    public Alumno buscarAlumno(long legajo) {
        return null;
    }

    @Override
    public Alumno buscarAlumnoPorGenero(String genero) {
        return null;
    }
}
