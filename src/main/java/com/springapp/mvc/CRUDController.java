package com.springapp.mvc;

import database.DTO.User;
import database.Service.Service;
import jdk.nashorn.internal.runtime.ECMAException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.List;

@Controller
public class CRUDController {

    @Autowired
    private Service service;

    @RequestMapping(value = "/")
    public String redirect(){
        return "redirect:/users";
    }


    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String getUserList(ModelMap model) {
        try {
            List<User> list = service.selectUsers(new HashMap<String, String>());
            model.addAttribute("userList", list);
        } catch (Exception e){
            model.addAttribute("exception", e.getMessage());
        }
        return "users";
    }

    @RequestMapping(value = "/users/remove/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable("id") int id) {
        try {
            service.deleteUser(id);
        }catch (Exception e){
            //todo add to page error message after redirect
        }
        return "redirect:/users";
    }

    @RequestMapping(value = "/users/edit/{id}", method = RequestMethod.GET)
    public String editPage(@PathVariable("id") String id, ModelMap model) {
        try {
            HashMap<String, String> hashMap = new HashMap<String, String>();
            hashMap.put("id", id);
            List<User> user = service.selectUsers(hashMap);
            model.addAttribute("userDB", user.get(0));
        }catch (Exception e){
            //todo add to page error message after redirect
        }
        return "editUser";
    }


    @RequestMapping(value = "/edit.form/{id}", method = RequestMethod.POST)
    public String editUser(@PathVariable("id") int id,@ModelAttribute User user) {
       try {
           service.updateUser(id, user);
       } catch (Exception e){
           //todo add to page error message after redirect
       }
        return "redirect:/users";
    }



    @RequestMapping(value = "/users/create", method = RequestMethod.GET)
    public String createPage() {
        return "createUser";
    }


    @RequestMapping(value = "/create.form", method = RequestMethod.POST)
    public String createUser(@ModelAttribute User user){
       try {
           service.insertUser(user);
       }
       catch (Exception e){
           //todo add to page error message after redirect
       }
        return "redirect:/users";
    }
}
