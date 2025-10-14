package com.nt.coding.challanges;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AccProgramming {

	public static void main(String[] args) {

		removeChar();
		System.out.println();
		checkTwoArraySameElement();
		System.out.println();
		argstrongNumber();
		System.out.println();
		swapVaraible();
		System.out.println();
		kthLargest();
		System.out.println();
		kthSmallest();
		System.out.println();
		printNegativeMatrixValues();
		System.out.println();
		firstNonRepeating();
		System.out.println();
		firstRepeated();
		System.out.println();
		moveZerosLast();
		System.out.println();
		findMissingNumber();
		System.out.println();
		findSameElement();
		System.out.println();
		countFrequency();
		System.out.println();
		factorialNumberRecursion();
		System.out.println();
		factorial();
		System.out.println();
		reverseString();
		System.out.println();
		checkPalindromeString();
		System.out.println();
		printOddAtLast();
		System.out.println();
		countFreqOfEachWord();
		System.out.println();
		sumOfDigitListUseStream();
		System.out.println();
		findOneMissingNumber();
		System.out.println();
		missingsNums();
		System.out.println();
		missingNumsAnotherWay();
		System.out.println();
		frequecny();
		System.out.println();
		frequencyOfEachChar();
		System.out.println();
		mostFrequentChar();
		System.out.println();
		
	}

	private static void mostFrequentChar() {
		String str = "successes";
		int[] freq = new int[256];
		for (char ch : str.toCharArray()) {
			freq[ch]++;
		}
		char maxChar = ' ';
		int maxCount = 0;
		for (char ch : str.toCharArray()) {
			if (freq[ch] > maxCount) {
				maxCount = freq[ch];
				maxChar = ch;

			}
		}

		System.out.println("Most Frequent char :: " + maxChar + " -> " + maxCount + "times");

	}

	private static void frequencyOfEachChar() {
		String str = "success";
		boolean[] flag = new boolean[str.length()];

		for (int i = 0; i < str.length(); i++) {
			int count = 0;
			if (!flag[i]) {
				for (int j = 0; j < str.length(); j++) {
					if (str.charAt(i) == str.charAt(j)) {
						count++;
						flag[j] = true;
					}
				}
			}

			if (count > 0) {
				System.out.print(str.charAt(i) + "" + count);
			}
		}
		System.out.println();
	}

	private static void frequecny() {
		System.out.println();
		String str = "success";
		char ch = 's';
		int count = 0;
		for (char s : str.toCharArray()) {
			if (s == ch) {
				count++;
			}
		}

		System.out.println(ch + " Char Count is :: " + count);
	}

	private static void missingNumsAnotherWay() {
		int arr[] = { 1, 3, 5, 7, 9 };
		int max = arr[0];
		int min = arr[0];
		for (int num : arr) {
			if (max < num) {
				max = num;
			}

			if (min > num) {
				min = num;
			}
		}

		System.out.println("Missings Other Way :: ");
		for (int i = min; i < max; i++) {
			boolean flag = false;
			for (int num : arr) {
				if (num == i) {
					flag = true;
					break;
				}
			}

			if (!flag) {
				System.out.print(i + " ");
			}
		}
	}

	private static void missingsNums() {
		int arr[] = { 1, 3, 5, 7, 9 };
		System.out.println("Find Missing Nums are :: ");
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = arr[i] + 1; j < arr[i + 1]; j++) {
				System.out.print(j + " ");
			}
		}
		System.out.println();
	}

	private static void findOneMissingNumber() {
		int arr[] = { 1, 3, 4, 5, 6, 7 };
		int nums = 7;
		int totalSum = nums * (nums + 1) / 2;
		int arrSum = 0;
		for (int num : arr) {
			arrSum = arrSum + num;
		}

		System.out.println("Missing Number is :: " + (totalSum - arrSum));

	}

	private static void sumOfDigitListUseStream() {
		List<Integer> list = List.of(123, 456, 789);
		List<Integer> digitSums = list.stream().map(num -> String.valueOf(num).chars().map(ch -> ch - '0').sum())
				.collect(Collectors.toList());

		System.out.println("Digit Sums :: " + digitSums);

		int totalSum = digitSums.stream().mapToInt(Integer::intValue).sum();
		System.out.println("Total Sum :: " + totalSum);

	}

	private static void countFreqOfEachWord() {
		System.out.println();
		List<String> list = List.of("apple banana grape", "banana grape", "grape apple");
		// apple -> 2, banana -> 2, grape -> 3
		Map<String, Long> wordCount = list.stream().flatMap(str -> Arrays.stream(str.split(" ")))
				.collect(Collectors.groupingBy(word -> word, Collectors.counting()));

		wordCount.forEach((key, value) -> System.out.println(key + " -> " + value));
	}

	private static void printOddAtLast() {
		int arr[] = { 1, 2, 5, 4, 7, 8, 11, 20 };
		int index = 0;
		int newArr[] = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 == 0) {
				newArr[index] = arr[i];
				index++;
			}
		}

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 != 0) {
				newArr[index] = arr[i];
				index++;
			}
		}

		for (int i = 0; i < newArr.length; i++) {
			System.out.print(newArr[i] + " ");
		}

	}

	private static void checkPalindromeString() {
		String str = "madam";
		String rev = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			rev = rev + str.charAt(i);
		}

		if (str.equals(rev)) {
			System.out.println(str + " -> Is Palindrome....");
		} else {
			System.out.println(str + " -> Is Not Palindrome.!");
		}
	}

	private static void reverseString() {
		String str = "hello";
		String rev = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			rev = rev + str.charAt(i);
		}

		System.out.println("Reverse String is :: " + rev);
	}

	private static void factorial() {
		int num = 5;
		int fact = 1;
		for (int i = 1; i <= num; i++) {
			fact = fact * i;
		}

		System.out.println("Factorial (Loop) :: " + fact);
	}

	private static void factorialNumberRecursion() {
		int num = 5;
		System.out.println("Factorial is (Recursion) :: " + (fact(num)));
	}

	private static int fact(int num) {
		if (num == 0 || num == 1) {
			return 1;
		}
		return num * fact(num - 1);
	}

	private static void countFrequency() {
		String str = "success";
		Map<Character, Integer> map = new LinkedHashMap<>();

		for (char ch : str.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}

		map.forEach((k, v) -> System.out.println(k + " -> " + v));
	}

	private static void findSameElement() {
		int arr1[] = { 1, 2, 3, 4 };
		int arr2[] = { 2, 3, 4, 5 };

		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr2.length; j++) {
				if (arr1[i] == arr2[j]) {
					System.out.print(arr1[i] + " ");
				}
			}
		}
		System.out.println();
	}

	private static void findMissingNumber() {
		int arr[] = { 2, 4, 3, 5, 6, 7, 8 };
		int nums = 8;
		int totalSum = nums * (nums + 1) / 2;
		int arrSum = 0;
		for (int num : arr) {
			arrSum = arrSum + num;
		}

		System.out.println("Missing Number is :: " + (totalSum - arrSum));
	}

	private static void moveZerosLast() {
		int arr[] = { 0, 4, 2, 0, 8, 0, 0 };

		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > 0) {
				int temp = arr[i];
				arr[i] = arr[count];
				arr[count] = temp;
				count++;
			}
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

		System.out.println();
	}

	private static void firstRepeated() {
		String str = "programming";
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			boolean flag = false;
			for (int j = 0; j < str.length(); j++) {
				if (i != j && ch == str.charAt(j)) {
					flag = true;
				}
			}

			if (flag) {
				System.out.println(str.charAt(i));
				break;
			}
		}
	}

	private static void firstNonRepeating() {
		String str = "swiss";
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			boolean flag = false;
			for (int j = 0; j < str.length(); j++) {
				if (i != j && ch == str.charAt(j)) {
					flag = true;
				}
			}

			if (!flag) {
				System.out.println(str.charAt(i));
				break;
			}
		}
	}

	private static void printNegativeMatrixValues() {
		int arr[][] = { { 1, 3, -5 }, { -8, 6, 9 }, { -4, -2, 2 } };
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] < 0) {
					System.out.print(arr[i][j] + " ");
				}
			}
		}
		System.out.println();
	}

	private static void kthSmallest() {
		int arr[] = { 10, 3, 29, 38, 5, 9, 29, 0 };
		int kth = 3;
		Arrays.sort(arr);

		int count = 0;
		int seen = Integer.MIN_VALUE;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != seen) {
				count++;
				seen = arr[i];
			}

			if (count == kth) {
				System.out.println("Kth Smallest is :: " + arr[i]);
			}
		}
	}

	private static void kthLargest() {
		int arr[] = { 10, 3, 29, 38, 5, 9, 29, 0 };
		int kth = 3;
		Arrays.sort(arr);

		int count = 0;
		int seen = Integer.MAX_VALUE;

		for (int i = arr.length - 1; i >= 0; i--) {
			if (arr[i] != seen) {
				count++;
				seen = arr[i];
			}

			if (count == kth) {
				System.out.println("Kth Largest is :: " + arr[i]);
				break;
			}
		}
	}

	private static void swapVaraible() {
		int num1 = 10;
		int num2 = 20;

		num1 = num1 + num2;
		num2 = num1 - num2;
		num1 = num1 - num2;

		System.out.println(num1 + " , " + num2);
	}

	private static void argstrongNumber() {
		int num = 153;
		int temp = num;
		int sum = 0;

		while (num > 0) {
			int rem = num % 10;
			sum = sum + rem * rem * rem;
			num = num / 10;
		}

		System.out.println(temp == sum ? "Is Argstrome..." : "Is Not Argstrong....");
	}

	private static void checkTwoArraySameElement() {

		/*int arr1[] = { 3, 2, 5, 7 };
		int arr2[] = { 2, 3, 5, 7};
		
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		
		if (Arrays.equals(arr1, arr2)) {
			System.out.println("Both arrays are same...");
		} else {
			System.out.println("Arrays are not same.!");
		}*/

		int arr1[] = { 3, 2, 5, 7 };
		int arr2[] = { 2, 3, 5, 7 };

		if (arr1.length != arr2.length) {
			System.out.println("Both arrays length are not same.!");
			return;
		}
		Arrays.sort(arr1);
		Arrays.sort(arr2);

		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] != arr2[i]) {
				System.out.println("Both arrays are not same.!");
				return;
			}
		}

		System.out.println("Both arrays are same...");
	}

	private static void removeChar() {

		/*String str = "CloudTech".toLowerCase();
		System.out.println(str.replaceAll("c", ""));*/

		String str = "CloudTech".toLowerCase();
		String newStr = "";

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != 'c') {
				newStr = newStr + str.charAt(i);
			}
		}

		for (int i = 0; i < newStr.length(); i++) {
			System.out.print(newStr.charAt(i));
		}

		System.out.println();
	}

}

/*


1. Core Java (30+)
==================

Difference between JDK, JRE, JVM.

Explain OOPs concepts with real examples.

Difference between == and .equals().

Explain String, StringBuilder, StringBuffer.

How does HashMap work internally?

What is ConcurrentHashMap? Why use it?

Difference between ArrayList and LinkedList.

Difference between ArrayList, Vector, Stack.

Difference between checked, unchecked exceptions.

Explain exception hierarchy in Java.

Difference between throw and throws.

Explain final, finally, and finalize.

What is static in Java?

Can we override static methods? Why not?

What is abstraction vs encapsulation?

Difference between interface and abstract class.

Multiple inheritance in Java – possible?

Explain JVM memory structure (Heap, Stack, Metaspace).

Difference between compile-time and runtime polymorphism.

Real-life example of polymorphism (e.g., in your projects).

How Collections.sort() works internally.

Difference between Comparable and Comparator.

What is marker interface (like Serializable)?

What is serialization/deserialization?

Why main method is static?

What is garbage collection in Java?

What are functional interfaces? Examples.

What are Java 8 features (Stream, Lambda, Optional)?

Explain default and static methods in interface.

What is Optional in Java? Why use it?




2. Advanced Java (JDBC, Servlet, JSP) (15+)
===========================================

JDBC architecture flow.

Difference between Statement, PreparedStatement, CallableStatement.

Which one is safe against SQL Injection?

Servlet lifecycle methods (init(), service(), destroy()).

Difference between GET and POST.

JSP lifecycle.

Difference between forward and redirect.

Difference between Servlet and JSP.

What is session management?

Cookies vs HttpSession.

What are filters in Servlets?

MVC design pattern with example.

Real-world usage of Servlets in your projects.

JDBC connection pooling – why?

How to handle transactions in JDBC?







3. Spring & Spring Boot (30+)
=============================

Difference between Spring and Spring Boot.

What is Dependency Injection (DI)?

What is IoC Container?

Difference between @Component, @Service, @Repository, @Controller.

What is @Autowired?

What are Spring Boot starters?

What is Spring Boot auto-configuration?

What is the use of application.properties?

How to connect Spring Boot with MySQL?

What is JPA and Hibernate?

Difference between save() and saveAndFlush().

Difference between @RequestParam and @PathVariable.

Difference between @GetMapping, @PostMapping.

How do you handle exceptions globally (@ControllerAdvice)?

What is @RestController vs @Controller?

What is Spring Data JPA repository?

Difference between CrudRepository, JpaRepository, PagingAndSortingRepository.

Explain Entity Lifecycle in JPA.

Difference between @Entity and @Table.

Difference between Eager and Lazy loading.

What is caching in Spring Boot?

What is Spring Security?

How do you secure REST APIs?

JWT vs OAuth2 difference.

Real-time example: How you used Spring Security in your Car Rental System.

How to enable Swagger in Spring Boot.

What is Actuator in Spring Boot?

Difference between @Bean, @Configuration.

How does Spring Boot handle embedded servers (Tomcat, Jetty)?

How do you deploy Spring Boot app to production?




4. Microservices (20+)
======================

Monolithic vs Microservices.

Benefits of Microservices.

Challenges of Microservices.

Service Registry (Eureka).

API Gateway – why and how.

Load Balancer in Microservices.

Synchronous vs Asynchronous communication.

REST vs Messaging (RabbitMQ/Kafka).

Circuit Breaker pattern (Resilience4j/Hystrix).

Distributed logging (Zipkin, Sleuth).

Distributed transactions problem.

Service discovery flow.

Config Server in Spring Cloud.

Fault tolerance in microservices.

Example of microservices in your project (Car Rental System).

Versioning REST APIs in microservices.

How to secure microservices (OAuth2, JWT).

Dockerizing microservices.

Kubernetes basics (Pods, Deployments).

CI/CD pipeline for microservices.




5. Database & SQL (15+)
=======================

Difference between SQL and NoSQL.

What is normalization?

Explain 1NF, 2NF, 3NF.

Difference between Primary Key and Unique Key.

Difference between Inner Join, Left Join, Right Join, Full Join.

Query: Find second highest salary.

Query: Find duplicate employees.

Query: Find nth highest salary.

Query: Count number of employees in each department.

Query: Get employees who earn more than average salary.

Query: Get employees with same salary.

What are indexes in SQL?

Clustered vs Non-clustered index.

How to optimize slow queries?

Difference between Delete, Truncate, Drop.





*/
