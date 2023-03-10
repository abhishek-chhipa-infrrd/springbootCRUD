package com.abhishek.springboot.tutorial.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/")
//	@Value(value = "${name.val}")
	public String helloWorld() {
		return "Hello world" ;
	}
}
