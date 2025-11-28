package com.nt.coding.challanges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@FunctionalInterface
interface Sum {
	int addition(int a, int b);
	// int substraction(int a, int b);
}

public class Pro04 {

	public static void main(String[] args) {

		stramComparison();
		System.out.println();
		reverseSentence();
		System.out.println();
		wordCountInList();
		System.out.println();
		reverseEachWordInSentence();
		System.out.println();
		removeDuplicateFromListOfList();
		System.out.println();
		groupListWithFirstCharacter();
		System.out.println();
		findDistinctElements();
		System.out.println();
		anagramGroupWithoutStream();
		System.out.println();
		anagramGroupUsingStream();
		System.out.println();
		sumOfTwoNumbers();
		System.out.println();
		countFrequencyEachCharacter();
		System.out.println();
		findDuplicateElements();
		System.out.println();
		removeDuplicates();
		System.out.println();
		findLongestWord();
		System.out.println();
		checkNumberEvenOdd();
		System.out.println();
		duplicateElementsInList();
		System.out.println();
		longestWord();
		System.out.println();
		reverseList();
		System.out.println();
		
	}


	private static void reverseList() {
		List<Integer> list = Arrays.asList(4, 2, 1, 5, 3);
		/*Collections.reverse(list);
		System.out.println(list);*/

		for (int i = 0, j = list.size() - 1; i < j;  i++, j--) {
			int temp = list.get(i);
			list.set(i, list.get(j));
			list.set(j, temp);
		}

		System.out.println(list);
	}

	private static void longestWord() {
		List<String> list = Arrays.asList("java", "python", "frameword", "programming", "language");
		String longest = list.stream().max(Comparator.comparingInt(String::length)).orElse("");
		System.out.println("Longest Word is :: " + longest);
	}

	private static void duplicateElementsInList() {
		List<Integer> list = Arrays.asList(1, 2, 2, 3, 4, 4, 5);
		System.out.println("Duplicate Elements are :: ");
		list.stream().collect(Collectors.groupingBy(ele -> ele, Collectors.counting())).entrySet().stream()
				.filter(ele -> ele.getValue() > 1).forEach(ele -> System.out.println(ele.getKey()));
	}

	private static void checkNumberEvenOdd() {
		int num = 7;
		String str[] = { "Even", "Odd" };
		System.out.println(num + " is " + str[num % 2]);
	}

	// Longest word
	private static void findLongestWord() {
		String str = "Java is programming langauage";
		/*String longest = "";
		for (String s : str.split(" ")) {
			if (s.length() > longest.length()) {
				longest = s;
			}
		
		}
		System.out.println("Longest Word is :: " + longest);*/

		String longest = Arrays.stream(str.split(" ")).max(Comparator.comparingInt(String::length)).orElse("");
		System.out.println("Longest Word is :: " + longest);
	}

	// remove duplicates from list without set
	private static void removeDuplicates() {
		int arr[] = { 1, 2, 2, 2, 3, 4, 4, 5 };
		/*List<Integer> list = new ArrayList<>();
		for(int num : arr) {
			if(!list.contains(num)) {
				list.add(num);
			}
		}
		System.out.println(list);*/

		Arrays.stream(arr).distinct().forEach(ele -> System.out.print(ele + " "));
	}

	// print duplicate elements
	private static void findDuplicateElements() {
		List<Integer> list = Arrays.asList(1, 2, 2, 2, 3, 4, 4, 5);
		Set<Integer> seen = new LinkedHashSet<Integer>();
		Set<Integer> duplicates = list.stream().filter(ele -> !seen.add(ele)).collect(Collectors.toSet());
		System.out.println(duplicates);
	}

	// count frequency of each character
	private static void countFrequencyEachCharacter() {
		String str = "java";
		Map<Character, Long> map = str.chars().mapToObj(ch -> (char) ch)
				.collect(Collectors.groupingBy(ch -> ch, Collectors.counting()));
		System.out.println(map);
	}

	// sum two numbers
	private static void sumOfTwoNumbers() {
		Sum sum = (a, b) -> a + b;
		System.out.println("Sum is :: " + sum.addition(5, 2));
	}

	// anagram groups using stream api
	private static void anagramGroupUsingStream() {
		String words[] = { "eat", "tea", "anuj", "silent", "ate", "nat", "bat", "juna", "listen" };
		Map<String, List<String>> map = Arrays.stream(words).collect(Collectors.groupingBy(str -> {
			char ch[] = str.toCharArray();
			Arrays.sort(ch);
			return new String(ch);
		}));

		System.out.println(map.values());

	}

	// anagram groups without using stream api
	private static void anagramGroupWithoutStream() {
		System.out.println();
		String words[] = { "eat", "tea", "anuj", "silent", "ate", "nat", "bat", "juna", "listen" };
		Map<String, List<String>> map = new LinkedHashMap<>();

		for (String str : words) {
			char[] ch = str.toCharArray();
			Arrays.sort(ch);
			String key = new String(ch);

			if (!map.containsKey(key)) {
				map.put(key, new ArrayList<>());
			}
			map.get(key).add(str);
		}

		System.out.println(new ArrayList<>(map.values()));
	}

	// find all distinct elements from list
	private static void findDistinctElements() {
		List<Integer> list = Arrays.asList(5, 4, 4, 3, 2, 2, 2, 1);
		list.stream().distinct().collect(Collectors.toList()).forEach(ele -> System.out.print(ele + " "));
	}

	// group the list using first character
	private static void groupListWithFirstCharacter() {
		System.out.println();
		List<String> list = Arrays.asList("abc", "pqr", "acd", "prt", "xyz", "mno");
		Map<Character, List<String>> result = list.stream().collect(Collectors.groupingBy(str -> str.charAt(0)));
		System.out.println(result);
	}

	// remove duplicates from list of list -> (using flatMap)
	private static void removeDuplicateFromListOfList() {
		List<Integer> list1 = Arrays.asList(1, 2, 3, 4);
		List<Integer> list2 = Arrays.asList(3, 4, 5, 6);
		List<List<Integer>> combinedList = new ArrayList<List<Integer>>();
		combinedList.add(list1);
		combinedList.add(list2);

		combinedList.stream().flatMap(List::stream).distinct().collect(Collectors.toList())
				.forEach(ele -> System.out.print(ele + " "));
	}

	// reverse each word of sentence
	private static void reverseEachWordInSentence() {
		String str = "I Love Java";
		String reverseEachWord = Arrays.stream(str.split(" ")).map(ele -> new StringBuilder(ele).reverse().toString())
				.collect(Collectors.joining(" "));
		System.out.println(reverseEachWord);
	}

	// count word occurrence in list
	private static void wordCountInList() {
		List<String> list = Arrays.asList("apple", "banana", "apple", "orange", "apple", "banana");
		Map<String, Long> map = list.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(map);
	}

	// reverse sentence
	private static void reverseSentence() {
		String str = "hello word";
		String[] split = str.split(" ");
		String rev = "";

		for (int i = split.length - 1; i >= 0; i--) {
			rev = rev + split[i] + " ";
		}

		System.out.println(rev);
	}

	// stream comparison of sequential stream and parallel stream
	private static void stramComparison() {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		// Sequential Stream
		System.out.println("Sequential Stream Output:");
		numbers.stream().map(n -> n * 2).forEach(e -> System.out.print(e + " "));
		System.out.println();

		// Parallel Stream
		System.out.println("Parallel Stream Output (order may vary):");
		numbers.parallelStream().map(n -> n * 2).forEach(e -> System.out.print(e + " "));
		System.out.println();
	}
}

/*

1. Intermediate Operations ::
-----------------------------
Purpose: Intermediate operations transform a stream into another stream. They do not produce a final result but rather 
return a new Stream object, allowing for method chaining.

Laziness: They are lazily evaluated, meaning they are only executed when a terminal operation is invoked. This allows 
for optimizations like short-circuiting. 

Examples: filter(), map(), sorted(), distinct(), limit(), skip(), peek().

Ex ::
-----

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IntermediateOperationExample {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Anna", "Charlie", "Andrew");

        // Intermediate operations: filter and map
        List<String> filteredAndMappedNames = 
        							names.stream()
									 .filter(name -> name.startsWith("A")) 
									 .map(String::toUpperCase()
									 .collect(Collectors.toList());

        System.out.println(filteredAndMappedNames); // Output: [ALICE, ANNA, ANDREW]
    }
}


2. Terminal Operations ::
-------------------------
Purpose: Terminal operations mark the end of the stream pipeline. They produce a final result or a side effect, and after a 
terminal operation is invoked, the stream is consumed and cannot be reused.

Eager Evaluation: They trigger the execution of all preceding intermediate operations.

Examples: forEach(), collect(), reduce(), count(), min(), max(), anyMatch(), allMatch(), 
noneMatch(), findFirst(), findAny(), toArray(). 

Ex ::
-----

import java.util.Arrays;
import java.util.List;

public class TerminalOperationExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        System.out.print("Numbers using forEach: ");
        numbers.stream()
               .forEach(System.out::print); 
        System.out.println();

        long count = numbers.stream().count(); 
        System.out.println("Count of numbers: " + count); // Output: 5
    }
}


*/

/*

Coupling ::
----------- 
Coupling refers to the knowledge or information or dependency of another class. 
It arises when classes are aware of each other. 

Cohesion ::
-----------
Cohesion refers to the level of a component which performs a single well-defined task. 
A single well-defined task is done by a highly cohesive method. 

Association :: 
--------------
Association represents the relationship between the objects. Here, one object can be associated with one 
object or many objects. 

Aggregation ::
-------------- 
Aggregation is a way to achieve Association. Aggregation represents the relationship where one object 
contains other objects as a part of its state. 

Composition :: 
--------------
The composition is also a way to achieve Association. The composition represents the relationship 
where one object contains other objects as a part of its state.

*/

/*
 
 Sequential Stream & Parallel Stream ::
 ======================================

In Java, streams provide a powerful and functional way to process 
collections of data. They can be executed in two primary modes: sequential 
and parallel.

Sequential Streams:
-------------------
Execution: Operations on a sequential stream are processed one element 
at a time, in the order they appear in the source. They run on a single thread.

Creation: By default, any stream created using collection.stream() or 
Stream.of() is sequential.

Characteristics:
Order: Maintains the encounter order of elements.

Performance: Performance is generally slower for large datasets or computationally 
intensive operations compared to parallel streams, as processing is single-threaded.

Simplicity: Simpler to reason about and debug due to their predictable, sequential execution.


Parallel Streams:
-----------------
Execution: Operations on a parallel stream are executed concurrently on multiple 
threads, utilizing multiple CPU cores if available. The underlying mechanism 
often involves the Fork/Join framework.

Creation:
By invoking collection.parallelStream() on a collection.
By calling the parallel() method on an existing sequential stream: sequentialStream.parallel().

Characteristics:
Order: The order of processing elements is generally not guaranteed, 
although terminal operations like collect(Collectors.toList()) will reconstruct 
the order.

Performance: Can offer significant performance improvements for large datasets and 
CPU-bound tasks by leveraging multi-core processors.

Complexity: Can be more complex to design and debug due to the concurrent nature of 
execution and potential for race conditions if not handled carefully.

Suitability: Best suited for operations that are independent and can be safely 
executed in parallel without relying on shared mutable state.

*/

/*

1. Is Java pass-by-value or pass-by-reference?

Always pass-by-value.

For objects, the reference itself is passed by value.
👉 Example: Giving someone a copy of your house key (they can open/modify the house but you didn’t give the actual house).

2. Difference between == and .equals()

== → compares memory address (references).

.equals() → compares values/content.
👉 Example: Two different cups (==) can hold same water (.equals()).

3. What happens if you don’t write a constructor?

Java provides a default constructor automatically.

It initializes values with default (0, null, false).
👉 Like getting a plain notebook from shop if you don’t customize one.

4. Can we overload main() method?

Yes, we can have multiple main() methods with different parameters.

But JVM only calls public static void main(String[] args).
👉 Like you can have many doors, but the building uses the main gate.

5. What is String immutability?

Once created, String cannot be changed.

Any modification creates a new object.
👉 Like writing with a permanent marker, can’t erase—only rewrite on a new page.

6. Difference between String, StringBuilder, StringBuffer

String → immutable.

StringBuilder → mutable, faster (not thread-safe).

StringBuffer → mutable, thread-safe (slower).

7. Why is char[] used for password instead of String?

String stays in memory (pool) until garbage collected.

char[] can be cleared immediately.
👉 Like writing password in pencil (erasable) vs permanent marker (String).

8. What is the difference between final, finally, finalize?

final → keyword (constant, prevent inheritance/override).

finally → block in exception handling (always executes).

finalize() → method called before GC.

9. Can constructor be private?

Yes, used in Singleton pattern.
👉 Like making only one key for a vault—no one else can make more.

10. Can abstract class have constructor?

Yes, but it cannot be instantiated.

Constructor runs when child class object is created.

11. Difference between Abstract class and Interface

Abstract class → can have concrete + abstract methods.

Interface → only abstract methods (till Java 7), default & static allowed in Java 8+.
👉 Abstract class = blueprint + some parts ready, Interface = full blueprint.

12. Can interface have private methods?

Yes, from Java 9 onwards.

Used for reusing common code in default methods.

13. Difference between Overloading and Overriding

Overloading → same method name, different parameters. (Compiletime Polymorphism)

Overriding → child class changes parent’s method. (Runtime Polymorphism)
👉 Overloading = multiple TV remotes, Overriding = universal remote replaces parent’s.

14. Why multiple inheritance not supported in Java?

To avoid diamond problem (confusion when two parents have same method).

15. What is transient keyword?

Prevents variable from being serialized.
👉 Like marking a notebook page “Do not photocopy”.

16. What is volatile keyword?

Ensures changes to variable are visible to all threads immediately.
👉 Like updating live stock price visible to everyone instantly.

17. Can we override static methods?

No, we can only hide them.
👉 Like hiding parent’s photo with child’s photo, but parent photo still exists.

18. Difference between throw and throws

throw → used to throw exception inside method.

throws → declares that method may throw exceptions.

19. What is checked vs unchecked exception?

Checked → compile-time (IOException, SQLException).

Unchecked → runtime (NullPointerException, ArithmeticException).

20. What is marker interface?

Interface with no methods (like Serializable).
👉 Like a tag/label on an object.

21. Can we create object without new keyword?

Yes, using reflection, cloning, deserialization.

22. Difference between shallow copy and deep copy

Shallow copy → copies reference.

Deep copy → copies full object.
👉 Like photocopy (shallow) vs writing new book (deep).

23. Difference between process and thread

Process → independent program.

Thread → lightweight unit inside process.

24. What is deadlock?

When two threads wait on each other forever.
👉 Like two people waiting for the other to open the door.

25. What is race condition?

Multiple threads try to modify same data at same time.
👉 Like two people editing the same Word doc.

26. Difference between HashMap and Hashtable

HashMap → not synchronized, allows null keys/values.

Hashtable → synchronized, no nulls.

27. Difference between HashSet and TreeSet

HashSet → unordered, faster.

TreeSet → sorted, slower.

28. Difference between fail-fast and fail-safe iterator

Fail-fast → throws error if collection modified (ArrayList).

Fail-safe → doesn’t throw (CopyOnWriteArrayList).

29. What is Optional in Java 8?

Container to avoid NullPointerException.
👉 Like gift box that may/may not contain gift.

30. What is lambda expression?

Short way to write function.

(x, y) -> x + y;

31. What is functional interface?

Interface with only one abstract method.

Example: Runnable, Callable, Predicate, Consumer, Function, Supplier

32. Difference between Stream map() and flatMap()

map() → transforms each element.

flatMap() → transforms + flattens nested lists.

33. What is method reference?

Short form of lambda to call existing method.

list.forEach(System.out::println);

34. What is default method in interface?

Method with body inside interface (Java 8+).

35. Difference between parallel stream and sequential stream

Sequential → one by one.

Parallel → multiple threads, faster for large data.

36. Can we change size of array after creation?

No, fixed.
👉 Use ArrayList for dynamic size.

37. Difference between Comparable and Comparator

Comparable → single sorting logic (inside class).

Comparator → multiple sorting logic (outside class).

38. What is immutability?

Object whose state cannot change after creation.
👉 Example: String, wrapper classes.

39. Why String is final in Java?

Security (used in class loading, credentials), caching, immutability.

40. Difference between Heap and Stack memory

Heap → stores objects.

Stack → stores method calls, local variables.

41. Difference between ClassLoader and Class.forName()

ClassLoader.loadClass() → loads class only.

Class.forName() → loads class + initializes.

42. What is reflection in Java?

API to inspect classes, methods, fields at runtime.

43. What is serialization and deserialization?

Serialization → convert object → byte stream.

Deserialization → byte stream → object.

44. Can we serialize static variables?

No, because they belong to class, not object.

45. What is diamond problem?

Occurs with multiple inheritance.

Java solves it by not allowing multiple inheritance with classes.

46. Difference between super and this

this → current class object.

super → parent class object.

47. What is enum in Java?

Special class for constants.
👉 Example: enum Day { MONDAY, TUESDAY }.

48. Difference between String Pool and Heap

String Pool → unique immutable Strings cached.

Heap → all objects, including Strings.

49. What is JIT compiler?

Just-In-Time compiler improves performance by compiling bytecode to native machine code at runtime.

50. What is garbage collection in Java?

Automatic removal of unused objects.
👉 Like a cleaning robot removing unused things from memory.

*/
