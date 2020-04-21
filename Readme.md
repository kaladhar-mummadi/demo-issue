# Pattern matching difference between webmvc and webflux for Request Mappings.

I have 3 mappings as following in a controller, you can see the code in `Controller.java`
 of attached project.
```java
@GetMapping("/foo/**")
public ResponseEntity getFoo() {}

@GetMapping("/foo/**/bar")
public ResponseEntity getFooBar() {}
```

- In `webmvc` whenever request comes as `/foo/1/2/3/bar` (as far as last path segment
 is `bar`) it maps to `getFooBar`.
- If `bar` is not specified then it maps to `getFoo`. i.e all `foo/1`, `foo/1/2`, `foo
/ab/cd`.... maps tp `getFoo`, until there is no `bar` in the last path segment.
- The issue is in webflux, when I switch to `webflux` all mappings map to
 `getFoo`. No matter if path consists of `bar` in last path segment.
- For eg. `/foo/ab/cd/bar` maps to `getFoo`.

> Uploaded the project here , to switch between `webflux` and `webmvc` please comment
appropriate starter dependency in `pom.xml`.

#### Notes:
- Webmvc ![AntPathMatcherTests](https://github.com/spring-projects/spring-framework/blob/master/spring-core/src/test/java/org/springframework/util/AntPathMatcherTests.java#L103) has tests like `/bla/**/bla`, which are not covered in
 ![PathPatternTests](https://github.com/spring-projects/spring-framework/blob/master/spring-web/src/test/java/org/springframework/web/util/pattern/PathPatternTests.java) of WebFlux. 