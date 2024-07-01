package com.app.crm_news_java.presentation.controllers;

import com.app.crm_news_java.presentation.dto.NewDTO;
import com.app.crm_news_java.services.interfaces.INewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RequestMapping("/news")
@Controller
public class NewController {

    @Autowired
    private INewService newService;

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteNew(@PathVariable Long id){
        return ResponseEntity.ok(this.newService.delete(id));
    }

    @GetMapping
    public ResponseEntity<List<NewDTO>> listNews(){
        return ResponseEntity.ok(this.newService.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<NewDTO> updateNew(@RequestBody NewDTO newDTO, @PathVariable Long id){
        return ResponseEntity.ok().body(this.newService.update(newDTO, id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<NewDTO> getById(@PathVariable Long id){
        NewDTO n = this.newService.findById(id);

        if(n.getId() == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(n);
    }

    @PostMapping
    public ResponseEntity<NewDTO> create(@RequestBody NewDTO newDTO){
        return ResponseEntity.ok(this.newService.create(newDTO));
    }

}
