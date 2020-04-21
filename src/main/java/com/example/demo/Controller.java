package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@GetMapping("/path/**")
	public ResponseEntity<String> getA() {
		return ResponseEntity.ok("response from type a");
	}

	@GetMapping("/path/**/:typeB")
	public ResponseEntity<String> getB() {
		return ResponseEntity.ok("response from type b");
	}

	@GetMapping("/path/**/:typeC")
	public ResponseEntity<String> getC() {
		return ResponseEntity.ok("response from type c");
	}
}
