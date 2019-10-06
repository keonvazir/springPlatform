package com.routepractice.route;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
@RestController
@RequestMapping("/coding")

public class RouteApplication{public static void main(String[] args) {
    SpringApplication.run(RouteApplication.class, args);
}
 
        @RequestMapping("")
        public String hello(@RequestParam(value="q", required=false) String searchQuery) {
                return "Hello Coding Dojo!";
        }
        @RequestMapping("/python")
        public String code(@RequestParam(value="q", required=false) String searchQuery) {
                return "Python/Django was fun!";
        }
        @RequestMapping("/java")
        public String java(@RequestParam(value="q", required=false) String searchQuery) {
                return "Java/Spring is better!";
        }
}



