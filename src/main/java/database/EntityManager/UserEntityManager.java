package database.EntityManager;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * Created by V on 07.11.2015.
 */

//todo change static methods, prepare for working on Tomcat
public class UserEntityManager {
    private static EntityManager entityManager;

    private UserEntityManager(){}

    public static void init(){
        entityManager = Persistence.createEntityManagerFactory("User").createEntityManager();
    }

    public static EntityManager getUserEM(){
      /*  if (entityManager == null){
            entityManager = Persistence.createEntityManagerFactory("User").createEntityManager();
        }*/
        return entityManager;
    }

    public static void close(){
        entityManager.close();
    }
}
