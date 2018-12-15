package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.UUID;

@RestController
public class FlightAppController {

    @GetMapping("/hello")
    public String getHelloMessage() {
        //generate random UUIDs
        ArrayList<UUID> l = new ArrayList<UUID>();
        for(int i = 0; i < 10; i++) {
            l.add(UUID.randomUUID());
        }

        StringBuilder
    }

//    @RequestMapping(value="/method7/{id}")
//    @ResponseBody
//    public String method7(@PathVariable("id") int id){
//        return "method7 with id="+id;
//    }
}
