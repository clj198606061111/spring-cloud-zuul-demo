package com.itclj.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/itclj")
public class ItcljController {

    @GetMapping("/{id}")
    public String getById(@PathVariable("id") String id) {
        return "Id is " + id;
    }
}
