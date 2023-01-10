package ru.maxima.springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculateController {
    @GetMapping("/calculate")
    public String numbers(@RequestParam(value="num1", required=false)double num1,
                          @RequestParam(value="num2", required=false)double num2,
                          @RequestParam(value="operation",required=false) String operation,
                          Model model){
        double result=0.0;
        switch(operation){
            case "div"-> result= (num2 == 0 ? 0 : num1/num2);
            case "sum"->result=num1+num2;
            case "ded"-> result=num1-num2;
            case "mult"-> result=num1*num2;
            default -> System.out.println("unknown operation");
        }
        model.addAttribute("result",result);
        return "calculate";
    }
}
