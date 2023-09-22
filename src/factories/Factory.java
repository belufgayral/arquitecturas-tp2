package factories;

import repositories.AlumnoCarreraRepository;
import repositories.AlumnoRepository;
import repositories.CarreraRepository;

import java.sql.SQLException;

public abstract class Factory {
    public static final String Factory = "mysql";
    public static MySQLFactory SQLFactory;


    public static Factory getFactory(String db) throws SQLException {
        switch(db){
            case Factory: return MySQLFactory.getInstance();
            default: return null;
        }
    }
    //crear los repository
    public abstract AlumnoRepository getAlumnoRepository();
    public abstract CarreraRepository getCarreraRepository();
    public abstract AlumnoCarreraRepository getAlumnoCarreraRepository();
	public abstract void closeConnection();

}
