package com.codeline.SpringBootOne;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String helloWithoutName(@RequestParam String name){
        if(name.isEmpty()){
            return "Hello Guest";
        }
        return "Helle " + name;
    }

    @GetMapping("/sum")
    public int hello(@RequestParam  int a , int b){
        return a+b ;
    }

    @GetMapping("/info")
    public Map<String, String> jSONObject(){
        Map<String,String> newMap= new HashMap<>();
        newMap.put("Name","Kaltham");
        newMap.put("city", "Muscat");
        newMap.put("Language","Arabic");

        return newMap;
    }

    @GetMapping("/greet")
    public String hello(@RequestParam String name){
        return "Welcome "+ name;
    }

    @GetMapping("/upper")
    public String textToUpper(@RequestParam String text){
        return text.toUpperCase();
    }

    @GetMapping("/random")
    public Integer randomNumber(){
        return new Random().nextInt(100)+1;
    }


}
