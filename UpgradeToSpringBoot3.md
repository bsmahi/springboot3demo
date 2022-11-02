# Journey to Spring Boot 3.0 and Spring Framework 6.0

Spring Boot 3.0 will be released in a few days,and we're looking forward to working on some of the new features. 

## Changes
 * Baseline Upgrade to Java17
 * Baseline Upgrade to Jakarta EE 9 APIs
 * Build Native Executables and Observability
 * Make use of Spring MVC's PathPatternParser
 * Baseline Upgrade for Kotlin, Lombok, and Gradle
 * Removal of Deprecated Code
 * Migrate from Legacy application.properties/.yaml processing

### Let's go through each of the changes in depth.


## 1. Baseline Upgrade Java 17

Moving to Java 17 (LTS) becomes the baseline for Spring Boot 3.0, allowing developers to take use of new language capabilities such as
* Pattern Matching - https://docs.oracle.com/en/java/javase/17/language/pattern-matching.html
* Records - https://docs.oracle.com/en/java/javase/17/language/records.html
* Switch Expressions - https://docs.oracle.com/en/java/javase/17/language/switch-expressions.html
* Text Blocks - https://docs.oracle.com/en/java/javase/17/text-blocks/index.html
* Sealed Classes and Interfaces - https://docs.oracle.com/en/java/javase/17/language/sealed-classes-and-interfaces.html

## 2. Baseline Upgrade to Jakarta EE 9 APIs

JavaEE8 to Jakarta EE9 refactoring, where the package namespace changed from `java.*` to `jakarta.*` and Spring Boot 3 is the first version that make use of Jakarta EE 9 APIs instead of JavaEE 8.
Because it is not feasible to utilise both Java EE and Jakarta EE APIs in the same project,we must guarantee that both your project code and third-party libraries use `jakarta.*` package imports. 
Fortunately, critical libraries such as `Hibernate Validator 7+, Tomcat 10+, and Jetty 11+` have already moved to Jakarta EE APIs.

## 3. Build Native Executables and Observability
Building native executables and delivering them to GraalVM takes precedence. So the Spring Native effort is now in full swing. For AOT generation, maven  introduced new goal of the *spring-boot-maven-plugin* i.e., `mvn spring-boot:aot-generate`. Click [here](https://spring.io/blog/2022/03/22/initial-aot-support-in-spring-framework-6-0-0-m3) for additional information.

With Spring Framework 6, a new [Micrometer](https://micrometer.io) was created, and the core [Spring Cloud Sleuth](https://spring.io/projects/spring-cloud-sleuth) project was moved to [Micrometer Tracing](https://github.com/micrometer-metrics/tracing/), which effectively tracks/records application metrics with Micrometer and 
implements tracing with providers such as OpenZipkin/Open Telemetry and auto-configuration is all in place with Spring Boot 3.

## 4. Make use of Spring MVC's PathPatternParser
It is recommended to utilise the parse pattern as the Spring MVC PathPatternParser (default) rather than AntPathMatcher.

## 5. Baseline Upgrade for Kotlin, Lombok, and Gradle 
Using Kotlin 1.7+, Lombok 1.18.22 (JDK17 required), and Gradle 7.3+ necessitates the use of Spring Framework 6 and Spring Boot 3.

## 6. Deprecated code has been removed
Deprecated code has been removed, thus when migrating, consider using the java compiler parameter `-Werror` to fail during build if deprecation warnings are raised.

## 7. Migrate from Legacy application.properties/.yaml processing
The legacy application.properties and application.yaml processing support has been discontinued in Spring Boot 3 therefore ensure that your project does not use it. i.e., the property spring.config.use-legacy-processing

# In conclusion
* Migrate to Spring Boot 2.7 first, then to Spring Boot 3 using the migration instructions for 2.7.
* Update to Java 17.
* Using the java compiler `-Werror` flag, check for deprecated code.
* Cross-check projects to ensure Jakarta EE 9 compatibility.
* To put the Spring Boot 3 update to the test, always explore with the current milestone.

Happy Coding.

## in28minutes
