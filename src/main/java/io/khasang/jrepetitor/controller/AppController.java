package io.khasang.jrepetitor.controller;


import io.khasang.jrepetitor.model.CreateTable;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.SimpleDateFormat;
import java.util.Date;


@Controller
public class AppController {
    @Autowired
    private CreateTable createTable;


    @RequestMapping("/")
    public String sayHello(Model model) {
        Date serverDate = new Date();
        serverDate.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String stringDate = sdf.format(serverDate.getTime());
        model.addAttribute("date", stringDate);
        return "hello";
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

    @RequestMapping("/user/")
    public String getUserPage() {
        return "user";
    }

    @RequestMapping("/superadmin")
    public String getSuperAdminPage() {
        return "superadmin";
    }
}
