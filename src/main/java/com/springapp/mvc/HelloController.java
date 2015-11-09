package com.springapp.mvc;

import database.DAO.UserDAO;
import database.DAO.UserDAOImpl;
import database.DTO.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.List;

@Controller
public class HelloController {
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        UserDAO userDAO = new UserDAOImpl();
        List<User> list = userDAO.selectUsers(new HashMap<String, String>());
        model.addAttribute("userList", list);
        return "users";
    }

    @RequestMapping(value = "/users/{id}/delete", method = RequestMethod.GET)
    public String deleteUser(@PathVariable("id") int id) {
        UserDAO userDAO = new UserDAOImpl();
        userDAO.deleteUser(id);
        return "redirect:/users";

    }
}
