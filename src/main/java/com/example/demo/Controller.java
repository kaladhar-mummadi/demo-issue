package com.example.demo;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
//impor/t org.springframework.web.reactive.function.server.ServerRequest;

@RestController
public class Controller {

//  @GetMapping("/foo/**")
//  public ResponseEntity<String> getFoo(ServerRequest request) {
//    String[] split = request.uri()
//        .getPath()
//        .split("/");
//    switch (split[split.length - 1]) {
//      case ":manifest":
//
//
//    }
//    return ResponseEntity.ok("response from foo/**");
//  }

  @GetMapping("/foo/**/bar")
  public ResponseEntity<String> getFooBar() {
    return ResponseEntity.ok("response from foo/**/bar");
  }

  @GetMapping("/message")
  public ResponseEntity<String> getMessage() {
    return ResponseEntity.ok("123");
  }

  @PutMapping
  public ResponseEntity<Void> putMessage(
      @RequestHeader(HttpHeaders.CONTENT_LENGTH) String contentLength) {

    System.out.println(contentLength);
    return ResponseEntity.ok().build();
  }
}
