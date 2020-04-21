package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@GetMapping("/foo/**")
	public ResponseEntity<String> getFoo() {
		return ResponseEntity.ok("response from foo/**");
	}

	@GetMapping("/foo/**/bar")
	public ResponseEntity<String> getFooBar() {
		return ResponseEntity.ok("response from foo/**/bar");
	}

}
