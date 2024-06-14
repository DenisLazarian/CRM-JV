package com.app.crm_news_java.presentation.controllers;


import com.app.crm_news_java.presentation.dto.UserDTO;
import com.app.crm_news_java.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RequestMapping("/users")
@Controller
public class UserController {

    @Autowired
    private IUserService userService;

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        return ResponseEntity.ok(this.userService.delete(id));
    }

    @GetMapping("/list")
    public ResponseEntity<List<UserDTO>> listUsers(){
        return ResponseEntity.ok(this.userService.findAll());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO, @PathVariable Long id){
        userDTO.setLastModifiedDate(new Date());
        return ResponseEntity.ok().body(this.userService.update(userDTO, id));
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<UserDTO> getById(@PathVariable Long id){
        return ResponseEntity.ok().body(this.userService.findById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<UserDTO> create(@RequestBody UserDTO userDTO){
        userDTO.setLastModifiedDate(new Date());
        return ResponseEntity.ok(this.userService.create(userDTO));
    }
}
