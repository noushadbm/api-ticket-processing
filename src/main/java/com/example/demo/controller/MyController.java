package com.example.demo.controller;

import com.example.demo.model.MyModel;
import com.example.demo.repository.MyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class MyController {

    @Autowired
    private MyRepository myRepository;

    @GetMapping
    public ResponseEntity<List<MyModel>> getAllItems() {
        List<MyModel> items = myRepository.findAll();
        return ResponseEntity.ok(items);
    }

    @PostMapping
    public ResponseEntity<MyModel> createItem(@RequestBody MyModel item) {
        MyModel savedItem = myRepository.save(item);
        return ResponseEntity.ok(savedItem);
    }
}
