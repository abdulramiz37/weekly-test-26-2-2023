<<<<<<< HEAD
package com.example.studentPortal.controller;

import com.example.studentPortal.model.Laptop;
import com.example.studentPortal.model.Student;
import com.example.studentPortal.service.LaptopService;
import jakarta.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/studentPortal")
public class LaptopController {
    @Autowired
    LaptopService laptopService;

    @PostMapping("/laptop")
    public ResponseEntity saveLaptop(@RequestBody String laptopData) {
        Laptop laptop = setLaptop(laptopData);
        int Id = laptopService.saveLaptop(laptop);
        return new ResponseEntity("laptop saved with id-" +Id, HttpStatus.CREATED);
    }
    @GetMapping(value = "/laptop")
    public ResponseEntity<String> getLaptop(@Nullable @RequestParam String Id) {
        JSONArray laptopDetails = laptopService.getLaptop(Id);
        return new ResponseEntity(laptopDetails.toString(), HttpStatus.OK);
    }
    @PutMapping(value = "/update-laptop/{Id}")
    public ResponseEntity<String> updateLaptop(@RequestBody String newLaptop, @PathVariable String Id) {
        Laptop laptop = setLaptop(newLaptop);
        laptopService.updateLaptop(laptop, Id);
        return new ResponseEntity("laptop updated", HttpStatus.OK);
    }
    @DeleteMapping(value = "/delete-laptop/{Id}")
    public ResponseEntity<String> deleteLaptop(@PathVariable String Id) {
        laptopService.deleteLaptop(Id);
        return new ResponseEntity("laptop deleted", HttpStatus.OK);
    }

    private Laptop setLaptop(String  laptopData) {
        JSONObject object = new JSONObject(laptopData);
        Laptop laptop = new Laptop();
        laptop.setName(object.getString("name"));
        laptop.setBrand(object.getString("brand"));
        laptop.setPrice(object.getString("price"));

        return laptop;
    }
}
=======
package com.example.studentPortal.controller;

import com.example.studentPortal.model.Laptop;
import com.example.studentPortal.service.LaptopService;
import jakarta.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/student")
public class LaptopController {
    @Autowired
    LaptopService laptopService;

    @PostMapping("/laptop")
    public ResponseEntity saveLaptop(@RequestBody String laptopData) {
        Laptop laptop = setLaptop(laptopData);
        String Id = laptopService.saveLaptop(laptop);
        return new ResponseEntity("laptop saved with id-" +Id, HttpStatus.CREATED);
    }
    @GetMapping(value = "/laptop")
    public ResponseEntity<String> getLaptop(@Nullable @RequestParam String Id) {
        JSONArray laptopDetails = laptopService.getLaptop(Id);
        return new ResponseEntity(laptopDetails.toString(), HttpStatus.OK);
    }
    @PutMapping(value = "/update-laptop/{Id}")
    public ResponseEntity<String> updateLaptop(@RequestBody String newLaptop, @PathVariable String Id) {
        Laptop laptop = setLaptop(newLaptop);
        laptopService.updateLaptop(laptop, Id);
        return new ResponseEntity("laptop updated", HttpStatus.OK);
    }
    @DeleteMapping(value = "/delete-laptop/{Id}")
    public ResponseEntity<String> deleteLaptop(@PathVariable String Id) {
        laptopService.deleteLaptop(Id);
        return new ResponseEntity("laptop deleted", HttpStatus.OK);
    }

    private Laptop setLaptop(String  laptopData) {
        JSONObject object = new JSONObject(laptopData);
        Laptop laptop = new Laptop();
        laptop.setId(object.getString("Id"));
        laptop.setName(object.getString("name"));
        laptop.setBrand(object.getString("brand"));
        laptop.setPrice(object.getString("price"));

        return laptop;
    }
}
>>>>>>> b8a4edad8d92aee6c0691373c4ff47bb81246d5f
