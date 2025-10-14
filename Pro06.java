package com.nt.coding.challanges;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Pro06 {

	public static void main(String[] args) {

		reverseString(); // olleh
		System.out.println();
		reverseSentence(); // fun is java
		System.out.println();
		reverseEachWrod(); // avaj si fun
		System.out.println();
		checkPalindrome();
		System.out.println();
		duplicateCharacters();
		System.out.println();
		findMissingElement();
		System.out.println();
		fibonacciSeries();
		System.out.println();
		countWordOfStrings();
		System.out.println();
		evensUsingJava8();
		System.out.println();
		frequencyOfEachElement();
		System.out.println();
		findDuplicateElements();
		System.out.println();
		findMaxAndMinElements();
		System.out.println();
		removeDuplicates();
		System.out.println();
		findFirstNonRepeatingCharacter();
		System.out.println();
		margeTwoListWithoutDuplicates();
		System.out.println();
		switchExpressionJava14();
		System.out.println();
		argmstrongCheck();
		System.out.println();
		removeDuplicatesFromSortedList();
		System.out.println();
		longestSubstringWithoutRepeatingCharacter();
		System.out.println();

	}

	private static void longestSubstringWithoutRepeatingCharacter() {
		String str = "aabbbccccda";
		Set<Character> set = new HashSet<>();
		int left = 0;
		int longest = 0;
		int start = 0;

		for (int right = 0; right < str.length(); right++) {
			char ch = str.charAt(right);

			while (set.contains(ch)) {
				set.remove(str.charAt(left++));
			}

			set.add(ch);

			if (right - left + 1 > longest) {
				longest = right - left + 1;
				start = left;
			}
		}

		String longestSubstring = str.substring(start, start + longest);

		System.out.println("Longest Substring length :: " + longest);
		System.out.println("Longest Substring :: " + longestSubstring);
	}

	private static void removeDuplicatesFromSortedList() {
		System.out.println("Removing Duplicates :: ");
		int[] arr = { 1, 2, 2, 3, 4, 4, 4, 5 };
		for (int i = 0; i < arr.length; i++) {
			int count = 0;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					count++;
				}
			}
			if (count == 0) {
				System.out.print(arr[i] + " ");
			}
		}
	}

	private static void argmstrongCheck() {
		int num = 153;
		int temp = num;
		int sum = 0;
		while (temp != 0) {
			int rem = temp % 10;
			sum = sum + rem * rem * rem;
			temp = temp / 10;
		}

		if (num == sum) {
			System.out.println(num + " Is Argstrong...");
		} else {
			System.out.println(num + " Is Not Argstrong.!");
		}
	}

	private static void switchExpressionJava14() {
		System.out.println("Switch Expression Java 14 Example :: ");
		int month = 12;
		int days = switch (month) {
		case 1, 3, 5 -> 31;
		default -> 30;
		};
		System.out.println(days);

	}

	private static void margeTwoListWithoutDuplicates() {

		int[] arr1 = { 1, 2, 3, 4 };
		int[] arr2 = { 3, 4, 5, 6 };

		int[] margedArray = new int[arr1.length + arr2.length];
		int count = 0;

		for (int i = 0; i < margedArray.length; i++) {
			if (i < arr1.length) {
				margedArray[count++] = arr1[i];
			} else {
				margedArray[count++] = arr2[i - arr1.length];
			}
		}

		System.out.println("Marged Array Elements :: ");
		for (int num : margedArray) {
			System.out.print(num + " ");
		}
		System.out.println();

		/*List<Integer> list1 = Arrays.asList(1, 2, 3, 4);
		List<Integer> list2 = Arrays.asList(3, 4, 5, 6);
		
		List<Integer> margedList = Stream.concat(list1.stream(), list2.stream()).distinct().collect(Collectors.toList());
		
		System.out.println("Marged List is :: ");
		System.out.println(margedList);*/
	}

	private static void findFirstNonRepeatingCharacter() {
		String str = "swiss";

		/*for(int i=0; i<str.length(); i++) {
			boolean flag = false;
			for(int j=i+1; j<str.length(); j++) {
				if(i!=j && str.charAt(i)==str.charAt(j)) {
					flag = true;
				}
			}
			
			if(!flag) {
				System.out.println("First Non-Repeated Character :: "+ str.charAt(i));
				break;
			}
		}*/

		/*Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();
		
		for (char ch : str.toCharArray()) {
			if (map.containsKey(ch)) {
				map.put(ch, map.get(ch) + 1);
			} else {
				map.put(ch, 1);
			}
		}
		
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			if (entry.getValue() == 1) {
				System.out.println("First Non-Repeated Character :: " + entry.getKey());
				break;
			}
		}*/

		Character firstNonRepeatedCharacter = str.chars().mapToObj(ch -> (char) ch)
				.collect(Collectors.groupingBy(ele -> ele, LinkedHashMap::new, Collectors.counting())).entrySet()
				.stream().filter(ele -> ele.getValue() == 1).map(Map.Entry::getKey).findFirst().orElse(null);
		System.out.println("First Non-Repeated Character :: " + firstNonRepeatedCharacter);

	}

	private static void removeDuplicates() {
		/*int[] arr = { 1, 2, 2, 2, 3, 4, 4, 5 };
		System.out.println("After Removing Duplicates :: ");
		for (int i = 0; i < arr.length; i++) {
			int count = 0;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					count++;
				}
			}
			if (count == 0) {
				System.out.print(arr[i] + " ");
			}
		}*/

		List<Integer> list = Arrays.asList(1, 2, 2, 2, 3, 4, 4, 5);
		Set<Integer> seen = new LinkedHashSet<Integer>();
		Set<Integer> duplicate = new LinkedHashSet<Integer>();

		System.out.println("Removing Duplicate Elements :: ");
		for (int num : list) {
			if (!seen.add(num)) {
				duplicate.add(num);
			}
		}

		System.out.println(seen);
	}

	private static void findMaxAndMinElements() {
		List<Integer> list = Arrays.asList(5, 2, 6, 1, 9, 4, 8);
		int max = list.stream().mapToInt(ele -> ele).max().getAsInt();
		int min = list.stream().mapToInt(ele -> ele).min().getAsInt();

		System.out.println("Min :: " + min + "\nMax :: " + max);
	}

	private static void findDuplicateElements() {

		/*int[] arr = { 1, 2, 2, 2, 3, 4, 4, 5 };
		
		System.out.println("Duplicate Elements :: ");
		for (int i = 0; i < arr.length; i++) {
			int count = 0;
			for (int j = i+1; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					count++;
				}
			}
			if (count == 1) {
				System.out.print(arr[i]+" ");
			}
		}
		System.out.println();*/

		List<Integer> list = Arrays.asList(1, 2, 2, 2, 3, 4, 4, 5);
		Set<Integer> duplicates = list.stream().filter(num -> Collections.frequency(list, num) > 1)
				.collect(Collectors.toSet());
		System.out.println("Duplicate Elements are :: ");
		System.out.println(duplicates);
	}

	private static void frequencyOfEachElement() {
		List<String> list = Arrays.asList("apple", "banana", "apple", "banana", "orange", "apple");
		Map<String, Long> result = list.stream().collect(Collectors.groupingBy(ele -> ele, Collectors.counting()));
		System.out.println(result);
	}

	private static void evensUsingJava8() {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
		System.out.println("Evens are :: ");
		Arrays.stream(arr).filter(num -> num % 2 == 0).map(num -> num).forEach(num -> System.out.print(num + " "));
	}

	private static void countWordOfStrings() {
		String str = "java is fun";
		String[] split = str.split(" ");
		System.out.println("No. of Words :: " + split.length);
	}

	private static void fibonacciSeries() {
		int f1 = 0;
		int f2 = 1;
		int fib;
		System.out.println("Fibonacci Series :: ");
		for (int i = 0; i <= 7; i++) {
			System.out.print(f1 + " ");
			fib = f1 + f2;
			f1 = f2;
			f2 = fib;
		}
		System.out.println();
	}

	private static void findMissingElement() {
		int[] arr = { 1, 2, 3, 4, 5 };
		int num = 6;
		int totalSum = num * (num + 1) / 2;
		int arrSum = 0;
		for (int ele : arr) {
			arrSum = arrSum + ele;
		}

		System.out.println("Missing Element is :: " + (totalSum - arrSum));
	}

	private static void duplicateCharacters() {
		String str = "programming";

		System.out.println("Duplicate Characters :: ");
		/*for(int i=0; i<str.length(); i++) {
			int count = 0;
			for(int j=i+1; j<=str.length()-1; j++) {
				if(str.charAt(i)==str.charAt(j)) {
					count++;
				}
			}
			if(count==1) {
				System.out.print(str.charAt(i)+" ");
			}
		}*/

		Map<Character, Integer> result = new LinkedHashMap<>();
		for (char ch : str.toCharArray()) {
			result.put(ch, result.getOrDefault(ch, 0) + 1);
		}

		result.forEach((key, value) -> {
			if (value > 1) {
				System.out.print(key + " ");
			}
		});
		System.out.println();
	}

	private static void checkPalindrome() {
		String str = "madam";
		String rev = "";

		for (int i = str.length() - 1; i >= 0; i--) {
			rev = rev + str.charAt(i);
		}

		if (rev.equals(str)) {
			System.out.println(str + " Is Palindrome...");
		} else {
			System.out.println(str + " Is Not Palindrome.!");
		}

		int num = 12321;
		int temp = num;
		int reverse = 0;
		while (temp != 0) {
			int rem = temp % 10;
			reverse = reverse * 10 + rem;
			temp = temp / 10;
		}

		if (num == reverse) {
			System.out.println(num + " Is Palindrome...");
		} else {
			System.out.println(num + " Is Not Palindrome.!");
		}
	}

	private static void reverseEachWrod() {
		String str = "java is fun";

		char[] ch = str.toCharArray();
		int start = 0;
		for (int i = 0; i < ch.length; i++) {
			if (ch[i] == ' ' || i == ch.length) {
				int end = i - 1;
				while (start < end) {
					char temp = ch[start];
					ch[start] = ch[end];
					ch[end] = temp;
					start++;
					end--;
				}
				start = i + 1;
			}
		}
		System.out.println("Reversed Each Word :: " + new String(ch));
	}

	private static void reverseSentence() {
		String str = "java is fun";
		String rev = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			rev = rev + str.charAt(i);
		}

		// System.out.println(rev);

		char[] ch = rev.toCharArray();
		int start = 0;

		for (int i = 0; i <= ch.length; i++) {
			if (i == ch.length || ch[i] == ' ') {
				int end = i - 1;
				while (start < end) {
					char temp = ch[start];
					ch[start] = ch[end];
					ch[end] = temp;
					start++;
					end--;
				}
				start = i + 1;
			}
		}

		System.out.println("Reverse Sentence is :: " + new String(ch));
	}

	private static void reverseString() {
		String str = "hello";
		String rev = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			rev = rev + str.charAt(i);
		}
		System.out.println("Reverse String :: " + rev);
	}
}

/*

🟦 Java

1Virtual Threads (Java 21)
--------------------------
Virtual threads are lightweight threads managed by the JVM, not the OS.
They allow thousands of concurrent tasks with low memory use.
Best for I/O-heavy apps (like servers) — much faster than traditional threads.



Sealed Classes (Java 17)
------------------------
Sealed classes restrict which classes can extend them.
It improves control and security over inheritance.
Example:
sealed class Vehicle permits Car, Bike {}

Only Car and Bike can extend Vehicle.



var vs record
--------------
var → local variable type inference (used in methods).
record → defines an immutable data class (used for modeling data).
Example:
record Person(String name, int age) {}


Optional.ofNullable() vs Optional.orElseGet()
---------------------------------------------
ofNullable() creates an Optional that can hold null safely.
orElseGet() executes a Supplier only when the value is absent — better for performance.



Parallel Stream API
--------------------
parallelStream() splits data across multiple threads using ForkJoinPool.
It speeds up large computations but must be used carefully for thread safety.



Switch Expressions
-------------------
Introduced in Java 14 to simplify switch logic.
They can return values and remove break statements.
Example:
int days = switch(month) { case 1,3,5 -> 31; default -> 30; };



Text Blocks
------------
Introduced in Java 15, text blocks allow multiline strings with """.
Useful for writing SQL, JSON, or HTML easily without escape characters.



Ensuring Immutability
---------------------
Use final for fields, no setters, and return new copies for mutable objects.
Once created, the object’s state never changes — like String class.



HashMap vs ConcurrentHashMap
----------------------------
HashMap → not thread-safe, may throw errors in multi-threaded use.
ConcurrentHashMap → thread-safe; allows concurrent reads and partial locking on writes.



G1 vs ZGC Garbage Collectors
----------------------------
G1 GC: region-based, pauses minimized for large heaps.
ZGC: ultra-low pause (<10ms), works on multi-terabyte heaps — best for modern large systems.




🟦 Spring + Spring Boot

@SpringBootApplication
----------------------
It combines @Configuration, @EnableAutoConfiguration, and @ComponentScan.
Simplifies setup — no XML config needed, just one annotation to start the app.



Dependency Injection
--------------------
Spring injects objects automatically instead of creating them manually.
Improves testability and decouples code — you can easily mock dependencies.



Externalizing Configuration
----------------------------
You can store configs in application.properties, environment variables, or config servers.
Helps manage different setups (dev, prod) without changing code.



Global Exception Handling
-------------------------
Use @ControllerAdvice + @ExceptionHandler to catch all errors in one place.
Keeps controller code clean and consistent error responses.



JWT Authentication
------------------
User logs in → backend returns JWT token.
Every request includes token in header → server validates before access.
No need for server-side sessions.



@RestController vs @Controller
------------------------------
@RestController → returns JSON directly.
@Controller → used for rendering HTML views (like JSP or Thymeleaf).



Custom Health Checks (Actuator)
-------------------------------
Add custom endpoints via HealthIndicator bean.
Example: check DB connection or API availability, and expose it at /actuator/health.



Spring Profiles
---------------
Profiles help load environment-specific configs like application-dev.properties or application-prod.properties.
Use @Profile("dev") to activate beans only in that environment.




Spring Boot + Kafka/RabbitMQ
-----------------------------
Use @KafkaListener or @RabbitListener to consume messages.
Spring Boot auto-configures connection and handles retries and serialization.



Database Migrations (Flyway/Liquibase)
--------------------------------------
Both tools manage schema changes automatically.
Store SQL scripts in resources/db/migration, and they apply changes during app startup.




🟦 Microservices

Service Discovery (Eureka/Consul)
---------------------------------
Microservices register with Eureka; others find them by name.
No hard-coded URLs — automatic load balancing and discovery.



Sync vs Async Communication
----------------------------
Sync: REST call, waits for response (like HTTP).
Async: message queues (Kafka/RabbitMQ), non-blocking and scalable.



API Gateway Pattern
--------------------
Acts as a single entry point for all clients.
Handles routing, security, rate limiting, and monitoring (e.g., Spring Cloud Gateway).



Fault Tolerance & Retries
-------------------------
Use Resilience4j or Hystrix to auto-retry, apply circuit breakers, and fallback methods.
Prevents service chain failures in microservices.



🟦 Coding Questions

Armstrong Number
-----------------
int num = 153, sum = 0, temp = num;
while(temp > 0) {
  int d = temp % 10;
  sum += d*d*d;
  temp /= 10;
}
System.out.println(sum == num ? "Armstrong" : "Not");

Checks if each digit’s cube sum equals the number.



Remove Duplicates from Sorted Array
-----------------------------------
int i=0;
for(int j=1;j<nums.length;j++){
 if(nums[i]!=nums[j]) nums[++i]=nums[j];
}
return i+1;

Keeps unique elements in place — no extra space used.



Longest Substring Without Repeating Characters
-----------------------------------------------
Set<Character> set = new HashSet<>();
int left=0, max=0;
for(int right=0; right<s.length(); right++){
 while(!set.add(s.charAt(right)))
   set.remove(s.charAt(left++));
 max = Math.max(max, right-left+1);
}

Uses sliding window to find longest unique substring.



🟨 Others

Kafka: Topic, Partition, Offset
--------------------------------
Topic: category of messages.
Partition: divides topic for parallelism.
Offset: unique ID of each message within a partition.



StatefulSets vs Deployments (Kubernetes)
----------------------------------------
Deployment: for stateless apps (like APIs).
StatefulSet: for apps needing stable storage and identity (like databases).



Second Highest Salary (SQL)
---------------------------
SELECT MAX(salary) FROM Employee 
WHERE salary < (SELECT MAX(salary) FROM Employee);


Finds salary just below the highest.
------------------------------------


Idempotent REST APIs
--------------------
An API is idempotent if calling it multiple times gives the same result.
Example: updating a record (PUT) — same data, same outcome.



Docker Image vs Container
-------------------------
Image: blueprint (app + dependencies).
Container: running instance of that image.
Many containers can run from one image.



Blue-Green Deployment (Kubernetes)
----------------------------------
Run two versions (Blue = old, Green = new).
Switch traffic to Green after testing — no downtime, easy rollback.





API
---

Request Response API
	|->REST
	|->RPC
	|->GraphQL



Event Driven API
	|->WebHooks
	|->WebSocket
	|->HTTP Streaming
	
	
	

	
🟩 Core Java (OOPs, Collections, Concurrency)

1. HashMap vs LinkedHashMap vs ConcurrentHashMap
------------------------------------------------
HashMap doesn’t maintain order and isn’t thread-safe.
LinkedHashMap maintains insertion order.
ConcurrentHashMap is thread-safe and faster than synchronized maps using segment-level locking.



2. Java ClassLoader hierarchy
-----------------------------
ClassLoaders load Java classes dynamically.
Hierarchy: Bootstrap → Extension → Application (System).
Custom ClassLoaders can load classes from special sources (like network or encrypted files).



3. Deadlock detection & prevention
----------------------------------
Deadlock occurs when two threads wait for each other’s locks.
Prevention: acquire locks in a fixed order or use tryLock() with timeout.
Detection: use thread dumps or tools like VisualVM.



4. Fork/Join Framework
-----------------------
Used for parallel computation by dividing tasks into subtasks.
Based on the “divide and conquer” principle.
Uses the ForkJoinPool for efficient multi-threaded execution.



5. CompletableFuture advantages
-------------------------------
Non-blocking async tasks with callbacks (thenApply, thenAccept).
Better chaining and exception handling than traditional Future.
Used for writing cleaner concurrent code.



🟩 Spring & Spring Boot

6. Auto-configuration in Spring Boot
-------------------------------------
Based on classpath entries and properties.
Uses @ConditionalOnClass, @ConditionalOnProperty to decide which beans to load automatically.



7. @ComponentScan vs @EnableAutoConfiguration vs @SpringBootApplication
------------------------------------------------------------------------
@ComponentScan: scans packages for beans.
@EnableAutoConfiguration: enables Spring Boot’s auto setup.
@SpringBootApplication: combines both plus @Configuration.



8. Rate limiting / throttling in APIs
--------------------------------------
Controls request frequency to prevent overuse.
Implement using Bucket4j, Redis counters, or API Gateway throttling policies.



9. Distributed caching (Redis)
------------------------------
Store frequently accessed data in Redis to reduce DB load.
Use @Cacheable, @CachePut, @CacheEvict annotations.
Configure via spring.cache.type=redis.



10. Spring Boot Actuator endpoints
-----------------------------------
Provide metrics, health, and info endpoints (/actuator/health, /actuator/metrics).
Secure them using Spring Security or API keys.




🟩 JPA / Hibernate

11. First-level vs Second-level cache
-------------------------------------
1st-level: session-level (default, per transaction).
2nd-level: shared across sessions using cache providers like Ehcache.



12. FetchType.LAZY vs EAGER
---------------------------
LAZY: loads only when accessed (better performance).
EAGER: loads immediately (may cause unnecessary joins).



13. Multi-tenant in JPA
------------------------
Used for apps serving multiple clients (tenants).
Approaches: separate schema per tenant or discriminator column.



14. Optimistic vs Pessimistic locking
--------------------------------------
Optimistic: assumes no conflict, checks version at commit.
Pessimistic: locks row in DB to prevent concurrent updates.



15. Dirty checking and flush mode
----------------------------------
Hibernate automatically tracks entity changes (dirty checking).
On flush (commit), only changed fields are updated.




🟩 Microservices & Architecture

16. REST vs gRPC vs GraphQL
---------------------------
REST: JSON over HTTP (simple and common).
gRPC: binary over HTTP/2, faster, used for inter-service calls.
GraphQL: client defines what data to fetch, reduces over-fetching.



17. Service discovery & load balancing
--------------------------------------
Discovery via Eureka/Consul; clients find services dynamically.
Load balancing via Ribbon, Nginx, or API Gateway.



18. Saga & Outbox patterns
---------------------------
Saga: breaks long transactions into smaller local ones with compensation.
Outbox: ensures DB and message broker consistency using a pending-events table.




19. Event-driven design (Kafka/Azure Service Bus)
-------------------------------------------------
Services communicate via events (decoupled).
Improves scalability and async processing.



20. Backward compatibility for APIs
-----------------------------------
Use versioning (v1/v2), avoid removing old fields.
Add optional new parameters instead of breaking existing ones.




🟩 Cloud & DevOps (Azure)

21. Azure Functions vs App Service
-----------------------------------
Functions: serverless, auto-scales, event-driven.
App Service: host long-running web APIs or apps.




22. Secrets/config management in Azure
---------------------------------------
Use Azure Key Vault for passwords, tokens.
Integrate with Spring using spring.cloud.azure.keyvault.



23. Zero-downtime deployment on AKS
------------------------------------
Use Rolling updates or Blue-Green deployment.
Ensures new pods are ready before killing old ones.



24. Azure Monitor / App Insights
---------------------------------
Tracks logs, performance, failures, and user behavior.
Helps detect slow endpoints and troubleshoot issues.



25. Vertical vs Horizontal scaling
----------------------------------
Vertical: add more power (CPU/RAM) to one server.
Horizontal: add more servers (pods) to handle load.



🟩 Behavioral / Leadership

31. Ambiguous requirements
--------------------------
I clarified requirements by asking questions, made assumptions clear, 
and documented them before coding.



32. Cross-team collaboration
----------------------------
Worked with frontend and DevOps teams to align APIs and CI/CD setup, ensuring on-time delivery.



33. Mentoring example
---------------------
Helped a junior engineer understand Spring Boot modules and code review practices.



34. Prioritizing conflicting requirements
------------------------------------------
Discussed priorities with stakeholders, focused on business-critical tasks 
first, and scheduled the rest for later sprints.




*/