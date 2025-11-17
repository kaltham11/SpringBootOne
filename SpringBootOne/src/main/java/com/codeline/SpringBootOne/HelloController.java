package com.codeline.SpringBootOne;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RestController
public class HelloController {

    private Map<Integer,String> courses=new HashMap<>();
    private int counterId=1;

    @PostMapping("create")
    public String create (@RequestParam String name) {
        courses.put(counterId,name);
        return "Courses create with ID =" + counterId++;
    }

    @GetMapping("getAll")
    public Map<Integer, String> getAllCourses(){
        return courses;
    }

    @GetMapping("getById")
    public String getCoursesByID(@RequestParam int id){
        return courses.getOrDefault(id, "Course not found");
    }

    @GetMapping("getByName")
    public String getCoursesByName(@RequestParam String name){
        for(Map.Entry<Integer,String> entry:courses.entrySet()){
            if(entry.getValue().equalsIgnoreCase(name)){
                return "ID: "+entry.getKey()+ ", value: "+entry.getValue();
            }
        }
        return  "Course not found";
    }

    @PutMapping ("update")
    public String updateCoursesByID(@RequestParam Integer id, String name){
        if(courses.containsKey(id)){
            courses.put(id, name);
            return  "Course update successfully";
        }
        return "Course not found";
    }

    @DeleteMapping ("delete/{id}")
    public String deleteCoursesByID(@PathVariable Integer id){
        if(courses.remove(id)!=null){
            return  "Course delete successfully";
        }
        return "Course not found";
    }




}
