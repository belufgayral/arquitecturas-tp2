package factories;

import javax.persistence.EntityManagerFactory;

public class MySQLFactory extends Factory{
    public static MySQLFactory instance;
    private EntityManagerFactory emf;

    private MySQLFactory(){
    }

    public static Factory getInstance(){
        if(instance == null){
            instance = new MySQLFactory();
        }
        return instance;
    }

    //creacion de los repositories
}
