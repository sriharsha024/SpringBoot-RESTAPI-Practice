package com.Practice.FirstSpring;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public HelloResponse sayHello() {
        return new HelloResponse("Hello Spring Boot!");
    }

    @GetMapping("/hello/{name}")
    public HelloResponse sayHelloParam(@PathVariable String name) {
        return new HelloResponse("Hello "+name);
    }

    @PostMapping("/hello")
    public HelloResponse sayHelloPost(@RequestBody String name) {
        return new HelloResponse("Hello "+name+" !");
    }
}
