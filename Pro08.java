package com.nt.coding.challanges;

import java.io.IOException;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

class A101 {
	
	public void m1() throws Exception {
		System.out.println("A.m1()");
	}
}

public class Pro08 extends A101 {
	
	public void m1() throws  IOException { 
		System.out.println("A.m1()");
	}
	
	public static void main(String[] args) {
		
		String str = "complete";
		
		Object obj = str; 

		/*	c - 1
			o - 1
			m - 1 
			p - 1
			l - 1 
			e - 2
			t - 1
		*/

		Map<Character, Long> map = str.chars()
						.mapToObj(ch -> (char)ch)
						.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		System.out.println(map);
		
		
		
	}
}


/*
OOP
is java is object oriented programming
types of creating object in java
serialization
types of conversion
Implecit, Explicit, narrowing
Autoboxing and AutoUnboxing
LinkedHashSet and LinkedHashMap
LinkedHashMap Internal Working
array and list
throw and throws
map(), flatMap()
concurrentHashMap -> how to resolve it

Dependency Injection
Types of Dependency Injection
@RestController, @Controller
@RequestMapping, @GetMapping, @PostMapping, @PutMapping, @DeleteMapping
@SpringBootApplication
Log4j


useEffect()
Component
Bootstrap

*/










/*

🔹 1. throw vs throws (Full Deep Explanation)
✅ Definition

throw → is used inside a method to actually throw an exception object.

throws → is used in the method signature to declare that the method might throw an exception.

✅ Detailed Explanation
Feature	throw	throws
Purpose	Used to throw an exception explicitly.	Used to declare which checked exceptions might be thrown.
Location	Inside a method or block.	After method name in declaration.
Type	Can only throw one exception at a time.	Can declare multiple exceptions separated by commas.
Keyword Usage	Followed by an exception object.	Followed by exception class names.
Example	throw new IOException("File not found");	public void read() throws IOException
✅ Example
public void readFile(String path) throws IOException {
    FileReader fr = new FileReader(path);  // may throw FileNotFoundException
    fr.read();
}

public void process() {
    try {
        readFile("abc.txt");
    } catch (IOException e) {
        e.printStackTrace();
    }
}


👉 throws IOException tells the compiler — “I might throw this, handle it when calling.”
👉 throw new IOException() actually throws it.

⚙️ Why we use throws and throw

throw → for custom, controlled error raising.

throws → for checked exceptions, so compiler knows to enforce handling.

⚠️ Common Mistake
public void m1() throws IOException {  // declares
    throw new FileNotFoundException();  // valid (subclass)
}


✅ You can throw a subclass exception if parent is declared.

❌ But not the other way:

public void m1() throws FileNotFoundException {
    throw new IOException(); // ❌ not allowed, parent broader exception
}

🔹 2. Type Conversion (Implicit, Explicit, Narrowing, Widening)
✅ Definition

Java converts data types automatically or manually between different numeric types.

🧠 Types

Implicit Conversion (Widening / Automatic)

Small → Large data type

Done automatically by compiler

Example: int → long → float → double

int a = 10;
double b = a; // implicit widening


Explicit Conversion (Narrowing / Manual)

Large → Small data type

You must cast manually (may lose data)

double d = 10.56;
int i = (int) d; // 10 (fraction lost)

⚙️ Why Narrowing Needs Explicit Cast

Because you may lose data (e.g., converting long to int can overflow).
Java wants the programmer to confirm: “Yes, I know what I’m doing.”

🧩 Example
byte b = 50;
b = (byte) (b * 2); // multiplication promotes to int → explicit cast back to byte


👉 Without (byte), it gives a compile-time error because result of b*2 is int.

🔁 Autoboxing and Unboxing

Autoboxing: Convert primitive → wrapper automatically
int → Integer

Unboxing: Convert wrapper → primitive
Integer → int

Integer i = 10; // autoboxing
int x = i;      // unboxing


🧠 Why needed:
To use primitives in Collections (since generics need objects, not primitives).

🔹 3. LinkedHashSet vs LinkedHashMap
Feature	LinkedHashSet	LinkedHashMap
Implements	Set interface	Map interface
Stores	Only values (unique)	Key-Value pairs
Order	Maintains insertion order	Maintains insertion order
Duplicates	Not allowed	Keys not allowed (values can duplicate)
Use Case	Store unique items with order	Store mappings with predictable iteration order
✅ Example
LinkedHashSet<String> set = new LinkedHashSet<>();
set.add("A"); set.add("B"); set.add("A");
System.out.println(set); // [A, B]

LinkedHashMap<Integer, String> map = new LinkedHashMap<>();
map.put(1, "A"); map.put(2, "B"); map.put(1, "C");
System.out.println(map); // {1=C, 2=B}

🔹 4. LinkedHashMap Internal Working

Extends HashMap + maintains a doubly linked list of entries.

Preserves insertion order (or access order if enabled via constructor).

Every entry has:

before and after pointers.

Uses hashCode() and equals() like HashMap for key lookup.

Optionally supports access-order for LRU cache design.

🧠 Example (Access Order)
LinkedHashMap<Integer, String> map =
    new LinkedHashMap<>(16, 0.75f, true); // accessOrder = true

map.put(1, "A"); map.put(2, "B");
map.get(1); // moves 1 to last
System.out.println(map); // {2=B, 1=A}

🔹 5. Array vs List
Feature	Array	List
Size	Fixed	Dynamic
Type	Can store primitives	Can store only objects
Performance	Faster access (index-based)	Slower (more flexible)
Conversion	Arrays.asList()	list.toArray()
Resizing	Not allowed	Allowed (auto grow/shrink)
✅ Example
String[] arr = {"A", "B"};
List<String> list = new ArrayList<>(Arrays.asList(arr));
list.add("C");

🔹 6. map() vs flatMap() in Java Streams
✅ map()

Used for transforming each element into another form.

Returns Stream<Stream<T>> if mapping creates streams.

List<String> names = Arrays.asList("John", "Jane");
List<Integer> lengths = names.stream().map(String::length).toList();

✅ flatMap()

Used to flatten nested streams or lists.

Converts Stream<Stream<T>> → Stream<T>

List<List<Integer>> list = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 4));
List<Integer> flat = list.stream().flatMap(List::stream).toList();
System.out.println(flat); // [1,2,3,4]


🧠 Simple Example:
map = "list of lists"
flatMap = "flatten them all"

🔹 7. ConcurrentHashMap and its Concurrency Handling
✅ Problem with HashMap

Not thread-safe → modifying while iterating throws ConcurrentModificationException.

✅ ConcurrentHashMap

Thread-safe alternative without using full synchronization.

Divides map into segments (buckets).

Allows concurrent reads and controlled writes.

⚙️ Internal Working

Uses CAS (Compare-And-Swap) for updates.

Locks only a specific bucket, not the entire map.

Since Java 8, uses Node and TreeBin structures (like HashMap).

✅ Example
ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
map.put(1, "A");
map.putIfAbsent(1, "B"); // won't replace
System.out.println(map);


🧠 Why not HashMap in multi-threaded apps?
Because concurrent updates can cause infinite loops or data corruption.

🔹 8. Dependency Injection (DI)
✅ Concept

Spring manages object creation and injects dependencies instead of creating them manually with new.

✅ Types

Constructor Injection

Setter Injection

Field Injection (@Autowired)

✅ Example
@Component
class Engine {}

@Component
class Car {
    private final Engine engine;

    @Autowired
    public Car(Engine engine) {
        this.engine = engine;
    }
}


Spring automatically creates Engine and injects into Car.

🧠 Why DI?

Reduces tight coupling.

Makes testing and maintenance easier.

🔹 9. Spring Annotations
Annotation	Purpose
@RestController	Combines @Controller + @ResponseBody — returns JSON directly.
@Controller	Used for MVC controllers returning views (HTML).
@RequestMapping	Maps request URLs to methods (GET, POST, etc.).
@GetMapping, @PostMapping, etc.	Shortcut for specific HTTP methods.
@SpringBootApplication	Combines @Configuration, @EnableAutoConfiguration, @ComponentScan.
🔹 10. Log4j (Logging Framework)

Used for logging messages instead of System.out.println().

Helps in debugging, auditing, and tracking application flow.

Configurable via XML or properties file.

✅ Example
import org.apache.log4j.Logger;
public class Test {
  static Logger log = Logger.getLogger(Test.class);
  public static void main(String[] args) {
    log.info("Application started");
    log.error("Error occurred");
  }
}





=============================================================================================================================================
=============================================================================================================================================





⚛️ 1. React useEffect() Hook
✅ What It Does

useEffect() is a React Hook used to perform side effects (tasks that affect things outside the component) like:

Fetching data from an API

Updating the document title

Setting up timers or event listeners

✅ Syntax
useEffect(() => {
  console.log("Component mounted or updated");
}, []);

✅ Dependency Array Meaning
Case	Meaning
[] empty	Runs only once (like componentDidMount).
[variable]	Runs when that variable changes.
no array	Runs after every render.
✅ Example
useEffect(() => {
  document.title = "Welcome Gokul!";
}, []);


🧠 Think of useEffect() as “after render, do this extra task.”

⚛️ 2. React Components
✅ What Is a Component

A component is a reusable piece of UI.

Each React app is made of components — like building blocks.

✅ Types

Functional Components

function Welcome() {
  return <h1>Hello Gokul!</h1>;
}


Class Components

class Welcome extends React.Component {
  render() {
    return <h1>Hello Gokul!</h1>;
  }
}


🧠 In simple words:
➡ A function that returns JSX (HTML-like code).
➡ Helps break big UIs into smaller, reusable pieces.

🎨 3. Bootstrap in React or Web Apps
✅ What It Is

Bootstrap is a CSS + JS framework for making responsive, mobile-first UIs quickly.

It provides ready-made components (buttons, cards, modals) and grid layout.

✅ Example
<button class="btn btn-primary">Submit</button>

✅ Grid Example
<div class="container">
  <div class="row">
    <div class="col-md-6">Left</div>
    <div class="col-md-6">Right</div>
  </div>
</div>


🧠 Think of it as “UI shortcut library” — saves time, keeps design consistent.

🧩 4. @SpringBootApplication (Deep Internal Working)
✅ What It Does

@SpringBootApplication = combo of:

@Configuration → allows bean definitions.

@ComponentScan → scans packages for @Component, @Service, etc.

@EnableAutoConfiguration → activates auto-configuration feature.

⚙️ How Auto-Configuration Works

Spring Boot checks your classpath and dependencies.

It loads pre-configured beans automatically (like DataSource, DispatcherServlet, EntityManager).

Controlled via spring.factories or META-INF/spring/org.springframework.boot.autoconfigure.AutoConfiguration.imports

✅ Example

If you add spring-boot-starter-web, Boot automatically:

Configures Tomcat

Registers DispatcherServlet

Sets up Jackson for JSON

Enables @RestController scanning

🧠 You don’t need XML config anymore — Boot does it dynamically.

🧠 5. Spring Dependency Injection (DI) — Deep Concept
✅ Definition

DI means Spring creates objects and injects dependencies automatically instead of using new.

It’s part of Inversion of Control (IoC).

✅ Types

Constructor Injection (Recommended)

@Component
class Car {
    private final Engine engine;
    @Autowired
    Car(Engine engine) { this.engine = engine; }
}


Setter Injection

@Component
class Car {
    private Engine engine;
    @Autowired
    public void setEngine(Engine engine) { this.engine = engine; }
}


Field Injection

@Autowired
private Engine engine;

⚙️ Why Constructor Injection Is Best

Makes class immutable

Easy for unit testing

Forces all dependencies to be available

🧩 6. Spring MVC Request Flow (Internal Lifecycle)
⚙️ Flow Diagram
Client → DispatcherServlet → HandlerMapping → Controller → Service → Repository
       ← ViewResolver ← ModelAndView ← Response

✅ Steps Explained

DispatcherServlet → Entry point for every request.

HandlerMapping → Finds which Controller method to call.

Controller → Handles request, calls service layer.

Service → Business logic.

Repository → Interacts with DB.

ViewResolver → Chooses view (HTML, JSON, etc.).

Response → Sent back to client.

🧠 In REST APIs, ViewResolver sends JSON (not JSP).

🔐 7. Spring Boot Logging (Log4j vs SLF4J)
✅ Log4j

Logging framework from Apache.

Directly logs messages (info, error, debug).

Older, but widely used.

✅ SLF4J

“Simple Logging Facade for Java” — just a facade (layer).

Lets you use any logging implementation (Log4j, Logback) behind it.

✅ Best Practice

Spring Boot uses SLF4J + Logback by default.

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

private static final Logger log = LoggerFactory.getLogger(MyClass.class);

log.info("Server started");
log.error("Error occurred", ex);


🧠 Always use LoggerFactory.getLogger() — never System.out.println() in production.

🌐 8. Controller vs RestController
Feature	@Controller	@RestController
Purpose	Used in MVC (returns views like JSP/HTML).	Used for REST APIs (returns JSON/XML).
Annotation	@Controller + @ResponseBody needed	@RestController = both combined
Use Case	Web UI apps	RESTful APIs
✅ Example
@Controller
public class PageController {
  @GetMapping("/home")
  public String home() { return "home.jsp"; }
}

@RestController
public class ApiController {
  @GetMapping("/users")
  public List<User> getUsers() { return userService.findAll(); }
}

💡 9. Common Spring Boot REST Annotations Recap
Annotation	Purpose
@RequestMapping	Maps request URL to method (supports all verbs).
@GetMapping	For GET requests.
@PostMapping	For POST requests.
@PutMapping	For PUT requests (update).
@DeleteMapping	For DELETE requests.
@PathVariable	Reads data from URL path.
@RequestParam	Reads query params.
@RequestBody	Reads JSON payload.
✅ Example
@PostMapping("/addUser")
public ResponseEntity<User> addUser(@RequestBody User user) {
    return ResponseEntity.ok(userService.save(user));
}

🧠 10. Spring Boot Logging Levels
Level	Description
TRACE	Most detailed (debug + internal flow)
DEBUG	Used for developer debugging
INFO	Important app flow info
WARN	Something unexpected, but not breaking
ERROR	App error or exception
✅ Example in application.properties
logging.level.root=INFO
logging.level.com.example=DEBUG

⚙️ 11. Lifecycle of a Spring Bean

Instantiation → Object created.

Dependency Injection → Dependencies injected.

PostConstruct → @PostConstruct method runs.

Ready for use

PreDestroy → @PreDestroy before shutdown.

✅ Example
@Component
class Test {
  @PostConstruct
  public void init() { System.out.println("Bean ready"); }

  @PreDestroy
  public void destroy() { System.out.println("Bean destroyed"); }
}


🧠 Spring manages the full lifecycle automatically.

🧠 12. Common Interviewer Deep Trick Question

❓ Why does Spring Boot not require web.xml?

✅ Because DispatcherServlet is automatically configured by Spring Boot’s ServletAutoConfiguration.
It uses embedded Tomcat with Annotation-based config, not XML.





=============================================================================================================================================
=============================================================================================================================================





🧩 1️⃣ Spring Boot REST Internal Flow (Deep Dive)

Let’s take a simple REST endpoint:

@RestController
@RequestMapping("/api/users")
public class UserController {

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        User user = service.findById(id);
        return ResponseEntity.ok(user);
    }
}

🔹 Full Internal Flow (Step-by-Step)
1. DispatcherServlet

Every HTTP request hits DispatcherServlet (the front controller in Spring MVC).

It acts like a traffic police — it doesn’t do business logic, it just delegates.

It finds the right controller method using the HandlerMapping.

2. HandlerMapping

Spring checks all @RequestMapping, @GetMapping, etc., and matches the URL.

Example: /api/users/5 → getUser() method.

3. HandlerAdapter

Invokes the actual controller method.

Handles method arguments (e.g., @PathVariable, @RequestParam, @RequestBody).

Spring uses ArgumentResolvers for this job internally.

4. Controller Execution

Your method runs: service.findById(id).

If it returns an object, the object is passed to HttpMessageConverter.

5. HttpMessageConverter

Converts Java object → JSON (using Jackson by default).

Based on Accept header (e.g., application/json or application/xml).

Example:

User → JSON { "id": 1, "name": "Gokul" }.

6. DispatcherServlet → Response

Sends the converted JSON response back to client via HttpServletResponse.

🧱 2️⃣ @ResponseBody vs @RestController vs ResponseEntity
🔹 @ResponseBody

Added on method → tells Spring to directly write object as response body (no view resolver).

Converts object → JSON using HttpMessageConverter.

🔹 @RestController

Shortcut for @Controller + @ResponseBody on every method.

So, REST APIs always use this.

🔹 ResponseEntity<T>

Complete control over:

HTTP status code (200, 404, 500)

Headers (Content-Type, custom headers)

Body (actual data)

Example:

return ResponseEntity
         .status(HttpStatus.CREATED)
         .header("info", "User created")
         .body(user);


Internally: Spring wraps this in a ResponseEntity object → handled by ResponseBodyAdvice → goes to HttpMessageConverter for serialization.

⚙️ 3️⃣ Exception Handling Flow

If exception occurs in controller:

DispatcherServlet catches it.

Passes to HandlerExceptionResolver chain.

It checks:

@ControllerAdvice + @ExceptionHandler

Default resolvers (ResponseStatusExceptionResolver, DefaultHandlerExceptionResolver)

Then creates appropriate ResponseEntity.

Example:

@ControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler(UserNotFoundException.class)
  public ResponseEntity<String> handle(UserNotFoundException ex) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
  }
}

🔍 4️⃣ Internal Bean Flow (Spring Container)

All @RestController, @Service, @Repository → Spring beans.

These are created by AnnotationConfigApplicationContext during app startup.

Dependency Injection ensures that:

Controller gets Service

Service gets Repository (JPA)

Repository gets EntityManager

🧠 5️⃣ Cross-Question Traps (asked in interviews)
Question	Deep Explanation
Q1. What happens if two controllers have same endpoint?	Spring throws IllegalStateException at startup (Ambiguous mapping).
Q2. How does Spring know to return JSON?	Based on Accept header → application/json → Jackson converter is used.
Q3. What is difference between @ResponseBody and HttpServletResponse?	@ResponseBody uses converter; HttpServletResponse manually writes data.
Q4. How can you return custom status without ResponseEntity?	Use @ResponseStatus(HttpStatus.CREATED) on method/class.
Q5. How Spring Boot auto-configures all this?	@SpringBootApplication → includes @EnableAutoConfiguration → loads default beans like DispatcherServlet, HandlerMapping, etc., from classpath (spring-boot-autoconfigure.jar).
🧩 6️⃣ Real-Life Example Analogy

Think of a Restaurant:

Customer (client) sends HTTP request → Waiter (DispatcherServlet).

Waiter finds right Chef (Controller).

Chef prepares dish (business logic via Service).

Food (Java object) converted to JSON (by HttpMessageConverter).

Waiter serves food (response) with proper packaging (ResponseEntity).




*/