package com.example.demo.controllers;

import com.example.demo.models.Korisnik;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController {

    private String username = new String();
    private String pass = new String();
    private Map<String, String> korisnikMap = new HashMap<>();


    @RequestMapping(value = "/login")
    public String read(@ModelAttribute(name= "user") Korisnik user, Model model)
    {
        korisnikMap.put("Tome", "123");
        korisnikMap.put("Boky", "123");
        korisnikMap.put("Kika", "123");

        username = user.getUsername();
        pass = user.getPassword();
        if(user.getUsername() != null && user.getPassword() != null)
        {
            System.out.println(username + " " + pass);
            if(korisnikMap.get(username) != null)
            {
                if(korisnikMap.get(username).equals(pass))
                    return "home";
                else
                    return "login";
            }
            else
                return "login";
        }
        return "login";
    }
    @RequestMapping("/home")
    public void displayName()
    {
    }
    @RequestMapping(value = "/register")
    public String RegisterScreen(@ModelAttribute(name = "newUser") Korisnik newUser, Model model)
    {
        username = newUser.getUsername();
        pass = newUser.getPassword();
        System.out.println("new User: " + username + " " + pass);
        if(username != "" && pass != "" && username != null && pass != null)
        {
            korisnikMap.put(username, pass);
            newUser.setUsername(username);
            newUser.setPassword(pass);
            return "index";
        }
        System.out.println("test");
        return "register";
    }

}
