package com.codeline.SpringBootOne.Controller;

import com.codeline.SpringBootOne.Entities.Course;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "*")
@RestController
public class CourseController {

    private List<Course> coursesList = new ArrayList<>();
    private int counterId = 1;

    @PostMapping("create")
    public String create(@RequestBody Course requestObj) {
        requestObj.setId(counterId);
        requestObj.setCreateDate(new Date());
        requestObj.setIsActive(true);
        coursesList.add(requestObj);
        return "Course created with ID: " + counterId++;

    }

    @GetMapping("getAll")
    public List<Course> getAllCourses() {
        List<Course> responseList = new ArrayList<>();
        for (Course c : coursesList) {
            if (c.getIsActive()) {
                responseList.add(c);
            }
        }
        return responseList;
    }

    @GetMapping("getById")
    public Course getCoursesByID(@RequestParam int id) {
        for (Course c : coursesList) {
            if (c.getId() == id && c.getIsActive()) {
                return c;
            }
        }
        return Course.builder().build();
    }

    @PutMapping("update")
    public String updateCourses(@RequestBody Course updateObjFromUser) {
        if (updateObjFromUser != null && updateObjFromUser.getId() != null) {
            Course existCourseToUpdate = findCourseById(updateObjFromUser.getId());
            coursesList.remove(existCourseToUpdate);
            existCourseToUpdate.setCourseName(updateObjFromUser.getCourseName());
            existCourseToUpdate.setCategory(updateObjFromUser.getCategory());
            existCourseToUpdate.setDurationHour(updateObjFromUser.getDurationHour());
            existCourseToUpdate.setUpdateDate(updateObjFromUser.getUpdateDate());

            coursesList.add(existCourseToUpdate);
            return "Course update Successfully";
        }
        return "Course not found";
    }


    @DeleteMapping("delete/{id}")
    public String deleteCoursesByID(@PathVariable Integer id) {
        Course existCourseToDelete = findCourseById(id);
        if (existCourseToDelete.getId() > 0) {
            coursesList.remove(existCourseToDelete);
            existCourseToDelete.setIsActive(false);
            existCourseToDelete.setUpdateDate(new Date());
            coursesList.add(existCourseToDelete);
            return "Course delete successfully";
        } else {

            return "Course not found";
        }
    }

    public Course findCourseById(int id) {
        for (Course c : coursesList) {
            if (c.getId() == id && c.getIsActive()) {
                return c;
            }
        }
        return Course.builder().id(-1).build();
    }


}
