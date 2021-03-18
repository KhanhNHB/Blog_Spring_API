package com.example.blog.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedHashMap;
import java.util.Map;

@RequestMapping("api/v1/tasks")
@RestController
public class TaskController {

    @GetMapping
    public ResponseEntity<Map<String, String>> getAllTasks(HttpServletRequest request) {
        Map<String, String> map = new LinkedHashMap<String, String>();
        map.put("data", "abc");

        return new ResponseEntity<>(map, HttpStatus.OK);
    }
}
