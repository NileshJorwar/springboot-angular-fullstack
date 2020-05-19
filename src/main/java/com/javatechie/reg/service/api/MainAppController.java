package com.javatechie.reg.service.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import com.javatechie.reg.service.api.dao.UserRepository;
import com.javatechie.reg.service.api.model.UserObject;

import java.util.List;

@SpringBootApplication
@RestController
@CrossOrigin(origins = "*")
public class MainAppController {

    @Autowired
    private UserRepository repository;

    @GetMapping("/login/{username}/{password}")
    public List<UserObject> login(@PathVariable String username, @PathVariable String password) {
//        List<User> list = repository.findByNameAndPassword( username,password);
        return repository.findByNameAndPassword( username,password);
//        System.out.println(list.get(0).getName() + "&" + list.get(0).getId());
//        return list.get(0).getName() + "&" + list.get(0).getId();
    }

    @PostMapping("/register")
    public String register(@RequestBody UserObject userObject) {
        repository.save(userObject);
        return "Hi " + userObject.getName() + " your Registration process successfully completed";
    }

    @GetMapping("/getAllUsers")
    public List<UserObject> findAllUsers() {
        return repository.findAll();
    }

    @GetMapping("/findUser/{email}")
    public List<UserObject> findUser(@PathVariable String email) {
        return repository.findByEmail(email);
    }

    @DeleteMapping("/cancel/{id}")
    public List<UserObject> cancelRegistration(@PathVariable int id) {
        repository.deleteById(id);
        return repository.findAll();
    }

    public static void main(String[] args) {
        SpringApplication.run(MainAppController.class, args);
    }

}


