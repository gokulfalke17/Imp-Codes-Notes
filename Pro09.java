package com.nt.coding.challanges;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;


record Employee(String name, int salary, String dept) {}

public class Pro09 {

	public static void main(String[] args) {
		
		List<Employee> emps = Arrays.asList(
				new Employee("abc", 5000, "IT"),
				new Employee("mno", 3000, "CS"),
				new Employee("abc", 1000, "CSE"),
				new Employee("pqr", 2000, "IT"),
				new Employee("abc", 4500, "IT"),
				new Employee("pqr", 2100, "CSE"),
				new Employee("stv", 4900, "CS"),
				new Employee("def", 8900, "ME")
			);
		
		secondHeighestSalaryEmployee(emps);
		System.out.println();
		groupEmployeeByDeptwise(emps);
		System.out.println();
		heighestSalaryEmployee(emps);
		System.out.println();
		countEmployeeInEachDept(emps);
		System.out.println();
		maxSalaryEmployeeEachDept(emps);
		System.out.println();
		minSalaryEmployeeEachDept(emps);
		System.out.println();
		sumOfAllEmployeeSalary(emps);
		System.out.println();	
		findDeptwiseAvgSalary(emps);
		System.out.println();
		findDeptwiseHeighestAvgSalary(emps);
		System.out.println();
		mostCommonFirstLetter(emps);
		System.out.println();
		
		
		
	}

	private static void mostCommonFirstLetter(List<Employee> emps) {
		Map<Character,Long> map = emps
							.stream()
							.map(ele -> ele
									.name().charAt(0))
							.collect(Collectors
									.groupingBy(Function
											.identity(), Collectors
											.counting()));
		
		System.out.println(map);
		
		Optional<Entry<Character, Long>> mostCommonFirstLetter = map
									.entrySet()
									.stream()
									.max(Map
											.Entry
												.comparingByValue());
		
		System.out.println("Most Common First Letter Freq :: \n"+mostCommonFirstLetter.get());
	}
	
	

	private static void findDeptwiseHeighestAvgSalary(List<Employee> emps) {
		Map<String,Double> map = emps.stream()
							.collect(Collectors
									.groupingBy(Employee::dept, 
											Collectors
											.averagingDouble(Employee::salary)));
		System.out.println(map);
		
		Optional<Entry<String, Double>> heighest = map.entrySet()
								.stream()
								.max(Map.Entry
										.comparingByValue());
		
		System.out.println("Heighest Average Salary In Deptwise :: \n"+heighest);
	}
	
	

	private static void findDeptwiseAvgSalary(List<Employee> emps) {
		Map<String,Double> map = emps.stream().collect(Collectors.groupingBy(Employee::dept, Collectors.averagingDouble(Employee::salary)));
		System.out.println(map);
	}
	
	
	

	private static void sumOfAllEmployeeSalary(List<Employee> emps) {

		//Find sum of all employee salaries
		
		long sumOfEmpsSalary = emps.stream()
						.collect(Collectors
								.summarizingLong(Employee::salary))
						.getSum();
		
		System.out.println("Employee Salary Sum :: \n"+ sumOfEmpsSalary);
	}
	
	

	private static void minSalaryEmployeeEachDept(List<Employee> emps) {

		//Find min salary employee in each department
		
		Map<String, Optional<Employee>> minSalaryDeptwise = emps.stream()
				.collect(Collectors
						.groupingBy(Employee::dept, 
								Collectors.minBy(Comparator
										.comparingInt(Employee::salary))));

		System.out.println("Min Salary Employee Deptwise :: ");
		minSalaryDeptwise.forEach((dept, emp) ->
		System.out.println(dept + " -> " + emp.orElse(null)));
		
	}

	
	
	private static void maxSalaryEmployeeEachDept(List<Employee> emps) {
		
		//Find max salary employee in each department
		
		Map<String, Optional<Employee>> maxSalaryDeptwise = emps.stream()
								.collect(Collectors
										.groupingBy(Employee::dept, 
												Collectors.maxBy(Comparator
														.comparingInt(Employee::salary))));
		
		System.out.println("Max Salary Employee Deptwise :: ");
		maxSalaryDeptwise.forEach((dept, emp) ->
        		System.out.println(dept + " -> " + emp.orElse(null)));
	}

	
	
	private static void countEmployeeInEachDept(List<Employee> emps) {
		
		//Count employees in each department
		
		Map<String, Long> countOfEmpsEachDept = emps.stream()
								.collect(Collectors
										.groupingBy(Employee::dept, 
													Collectors.counting()));
		
		System.out.println("Employee Count Deptwise :: \n"+ countOfEmpsEachDept);
	}
	
	

	private static void heighestSalaryEmployee(List<Employee> emps) {
		
		//Find employee with highest salary
		
		Optional<Employee> heighestSalaryEmployee = emps.stream()
									.distinct()
									.distinct()
									.sorted(Comparator
											.comparingInt(Employee::salary)
											.reversed())
									.findFirst();
		
		heighestSalaryEmployee
				.ifPresentOrElse(emp -> System.out.println("Heighest Salary Employee :: \n"+ emp), 
								  () -> System.out.println("Heighest Salary Employee Not Found.!"));
	}

	
	
	
	private static void groupEmployeeByDeptwise(List<Employee> emps) {
		
		//Group employees by department
		
		Map<String,List<Employee>> map = emps.stream()
						.collect(Collectors.groupingBy(Employee::dept));
		
		System.out.println("Group Employees Deptwise :: ");
		map.forEach((key, value) -> System.out.println(key+" -> "+ value));
	}
	
	

	private static void secondHeighestSalaryEmployee(List<Employee> emps) {
		
		//Find employee with second highest salary
		
			/*
			Integer secondHeighestSalary = emps.stream()
							.distinct()
							.map(Employee::salary)
							.sorted(Collections
									.reverseOrder())
							.skip(1)
							.findFirst()
							.orElse(null);
			
			System.out.println("Second Heighest Salary is "+secondHeighestSalary);
			*/
	
	
	
			Optional<Employee> secondHeighestSalary = emps.stream()
								.distinct()
								.sorted(Comparator
										.comparingInt(Employee::salary)
										.reversed())
								.skip(1)
								.findFirst();
			
			secondHeighestSalary
					.ifPresentOrElse(emp -> System.out.println("Second Heighest Salary Employee is :: \n"+ emp),
									() -> System.out.println("Second Heighest Salary Employee Not Found.!"));

	
	}
}



/*


🔥 CORE JAVA – Quick Revision Answers
--------------------------------------
1. OOPS concepts with real-time examples

OOPS means building programs using objects.
It includes Encapsulation (hiding data), Inheritance (reusing code),
Polymorphism (same method, different behavior), and Abstraction (show only required details).
Example: In a banking app — Account is a class, SavingsAccount extends it, withdraw() behaves
differently for each type, and internal balance is hidden.


2. Method Overloading vs Overriding

Overloading: Same method name, different parameters, compile-time polymorphism.
Overriding: Same method name and parameters in child class, runtime polymorphism.
Overloading happens in same class; overriding happens in parent-child classes.


3. Covariant Return Type

When overriding, child class method can return a subclass of the return type of parent method.
This gives flexibility and avoids casting.
Example: Parent returns Animal, child can override and return Dog.


4. Abstract class vs Interface (when to use what)

Use abstract class when you want partial implementation.
Use interface when you want pure abstraction or multiple implementations.
Interface supports multiple inheritance; abstract class does not.
Interface methods are public; abstract class can have any access.


5. Why Encapsulation is needed

Encapsulation hides data using private fields and provides getters/setters.
It protects data from misuse.
Improves security and maintainability of code.
Ensures only valid data enters the object.


6. String vs StringBuilder vs StringBuffer

String is immutable → every change creates new object.
StringBuilder is mutable and fast but not thread-safe.
StringBuffer is mutable and thread-safe, slower.
Use StringBuilder mostly.


7. How to create an immutable class

Make class final, all fields private and final.
No setters, only getters.
Do deep copy for mutable fields.
Initialize values only through constructor.


8. JVM Memory Model (Heap, Stack, Metaspace)

Stack stores method calls and local variables.
Heap stores objects created by new.
Metaspace stores class metadata.
GC cleans unused objects from heap.


9. Garbage Collection and its types

GC removes unused objects automatically.
Types include Young GC, Major GC, and Full GC.
Uses algorithms like Mark-Sweep, Copying, G1.
Improves memory management.


10. HashMap internal working

HashMap stores data as key-value pairs in buckets.
It uses hashCode() to find bucket location.
If collision happens, it uses linked list or tree.
Load factor decides resizing.


11. HashMap vs ConcurrentHashMap

HashMap is not thread-safe; ConcurrentHashMap is thread-safe.
ConcurrentHashMap uses segment locks, giving better performance.
HashMap allows null keys; ConcurrentHashMap does not.


12. Fail-fast vs Fail-safe

Fail-fast throws ConcurrentModificationException when structure is modified.
Fail-safe works on a clone and does not throw exception.
Example: ArrayList → fail-fast, CopyOnWriteArrayList → fail-safe.


13. ArrayList vs LinkedList

ArrayList is better for searching (index-based).
LinkedList is better for inserting/deleting in middle.
ArrayList uses dynamic array; LinkedList uses doubly-linked list.


14. volatile, transient, ThreadLocal

volatile ensures variable value is always read from main memory.
transient prevents a field from being serialized.
ThreadLocal provides separate variable value per thread.


15. Thread lifecycle and ExecutorService

Lifecycle: New → Runnable → Running → Blocked → Dead.
ExecutorService manages thread pool.
It reuses threads, improves performance, handles async tasks easily.



🔥 JAVA 8 – Quick Revision Answers
-----------------------------------
1. Streams internal flow

Stream processes data in a pipeline: source → intermediate ops → terminal op.
All operations are lazy and processed only when terminal method is called.
Streams don’t modify original data structure.


2. Intermediate vs Terminal operations

Intermediate: return Stream (map, filter, sorted).
Terminal: end the pipeline (collect, forEach, reduce).
Intermediate operations are lazy; terminal operations are executed immediately.


3. map vs flatMap

map: transforms each element → returns single value.
flatMap: transforms and flattens nested structures (List<List<T>>).
flatMap is used to avoid nested lists.


4. Optional class

Optional avoids NullPointerException.
Represents a value that may or may not exist.
Provides methods like isPresent(), orElse(), orElseGet().


5. Functional interfaces – Predicate, Function, Consumer

Predicate → takes input, returns boolean.
Function → takes input, returns output.
Consumer → takes input, returns nothing.
Used in lambda expressions.


6. Default and static methods in interfaces

Default methods provide common implementation.
Static methods belong to interface, not object.
They allow interfaces to evolve without breaking old code.


🔥 SPRING & SPRING BOOT – Quick Revision Answers
-------------------------------------------------
1. IoC and Dependency Injection

IoC means container controls object creation.
DI injects required dependencies into classes.
Reduces tight coupling and improves testability.


2. @Component vs @Service vs @Repository

@Component: generic bean.
@Service: business logic layer.
@Repository: DAO layer and exception translation.
All are detected by component scanning.


3. @Autowired vs @Qualifier vs @Primary

@Autowired: injects bean automatically.
@Qualifier: used when multiple beans exist.
@Primary: gives default bean when conflicts occur.


4. Bean scopes and lifecycle

Scopes: singleton, prototype, request, session.
Lifecycle: instantiate → dependency inject → init → destroy.
Init uses @PostConstruct, destroy uses @PreDestroy.


5. AOP real-world use cases

Used to handle cross-cutting concerns.
Examples: logging, security, transactions, metrics, auditing.
Keeps code clean and reduces duplication.


6. Spring Boot auto-configuration

Spring Boot auto-configures beans based on classpath.
Uses @ConditionalOnMissingBean, @ConditionalOnClass.
Reduces boilerplate code.


7. What @SpringBootApplication includes

Includes @Configuration, @EnableAutoConfiguration, @ComponentScan.
It enables component scanning and auto-configuration in one annotation.


8. Disabling auto-configuration

Use @SpringBootApplication(exclude = XYZ.class).
Or use properties like spring.autoconfigure.exclude.


9. DispatcherServlet request flow

Client → DispatcherServlet → HandlerMapping → Controller → ViewResolver → Response.
It handles complete request lifecycle in Spring MVC.


10. @RequestParam vs @PathVariable

@RequestParam: query parameters (?name=abc).
@PathVariable: URL variables (/user/10).
Both help extract user input from request.


11. @RestController vs @Controller

@RestController = @Controller + @ResponseBody.
Returns JSON/XML directly.
@Controller returns views (JSP/HTML).


12. Exception handling using @ControllerAdvice

Handles exceptions globally.
Prevents duplicate error-handling code in each controller.
Uses @ExceptionHandler methods.


13. Lazy vs Eager loading in JPA

Eager loads data immediately.
Lazy loads data when needed.
Lazy improves performance in large relations.


14. @Query annotation

Used for custom JPQL or native queries.
Helps write complex queries not supported by method names.

🔥 MICROSERVICES – Quick Revision Answers
------------------------------------------
1. Monolithic vs Microservices

Monolithic → single large deployment.
Microservices → small independent services.
Microservices give scalability, easy deployment, fault isolation.


2. API Gateway

Acts as single entry point.
Handles routing, authentication, rate limiting.
Examples: Zuul, Spring Cloud Gateway.


3. Service Registry and Discovery

Helps services register themselves.
Clients discover services dynamically.
Tools: Eureka, Consul.


4. Circuit Breaker pattern

Stops calling a failing service temporarily.
Prevents system crash.
Tools: Resilience4j, Hystrix.


5. Saga pattern

Manages distributed transactions across microservices.
Two types: Choreography (events), Orchestration (central coordinator).
Ensures data consistency.


6. Idempotency

Same operation can be repeated without affecting result.
Used in payment, order APIs to avoid duplicates.


7. Sync vs Async communication

Sync: request-response (blocking) – REST.
Async: event-based (non-blocking) – Kafka, RabbitMQ.


8. Feign Client vs RestTemplate vs WebClient

Feign → declarative REST client.
RestTemplate → old synchronous client.
WebClient → reactive, async, modern.


9. JWT vs OAuth2

JWT gives token-based authentication.
OAuth2 supports delegated authorization (Google/Facebook login).
JWT is simple; OAuth2 is more secure & enterprise-level.


10. Method-level and role-based security

Use @PreAuthorize, @PostAuthorize.
Use roles like ROLE_ADMIN, ROLE_USER.
Checks permission before executing method.


11. Caching strategies

Cache aside, read-through, write-through.
Used to improve performance and reduce DB load.

🔥 SQL – Quick Revision Answers
--------------------------------
1. Primary vs Unique vs Foreign key

Primary: uniquely identifies row, only one per table.
Unique: also unique but can be multiple.
Foreign key: refers to primary key of another table.


2. Indexing — pros and cons

Pros: faster search, better performance.
Cons: slower inserts/updates, takes memory.


3. Delete vs Truncate vs Drop

Delete: removes rows, can rollback.
Truncate: removes all data, cannot rollback.
Drop: removes table itself.


4. ACID properties

Atomicity, Consistency, Isolation, Durability.
Ensures reliable transactions and data safety.


5. Normalization vs Denormalization

Normalization removes redundancy.
Denormalization increases redundancy for better performance.


6. SQL Injection and prevention

Hacker injects malicious SQL into query.
Use prepared statements, validations, ORM.


7. Group By → Having → Order By

Group rows → filter groups → sort final data.
This is the correct execution sequence.




*/




//********************************************************************************************************************************************************
//********************************************************************************************************************************************************




/*

✅ CORE JAVA – Quick Revision (Fresher → 5+ yrs)
1. What is the difference between class and object?

A class is a blueprint, and an object is the actual real entity created from it.
Class defines properties and behaviors; object uses them.
Example: Car is class; myCar is object.

2. What is constructor chaining?

Calling one constructor from another inside the same class or parent class.
Achieved using this() or super().
It helps reuse initialization code.

3. Why is multiple inheritance not allowed in Java?

To avoid the diamond problem.
If two parents have same method, compiler cannot decide which to use.
Interfaces solve this problem safely.

4. What is composition?

HAS-A relationship between classes.
Example: Car has Engine.
It provides better flexibility than inheritance.

5. Why is String immutable?

For thread-safety, caching, security, and performance.
Strings are stored in String pool, so immutability avoids accidental changes.
It also improves hash performance.

6. What is the difference between == and equals()?

== checks reference (memory address).
equals() checks content.
String overrides equals() but == may fail.

7. What is wrapper class and why needed?

Primitive → Object form (int → Integer).
Used for collections, generics, serialization, and null handling.

8. What is static block?

A block that runs once when the class loads.
Used for initialization logic like loading drivers.

9. What is method hiding?

When subclass declares a static method with same signature as parent.
Static methods are resolved at compile time.

10. What is the difference between final, finally, finalize()?

final → keyword (fix variable/method/class).
finally → block in exception handling.
finalize() → called by GC before object removal.

✅ COLLECTIONS – Quick Revision
1. Difference between Collection and Collections?

Collection → interface (List, Set, Queue).
Collections → utility class with methods like sort, reverse.

2. What is Set? Why does it not allow duplicates?

Set stores unique elements.
It uses hashing (HashSet) or trees (TreeSet) to avoid duplicates.

3. Why is HashSet faster than TreeSet?

HashSet uses hashing → O(1).
TreeSet uses trees → O(log n).
TreeSet keeps sorted order.

4. What is Iterator and ListIterator?

Iterator → forward only, supports removal.
ListIterator → bidirectional, supports add/update.

5. What is ConcurrentModificationException?

Occurs when you modify a collection while iterating.
Fail-fast iterators throw it.

6. What is LinkedHashMap?

Maintains insertion order.
Useful for LRU cache using removeEldestEntry.

✅ JAVA 8 – Quick Revision
1. What is a functional interface?

An interface with exactly one abstract method.
Examples: Runnable, Callable, Comparator.
Used with lambdas.

2. Why streams do not store data?

Stream is a view, not a storage.
It processes data on-demand using pipelines.

3. What is method reference?

Shortcut of lambda to call existing method.
Example: System.out::println.

4. What is Collectors.toMap() used for?

Collect stream into Map.
Requires handling duplicate keys for safety.

5. How does filter() work internally?

It checks each element with a condition.
If true → passes to next stage; else discarded.

6. Why Optional is better than null checks?

Avoids NullPointerException.
Compact and cleaner handling of missing values.

✅ MULTITHREADING – Quick Revision
1. What is synchronization?

Allows only one thread to access critical section.
Prevents inconsistent data.

2. What is deadlock?

Two threads wait forever for each other’s locked resource.
Occurs due to circular wait.

3. What is Callable vs Runnable?

Runnable → no return value, no checked exception.
Callable → returns value, can throw exception.

4. What is Future and CompletableFuture?

Future → represents async result but blocking.
CompletableFuture → async + non-blocking + chaining.

5. What is thread starvation?

Low priority threads never get CPU.
Happens in unfair lock or high load system.

✅ SPRING CORE – Quick Revision
1. What is Dependency Injection?

Spring injects dependencies automatically.
Helps loose coupling and testability.

2. What is BeanPostProcessor?

Runs before and after bean initialization.
Used for custom logic like proxies and AOP.

3. @ComponentScan – why required?

Tells Spring where to search for beans.
Without it, beans won’t load.

4. @Lazy vs @Scope("prototype")

@Lazy loads bean on-demand.
prototype creates new bean each time requested.

5. How does AOP work internally?

Uses dynamic proxies to wrap methods.
Adds extra logic without changing core code.

✅ SPRING MVC – Quick Revision
1. What is ViewResolver?

It maps controller return values to actual JSP/HTML pages.
Example: "home" → /WEB-INF/home.jsp.

2. What is Model?

Used to pass data from controller to view.
model.addAttribute("msg", value).

3. Difference between GET and POST?

GET → fetch data, parameters visible.
POST → send data, secure.

✅ SPRING REST – Quick Revision
1. What is @RestController?

Controller returning JSON response.
No need of @ResponseBody.

2. What is ResponseEntity?

Helps send custom status codes + headers + body.

3. What is versioning in REST?

Different API versions using URL or headers.
Example: /api/v1/users.

4. What is HATEOAS?

API returns links with response for navigation.
More RESTful.

✅ SPRING BOOT – Quick Revision
1. What is actuator?

Provides production-ready endpoints: health, metrics, info.
Used for monitoring.

2. What is profiles in Spring Boot?

Run app with environment-specific config (dev/test/prod).
Use @Profile("dev").

3. How does embedded server work?

Spring Boot bundles Tomcat/Jetty.
Starts automatically at application startup.

4. What is custom starter?

Reusable module with auto-config.
Used for internal libs.

✅ SPRING DATA JPA – Quick Revision
1. What is EntityManager?

Core JPA interface to manage persistence context.
Spring Data hides it but uses it internally.

2. What is persistence context?

First-level cache inside session.
Ensures same entity is reused.

3. What is dirty checking?

JPA auto-detects changes and updates DB.
No need to write update queries.

4. What is cascading?

Allows operations to flow from parent to child.
Example: save parent → save children.

5. What is fetch type?

EAGER loads immediately; LAZY loads when required.

✅ MICROSERVICES – Quick Revision
1. What is distributed logging?

Central logging for multiple microservices.
Tools: ELK, Splunk.

2. What is API throttling?

Limit number of requests to avoid overload.
Handled at Gateway.

3. What is config server?

Central configuration for all services.
Supports dynamic refresh.

4. What is sidecar pattern?

Attach helper container to main service (logging, proxy).

✅ SPRING SECURITY – Quick Revision
1. What is Authentication vs Authorization?

Authentication → who you are.
Authorization → what you can access.

2. What is SecurityFilterChain?

Defines all security rules in Spring Boot 3+.
Replaces WebSecurityConfigurerAdapter.

3. What is BCrypt?

Strong hashing algorithm used for passwords.
Auto adds salt.

4. What is CSRF?

Attacker tricks user to perform unwanted actions.
Disabled for REST APIs.

✅ SQL – Quick Revision
1. What is view and why used?

Virtual table based on query.
Improves security and simplifies complex joins.

2. What are joins?

INNER, LEFT, RIGHT, FULL, CROSS.
Used to combine tables based on keys.

3. What is stored procedure?

Precompiled SQL code.
Improves performance and reusability.


*/



//********************************************************************************************************************************************************
//********************************************************************************************************************************************************




/*



🔹 Core Java + OOPs
--------------------
0️⃣1️⃣ Explain the difference between Abstraction and Encapsulation.

Abstraction hides the implementation details and shows only functionality to the user.
Example: Interfaces or abstract classes.

Encapsulation hides the internal state of an object and provides access via getters/setters.

Abstraction is about what an object does; Encapsulation is about how it stores data safely.



0️⃣2️⃣ How do you create an Immutable Class in Java?

Declare the class final so it cannot be extended.

Make all fields private and final.

Initialize fields via constructor only.

Provide no setters, only getters.

If fields are mutable objects, return defensive copies in getters.



0️⃣3️⃣ What’s the difference between String, StringBuilder, and StringBuffer?

String → immutable, every modification creates a new object.

StringBuilder → mutable, fast, not thread-safe.

StringBuffer → mutable, thread-safe (synchronized), slightly slower.



0️⃣4️⃣ What’s the internal working of HashMap?

HashMap stores key-value pairs using hash codes.

It uses buckets (array) + linked list/tree for collisions.

Key’s hashCode() determines the bucket; equals() checks uniqueness.

From Java 8, linked list transforms into red-black tree if too many collisions.



0️⃣5️⃣ How does ConcurrentHashMap handle concurrency differently from Hashtable?

Hashtable → synchronizes all methods, blocking every thread (low performance).

ConcurrentHashMap → uses bucket-level locking (Java 7) or lock-free techniques (Java 8+) for better concurrency.

Multiple threads can read and write simultaneously without global locking.



0️⃣6️⃣ What’s the difference between Comparable and Comparator?

Comparable → defines natural ordering (compareTo()), implemented in the class itself.

Comparator → defines custom ordering (compare()), implemented outside the class.

Comparator allows multiple sorting strategies; Comparable allows only one.



0️⃣7️⃣ Explain Garbage Collection and what triggers it.

Garbage Collection (GC) automatically frees memory occupied by unreachable objects.

Triggered when Heap memory is full or JVM decides to clean unused objects.

Types: Serial, Parallel, CMS, G1 GC.

Helps prevent memory leaks but doesn’t guarantee immediate destruction.



0️⃣8️⃣ What are checked vs unchecked exceptions?

Checked → checked at compile-time, must be handled or declared (e.g., IOException).

Unchecked → runtime exceptions, need not be declared (e.g., NullPointerException).

Checked for recoverable scenarios; unchecked for programming errors.



0️⃣9️⃣ How does JVM memory work (Heap, Stack, Metaspace)?

Heap: stores objects, garbage-collected memory.

Stack: stores method calls and local variables (LIFO).

Metaspace: stores class metadata, replaces PermGen in Java 8+.

JVM manages memory allocation, deallocation, and GC automatically.



0️⃣🔟 What’s the difference between == and equals()?

== → compares memory/reference (are both objects same in memory?).

equals() → compares logical equality (content of objects).

For Strings, == may fail; always use equals() for content comparison.



🔹 Java 8 + Stream API
-----------------------
1️⃣1️⃣ Write a Stream API query to find the 2nd-highest salary from a list.

Optional<Integer> secondHighest = employees.stream()
    .map(Employee::getSalary)
    .distinct()
    .sorted(Comparator.reverseOrder())
    .skip(1)
    .findFirst();


distinct() removes duplicates, sorted() in descending order, skip(1) jumps the highest.



1️⃣2️⃣ What are Functional Interfaces and how do you define one?

An interface with exactly one abstract method.

Can have default and static methods.

Annotate with @FunctionalInterface (optional but recommended).

Example: Runnable, Comparator, Predicate, Function.



1️⃣3️⃣ Difference between map() and flatMap() in Streams.

map() → transforms each element into exactly one output element.

flatMap() → transforms each element into zero or more elements and flattens the result.

Use flatMap when the function returns a Stream or collection.



1️⃣4️⃣ How do you handle null values using Optional?

Optional prevents NullPointerException.

Example: Optional.ofNullable(value).orElse(defaultValue).

Methods: isPresent(), ifPresent(), orElse(), orElseGet(), orElseThrow().



1️⃣5️⃣ What is the purpose of method references?

Method references (Class::method) simplify lambda expressions.

Types: static (Class::staticMethod), instance (obj::instanceMethod), constructor (Class::new).

Improves readability and reduces boilerplate.



🔹 Spring Boot & Framework Concepts
------------------------------------
1️⃣6️⃣ Difference between @Component, @Service, and @Repository.

@Component → generic bean.

@Service → business logic layer.

@Repository → DAO layer, also converts SQL exceptions to DataAccessException.

All are detected during component scanning.



1️⃣7️⃣ What is Dependency Injection and how does Spring manage it?

DI is injecting dependencies instead of creating objects manually.

Spring uses IoC container to manage object creation, wiring, and lifecycle.

Types: constructor, setter, or field injection.



1️⃣8️⃣ How does Spring Boot Auto Configuration work?

Spring Boot checks the classpath and beans and auto-configures required components.

Example: adding spring-boot-starter-web creates DispatcherServlet, Tomcat, etc.

Reduces boilerplate and speeds up development.



1️⃣9️⃣ Explain Bean Lifecycle in Spring.

Bean instantiation

Property injection

BeanNameAware / BeanFactoryAware

@PostConstruct or init-method

Ready to use

@PreDestroy or destroy-method before destruction



2️⃣0️⃣ What’s the difference between @Controller and @RestController?

@Controller → returns view (JSP, HTML).

@RestController → returns data (JSON/XML) directly using @ResponseBody.



2️⃣1️⃣ How do you handle exceptions globally in Spring Boot?

Use @ControllerAdvice + @ExceptionHandler.

Handles exceptions from all controllers centrally.

Can return custom response structures for API errors.



2️⃣2️⃣ What’s the role of application.properties / application.yml?

Store configuration like database, server port, logging.

Supports environment-specific settings and easy externalization.


🔹 SQL & JPA
-------------
2️⃣3️⃣ Write query to fetch 3rd highest salary from table.

SELECT DISTINCT salary
FROM employee
ORDER BY salary DESC
LIMIT 1 OFFSET 2;


DISTINCT avoids duplicates, OFFSET 2 skips top 2 salaries.

Works in MySQL/PostgreSQL. Use ROW_NUMBER() in SQL Server.


2️⃣4️⃣ Explain JOINs.

INNER JOIN: only matching rows.

LEFT JOIN: all rows from left + matching from right.

RIGHT JOIN: all rows from right + matching from left.

FULL JOIN: all rows from both sides.



2️⃣5️⃣ What is lazy loading and eager loading in Hibernate?

Lazy loading: fetch data only when accessed (FetchType.LAZY).

Eager loading: fetch data immediately (FetchType.EAGER).

Helps optimize performance and reduce unnecessary DB queries.



2️⃣6️⃣ How do you implement pagination in JPA?

Pageable pageable = PageRequest.of(0, 10); 
Page<Employee> page = employeeRepository.findAll(pageable);


Fetch results in chunks (pages) instead of all records.



2️⃣7️⃣ What’s the difference between save(), saveAndFlush(), and persist()?

save(): persists entity, flush is not guaranteed immediately.

saveAndFlush(): saves and forces immediate DB flush.

persist(): JPA standard method, entity must be in transaction, flushes at commit.




🔹 Advanced Java / Multithreading
---------------------------------
0️⃣1️⃣ Explain synchronized, volatile, and ReentrantLock.

synchronized → locks a method/block so only one thread executes at a time.

volatile → ensures visibility of changes across threads without locking.

ReentrantLock → explicit lock object, more flexible than synchronized (can tryLock, interruptible lock).


0️⃣2️⃣ What’s difference between ExecutorService and ForkJoinPool?

ExecutorService → general-purpose thread pool, executes Runnable/Callable tasks.

ForkJoinPool → specialized for recursive divide-and-conquer tasks (splitting large tasks into subtasks).

ForkJoinPool uses work-stealing algorithm for efficiency.



0️⃣3️⃣ How would you handle deadlocks in a multithreaded system?

Identify circular waits using thread dumps or monitoring.

Use timeout locks (tryLock with timeout) instead of blocking locks.

Lock ordering consistently can prevent circular dependencies.

Detect & resolve deadlock programmatically if needed.



0️⃣4️⃣ Explain the Producer-Consumer problem using wait() and notify().

Producer adds items to a shared buffer; consumer removes items.

Use synchronized on buffer, wait() when buffer is full/empty.

Use notify() or notifyAll() to wake waiting threads.

Ensures proper coordination without busy-waiting.



0️⃣5️⃣ What’s the difference between Callable and Runnable?

Runnable → no return value, cannot throw checked exceptions.

Callable → returns a value (via Future) and can throw exceptions.

Callable is preferred when task result or exception handling is needed.


🔹 Spring Boot & Microservices
------------------------------
0️⃣6️⃣ Explain @Transactional propagation types.

REQUIRED: join existing transaction or create new.

REQUIRES_NEW: suspend current and start new transaction.

SUPPORTS: run within transaction if exists.

MANDATORY: must run in existing transaction; else exception.

NOT_SUPPORTED: suspend current transaction.

NEVER: throws exception if transaction exists.

NESTED: runs nested transaction using savepoints.



0️⃣7️⃣ How do you implement circuit breaker in microservices?

Prevent cascading failures if a service is failing.

Use Resilience4j or Hystrix to wrap calls.

Open circuit when failures exceed threshold; retry later.

Allows fallback methods and controlled failure handling.



0️⃣8️⃣ Difference between Feign Client, RestTemplate, and WebClient.

RestTemplate → synchronous HTTP calls, older style.

WebClient → reactive, async, non-blocking (Spring WebFlux).

Feign Client → declarative HTTP client, integrates with service discovery, easier to use.



0️⃣9️⃣ How do you handle service discovery and load balancing?

Use Eureka/Nacos/Consul for service discovery.

Client or server-side load balancing distributes traffic.

Spring Cloud integrates Ribbon (deprecated) or Spring Cloud LoadBalancer.



1️⃣0️⃣ How would you design a Rate Limiter for an API (Bucket4J / Redis)?

Use token bucket algorithm to allow X requests per time window.

Bucket4J → in-memory or Redis-based for distributed systems.

Prevents abuse and ensures fair API usage.


🔹 System Design & Architecture
-------------------------------
1️⃣1️⃣ Design a URL Shortener service (TinyURL-style).

Generate short code for long URLs using hash or base62 encoding.

Store mapping in DB (Redis or SQL).

Redirect endpoint fetches long URL using short code.

Handle collisions, analytics (clicks), and expiration if needed.



1️⃣2️⃣ How would you design a payment gateway microservice?

Expose endpoints for transaction creation, status, refund.

Integrate with payment processors (Stripe/PayPal).

Use idempotency keys to avoid duplicate charges.

Include audit logging, retries, and secure credentials.



1️⃣3️⃣ Explain Event-Driven Architecture using Kafka or RabbitMQ.

Microservices communicate via events/messages, decoupled from each other.

Producer publishes event → broker (Kafka/RabbitMQ) → consumer subscribes.

Improves scalability, asynchronous processing, and fault tolerance.



1️⃣4️⃣ What’s the role of API Gateway in microservices?

Single entry point for all clients.

Handles routing, authentication, rate limiting, and aggregation.

Examples: Spring Cloud Gateway, Kong, NGINX.



1️⃣5️⃣ Achieve fault tolerance and high availability in distributed systems?

Replication → multiple instances of service/database.

Load balancing → distribute requests.

Circuit breakers, retries, fallbacks → prevent cascading failures.

Monitoring & alerting → detect and handle issues early.


🔹 Docker, CI/CD, Deployment
-----------------------------
1️⃣6️⃣ Difference between a Docker Image and a Docker Container?

Image: immutable template with app + environment.

Container: running instance of an image.

Image is static; container is dynamic and ephemeral.



1️⃣7️⃣ How do you write a Dockerfile for a Spring Boot application?

FROM openjdk:17-jdk-alpine
COPY target/app.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8080

Builds an image that runs your JAR in an isolated container.



1️⃣8️⃣ Explain how Docker Compose helps in managing multiple services.

Defines multiple containers in a single YAML file.

Handles networking, volume mounts, and environment variables.

Start all services with a single command (docker-compose up).



1️⃣9️⃣ Best practices for Dockerizing Java apps (JARs)?

Use slim base images (alpine/openjdk-slim).

Avoid running as root; set memory limits.

Separate build and runtime stages using multi-stage builds.



2️⃣0️⃣ How would you deploy your Spring Boot app to AWS ECS or Kubernetes?

Build Docker image → push to ECR/DockerHub.

ECS → define task, service, cluster; Kubernetes → create deployment + service.

Use ConfigMaps/Secrets for environment configs.



🔹 Database & Performance
--------------------------
2️⃣1️⃣ What is connection pooling, and how does HikariCP help performance?

Connection pooling reuses DB connections instead of creating each time.

HikariCP is fast, lightweight, and manages max/min pool size efficiently.

Reduces DB connection overhead and improves throughput.



2️⃣2️⃣ Explain indexes & how do they improve query performance?

Index → data structure (B-tree, hash) to speed up searches.

Reduces full table scans.

Trade-off: slows inserts/updates because index needs maintenance.



2️⃣3️⃣ Difference between ACID and BASE transactions?

ACID: strict consistency, reliable, used in RDBMS.

BASE: eventually consistent, highly available, used in distributed NoSQL systems.



2️⃣4️⃣ Implement read-replicas for scaling reads?

Use primary DB for writes and replica DBs for reads.

Distribute read traffic to replicas to reduce load on master.

Helps in horizontal scaling for read-heavy systems.



2️⃣5️⃣ How do you debug N+1 queries in JPA?

Enable SQL logging to detect multiple queries per entity.

Use fetch joins (JOIN FETCH) or entity graphs to reduce extra queries.

Lazy loading might be causing repeated queries in loops.


🔹 Case-Based / Troubleshooting Questions
-----------------------------------------
2️⃣6️⃣ A microservice is failing intermittently under load – how do you investigate?

Check logs, metrics (CPU, memory, threads).

Monitor DB or dependent services for bottlenecks.

Use profiling and load testing to identify issues.



2️⃣7️⃣ API response time suddenly doubled – how would you troubleshoot?

Check recent deployments, database queries, caching layers.

Analyze logs and monitoring metrics.

Use profiling or distributed tracing (Jaeger/Zipkin).



2️⃣8️⃣ A new deployment increased DB CPU usage – steps?

Identify slow queries or indexes missing.

Check connection pool saturation.

Rollback deployment if needed; optimize queries or add read-replicas.



2️⃣9️⃣ How do you handle retry logic in REST calls safely?

Use exponential backoff to avoid flooding.

Handle idempotent operations to avoid duplicates.

Limit max retries and implement circuit breaker patterns.



3️⃣0️⃣ Design a notification service (email/SMS/push) using microservices & Kafka.

Producers send notification requests to Kafka topic.

Consumers pick up messages asynchronously and send notifications.

Use retry and DLQ (dead-letter queue) for failures.

Provides scalable, decoupled, and fault-tolerant notification system.





*/