package com.example.demo.greeting;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	@GetMapping("/")
	public String greeting() {
		return "Hello, ";
	}

	@GetMapping("/{name}")
	public String greetingWithName(@PathVariable("name") String name) {
		return "Hello, " + name;
	}

	@PostMapping("/")
	public String greetingPost(GreetingInfo userInfo) {
		System.out.println("User Info: " + userInfo);
		return "OK";
	}
}
