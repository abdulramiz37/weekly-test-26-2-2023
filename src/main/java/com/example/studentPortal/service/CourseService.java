<<<<<<< HEAD
package com.example.studentPortal.service;

import com.example.studentPortal.dao.CourseRepository;
import com.example.studentPortal.model.Course;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.attribute.standard.JobSheets;
import java.util.List;

@Service
public class CourseService {
    @Autowired
    CourseRepository courseRepository;

    public int saveCourse(Course course) {
        Course course1 = courseRepository.save(course);
        return course1.getId();
    }

    public JSONArray getCourse(String Id) {
        JSONArray courses = new JSONArray();
        if(null!= Id && courseRepository.findById(Integer.valueOf(Id)).isPresent()) {
            Course course = courseRepository.findById(Integer.valueOf(Id)).get();
            JSONObject object = setCourse(course);
            courses.put(object);
        }
        else {
            List<Course> courseList = courseRepository.findAll();
            for(Course course : courseList) {
                JSONObject object = setCourse(course);
                courses.put(object);
            }
        }
        return courses;
    }

    private JSONObject setCourse(Course course) {
        JSONObject object = new JSONObject();
        object.put("title", course.getTitle());
        object.put("description", course.getDescription());
        object.put("duration", course.getDuration());

        return object;
    }
    public void updateCourse(Course newCourse, String Id) {
        if(courseRepository.findById(Integer.valueOf(Id)).isPresent()) {
            courseRepository.save(newCourse);
        }
    }
    public void deleteCourse(String Id) {
        if(courseRepository.findById(Integer.valueOf(Id)).isPresent()) {
            Course course = courseRepository.findById(Integer.valueOf(Id)).get();
            courseRepository.delete(course);
        }
    }
}
=======
package com.example.studentPortal.service;

import com.example.studentPortal.dao.CourseRepository;
import com.example.studentPortal.model.Course;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.attribute.standard.JobSheets;
import java.util.List;

@Service
public class CourseService {
    @Autowired
    CourseRepository courseRepository;

    public String saveCourse(Course course) {
        Course course1 = courseRepository.save(course);
        return course1.getId();
    }

    public JSONArray getCourse(String Id) {
        JSONArray courses = new JSONArray();
        if(null!= Id && courseRepository.findById(Integer.valueOf(Id)).isPresent()) {
            Course course = courseRepository.findById(Integer.valueOf(Id)).get();
            JSONObject object = setCourse(course);
            courses.put(object);
        }
        else {
            List<Course> courseList = courseRepository.findAll();
            for(Course course : courseList) {
                JSONObject object = setCourse(course);
                courses.put(object);
            }
        }
        return courses;
    }

    private JSONObject setCourse(Course course) {
        JSONObject object = new JSONObject();
        object.put("Id", course.getId());
        object.put("title", course.getTitle());
        object.put("description", course.getDescription());
        object.put("duration", course.getDuration());

        return object;
    }
    public void updateCourse(Course newCourse, String Id) {
        if(courseRepository.findById(Integer.valueOf(Id)).isPresent()) {
            courseRepository.save(newCourse);
        }
    }
    public void deleteCourse(String Id) {
        if(courseRepository.findById(Integer.valueOf(Id)).isPresent()) {
            Course course = courseRepository.findById(Integer.valueOf(Id)).get();
            courseRepository.delete(course);
        }
    }
}
>>>>>>> b8a4edad8d92aee6c0691373c4ff47bb81246d5f
