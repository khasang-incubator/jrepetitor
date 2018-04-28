package io.khasang.jrepetitor.controller;

import io.khasang.jrepetitor.model.CreateTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AppController {
    @Autowired
    private CreateTable createTable;

    // Фабричный метод бинов.
    // Cat cat = new Cat();

    @RequestMapping("/")
    public String helloPage() {
        return "cat";
    }

    @RequestMapping("/profile")
    public String profile() {
        return "profile";
    }

    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    @RequestMapping("/create")
    public String createTableStatus(Model model) {
        model.addAttribute("status", createTable.createTableStatus());
        return "create";
    }

    @RequestMapping(value = "/password/{password}", method = RequestMethod.GET)
    public String getPasswordHelp(@PathVariable("password") String password, Model model) {
        model.addAttribute("password", new BCryptPasswordEncoder().encode(password));
        return "pwd";
    }

    @RequestMapping("/user")
    public String getUserPage() {
        return "user";
    }

}
