<<<<<<< HEAD
package com.example.studentPortal.controller;

import com.example.studentPortal.model.Address;
import com.example.studentPortal.model.Student;
import com.example.studentPortal.service.StudentService;
import jakarta.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/studentPortal")
public class StudentController {
    @Autowired
    StudentService service;

    @PostMapping(value = "/student")
    public ResponseEntity saveUser(@RequestBody String studentData) {
        Student student = setStudent(studentData);
        int Id = service.saveStudent(student);
        return new ResponseEntity("user saved with id-" +Id, HttpStatus.CREATED);
    }
    @GetMapping(value = "/student")
    public ResponseEntity<String> getStudent(@Nullable @RequestParam String Id) {
        JSONArray studentDetails = service.getStudent(Id);
        return new ResponseEntity(studentDetails.toString(), HttpStatus.OK);
    }

    @PutMapping(value = "/student/{Id}")
    public ResponseEntity<String> updateStudent(@PathVariable String Id, @RequestBody String studentData) {
        Student student = setStudent(studentData);
        service.updateStudent(Id, student);
        return new ResponseEntity("user updated", HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete-student/{Id}")
    public ResponseEntity<String> deleteStudent(@PathVariable String Id) {
        service.deleteStudent(Id);
        return new ResponseEntity("student deleted", HttpStatus.OK);
    }

    private Student setStudent(String studentData) {
        JSONObject jsonObject = new JSONObject(studentData);
        Student student = new Student();
        student.setName(jsonObject.getString("name"));
        student.setAge(jsonObject.getString("age"));
        student.setPhoneNumber(jsonObject.getString("phoneNumber"));
        student.setBranch(jsonObject.getString("branch"));
        student.setDepartment((jsonObject.getString("department")));

        Address address = new Address();
        address.setLandmark(jsonObject.getString("landmark"));
        address.setZipcode(jsonObject.getString("zipcode"));
        address.setDistrict(jsonObject.getString("district"));
        address.setState(jsonObject.getString("state"));
        address.setCountry(jsonObject.getString("country"));

        student.setAddress(address);

        return student;
    }
}
=======
package com.example.studentPortal.controller;

import com.example.studentPortal.model.Address;
import com.example.studentPortal.model.Student;
import com.example.studentPortal.service.StudentService;
import jakarta.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/student-portal")
public class StudentController {
    @Autowired
    StudentService service;

    @PostMapping(value = "/student")
    public ResponseEntity saveUser(@RequestBody String studentData) {
        Student student = setStudent(studentData);
        String Id = service.saveStudent(student);
        return new ResponseEntity("user saved with id-" +Id, HttpStatus.CREATED);
    }
    @GetMapping(value = "/student")
    public ResponseEntity<String> getStudent(@Nullable @RequestParam String Id) {
        JSONArray studentDetails = service.getStudent(Id);
        return new ResponseEntity(studentDetails.toString(), HttpStatus.OK);
    }

    @PutMapping(value = "/student/{Id}")
    public ResponseEntity<String> updateStudent(@PathVariable String Id, @RequestBody String studentData) {
        Student student = setStudent(studentData);
        service.updateStudent(Id, student);
        return new ResponseEntity("user updated", HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete-student/{Id}")
    public ResponseEntity<String> deleteStudent(@PathVariable String Id) {
        service.deleteStudent(Id);
        return new ResponseEntity("student deleted", HttpStatus.OK);
    }

    private Student setStudent(String studentData) {
        JSONObject jsonObject = new JSONObject(studentData);
        Student student = new Student();
        student.setName(jsonObject.getString("name"));
        student.setAge(jsonObject.getString("age"));
        student.setPhoneNumber(jsonObject.getString("phoneNumber"));
        student.setBranch(jsonObject.getString("branch"));
        student.setDepartment((jsonObject.getString("department")));

        Address address = new Address();
        address.setLandmark(jsonObject.getString("landmark"));
        address.setZipcode(jsonObject.getString("zipcode"));
        address.setDistrict(jsonObject.getString("district"));
        address.setState(jsonObject.getString("state"));
        address.setCountry(jsonObject.getString("country"));

        student.setAddress(address);

        return student;
    }
}
>>>>>>> b8a4edad8d92aee6c0691373c4ff47bb81246d5f
