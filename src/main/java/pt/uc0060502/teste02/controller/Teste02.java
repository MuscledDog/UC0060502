package pt.uc0060502.teste02.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class Teste02 {
    @GetMapping("/hello")
    public String hello() {
        return "hello uc0060502";
    }

    @GetMapping("/teste02")
    public String teste(){
        return "Teste02";
    }
    
}
