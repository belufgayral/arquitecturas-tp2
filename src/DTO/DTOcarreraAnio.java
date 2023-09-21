package DTO;

import java.util.Date;

public class DTOcarreraAnio {
    private String nombreCarrera;
    private Date anio;
    private int egresados;
    private int regulares;

    public DTOcarreraAnio(String nombre, int egresados, int regulares, Date anio){
        this.nombreCarrera = nombre;
        this.egresados = egresados;
        this.regulares = regulares;
        this.anio = anio;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public Date getAnio() {
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

    public void setAnio(Date anio) {
        this.anio = anio;
    }

    public void setEgresados(int egresados) {
        this.egresados = egresados;
    }

    public void setRegulares(int regulares) {
        this.regulares = regulares;
    }

}
