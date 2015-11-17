package database.EntityManager;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * Created by V on 07.11.2015.
 */

public class UserEntityManager {
    private static EntityManager entityManager;

    private UserEntityManager(){}

    public static void init(){
        entityManager = Persistence.createEntityManagerFactory("User").createEntityManager();
    }

    public static EntityManager getUserEM(){
           return entityManager;
    }

    public static void close(){
        entityManager.close();
    }
}
