package interfaces;

import entities.Alumno;

import java.util.List;

public interface InterfaceCarrera<Carrera> {

    public void crearCarrera(Carrera c);
    public void eliminarCarrera(Carrera c);
    public void updateCarrera(Carrera c);
    public List<Carrera> listarCarreras();
}
