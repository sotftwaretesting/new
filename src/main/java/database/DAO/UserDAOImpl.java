package database.DAO;

import database.DTO.User;
import database.EntityManager.UserEntityManager;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import utils.CommonUtils;

import javax.persistence.EntityManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by V on 07.11.2015.
 */

public class UserDAOImpl implements UserDAO {

//    @PersistenceContext(unitName = "User", type = PersistenceContextType.TRANSACTION)
//    private EntityManager entityManager;



    private static final Logger logger = LogManager.getLogger(UserDAOImpl.class);

    @Override
    public Map<Boolean, String> deleteUser(int userId) {
        HashMap<Boolean, String> result = new HashMap<Boolean, String>();
        try {
            EntityManager entityManager = UserEntityManager.getUserEM();
            User user = entityManager.find(User.class, userId);
            entityManager.getTransaction().begin();
            entityManager.remove(user);
            entityManager.getTransaction().commit();
            logger.log(Level.INFO, "User was deleted: " + user);
            result.put(true, "");
            return result;
        } catch (Exception e) {
            result.put(false, e.getMessage());
            logger.log(Level.INFO, String.format("User with id %s wasn't deleted", userId));
            logger.log(Level.INFO, CommonUtils.getStackTrace(e));
            return result;
        }
    }

    @Override
    public Map<Boolean, String> insertUser(User user) {
        HashMap<Boolean, String> result = new HashMap<Boolean, String>();
        try {
            EntityManager entityManager = UserEntityManager.getUserEM();
            entityManager.getTransaction().begin();
            entityManager.persist(user);
            entityManager.getTransaction().commit();
            logger.log(Level.INFO, "User was inserted: " + user);
            result.put(true, "");
            return result;
        } catch (Exception e) {
            result.put(false, e.getMessage());
            logger.log(Level.INFO, String.format("User wasn't inserted: " + user));
            logger.log(Level.INFO, CommonUtils.getStackTrace(e));
            return result;
        }
    }

    @Override
    public Map<Boolean, String> updateUser(User user) {
        HashMap<Boolean, String> result = new HashMap<Boolean, String>();
        try {
            EntityManager entityManager = UserEntityManager.getUserEM();
            if (entityManager.find(User.class, user.getId()) == null) {
                throw new IllegalArgumentException("Unknown User id");
            }
            entityManager.getTransaction().begin();
            entityManager.merge(user);
            entityManager.getTransaction().commit();
            logger.log(Level.INFO, "User was updated, id: " + user);
            result.put(true, "");
            return result;
        } catch (Exception e) {
            result.put(false, e.getMessage());
            logger.log(Level.INFO, String.format("User wasn't updated: " + user));
            logger.log(Level.INFO, CommonUtils.getStackTrace(e));
            return result;
        }
    }

    @Override
    public List<User> selectUsers(Map<String, String> filter) {
        EntityManager entityManager = UserEntityManager.getUserEM();
        StringBuilder stringBuilder = new StringBuilder("SELECT u from User u");
        for (Map.Entry<String, String> entry : filter.entrySet()) {
            stringBuilder.append(String.format("where u.%s = %s", entry.getKey(), entry.getValue()));
        }
        return entityManager.createQuery(stringBuilder.toString(), User.class).getResultList();
    }

    //todo check for null in all methods
}
