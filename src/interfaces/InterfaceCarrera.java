package interfaces;

import DTO.CarrerasInscriptosDTO;
import DTO.ReporteCarrerasDTO;
import entities.Alumno;
import entities.Carrera;

import java.util.List;

public interface InterfaceCarrera<Carrera> {

    public void crearCarrera(Carrera c);
    public List<Carrera> listarCarreras();
    public entities.Carrera buscarCarreraPorNombre(String c);
    public List<CarrerasInscriptosDTO> listarCarrerasConAlumnosIncriptos();
    public List<ReporteCarrerasDTO> reporteDeCarreras();
}
