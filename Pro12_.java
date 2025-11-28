package com.nt.coding.challanges;

public class Pro12_ {
	
	public static void main(String[] args) {
		System.out.println("Pro12_.main()");
	}
}


/*

✅ CORE JAVA
-------------

1️⃣ Internal working of Java Streams + Lazy evaluation

Streams use pipeline processing → Source → Intermediate Ops → Terminal Op.

Intermediate operations like map, filter are lazy (they don’t execute immediately).

Only the terminal operation (like collect, reduce, forEach) triggers execution.

Streams internally use Spliterator for splitting data and parallel processing.

Advantages: less memory use, faster execution, clean code.




2️⃣ HashMap vs LinkedHashMap vs TreeMap (Internals)
HashMap

Uses array + linked list + balanced tree (after Java 8).

No order guaranteed.

LinkedHashMap

Same internal structure but adds a doubly-linked list to maintain insertion order.

TreeMap

Uses Red-Black Tree.

Always sorted based on keys.




3️⃣ JVM Memory Internals (Heap, Stack, Metaspace)

Stack = method calls + local variables, created per thread.

Heap = object memory, shared by all threads.

Metaspace = stores class metadata (replaced PermGen).

JVM uses GC to clean unused objects from the heap.

This structure prevents memory leakage and improves performance.




4️⃣ Garbage Collector in Java 11/17 (How it works?)

Java 11 uses G1GC (default) → splits heap into small regions.

GC cleans young generation first → moves surviving objects to old gen.

Java 17 supports ZGC and Shenandoah (near-zero pause GC).

GC uses mark → scan → compact phases internally.

Goal: remove unused objects without stopping the application.




5️⃣ CompletableFuture (What problem it solves?)

Solves callback hell + parallel async tasks.

Runs tasks in separate thread pool (ForkJoinPool).

Supports chaining: thenApply, thenCombine, thenAccept.

Allows non-blocking API calls and parallel workflows.

Reduces waiting time and improves performance.

🏗️ SPRING & SPRING BOOT
------------------------

6️⃣ How Spring Boot does Auto-Configuration?

Reads spring.factories / META-INF and loads auto-config classes.

Uses @ConditionalOnClass, @ConditionalOnMissingBean to decide bean creation.

Scans classpath + creates required beans automatically (DataSource, MVC, JPA).

Developer writes zero configuration.

Reduces boilerplate drastically.




7️⃣ What happens when REST endpoint is called?

Request hits DispatcherServlet.

HandlerMapping finds correct controller method.

HandlerAdapter executes method.

Response is converted (via HttpMessageConverters).

Sent back as JSON/XML.




8️⃣ Singleton vs Prototype (Real project explanation)

Singleton = only one object created for entire application.

Example: Service classes, Utils → shared by all users.

Prototype = new object created each time you request it.

Example: New Form object per request.

Singleton = shared, Prototype = fresh objects.




9️⃣ How @Transactional ensures rollback?

Spring uses proxy around your method.

Proxy opens a transaction before method executes.

If exception occurs → proxy triggers rollback.

If success → proxy commits.

Works with JPA EntityManager and Hibernate session.




🔟 RestTemplate vs WebClient
RestTemplate

Blocking, synchronous HTTP calls.

One request = one thread waits.

WebClient

Non-blocking, asynchronous, reactive.

Can handle huge load with few threads.

Use case:

Small apps = RestTemplate

Microservices + heavy traffic = WebClient




☁️ MICROSERVICES
-----------------

1️⃣1️⃣ Sync vs Async Communication

Sync: Request → Wait → Response (REST calls).

Async: No waiting, send message and continue (Kafka, RabbitMQ).

Async improves performance, sync is simpler for CRUD operations.




1️⃣2️⃣ Fault-Tolerant Microservice Design

Use Retry, Circuit Breaker, Bulkhead, Fallback.

Use Resilience4j or Hystrix.

Keep services stateless + scalable vertically & horizontally.

Add caching, rate limiting, timeout.

Design for failures, not for ideal conditions.




1️⃣3️⃣ API Gateway vs Load Balancer
API Gateway

Handles routing, authentication, rate limiting, logging.

Example: Spring Cloud Gateway, Kong.

Load Balancer

Distributes traffic to multiple services.

Example: NGINX, AWS ELB.

Gateway = smart gate
LB = traffic manager.




1️⃣4️⃣ Distributed Tracing (Zipkin/Jaeger)

Assigns a trace ID to each request.

Follows request across 5–10 microservices.

Collects latency, errors, fallbacks.

Zipkin/Jaeger store and visualize the traces.

Helps debug slow API chains.




1️⃣5️⃣ API Versioning

URL based → /api/v1/users.

Header based → X-API-VERSION: 1.

Parameter based → /users?version=1.

Useful for backward compatibility without breaking old clients.




🗄️ DATABASE & PERFORMANCE
--------------------------

1️⃣6️⃣ How Connection Pooling works (HikariCP)?

Creates few pre-initialized DB connections.

Reuses them for all requests.

Avoids cost of opening/closing DB connections.

HikariCP is fastest due to low latency, optimized code, low GC impact.




1️⃣7️⃣ Optimistic vs Pessimistic Locking

Optimistic: No lock → assumes no conflicts → checks version on commit.

Pessimistic: Locks row during read → no other writer allowed.

Real-life:

Optimistic = trusting no one takes your seat.

Pessimistic = reserving the seat.




1️⃣8️⃣ Efficient Pagination

Use LIMIT OFFSET for simple cases.

Use keyset pagination for large data → much faster.

Avoid SELECT *.

Always use indexes for fields used in pagination.




1️⃣9️⃣ Query Optimization using Indexes

Index = sorted structure to speed up search.

Speeds up WHERE, JOIN, ORDER BY.

Avoid indexing small tables & frequently updated fields.

Composite indexes help multiple-column queries.




2️⃣0️⃣ N+1 Select Problem

One query for parent + N queries for children.

Caused by Lazy Loading.

Fix using JOIN FETCH, EntityGraph, or batch size.

Reduces 100 queries to 1–2 queries.



//=================================================================================================================




🔥 𝗖𝗢𝗥𝗘 𝗝𝗔𝗩𝗔
------------

✅ OOPS Concepts with Real-Time Examples
1. Encapsulation

Binding data + methods together.

Example: BankAccount class hides balance (private) and exposes deposit(), withdraw().

2. Inheritance

One class extends another.

Example: Car extends Vehicle. Car inherits engine, wheels from Vehicle.

3. Polymorphism

One interface, many implementations.

Example: Payment pay = new CreditCardPayment();

4. Abstraction

Show only essential details.

Example: Car driver presses accelerator → internal engine logic is hidden.




✅ Method Overloading vs Overriding
Overloading

Same method name, different parameters.

Happens at compile time.

Example: add(int a), add(int a, int b).

Overriding

Child class gives new implementation to parent method.

Happens at runtime.

Example: class SBI extends Bank overrides getInterest().




✅ Covariant Return Type

Child class method can return subclass of the return type used in parent.
Example:

class A { A get(){} }  
class B extends A { B get(){} }


Helps in method chaining.




✅ Abstract Class vs Interface (When to Use?)
Abstract Class

Partial abstraction (can have concrete methods).

Use when classes share common behavior.
Example: Vehicle abstract class having startEngine().

Interface

100% abstraction (till Java 7) / default methods allowed (Java 8+).

Use to provide capability.
Example: Comparable, Runnable.




✅ Why Encapsulation Is Needed

Protects data.

Controls access using getters/setters.

Useful for validation e.g., no negative balance.

Makes code more maintainable & secure.



✅ String vs StringBuilder vs StringBuffer

Feature			String		StringBuilder		StringBuffer
Mutability		Immutable	Mutable				Mutable
Thread-safe		No			No					Yes
Speed			Slow		Fast				Slower than SB

Real-time:

String → constants, messages

StringBuilder → building JSON, loops

StringBuffer → multithreaded logging




✅ How to Create an Immutable Class

Make class final.

All fields private + final.

No setters.

Deep copy mutable fields.

Only getters allowed.




✅ JVM Memory Model

Heap: Objects

Stack: Local variables, method calls

Metaspace: Class metadata

PC Register: Current instruction

Native Memory: Native code




✅ Garbage Collection Types

Serial GC → single thread

Parallel GC → multithreaded

CMS → low pause

G1GC → region-based, default

ZGC → ultra-low pause




✅ HashMap Internal Working

Uses array of buckets → each bucket has linked list / tree.

Key converted to hash → index = hash % arraySize.

Collisions handled using LinkedList → later Tree (balanced).

Resize happens when load factor > 0.75.




✅ HashMap vs ConcurrentHashMap

HashMap is not thread-safe, allows NULL.

ConcurrentHashMap is thread-safe using segment locking, no NULL allowed.




✅ Fail-fast vs Fail-safe

Fail-fast throws ConcurrentModificationException (Iterator on ArrayList).

Fail-safe does not throw (Iterator on ConcurrentHashMap).




✅ ArrayList vs LinkedList
Feature	ArrayList	LinkedList
Storage	Dynamic array	Doubly linked list
Access speed	Fast O(1)	Slow O(n)
Insert/delete middle	Slow	Fast




✅ volatile, transient, ThreadLocal

volatile → visibility across threads

transient → skip during serialization

ThreadLocal → one variable per thread (e.g., requestId)




✅ Thread Lifecycle

New → Runnable → Running → Waiting → Terminated.

ExecutorService

Manages thread pools.

Reuses threads → improves performance.



🔥 𝗝𝗔𝗩𝗔 𝟴
---------

✅ Streams Internal Flow

Uses lazy evaluation.

Only processed when terminal operation is called.

Uses Spliterator for parallel execution.




✅ Intermediate vs Terminal Ops

Intermediate: map, filter, sorted. Lazy.

Terminal: collect, forEach, reduce. End the stream.




✅ map vs flatMap

map → one-to-one transform

flatMap → flatten nested lists/streams




✅ Optional Class

Used to avoid null checks.

Methods: isPresent(), orElse(), orElseThrow().




✅ Functional Interfaces

Predicate<T> → boolean test

Function<T,R> → input → output

Consumer<T> → accepts input, no return

Supplier<T> → returns, no input




✅ Default & Static Methods in Interface

Default → reusable method body

Static → utility methods inside interface




🔥 𝗦𝗣𝗥𝗜𝗡𝗚 & 𝗦𝗣𝗥𝗜𝗡𝗚 𝗕𝗢𝗢𝗧
----------------------

✅ IoC & Dependency Injection

IoC → Spring controls object creation.

DI → Spring injects objects into other objects.




✅ @Component vs @Service vs @Repository

@Component → generic bean

@Service → business logic

@Repository → DB-layer + exception translation




✅ @Autowired vs @Qualifier vs @Primary

@Autowired → inject bean

@Qualifier → choose specific bean

@Primary → default bean




✅ Bean Scopes

Singleton → one object

Prototype → new each time

Request / Session → web apps




✅ Bean Lifecycle

Instantiation

Dependency Injection

@PostConstruct

Use

@PreDestroy




✅ AOP Real-World Use

Logging

Security

Transaction management

Audit logs




✅ Auto-Configuration Internals

Spring scans classpath.

Loads beans using @Conditional logic.

All auto-configs defined in META-INF/spring.factories.




✅ What @SpringBootApplication Includes?

@Configuration

@EnableAutoConfiguration

@ComponentScan




✅ Disabling Auto-Configuration
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)




✅ DispatcherServlet Flow

Request → DispatcherServlet → HandlerMapping → Controller → ViewResolver → Response.




@RequestParam vs @PathVariable

Query param → ?id=10

Path variable → /user/10




@RestController vs @Controller

RestController = JSON response by default

Controller = HTML views (Thymeleaf)




ControllerAdvice

Centralized exception handling.




Lazy vs Eager Loading

Lazy → load when needed

Eager → load immediately




@Query

Custom SQL/JPQL query.




🔥 𝗠𝗜𝗖𝗥𝗢𝗦𝗘𝗥𝗩𝗜𝗖𝗘𝗦
---------------

Monolithic vs Microservices Architecture

Monolith → one big app

Microservices → multiple small independent services




API Gateway

Single entry point

Handles routing, auth, rate limiting




Service Registry & Discovery

Eureka/Consul → services register & discover each other.

Circuit Breaker Pattern

Stops calling a failing service

Uses Resilience4j




Saga Pattern

For distributed transactions

Orchestrator → central controller

Choreography → event-driven




Idempotency

Same request executed multiple times → same output

Important in payments




Sync vs Async Communication

Sync → REST

Async → Kafka/RabbitMQ




Feign vs RestTemplate vs WebClient

Feign → easy declarative client

RestTemplate → blocking

WebClient → non-blocking




JWT vs OAuth2

JWT → self-contained token

OAuth2 → third-party authorization




Method-Level Security

@PreAuthorize, @Secured

Caching Strategies

Read-through, write-through, write-behind




🔥 𝗦𝗤𝗟 & 𝗗𝗔𝗧𝗔𝗕𝗔𝗦𝗘
-----------------

Primary vs Unique vs Foreign Key

Primary: unique + not null

Unique: unique but can be null

Foreign: reference to another table




Indexing Pros & Cons

Pros: faster read
Cons: slower write, consumes memory




Delete vs Truncate vs Drop

Delete → removes rows

Truncate → removes all rows (fast)

Drop → removes table




ACID

Atomicity, Consistency, Isolation, Durability




Normalization vs Denormalization

Normalization → remove redundancy

Denormalization → improve read speed




SQL Injection Prevention

Use PreparedStatement

Validate inputs

Group By → Having → Order By

Group rows → filter groups → sort output






*/