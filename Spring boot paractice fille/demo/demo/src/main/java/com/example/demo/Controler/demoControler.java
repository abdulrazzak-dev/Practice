package com.example.demo.Controler;

import com.example.demo.Serivce.demoSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vi")
public class demoControler {
    @Autowired
    private demoSerivce DemoSerivce;

    @GetMapping("/demo")
    String demo() {
        return "helo world";
    }}

 //   @GetMapping("/get")

    //String demo1() {
//        DemoSerivce.callTodo();
//        return "helo world";

