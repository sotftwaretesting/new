package database.DAO;

import database.DTO.User;

import java.util.List;
import java.util.Map;

/**
 * Created by V on 07.11.2015.
 */
public interface UserDAO {

    Map<Boolean, String> insertUser(User user);

    Map<Boolean, String> updateUser(User user);

    Map<Boolean, String> deleteUser(int userId);

    List<User> selectUsers(Map<String, String> filter);

}
