package ru.maxima.springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {
    @GetMapping("/hello")
    public String helloPage(){

        return "first/hello";
    }
    @GetMapping("/goodbye")
    public String goodbyePage(){
        return "first/goodbye";
    }

    @GetMapping ("/b")
    public String b(@RequestParam(value="name", required=false)String name,
                    @RequestParam(value="surname", required=false)String surname,
    Model model) {
        model.addAttribute("message","Hello, "+name+ " "+surname);
        System.out.println(name+" "+surname);

        return "first/b";
    }
    @GetMapping ("/a")
    public String a(HttpServletRequest request){
        String name=request.getParameter("name");
        String surname=request.getParameter("surname");
        System.out.println(name+" "+surname);
        return "";

    }
}
