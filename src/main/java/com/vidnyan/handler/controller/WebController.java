package com.vidnyan.handler.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class WebController {
    @PostMapping("/data")
    public String setData(@RequestBody String data) {
        return "hello word";
    }
}
