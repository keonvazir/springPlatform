package com.routepractice.route;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

@SpringBootApplication
@RestController


public class DojoController{
	public static void main(String[] args) {
		SpringApplication.run(RouteApplication.class, args);
	}
	@RequestMapping("/{dojo}")
    public String showLesson(@PathVariable("dojo") String dojo){
    	return "I love the dojo party!";
    }
	@RequestMapping("/{dojo}/{burbank-dojo}")
	public String showBurbank(@PathVariable("dojo") String dojo, @PathVariable("burbank-dojo") String burbankDojo) {
		return "I live in Burbank!";
	}
	@RequestMapping("/{dojo}/{burbank-dojo}/{san-jose}")
	public String showJose(@PathVariable("dojo") String dojo, @PathVariable("burbank-dojo") String burbankDojo, @PathVariable("san-jose") String sanJose) {
		return "I live in San Jose, he lives in Burbank!";
	}
	@RequestMapping("/{dojo}/{burbank-dojo}/{san-jose}/{firstname}/{lastname}")
	public String showHome(@PathVariable("dojo") String dojo, @PathVariable("burbank-dojo") String burbankDojo, @PathVariable("san-jose") String sanJose, @PathVariable("firstname") String firstname, @PathVariable("lastname") String lastname) {
		return "I live in San Jose, he lives in Burbank! " + firstname + " " + lastname;
	
}
}
