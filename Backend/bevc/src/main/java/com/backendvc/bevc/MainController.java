package com.backendvc.bevc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*@CrossOrigin(origins = {"http://127.0.0.1:5500", "http://localhost:5500"})*/
@RestController
@RequestMapping("/api/users")
public class MainController {

@Autowired
private UserService userService;

@Autowired
public MainController(UserService userService){
    this.userService = userService;
}

 @GetMapping
      public List<UserInfo> getUsers(){
        return userService.getUsers();
      }

       @CrossOrigin(origins = "http://127.0.0.1:5500") // Allow CORS for this endpoint
       @PostMapping( "/register")
      public ResponseEntity<String> registerNewUser(@RequestBody UserInfo user){
        System.out.println("*****POST MAPPING ACCESSED******");
        userService.registerNewUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("User Registered Successfully");
      }

      
}