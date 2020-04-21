# Behavior difference between PathPatternParser(WebFlux) vs AntPathMatcher(MVC)

Created 2 mappings as following in the controller, code is in `Controller
.java`of the attached [project](https://github.com/kaladhar-mummadi/demo-issue).
```java
@GetMapping("/foo/**")
public ResponseEntity getFoo() {}

@GetMapping("/foo/**/bar")
public ResponseEntity getFooBar() {}
```

- In `webmvc` whenever request comes as `/foo/1/2/3/bar` (as far as last path segment
 is `bar`) it maps to `getFooBar`.
- If `bar` is not specified ast last path segment then it maps to `getFoo`. 
- i.e all `foo/1`, `foo/1/2`, `foo/ab/cd`.... maps to `getFoo`.
- The issue is in webflux, when I switch to `webflux` all mappings map to
 `getFoo`. No matter if path consists of `bar` in the last path segment.
- For eg. `/foo/ab/cd/bar` maps to `getFoo` instead of `getFooBar`.

> Uploaded the project here , to switch between `webflux` and `webmvc` please comment out
appropriate starter dependency in `pom.xml`.

#### Repro project here : https://github.com/kaladhar-mummadi/demo-issue
#### Notes:
- Webmvc [AntPathMatcherTests](https://github.com/spring-projects/spring-framework/blob/master/spring-core/src/test/java/org/springframework/util/AntPathMatcherTests.java#L103) has tests like `/bla/**/bla`, which are not covered in
 [PathPatternTests](https://github.com/spring-projects/spring-framework/blob/master/spring-web/src/test/java/org/springframework/web/util/pattern/PathPatternTests.java) of WebFlux. 
