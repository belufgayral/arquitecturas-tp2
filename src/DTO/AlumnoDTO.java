package DTO;

import entities.Carrera;

public class AlumnoDTO {
    private long legajo;
    private long dni;
    private String nombreCompleto;
    private String ciudad;
    private String carrera;

    public AlumnoDTO(long legajo, long dni, String nombre,String apellido, String ciudad
            , String nombreCarrera
         ) {
        this.legajo = legajo;
        this.dni = dni;
        this.nombreCompleto = nombre+' '+apellido;
        this.ciudad = ciudad;
        this.carrera = nombreCarrera;
    }

    public long getLegajo() {
        return legajo;
    }

    public long getDni() {
        return dni;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getNombreCarrera() {
        return carrera;
    }

    @Override
    public String toString() {
        return "AlumnoDTO{" +
                "legajo=" + legajo +
                ", dni=" + dni +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", nombreCarrera='" + carrera + '\'' +
                '}';
    }
}
