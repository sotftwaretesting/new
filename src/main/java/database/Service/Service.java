package database.Service;

import database.DTO.User;

import java.util.List;
import java.util.Map;

/**
 * Created by V on 16.11.2015.
 */
public interface Service {
    void insertUser(User user) throws Exception;

    void updateUser(int id,User user) throws Exception;

    void deleteUser(int userId) throws Exception;

    List<User> selectUsers(Map<String, String> filter) throws Exception;
}
