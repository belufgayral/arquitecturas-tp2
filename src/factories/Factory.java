package factories;

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
    //...
}
