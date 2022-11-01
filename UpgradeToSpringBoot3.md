# Journey to Spring Boot 3.0 and Spring Framework 6.0

Spring Boot 3.0 will be released in a few days, and we're looking forward to working on some of the new features.It is strongly advised that we do not migrate immediately to Spring Boot 3.0; it is generally simpler to upgrade in release order,for example, 2.5 -> 2.6 -> 2.7 rather than previous versions/2.5 -> 3.0.

Let's go through some of the most important aspects to improve.

## 1. Upgrade to Java 17

Moving to Java 17 (LTS) becomes the baseline for Spring Boot 3.0,allowing developers to take use of new language capabilities such as `Pattern Matching, Records, Switch Expressions, Text Blocks, and Sealed Classes and Interfaces`.

## 2. Refactor to Jakarta EE 9 APIs

JavaEE8 to Jakarta EE9 refactoring, where the package namespace changed from `java.*` to `jakarta.*` and Spring Boot 3 is the first version that make use of Jakarta EE 9 APIs instead of JavaEE 8.

For example, in order to access the Entity object within the Entity class, we must replace:

`import javax.persistence.Entity;` > `import jakarta.persistence.Entity;`

and, we need to modify/replace the `HttpServletRequest` object when we access it from your Spring MVC Controller

`import javax.servlet.http.HttpServletRequest;` > `import jakarta.servlet.http.HttpServletRequest;`

Because it is not feasible to utilise both Java EE and Jakarta EE APIs in the same project, we must guarantee that both your project code and third-party libraries use `jakarta.*` package imports. Fortunately, critical libraries such as `Hibernate Validator 7+, Tomcat 10+, and Jetty 11+` have already moved to Jakarta EE APIs.

## 3. Deprecated code has been removed
Deprecated code has been removed, thus when migrating, consider using the java compiler parameter `-Werror` to fail during build if deprecation warnings are raised.

## 4. Migrate from Legacy application.properties/.yaml processing
The legacy application.properties and application.yaml processing support has been discontinued in Spring Boot 3 therefore ensure that your project does not use it. i.e., the property spring.config.use-legacy-processing

## 5. Make use of Spring MVC's PathPatternParser
It is recommended to utilise the parse pattern as the Spring MVC PathPatternParser (default) rather than AntPathMatcher.

## 6. Build Native Executables and Observability
* Building native executables and delivering them to GraalVM takes precedence. So the Spring Native effort is now in full swing. For AOT generation, maven  introduced new goal of the *spring-boot-maven-plugin* I.e., `mvn spring-boot:aot-generate`. Click [here](https://spring.io/blog/2022/03/22/initial-aot-support-in-spring-framework-6-0-0-m3) for additional information.

* With Spring Framework 6, a new [Micrometer](https://micrometer.io) was created, and the core [Spring Cloud Sleuth](https://spring.io/projects/spring-cloud-sleuth) project was moved to [Micrometer Tracing](https://github.com/micrometer-metrics/tracing/), which effectively tracks/records application metrics with Micrometer and implements tracing with providers such as OpenZipkin/Open Telemetry and auto-configuration is all in place with Spring Boot 3.

## 7. Miscellanous 
Using Kotlin 1.7+, Lombok 1.18.22 (JDK17 required), and Gradle 7.3+ necessitates the use of Spring Framework 6 and Spring Boot 3.

# In conclusion
* Migrate to Spring Boot 2.7 first, then to Spring Boot 3 using the migration instructions for 2.7.
* Update to Java 17.
* Using the java compiler `-Werror` flag, check for deprecated code.
* Cross-check projects to ensure Jakarta EE 9 compatibility.
* To put the Spring Boot 3 update to the test, always explore with the current milestone.

Happy Coding.

## in28minutes
