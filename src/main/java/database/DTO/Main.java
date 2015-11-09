package database.DTO;

import database.DAO.UserDAOImpl;
import database.EntityManager.UserEntityManager;

import javax.persistence.EntityManager;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by V on 07.11.2015.
 */
public class Main {

    public static void main(String[] args) {
        EntityManager entityManager = UserEntityManager.getUserEM();
       /* Query query = entityManager.createQuery("SELECT u from User u");
        List<User> s = query.getResultList();
        for (User user : s) {
            System.out.println(user);
        }*/


        UserDAOImpl userDAO = new UserDAOImpl();
        Map<String, String> map = new HashMap<String, String>();
//        map.put("","");
        for (User ss : userDAO.selectUsers(map)){
            System.out.println(ss);
        }
      /*  user.setAge(1030);
        user.setId(10);
        userDAO.updateUser(user);*/

/*
        entityManager = GetUserEM.getUserEM();
        System.out.println("");
        Query query1 = entityManager.createQuery("SELECT u from User u");
        List<User> s1 = query1.getResultList();
        for (User user1 : s1) {
            System.out.println(user1);
        }*/
    }
}
