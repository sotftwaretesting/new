package database.Service;

import database.DAO.UserDAO;
import database.DTO.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * Created by V on 16.11.2015.
 */
public class ServiceImpl implements Service {

    @Autowired
    private UserDAO userDAO;

    @Override
    public void insertUser(User user) throws Exception{
        userDAO.insertUser(user);
    }

    @Override
    public void updateUser(int id, User user) throws Exception {
        userDAO.updateUser(id, user);
    }

    @Override
    public void deleteUser(int userId) throws Exception {
        userDAO.deleteUser(userId);
    }

    @Override
    public List<User> selectUsers(Map<String, String> filter) throws Exception {
        return userDAO.selectUsers(filter);
    }
}
