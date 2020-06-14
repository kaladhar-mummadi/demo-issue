/*
 * ADOBE CONFIDENTIAL
 *
 * Copyright 2020 Adobe. All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property of Adobe and
 * its suppliers, if any. The intellectual and technical concepts contained herein are
 * proprietary to Adobe and its suppliers and are protected by all applicable intellectual
 * property laws, including trade secret and copyright laws. Dissemination of this
 * information or reproduction of this material is strictly forbidden unless prior written
 * permission is obtained from Adobe.
 */
package com.example.demo;

import java.util.Arrays;
import org.apache.http.HttpHeaders;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.yaml.snakeyaml.util.ArrayUtils;

public class TestContentLengthWebClient {
  String[] vals = new String[]{null};
  WebClient webClient = WebClient.builder().baseUrl("http://localhost:8080")
      .defaultHeader(HttpHeaders.CONTENT_LENGTH, vals)
      .build();
  
  @Test
  public void testContentLength() {

    HttpStatus block = webClient.put().body(BodyInserters.fromValue("[123]"))
        .exchange()
        .map(clientResponse -> {
          System.out.println(clientResponse);
          return clientResponse.statusCode();
        })
        .block();

    Assertions.assertEquals(block.value(), 400);

  }
  @Test
  public void testContentLength2() {

    HttpStatus block = webClient.put().body(BodyInserters.fromValue("[123]"))
        .exchange()
        
        .map(clientResponse -> {
          System.out.println(clientResponse);
          return clientResponse.statusCode();
        })
        .block();

    Assertions.assertEquals(block.value(), 400);
  }
}
