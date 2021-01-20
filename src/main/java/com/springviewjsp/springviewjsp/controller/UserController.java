package com.springviewjsp.springviewjsp.controller;

import com.springviewjsp.springviewjsp.model.UserModel;
import com.springviewjsp.springviewjsp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String userList(Model model) {
        List<UserModel> listUsers = userService.listUsers();
        model.addAttribute("listUsers", listUsers);

        return "index";
    }

    @RequestMapping("/create")
    public String addUser(Model model) {
        UserModel user = new UserModel();
        model.addAttribute("user", user);

        return "newUser";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("user") UserModel user) {
        userService.createUser(user);

        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public String editUser(Model model, @PathVariable(name = "id") Long id) {
        UserModel user = userService.userById(id);
        model.addAttribute("user", user);

        return "editUser";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String updateUser(@PathVariable(name = "id") Long id, @ModelAttribute("user") UserModel user) {
        userService.updateUser(user, id);

        return "redirect:/";
    }

    @RequestMapping(value="/delete/{id}",method = RequestMethod.GET)
    public String delete(@PathVariable int id){
        userService.delete(id);
        return "redirect:/";
    }
}
