# Pattern matching difference between webmvc and webflux for Request Mappings.

I have 3 mappings as following in a controller, you can see the code in `Controller.java`
 of attached project.
```java
@GetMapping("/path/**")
handlerA

@GetMapping("/path/**/:typeB")
handlerB

@GetMapping("/path/**/:typeC")
handlerC
```

- In `webmvc` whenever request comes as `/path/1/2/3/:typeB` it does map to `handlerB`
- Same for `/path/1/2/:typeC` which maps to `handlerC`. 
- Note the difference is in last path segment which is either `:typeB` or `:typeC`.
- If no type is specified then it maps to `handlerA`.

So the issue is webflux, when I switch to `webflux` all mappings map to `handlerA`.Like `/path/1/2/3/:typeB`, `/path/1/2/3/:typeC` map to `handlerA`

> Uploaded the project here https://github.com/kaladhar-mummadi/demo-issue , to switch between `webflux` and `webmvc` please comment appropriate starter dependency in `pom.xml`.

