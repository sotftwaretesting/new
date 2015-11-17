package database.DAO;

import database.DTO.User;
import database.EntityManager.UserEntityManager;
import utils.CommonUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by V on 07.11.2015.
 */

public class UserDAOImpl implements UserDAO {


    @Override
    public void deleteUser(int userId) throws Exception{
        EntityManager entityManager = UserEntityManager.getUserEM();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            User user = entityManager.find(User.class, userId);
            transaction.begin();
            entityManager.remove(user);
            transaction.commit();
            System.out.println("User was deleted: " + user);
        } catch (Exception e) {
            closeTransaction(transaction);
            System.out.println(String.format("User with id %s wasn't deleted", userId));
            System.out.println(CommonUtils.getStackTrace(e));
            throw e;
        }
    }

    @Override
    public void insertUser(User user) throws Exception{
        EntityManager entityManager = UserEntityManager.getUserEM();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            user.setCreated(new Date());
            entityManager.getTransaction().begin();
            entityManager.persist(user);
            entityManager.getTransaction().commit();
            System.out.println("User was inserted: " + user);
        } catch (Exception e) {
            closeTransaction(transaction);
            System.out.println(String.format("User wasn't inserted: " + user));
            System.out.println(CommonUtils.getStackTrace(e));
            throw e;
        }
    }

    @Override
    public void updateUser(int id, User user) throws Exception{
        EntityManager entityManager = UserEntityManager.getUserEM();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            User userInDB = entityManager.find(User.class, id);
            entityManager.getTransaction().begin();
            userInDB.setAge(user.getAge());
            userInDB.setName(user.getName());
            userInDB.setIsAdmin(user.getIsAdmin());
            entityManager.persist(userInDB);
            entityManager.getTransaction().commit();
            System.out.println("User was updated, id: " + user);
        } catch (Exception e) {
            closeTransaction(transaction);
            System.out.println(String.format("User wasn't updated: " + user));
            System.out.println(CommonUtils.getStackTrace(e));
            throw e;
        }
    }

    @Override
    public List<User> selectUsers(Map<String, String> filter) throws Exception{
        EntityManager entityManager = UserEntityManager.getUserEM();
        StringBuilder stringBuilder = new StringBuilder("SELECT u from User u ");
        for (Map.Entry<String, String> entry : filter.entrySet()) {
            stringBuilder.append(String.format("where u.%s = %s", entry.getKey(), entry.getValue()));
        }
        return entityManager.createQuery(stringBuilder.toString(), User.class).getResultList();
    }


    private void closeTransaction(EntityTransaction transaction) {
        try {
            if (transaction.isActive())
                transaction.rollback();
        }catch (Exception e){
            System.out.println("Exception in closing transaction");
            System.out.println(CommonUtils.getStackTrace(e));
        }
    }
}
