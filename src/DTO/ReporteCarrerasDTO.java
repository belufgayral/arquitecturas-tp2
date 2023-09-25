package DTO;

import java.util.Date;

public class ReporteCarrerasDTO {
    private String nombreCarrera;
    private int anio;
    private int regulares;
    private int egresados;

    public ReporteCarrerasDTO(String nombre, int egresados, int regulares, int anio){
        this.nombreCarrera = nombre;
        this.egresados = egresados;
        this.regulares = regulares;
        this.anio = anio;
    }

    public ReporteCarrerasDTO() {

    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public int getAnio() {
        return anio;
    }
    public int getEgresados() {
        return egresados;
    }

    public int getRegulares() {
        return regulares;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public void setEgresados(int egresados) {
        this.egresados = egresados;
    }

    public void setRegulares(int regulares) {
        this.regulares = regulares;
    }

	@Override
	public String toString() {
		return "CarreraAnioDTO [nombreCarrera=" + nombreCarrera + ", anio=" + anio + ", regulares=" + regulares
				+ ", egresados=" + egresados + "]";
	}
}
