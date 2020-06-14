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

import java.net.URISyntaxException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
import org.apache.http.protocol.HttpContext;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestContentLengthHttpClient {

  static HttpAsyncClientBuilder httpAsyncClientBuilder = HttpAsyncClientBuilder.create()
      .disableConnectionState().disableAuthCaching().disableCookieManagement();
  static CloseableHttpAsyncClient httpAsyncClient;
  private HttpUriRequest request;


  @BeforeAll
  public static void setup() {
    httpAsyncClientBuilder.addInterceptorLast((HttpRequest httpRequest,HttpContext httpContext) -> {  
      httpRequest.removeHeaders(HttpHeaders.CONTENT_LENGTH);
    });
    httpAsyncClient = httpAsyncClientBuilder.build();
    httpAsyncClient.start();
  }
  
  @BeforeEach
  public void setupRequest() throws URISyntaxException {
    String url = "http://localhost:8080";
    URIBuilder uriBuilder = new URIBuilder(url);
    request = new HttpPut();
    ((HttpRequestBase) request).setURI(uriBuilder.build());
    String someValue = "someValue";
    byte[] bytes = someValue.getBytes();

    ByteArrayEntity byteArrayEntity = new ByteArrayEntity(bytes);
    ((HttpEntityEnclosingRequestBase) request).setEntity(byteArrayEntity);
  }

  @Test
  public void testContentLength() throws ExecutionException, InterruptedException {
    Future<HttpResponse> execute = httpAsyncClient.execute(request, null);
    HttpResponse response = execute.get();
    Assertions.assertEquals(400, response.getStatusLine().getStatusCode());

  }
  
  @Test
  public void testContentLength2() throws ExecutionException, InterruptedException {
    Future<HttpResponse> execute = httpAsyncClient.execute(request, null);
    HttpResponse response = execute.get();
    Assertions.assertEquals(400, response.getStatusLine().getStatusCode());

  }
  
}
