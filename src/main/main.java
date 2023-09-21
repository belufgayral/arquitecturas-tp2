package main;

import entities.Alumno;
import factories.Factory;
import factories.MySQLFactory;
import repositories.AlumnoCarreraRepository;
import repositories.AlumnoRepository;
import repositories.CarreraRepository;

public class main {

    public static void main(String[] args) {
        Factory mysql = MySQLFactory.getInstance();

        AlumnoRepository alumnoRep = mysql.getAlumnoRepository();
        CarreraRepository carreraRep = mysql.getCarreraRepository();
        AlumnoCarreraRepository alumnoCarreraRep = mysql.getAlumnoCarreraRepository();

    }
}
