<<<<<<< HEAD
package com.example.studentPortal.service;

import com.example.studentPortal.dao.LaptopRepository;
import com.example.studentPortal.model.Laptop;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaptopService {
    @Autowired
    LaptopRepository laptopRepository;

    public int saveLaptop(Laptop laptop) {
        Laptop laptop1 = laptopRepository.save(laptop);
        return laptop1.getId();
    }
    public JSONArray getLaptop(String Id) {
        JSONArray laptopArray = new JSONArray();
        if(null != Id && laptopRepository.findById(Integer.valueOf(Id)).isPresent()) {
            Laptop laptop = laptopRepository.findById(Integer.valueOf(Id)).get();
            JSONObject object = setLaptop(laptop);
            laptopArray.put(object);
        }
        else {
            List<Laptop> laptops = laptopRepository.findAll();
            for(Laptop laptop : laptops) {
                JSONObject object = setLaptop(laptop);
                laptopArray.put(object);
            }
        }
        return laptopArray;
    }

    private JSONObject setLaptop(Laptop laptop) {
        JSONObject object = new JSONObject();
        object.put("Id", laptop.getId());
        object.put("name", laptop.getName());
        object.put("brand", laptop.getBrand());
        object.put("price", laptop.getPrice());
        object.put("student", laptop.getStudent());

        return object;
    }

    public void updateLaptop(Laptop newLaptop, String Id) {
        if(laptopRepository.findById(Integer.valueOf(Id)).isPresent()) {
            laptopRepository.save(newLaptop);
        }
    }
    public void deleteLaptop(String Id) {
        if(laptopRepository.findById(Integer.valueOf(Id)).isPresent()) {
            Laptop laptop = laptopRepository.findById(Integer.valueOf(Id)).get();
            laptopRepository.delete(laptop);
        }
    }
}
=======
package com.example.studentPortal.service;

import com.example.studentPortal.dao.LaptopRepository;
import com.example.studentPortal.model.Laptop;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaptopService {
    @Autowired
    LaptopRepository laptopRepository;

    public String saveLaptop(Laptop laptop) {
        Laptop laptop1 = laptopRepository.save(laptop);
        return laptop1.getId();
    }
    public JSONArray getLaptop(String Id) {
        JSONArray laptopArray = new JSONArray();
        if(null != Id && laptopRepository.findById(Integer.valueOf(Id)).isPresent()) {
            Laptop laptop = laptopRepository.findById(Integer.valueOf(Id)).get();
            JSONObject object = setLaptop(laptop);
            laptopArray.put(object);
        }
        else {
            List<Laptop> laptops = laptopRepository.findAll();
            for(Laptop laptop : laptops) {
                JSONObject object = setLaptop(laptop);
                laptopArray.put(object);
            }
        }
        return laptopArray;
    }

    private JSONObject setLaptop(Laptop laptop) {
        JSONObject object = new JSONObject();
        object.put("Id", laptop.getId());
        object.put("name", laptop.getName());
        object.put("brand", laptop.getBrand());
        object.put("price", laptop.getPrice());
        object.put("student", laptop.getStudent());

        return object;
    }

    public void updateLaptop(Laptop newLaptop, String Id) {
        if(laptopRepository.findById(Integer.valueOf(Id)).isPresent()) {
            laptopRepository.save(newLaptop);
        }
    }
    public void deleteLaptop(String Id) {
        if(laptopRepository.findById(Integer.valueOf(Id)).isPresent()) {
            Laptop laptop = laptopRepository.findById(Integer.valueOf(Id)).get();
            laptopRepository.delete(laptop);
        }
    }
}
>>>>>>> b8a4edad8d92aee6c0691373c4ff47bb81246d5f
