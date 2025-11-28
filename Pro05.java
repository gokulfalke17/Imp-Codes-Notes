package com.nt.coding.challanges;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Pro05 {

	public static void main(String[] args) {

		reverseEachWordFromSentence();
		System.out.println();
		printUniqueElements();
		System.out.println();
		findMissingElement_DuplicateElement();
		System.out.println();
		validShuffle();
		System.out.println();

		System.out.println("===============================\n");

		usingJava8AlltheseCodes();
		System.out.println();
		integersSumOfSquares();
		System.out.println();
		listOfNumbersMoreThan10AndAverage();
		System.out.println();
		
		
		

	}

	private static void listOfNumbersMoreThan10AndAverage() {
		int[] arr = {1, 14, 9, 19, 6};
		
		OptionalDouble average = Arrays.stream(arr).filter(num -> num > 10).mapToLong(num -> num).average();
		System.out.println("Average is :: "+ average.getAsDouble());
	}

	private static void integersSumOfSquares() {
		int[] arr = {1, 14, 9, 19, 6};
		int sum = Arrays.stream(arr).map(num -> num * num).sum();
		System.out.println("Sum of Square :: "+ sum);
	}

	private static void usingJava8AlltheseCodes() {

		System.out.println("----> Java 8 Same Codes <----\n");
		String str = "java is fun";
		String reversedEachWord = Arrays.stream(str.split(" ")).map(ele -> new StringBuilder(ele).reverse().toString())
				.collect(Collectors.joining(" "));
		System.out.println("Reversed Each Word :: ");
		System.out.println(reversedEachWord);


		System.out.println();

		int[] array = { 1, 2, 3, 5, 1, 5, 20, 2, 12, 10 };
		List<Integer> unique = Arrays.stream(array).boxed()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
				.filter(ele -> ele.getValue() == 1).map(Map.Entry::getKey).collect(Collectors.toList());
		System.out.println("Unique Element List :: ");
		System.out.println(unique);


		System.out.println();

		int[] arr = { 4, 3, 6, 2, 1, 1 };
		int num = 6;
		int totalSum = num * (num + 1) / 2;
		int arrSum = Arrays.stream(arr).sum();

		Integer duplicate = Arrays.stream(arr).boxed()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
				.filter(ele -> ele.getValue() > 1).map(Map.Entry::getKey).findFirst().orElse(-1);

		int missing = totalSum - arrSum + duplicate;

		System.out.println("Missing Element :: " + missing);
		System.out.println("Duplicate Element :: " + duplicate);
		
		
	}

	// check valid shuffle
	private static void validShuffle() {
		String str1 = "abc";
		String str2 = "def";
		String result = "dabecf";

		boolean flag = false;

		if (result.length() != str1.length() + str2.length()) {
			flag = false;
		}

		int count1 = 0;
		int count2 = 0;

		for (int i = 0; i < result.length(); i++) {
			char ch = result.charAt(i);
			if (count1 < str1.length() && ch == str1.charAt(count1)) {
				count1++;
			} else if (count2 < str2.length() && ch == str2.charAt(count2)) {
				count2++;
			} else {
				flag = false;
			}
		}
		flag = count1 == str1.length() && count2 == str2.length();

		if (flag) {
			System.out.println("Is Valid Shuffle...");
		} else {
			System.out.println("Is Not Valid Shuffle.!");
		}
	}

	// find missing element and duplicate element
	private static void findMissingElement_DuplicateElement() {
		int arr[] = { 4, 3, 6, 2, 1, 1 };

		int duplicate = 0;
		for (int i = 0; i < arr.length; i++) {
			int count = 0;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					count++;
				}
			}
			if (count == 1) {
				duplicate = arr[i]; // 1
			}
		}

		System.out.println("Duplicate Element :: " + duplicate);

		int num = 6;
		int totalSum = num * (num + 1) / 2;
		int arrSum = 0;
		for (int ele : arr) {
			arrSum = arrSum + ele;
		}

		// here just + duplicate element
		int missing = totalSum - arrSum + duplicate;
		System.out.println("Missing Element :: " + missing); // 5

	}

	// print only unique elements
	private static void printUniqueElements() {
		int[] arr = { 1, 2, 3, 5, 1, 5, 20, 2, 12, 10 };
		System.out.println("Unique Elements are :: ");
		for (int i = 0; i < arr.length; i++) {
			int count = 0;
			for (int j = 0; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					count++;
				}
			}
			if (count == 1) {
				System.out.print(arr[i] + " ");
			}
		}
		System.out.println();
	}

	// reverse each word from sentence
	private static void reverseEachWordFromSentence() {
		String str = "java is fun";

		char[] ch = str.toCharArray();
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

		System.out.println("Reverse Each Word in Sentence :: ");
		System.out.println(new String(ch)); // avaj si nuf

	}
}



/*

map.computeIfAbsent() ::
------------------------
computeIfAbsent() in Java is used when you want to add a value to a Map only if the key does not already exist.
It checks if the key is missing — if yes, it creates and adds the value using the given function.
If the key is already there, it just returns the existing value.

Example ::
map.computeIfAbsent("user", k -> new ArrayList<>()); 



peek() method from stream :: 
----------------------------
peek() in Java Stream is used to see or debug the data flowing through a stream without changing it.
It lets you perform some action (like printing) on each element in between operations such as filter or map.
It’s mostly used for debugging or logging inside stream pipelines.

Example ::
Stream.of(1, 2, 3)
      .peek(n -> System.out.println("Before map: " + n))
      .map(n -> n * 2)
      .peek(n -> System.out.println("After map: " + n))
      .toList();



@Transactional annotation ::
----------------------------
@Transactional in Spring is used to manage database transactions automatically.
It means all the code inside that method runs as one single unit of work —
if everything succeeds, changes are saved (commit), but if an exception occurs, all changes are rolled back.

Example ::
@Transactional
public void transferMoney(Account from, Account to, double amount) {
    from.withdraw(amount);
    to.deposit(amount);
}


@OneToMany and @ManyToMany annotation ::
----------------------------------------
@OneToMany
==========
This means one entity is related to many others.
For example, one Department can have many Employees.
Used when one side “owns” multiple items.

Example ::
@Entity
class Department {
    @OneToMany(mappedBy = "department")
    private List<Employee> employees;
}

@Entity
class Employee {
    @ManyToOne
    private Department department;
}


@ManyToMany
===========
This means many entities can be related to many others.
For example, a Student can join many Courses, and a Course can have many Students.

Example ::
@Entity
class Student {
    @ManyToMany
    private List<Course> courses;
}

@Entity
class Course {
    @ManyToMany(mappedBy = "courses")
    private List<Student> students;
}


@OneToMany → one parent linked to many children.
@ManyToMany → both sides have multiple connections.



Optimistic and Pestimestic locking ::
-------------------------------------
Optimistic Locking
==================
Assumes multiple transactions can work on the same data without conflict.
Checks for conflicts only when saving/updating.
Uses a version number (or timestamp) to detect if data was changed by someone else.
If conflict occurs → transaction fails, user retries.

Example ::
@Entity
class Account {
    @Id
    private Long id;
    
    @Version
    private int version; // used for optimistic locking
    private double balance;
}

Pessimistic Locking
===================
Assumes conflicts are likely, so it locks the data while reading.
Other transactions must wait until the lock is released.
Ensures no one else can update the same row until current transaction finishes.

Example ::
@Lock(LockModeType.PESSIMISTIC_WRITE)
@Query("SELECT a FROM Account a WHERE a.id = :id")
Account findAccountForUpdate(@Param("id") Long id);


-------------------------------------------------------------------------------
Feature			Optimistic Locking				Pessimistic Locking
-------------------------------------------------------------------------------
Assumption		Conflicts are rare				Conflicts are likely
Locking			No lock, check at update		Lock row while reading
Performance		Faster for reads				Slower due to waiting threads
Use case		Read-heavy apps					Write-heavy apps
-------------------------------------------------------------------------------






Difference between HashMap and ConcurrentHashMap

HashMap is not thread-safe, so multiple threads can corrupt data.
ConcurrentHashMap uses segment-level locking or CAS to allow safe concurrent updates.
It gives better performance in multithreaded apps.



Immutability and its importance

An immutable object cannot change after creation (like String).
It’s safe to share between threads since its state can’t change.
Helps avoid synchronization issues.



Java Memory Model (JMM)

JMM defines how threads interact through memory.
It ensures visibility using happens-before rules — changes in one thread become visible to others.
Volatile variables and synchronized blocks help maintain consistency.



ThreadLocal vs synchronized

ThreadLocal gives each thread its own copy of a variable, no sharing.
synchronized locks a block/object to allow only one thread at a time.
Use ThreadLocal for isolation, synchronized for protection.



Producer-Consumer using Java Concurrency

Use BlockingQueue to safely pass items between producer and consumer threads.
Producers put items, consumers take items — no manual waiting needed.
Example: LinkedBlockingQueue, ArrayBlockingQueue.



Spring Security internal working

Spring Security uses a chain of filters — UsernamePasswordAuthenticationFilter, etc.
They call AuthenticationManager, which checks credentials via providers.
Once verified, a SecurityContext holds the user info.



@RequestParam, @PathVariable, @RequestBody

@RequestParam: takes query params (e.g. /api?name=Tom)
@PathVariable: takes values from URL path (e.g. /api/users/10)
@RequestBody: maps JSON body to Java object.
Each used based on input type.



Global Exception Handling

Use @ControllerAdvice + @ExceptionHandler to catch exceptions globally.
It avoids repeating try-catch in controllers.
Returns user-friendly JSON error messages.



Idempotent APIs

An API is idempotent if repeated calls give same result.
Use unique request IDs, database constraints, or tokens to prevent double processing.
Common in payment APIs to avoid duplicate charges.



@Transactional for Data Integrity

Wraps multiple DB operations in one unit.
If any operation fails, all are rolled back automatically.
Ensures data stays consistent.



High-volume inserts/updates

Use batch processing (hibernate.jdbc.batch_size=50).
Turn off auto-flush and second-level cache.
It reduces DB round-trips and improves performance.



persist(), merge(), save()

persist() → only makes entity managed, no return.
merge() → updates detached entity and returns managed one.
save() → Hibernate-specific, returns generated ID.



Avoiding N+1 Select Problem

Use fetch joins or EntityGraph to load related data in one query.
Example: @Query("SELECT e FROM Emp e JOIN FETCH e.dept").
Reduces extra DB hits.



Optimistic vs Pessimistic Locking

Optimistic assumes few conflicts → checks with version number.
Pessimistic locks DB rows to prevent others from editing.
Optimistic = fast, Pessimistic = safer in high writes.



Auditing Entity Changes

Use Hibernate Envers or custom auditing with @PrePersist, @PreUpdate.
It stores who changed what and when.
Useful for tracking data changes in finance apps.



Distributed Transactions

Use Saga Pattern (chained local transactions) or Outbox Pattern.
Avoid global locks — handle rollback via compensating actions.
2PC (Two-Phase Commit) is slower and less scalable.



Secure API Gateway

Use Spring Cloud Gateway + JWT authentication.
The gateway validates tokens before routing to microservices.
It also adds rate limiting and logging.



Retries & Idempotency

Use Resilience4j / RetryTemplate to auto-retry failed calls.
Make requests idempotent with unique IDs or transaction keys.
Prevents duplicate downstream updates.



Rate Limiting & Throttling

Use Bucket4j or Redis to count requests per user/IP.
When limit exceeds, return HTTP 429.
Protects your APIs from abuse.



Scalable Notification Service

Use Kafka or RabbitMQ for message queuing.
Notifications are consumed asynchronously by multiple workers.
Enables millions of messages to be processed reliably.



Secure Data Storage (PCI DSS)

Encrypt sensitive data like card numbers using AES/RSA.
Never store plain text; keep keys safe (Vault, AWS KMS).
Mask data in logs.



OAuth2 vs OpenID vs SAML

OAuth2 → gives access to resources (authorization).
OpenID Connect → adds user identity layer on top of OAuth2.
SAML → XML-based older standard for enterprise SSO.



Token Expiration & Refresh

Access tokens expire fast; refresh tokens issue new ones.
When access token expires, client uses refresh token to get a new one.
Handled in Spring Security with JWT filters.



Data Encryption (At Rest vs In Transit)

At Rest: encrypt stored data using AES.
In Transit: use HTTPS/TLS to secure data between client and server.
Both ensure privacy and security.



Fraud / Anomaly Detection

Use machine learning or rule engines to detect unusual patterns.
E.g., too many payments from same IP or sudden large amounts.
Log and flag for review.







*/
