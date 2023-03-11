<<<<<<< HEAD
package com.example.studentPortal.service;

import com.example.studentPortal.dao.StudentRepository;
import com.example.studentPortal.model.Address;
import com.example.studentPortal.model.Student;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository repository;
    public int saveStudent(Student student) {
        Student student1 = repository.save(student);
        return student1.getId();
    }
    public JSONArray getStudent(String Id) {
        JSONArray studentArray = new JSONArray();
        if(null != Id && repository.findById(Integer.valueOf(Id)).isPresent()) {
            Student student =repository.findById(Integer.valueOf(Id)).get();
            JSONObject object = setStudent(student);
            studentArray.put(object);
        }
        else {
            List<Student> students = repository.findAll();
            for(Student student : students) {
                JSONObject object = setStudent(student);
                studentArray.put(object);
            }
        }
        return studentArray;
    }
    private JSONObject setStudent(Student student) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", student.getId());
        jsonObject.put("name", student.getName());
        jsonObject.put("age", student.getAge());
        jsonObject.put("phoneNumber", student.getPhoneNumber());
        jsonObject.put("branch", student.getBranch());
        jsonObject.put("department", student.getDepartment());
        jsonObject.put("address", student.getAddress());

        return jsonObject;
    }

    public void updateStudent(String Id, Student newStudent) {
        if(repository.findById(Integer.valueOf(Id)).isPresent()) {
            Student student = repository.findById(Integer.valueOf(Id)).get();
            repository.save(newStudent);
        }
    }

    public void deleteStudent(String Id) {
        if(repository.findById(Integer.valueOf(Id)).isPresent()) {
            Student student = repository.findById(Integer.valueOf(Id)).get();
            repository.delete(student);
        }
    }
}
=======
package com.example.studentPortal.service;

import com.example.studentPortal.dao.StudentRepository;
import com.example.studentPortal.model.Address;
import com.example.studentPortal.model.Student;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository repository;
    public String saveStudent(Student student) {
        Student student1 = repository.save(student);
        return student1.getId();
    }
    public JSONArray getStudent(String Id) {
        JSONArray studentArray = new JSONArray();
        if(null != Id && repository.findById(Integer.valueOf(Id)).isPresent()) {
            Student student =repository.findById(Integer.valueOf(Id)).get();
            JSONObject object = setStudent(student);
            studentArray.put(object);
        }
        else {
            List<Student> students = repository.findAll();
            for(Student student : students) {
                JSONObject object = setStudent(student);
                studentArray.put(object);
            }
        }
        return studentArray;
    }
    private JSONObject setStudent(Student student) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", student.getId());
        jsonObject.put("name", student.getName());
        jsonObject.put("age", student.getAge());
        jsonObject.put("phoneNumber", student.getPhoneNumber());
        jsonObject.put("branch", student.getBranch());
        jsonObject.put("department", student.getDepartment());
        jsonObject.put("address", student.getAddress());

        return jsonObject;
    }

    public void updateStudent(String Id, Student newStudent) {
        if(repository.findById(Integer.valueOf(Id)).isPresent()) {
            Student student = repository.findById(Integer.valueOf(Id)).get();
            repository.save(newStudent);
        }
    }

    public void deleteStudent(String Id) {
        if(repository.findById(Integer.valueOf(Id)).isPresent()) {
            Student student = repository.findById(Integer.valueOf(Id)).get();
            repository.delete(student);
        }
    }
}
>>>>>>> b8a4edad8d92aee6c0691373c4ff47bb81246d5f
