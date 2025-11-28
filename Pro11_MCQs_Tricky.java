package com.nt.coding.challanges;

import java.util.Arrays;
import java.util.List;

public class Pro11_MCQs_Tricky {
	
	public static void main(String[] args) throws InterruptedException {
		/*
		int a = 10;
		System.out.println(a++ + ++a);	
		*/
		
		
		
		/*
		int x = 5;
		System.out.println(x++ + x++);	
		*/
		
		
		
		/*
		String s = null;
		System.out.println(s + "java"); 
		*/
		
		
		
		/*
		System.out.println(10 + 20 + "Java");
		*/
		
		/*
		System.out.println("Java" + 10 + 20);
		*/
		
		
		
		/*
		char c = 'A';
		c++;
		System.out.println((int)c);
		*/
		
		
		
		/*
		byte b = 127;
		b++;
		System.out.println(b);
		*/
		
		
		
		/*
		//System.out.println(10/0);
		System.out.println(10/0.0);
		*/
		
		
		//System.out.println('A' + 'B');
		
		
		
		//System.out.println(1 + 2 + "3" + 4 + 5);

		
		/*
		String s1 = "Java";
		String s2 = new String("Java");
		System.out.println(s1 == s2);
		*/
		
		
		/*
		String s = "abc";
		s.concat("xyz");
		System.out.println(s);
		*/
		
		/*
		int[] a = new int[5];
		System.out.println(a[0]);
		*/
		
		
		
		/*
		A1 a = new B();
		System.out.println(a instanceof B);
		*/
		
		
		/*
		int[][] arr = new int[2][];
		System.out.println(arr[0]);
		*/
		
		
		/*
		Integer a = 128;
		Integer b = 128;
		System.out.println(a == b);
		*/

		/*Integer a = 127;
		Integer b = 127;
		System.out.println(a == b);
		*/
		
		
//		System.out.println(args.length);
		
		
		/*
		Thread t = new Thread();
		t.start();
		t.start();
		*/
		
		
		//m1();
		
		
		
		/*
		volatile int x = 0;
		x = x + 1;
		
		System.out.println(x);
		*/
		
		
		
		
		
		/*Thread.currentThread().setDaemon(true);
		*/ //Cannot make already-running thread daemon.
		
		
		
		/*
		Object o = new Object();
		o.wait();
		*/
		
		
		/*
		int x = 0;
		Runnable r = () -> { x++; };
		new Thread(r).start();
		*/
		
		
		/*
		Thread t = new Thread(() -> {});
		t.setPriority(11);
		t.start();
		*/
		
		
		
		/*List<Integer> l = Arrays.asList(1,2,3);
		l.add(4);
		
		System.out.println(l);*/ 
		
		/*
		Set<Integer> s = new TreeSet<>();
		s.add(10);
		s.add(null);
		*/
		
		
		
		/*
		List<Integer> l = new ArrayList<>();
		l.add(1);
		l.add(1);
		l.remove(Integer.valueOf(1));
		System.out.println(l);
		*/
		
		
		
		//Stream.of(1,2,3).map(x -> x*2);

		
		/*
		List<Integer> l = Arrays.asList(1,2,3);
		l.stream().forEach(x -> x++);
		System.out.println(l);
		*/
		
		
		/*
		Stream.empty().findFirst().get();
		*/
		
		
		/*
		System.out.println("a".chars().count());
		*/
		
		
		/*
		char c = 'A' + 1;
		System.out.println(c);
		*/
		
		
		
		/*
		Stream<Integer> list = Stream.of(1, 2, 3, 4);
		list.forEach(System.out::println);
		list.forEach(System.out::println);
		*/
		
		/*
		int num = 10;
		num = 20;
		
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Number is :: "+ num);
			}
		};
		runnable.run();
		*/
		
		
		
		//heartPattern();
		
		
	}
	
	
	
	private static void heartPattern() {
		
		for(int i=1; i<=5; i++) {
			for(int j=1; j<=5; j++) {
				if(
					(i==1 && (j==2 || j==4)) ||
					(i==2 && j==3) ||
					(i==3 && (j==1 || j==5)) ||
					(i==4 && (j==2 || j==4)) ||
					(i==5 && j==3)
					 
				  ) {
					System.out.print("* ");
				}else {
					System.out.print("  ");
				}
				
				
			}
			System.out.println();
		}
	}
	
	

	synchronized static void m1() {
	    System.out.println("A");
	    m1();
	}
	
	
}

class A1 {}
class B extends A1 {}


/*

What does Thread.yield() do?

A. Terminates thread
B. Pauses thread forever
C. Hints scheduler to switch thread
D. Makes thread sleep for 1 ms

Answer: C
Yield only requests scheduler to switch—not guaranteed.




What happens when a thread calls start() twice?

A. Runs again
B. Restarts
C. Throws exception
D. Creates new thread

Answer: C — IllegalThreadStateException



What does join() do?

A. Pause current thread until target thread completes
B. Kill thread
C. Release lock
D. None

Answer: A



Which executor creates unlimited threads?

A. newSingleThreadExecutor()
B. newCachedThreadPool()
C. newFixedThreadPool()
D. newScheduledThreadPool()

Answer: B



What is thread starvation?

A. Thread runs slow
B. Thread never gets CPU
C. Thread stops
D. Thread dies

Answer: B



Deadlock occurs when

A. resources unlimited
B. cyclic lock dependency
C. threads slow
D. memory full

Answer: B


HashMap default load factor?

A. 0.5
B. 0.75
C. 1.0
D. 0.25

Answer: B





*/






//*******************************************************************************************************************************
//*******************************************************************************************************************************






/*


Can we use both @Controller and @RestController together on the same class? What happens?

Answer:
No, we should NOT use both.
@RestController = @Controller + @ResponseBody.
If you add both, nothing breaks, but @RestController wins because it already includes @Controller.
So the controller will always return JSON, never a JSP/HTML view.



Difference between @Controller and @RestController?

@Controller returns view pages using view resolvers (Thymeleaf/JSP).
@RestController returns JSON/XML directly.
@RestController = @Controller + @ResponseBody.
Used for REST APIs.



What happens if we forget @ResponseBody?

Then Spring assumes you are returning a view name, not JSON.
It will try to resolve a template with that name → you get 404 template not found.



Can @Service and @Component be used interchangeably?

Yes.
@Service is just a specialization of @Component.
Both register beans, but @Service adds semantic meaning (business logic layer).
Internally both behave the same in BeanFactory.



What happens if two beans have the same name?

Spring throws
UnsatisfiedDependencyException: expected single matching bean

Unless you use @Qualifier or rename one bean.



What does @Autowired on a constructor do?

Spring injects the dependency automatically.
If there is only one constructor → @Autowired is optional.
This is the preferred method of dependency injection.



What happens if Spring finds multiple matching beans for @Autowired?

Spring fails at startup → NoUniqueBeanDefinitionException.
Use:

@Primary → default preferred bean
@Qualifier → explicitly choose the bean



What is the lifecycle of a Spring Bean?

Instantiation

Dependency Injection

@PostConstruct

Bean ready

@PreDestroy before shutdown




What is the difference between @Bean and @Component?

@Component is used for component scanning.
@Bean is used for manual bean creation inside @Configuration.
@Bean is preferred for 3rd-party class instances.



Can we autowire a static field?

No.
Spring injects beans into objects, not into static fields.
Static members are not part of Spring context.


What if we put @Transactional on private methods?

It will NOT work.
Spring AOP uses proxies → only public methods are visible.
Private methods bypass proxy → no transaction applied.


What if a @Transactional method calls another private method?

Inner private calls are not transactional.
All internal calls bypass Spring proxy.
Only external calls create transactions.



What if I throw a checked exception in @Transactional?

Transaction will NOT rollback on checked exceptions by default.
You must specify:

@Transactional(rollbackFor = Exception.class)



What is the use of @EnableAutoConfiguration?

It auto-configures beans based on classpath.
Spring Boot checks dependencies and auto-creates beans (DispatcherServlet, DataSource, Jackson, etc.)



What happens if you remove spring-boot-starter-web?

Your application will start, but no controller endpoints will work.
No Tomcat, DispatcherServlet, MVC infrastructure.



What is the difference between application.properties and application.yml?

Same purpose, different format.
YAML supports hierarchy better.
Properties are flat.
Spring Boot automatically loads both.



What is the use of @Value vs @ConfigurationProperties?

@Value is for single property injection.
@ConfigurationProperties binds full objects from properties.
Better for structured configurations.



Can we create a REST API without @SpringBootApplication?

Yes.
But you must manually enable:

Component scan

Auto-configuration

Configuration classes
This is why @SpringBootApplication combines them.



Can @RestController return a view?

No.
It always returns JSON/XML because of @ResponseBody.
To return view → use @Controller.


What is the use of @ConditionalOnProperty?

Enable/disable beans based on config. Example:
@ConditionalOnProperty(name="feature.x.enabled", havingValue="true")

Feature toggles become easy.



What is Bean Overriding?

When two beans have the same name → the latest loaded bean overrides the previous.
Spring Boot 2.1+ disables overriding by default → must enable manually.



Does Spring Boot create multiple DataSource beans?

No, unless you define custom ones.
Boot creates a single auto-configured DataSource.



What is Circular Dependency in Spring?

A → B, B → A.
Spring fails:

BeanCurrentlyInCreationException

Constructor injection cannot resolve circular dependencies.




What does @Lazy do?

Bean initializes only when used, not at startup.
Good for performance if bean creation is heavy.



What happens if we annotate the same bean with @Lazy and @Scope("prototype")?

Lazy is meaningless because prototype beans are created only when requested anyway.



Why is field injection discouraged?

Hard to test, cannot be immutable, global state issues.
Constructor injection is recommended.



What is the DispatcherServlet?

Front controller of Spring MVC.
Receives request → finds handler → executes → returns response.



What is the difference between Filter, Interceptor, and AOP?

Filter → Servlet level

Interceptor → Spring MVC level

AOP → Method execution level



Can @Autowired inject by type AND by name?

Yes.
By type first.
If multiple beans found → by name.



What is the use of @PathVariable vs @RequestParam?

PathVariable → part of URL
RequestParam → query parameter



Why does Spring Boot need Tomcat?

To host Servlet-based apps.
Spring Boot auto-configures embedded Tomcat by default.



What is the use of @RestControllerAdvice?

Global exception handling.
Intercepts exceptions across all controllers.



What if two @RestControllerAdvice exist?

Both are applied.
But order matters → use @Order annotation.



How does Spring Boot automatically serialize objects to JSON?

Using Jackson.
MappingJackson2HttpMessageConverter handles conversion.



What is @RequestBody doing internally?

Reads JSON from HTTP request → converts to Java object using MessageConverter.



What if we forget @RequestBody?

Spring assumes form-data input.
For JSON, the object will be null.




What if JSON fields are extra and not in the model?

By default ignored.
If strict mapping needed → enable:

FAIL_ON_UNKNOWN_PROPERTIES=true




Difference between @ComponentScan and @SpringBootApplication?

@SpringBootApplication already includes component scanning for its package.



How to make a scheduled task run every 5 seconds?
@Scheduled(fixedRate = 5000)




Why we use @Repository?

For DAO layer.
It converts SQL exceptions into Spring’s DataAccessException.



How to return custom HTTP status from controller?
return new ResponseEntity<>(body, HttpStatus.CREATED);



What is the use of @JsonIgnore?

Skip a field during serialization.
Useful for sensitive data like passwords.



What happens if two controllers have same endpoint?

You get:

Ambiguous mapping exception



How do you secure a specific endpoint?
@PreAuthorize("hasRole('ADMIN')")




What is the difference between Mono and Flux in WebFlux?

Mono → 0 or 1 element
Flux → 0 or many elements
Reactive programming.



Can we use @Transactional in WebFlux?

Not fully.
Transactional works only with blocking DB drivers.
Use R2DBC or reactive transactions.



How does Spring Boot handle circular dependencies?

If constructor injection → fails startup.
If field/setter injection → warns but works (not recommended).





✅ HTTP vs HTTPS (Very Simple Explanation)
1️⃣ Security

HTTP is not secure. Data goes as plain text.

HTTPS is secure. Data is encrypted, so hackers can’t read it.

2️⃣ Data Protection

In HTTP, anyone on the network can see your passwords, card numbers, etc.

In HTTPS, even if someone steals the data, they cannot understand it.

3️⃣ Certificate

HTTP does not use any certificate.

HTTPS uses an SSL/TLS certificate that proves the website is trusted.

4️⃣ URL Format

HTTP starts with http://

HTTPS starts with https:// and shows a lock icon in the browser.

5️⃣ Performance

HTTP is slightly faster because no encryption.

HTTPS is a little slower, but modern systems make it very fast too.

6️⃣ Usage

HTTP is used for normal, non-sensitive sites.

HTTPS is used for banking, login, payment, email, all modern websites.




Q. What will happen if we replace @Configuration with @Component in a 
Spring class that defines @Bean methods? Explain with example.

If you replace @Configuration with @Component, Spring will not create 
beans using full proxy mode. This means the @Bean methods will be 
treated like normal methods, and Spring will not intercept calls 
between them.
So each time your code calls one @Bean method from another, Spring 
will create a new object instead of returning the singleton bean 
from the container.

Example: In your code, getA() calls getB().
With @Configuration, getB() returns the same B bean.
With @Component, getB() returns a new B object, so A.b ≠ B bean.


@Configuration ->	true	Spring returns same singleton B bean
@Component	   ->   false	Spring creates a new B object inside getA()





*/






/*

Q|A
---

✅Spring Boot Basics:
        ☑️What is Spring Boot?
        ☑️Advantages of using Spring Boot.
        ☑️Spring Boot auto-configuration.

    ✅Spring Boot Annotations:
        ☑️@SpringBootApplication
        ☑️@RestController, @Controller, @Service, @Repository
        ☑️@Autowired, @Qualifier, @Value
        ☑️@RequestMapping, @GetMapping, @PostMapping, @PutMapping, @DeleteMapping
        ☑️@PathVariable, @RequestParam, @RequestBody

    ✅Spring Boot Configuration:
        ☑️Externalized Configuration with application.properties or application.yml
        ☑️Profiles in Spring Boot
        ☑️Customizing Configuration Properties

    ✅Spring Boot Data:
        ☑️Spring Data JPA
        ☑️Spring Data JDBC
        ☑️Spring Data MongoDB
        ☑️Spring Data Redis
        ☑️Spring Data Elasticsearch

    ✅Spring Boot Security:
        ☑️Authentication and Authorization with Spring Security
        ☑️OAuth2 and JWT Authentication
        ☑️Securing RESTful APIs

    ✅Spring Boot Actuator:
        ☑️Monitoring and managing applications
        ☑️Metrics, health checks, info endpoint

    ✅Spring Boot Testing:
        ☑️Unit testing with JUnit and Mockito
        ☑️Integration testing with Spring Boot Test

    ✅Spring Boot RESTful Web Services:
        ☑️Building RESTful APIs with Spring Boot
        ☑️Consuming RESTful APIs with RestTemplate and WebClient

    ✅Spring Boot Microservices:
        ☑️Principles of microservices architecture
        ☑️Service registration and discovery with Eureka or Consul
        ☑️Inter-service communication with Feign or WebClient
        ☑️Distributed tracing with Spring Cloud Sleuth and Zipkin

   
    ✅Spring Boot Best Practices:
        ☑️Error handling and exception management
        ☑️Logging and debugging
        ☑️Performance optimization
        ☑️Security best practices

    ✅Advanced Spring Boot Topics (Great to have):
        ☑️Reactive programming with Spring WebFlux
        ☑️GraphQL with Spring Boot
        ☑️Reactive microservices with Spring Cloud Gateway and Spring Cloud Function


*/