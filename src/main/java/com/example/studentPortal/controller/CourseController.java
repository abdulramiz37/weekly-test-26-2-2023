<<<<<<< HEAD
package com.example.studentPortal.controller;

import com.example.studentPortal.model.Course;
import com.example.studentPortal.service.CourseService;
import jakarta.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/studentPortal")
public class CourseController {
    @Autowired
    CourseService courseService;

    @PostMapping(value = "/course")
    public ResponseEntity saveCourse(@RequestBody String courseData) {
        Course course = setCourse(courseData);
        int Id = courseService.saveCourse(course);
        return new ResponseEntity("course saved with id-" + Id, HttpStatus.CREATED);
    }

    @GetMapping(value = "/course")
    public ResponseEntity<String> getCourse(@Nullable @PathVariable String Id) {
        JSONArray courseDetails = courseService.getCourse(Id);
        return new ResponseEntity(courseDetails.toString(), HttpStatus.OK);
    }

    @PutMapping(value = "/update-course/{Id}")
    public ResponseEntity<String> updateCourse(@RequestBody String courseData, @PathVariable String Id) {
        Course course = setCourse(courseData);
        courseService.updateCourse(course, Id);
        return new ResponseEntity("course updated", HttpStatus.OK);
    }
    @DeleteMapping(value = "/delete-course/{Id}")
    public ResponseEntity<String> deleteCourse(@PathVariable String Id) {
        courseService.deleteCourse(Id);
        return new ResponseEntity("course deleted", HttpStatus.OK);
    }

    private Course setCourse(String courseData) {
        JSONObject object = new JSONObject(courseData);
        Course course = new Course();
        course.setTitle(object.getString("title"));
        course.setDescription(object.getString("description"));
        course.setDuration(object.getString("duration"));

        return course;
    }
}
=======
package com.example.studentPortal.controller;

import com.example.studentPortal.model.Course;
import com.example.studentPortal.service.CourseService;
import jakarta.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/student")
public class CourseController {
    @Autowired
    CourseService courseService;

    @PostMapping(value = "/course")
    public ResponseEntity saveCourse(@RequestBody String courseData) {
        Course course = setCourse(courseData);
        String Id = courseService.saveCourse(course);
        return new ResponseEntity("course saved with id-" + Id, HttpStatus.CREATED);
    }

    @GetMapping(value = "/course")
    public ResponseEntity<String> getCourse(@Nullable @PathVariable String Id) {
        JSONArray courseDetails = courseService.getCourse(Id);
        return new ResponseEntity(courseDetails.toString(), HttpStatus.OK);
    }

    @PutMapping(value = "/update-course/{Id}")
    public ResponseEntity<String> updateCourse(@RequestBody String courseData, @PathVariable String Id) {
        Course course = setCourse(courseData);
        courseService.updateCourse(course, Id);
        return new ResponseEntity("course updated", HttpStatus.OK);
    }
    @DeleteMapping(value = "/delete-course/{Id}")
    public ResponseEntity<String> deleteCourse(@PathVariable String Id) {
        courseService.deleteCourse(Id);
        return new ResponseEntity("course deleted", HttpStatus.OK);
    }

    private Course setCourse(String courseData) {
        JSONObject object = new JSONObject(courseData);
        Course course = new Course();
        course.setId(object.getString("Id"));
        course.setTitle(object.getString("title"));
        course.setDescription(object.getString("description"));
        course.setDuration(object.getString("duration"));

        return course;
    }
}
>>>>>>> b8a4edad8d92aee6c0691373c4ff47bb81246d5f
