package com.example.demo.greeting;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
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

	@GetMapping("/users/{userId}")
	public String userInfo(@PathVariable("userId") String userId) {
		if ("kido".equals(userId)) {
			throw new RuntimeException("userError");
		}

		return "User Id: " + userId;
	}

	@GetMapping("/users/ex/{userId}")
	public String userInfoEx2(@PathVariable("userId") String userId) {
		if ("kido".equals(userId)) {
			throw new IllegalArgumentException("userError");
		}

		return "User Id: " + userId;
	}

	// @ExceptionHandler(value = IllegalArgumentException.class)
	// public String handleError(HttpServletRequest req, Exception exception) {
	// String message = "IllegalArgumentException: Request: " + req.getRequestURI()
	// + " exception : " + exception;
	// System.out.println(message);

	// return message;
	// }

	@ExceptionHandler(value = IllegalArgumentException.class)
	public ResponseEntity<ErrorInfo> handleError2(HttpServletRequest req, Exception exception) {
		String message = "IllegalArgumentException: Request: " + req.getRequestURI() + " exception : " + exception;
		ErrorInfo errInfo = new ErrorInfo("ILARG001", message, "{}");

		return new ResponseEntity<ErrorInfo>(errInfo, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
