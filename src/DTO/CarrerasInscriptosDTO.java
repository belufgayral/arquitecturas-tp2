package DTO;

public class CarrerasInscriptosDTO {
    private String nombreCarrera;
    private long cantInscriptos;

    public CarrerasInscriptosDTO(String nombreCarrera, long cantInscriptos) {
        this.nombreCarrera = nombreCarrera;
        this.cantInscriptos = cantInscriptos;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

//    public void setNombreCarrera(String nombreCarrera) {
//        this.nombreCarrera = nombreCarrera;
//    }

    public long getCantInscriptos() {
        return cantInscriptos;
    }

//    public void setCantInscriptos(int cantInscriptos) {
//        this.cantInscriptos = cantInscriptos;
//    }


    @Override
    public String toString() {
        return "AlumnoCarreraDTO{" +
                "nombreCarrera='" + nombreCarrera + '\'' +
                ", cantInscriptos=" + cantInscriptos +
                '}';
    }
}
