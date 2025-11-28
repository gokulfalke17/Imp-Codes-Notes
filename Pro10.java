package com.nt.coding.challanges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Pro10 {

	public static void main(String[] args) {
		firstNonRepeatedCharacter();
		System.out.println();
		findDuplicateElements();
		System.out.println();
		findSecondLargeElement();
		System.out.println();
		reverseWordsMaintainOrder();
		System.out.println();
		reverseSentence();
		System.out.println();
		targetSum();
		System.out.println();
		evenOddWithoutMod();
		System.out.println();
		checkValidParenthesys();
		System.out.println();
		validShuffleString();
		System.out.println();
		checkAnagrams();
		System.out.println();
		groupOfAnagrams();
		System.out.println();
		frequencyOfWord();
		System.out.println();
		findSlidingWindowAverage();
		System.out.println();
		
		/*
		String json = """
					
					"Name" 	  : "Gokul",
					"Email"   : "gokul@gmail.com"
					"Mobile"  : "12345";
				""";
				
				//java 14 feature
		
		*/
		
		
		
		/*
		int day = 1;
		String result = switch(day) {
		case 1 -> "Monday";
		default -> "Unknown";
		};
		System.out.println(result);
		
		
		//java 12 feature
		
		*/
		
		
		
		/*
		Sequenced Collections
		
		Reverse iteration support directly.
		
		//java 21
		
		*/
		
		
	}
	



	private static void findSlidingWindowAverage() {

		List<Integer> list = Arrays.asList(4, 8, 15, 16, 23, 42);
		//window = 3;
		//[9.0, 13.0, 18.0, 27.0]
		
		List<Double> result = IntStream
						.range(0, list
								.size()-2)
						.mapToObj(i -> (list
								.get(i) + list
								.get(i+1) + list
								.get(i+2))/3.0)
						.toList();
		
		System.out.println("Sliding Window Average :: \n"+result);
		
	}



	private static void frequencyOfWord() {

		List<String> list = Arrays.asList("apple", "orange", "mango", "apple", "banana", "banana", "apple");
		
		Map<String,Long> map = list.stream()
						.collect(Collectors
								.groupingBy(word -> word, Collectors
										.counting()));
		System.out.println(map);
	}
	
	
	

	private static void groupOfAnagrams() {
		
		String[] str = {"ate", "tea", "bat", "tab", "mat", "cat"};
		Map<String, List<String>> map = new LinkedHashMap<>();
		
		for(String s : str) {
			char[] ch = s.toCharArray();
			Arrays.sort(ch);
			String key = new String(ch);
			map.computeIfAbsent(key, k -> new ArrayList<>()).add(key);
		}
		
		map.forEach((key, value) -> System.out.println(key+" -> "+value));
		
		
		
		/*
		String[] str = {"ate", "tea", "bat", "tab", "mat", "cat"};
		Map<String,List<String>> map = Arrays
								.stream(str)
								.collect(Collectors
										.groupingBy(s -> {
											
							char ch[] = s.toCharArray();
							Arrays.sort(ch);
							return new String(ch);
							
						}));
		
		map.forEach((key, value) -> System.out.println(key+" -> "+value));
		*/
		
		
		
	}
	
	
	

	private static void checkAnagrams() {
		/*String str1 = "listen";
		String str2 = "silent";
		
		int count1 = 0;
		int count2 = 0;
		
		for(int i=0; i<str1.length(); i++) {
			if(str1.length()!=str2.length()) {
				System.out.println("Length is Not Same, So Not Anagrams.!");
				return;
			}
			
			for(int j=0; j<str2.length(); j++) {
				if(str1.charAt(i)==str1.charAt(j)) {
					count1++;
				}
				
				if(str1.charAt(i)==str2.charAt(j)) {
					count2++;
				}
			}
		}
		
		if(count1==count2) {
			System.out.println("Is Anagrams...");
		}else {
			System.out.println("Is Not Anagrams.!");
		}*/
		
		/*
		String str1 = "silent";
		String str2 = "listen";
		
		List<Character> list1 = new ArrayList<>();
		List<Character> list2 = new ArrayList<>();
		
		
		if(str1.length()!=str2.length()) {
			System.out.println("Length is Not Same, So Not Anagrams.!");
			return;
		}
		
		for(char ch : str1.toCharArray()) {
			list1.add(ch);
		}
		
		for(char ch : str2.toCharArray()) {
			list2.add(ch);
		}
		
		Collections.sort(list1);
		Collections.sort(list2);
		
		if(list1.equals(list2)) {
			System.out.println("Is Anagrams");
		}else {
			System.out.println("Is Not Anagrams.!");
		}
		*/
		
		
		String str1 = "silent";
		String str2 = "listen";
		
		if(str1.length()!=str2.length()) {
			System.out.println("Length is Not Same, So Not Anagrams.!");
			return;
		}
		
		Map<Character, Long> map1 = str1.chars()
							.mapToObj(ch -> (char)ch)
							.collect(Collectors
									.groupingBy(ch -> ch, Collectors
													.counting()));
		
		Map<Character, Long> map2 = str2.chars()
							.mapToObj(ch -> (char)ch)
							.collect(Collectors
									.groupingBy(ch -> ch, Collectors
													.counting()));
		
		if(map1.equals(map2)) {
			System.out.println("Is Anagrams...");
		}else {
			System.out.println("Is Not Anagrams.!");
		}
	}
	
	
	

	private static void validShuffleString() {
		String str1 = "abc", str2 = "def";
		String str3 = "adbcef";

		List<Character> list1 = new ArrayList<>();
		(str1 + str2).chars().forEach(ch -> list1.add((char) ch));

		List<Character> list2 = str3.chars().mapToObj(ch -> (char) ch).sorted().toList();

		Collections.sort(list1);

		System.out.println(list1.equals(list2) ? "Valid Shuffle" : "Invalid Shuffle");

	}
	
	

	private static void checkValidParenthesys() {
		String str = "({[}{)]";
		Stack<Character> stack = new Stack<>();
		for (char ch : str.toCharArray()) {
			if (ch == '(' || ch == '{' || ch == '[') {
				stack.push(ch);
			} else {
				if (stack.isEmpty()) {
					System.out.println("Invalid");
					break;
				}
				char top = stack.pop();
				if ((ch == '(' && top != ')') || (ch == '{' && top != '}') || (ch == '[' && top != ']')) {

					System.out.println("Invalid");
					break;
				}
			}
		}
		System.out.println(stack.isEmpty() ? "Valid" : "Invalid");
	}
	
	
	

	private static void evenOddWithoutMod() {
		String check[] = { "even", "odd" };
		int num = 29;
		int result = num & 1;
		System.out.println(check[result]);
	} 
	
	

	private static void targetSum() {
		int[] arr = { 1, 2, 3, 4, 5 };
		int target = 6;
		int start = 0;
		int end = arr.length - 1;

		while (start < end) {
			int sum = arr[start] + arr[end];
			if (sum == target) {
				System.out.println(arr[start] + "  " + arr[end]);
				start++;
				end--;
			} else if (sum < target) {
				start++;
			} else {
				end--;
			}
		}
	}

	
	
	private static void reverseSentence() {

		// Reverse Sentence

		/*
		String str = "Java Interview Questions";
		String rev = "";
		for(int i=str.length()-1; i>=0; i--) {
			rev = rev + str.charAt(i);
		}
		
		int start = 0;
		int end = 0;
		char[] ch = rev.toCharArray();
		
		for(int i=0; i<=ch.length; i++) {
			if(i==ch.length || ch[i]==' ') {
				end = i-1;
				while(start < end) {
					char temp = ch[start];
					ch[start] = ch[end];
					ch[end] = temp;
					start++;
					end--;
				}
				start = i+1;
			}
		}
		
		System.out.println("Reversed Sentence :: "+ new String(ch));
		*/

		String str = "Java Interview Questions";
		String[] split = str.split(" ");
		String result = "";

		System.out.println("Reverse Sentence :: ");
		for (int i = split.length - 1; i >= 0; i--) {
			result = result + split[i] + " ";
		}

		System.out.println(result);

		/*String str = "Java Interview Questions";
		String result = Arrays.stream(str.split(" ")).collect(Collectors.collectingAndThen(
		        Collectors.toList(),
		        list -> { Collections.reverse(list); return list; }
		))
		.stream()
		.collect(Collectors.joining(" "));
		
		System.out.println("Reverse Sentence :: \n"+ result);
		*/

	}

	private static void reverseWordsMaintainOrder() {

		// Reverse Words but Maintain Word Order

		/*String str = "Java Interview Questions";
		
		int start = 0;
		int end = 0;
		char[] ch = str.toCharArray();
		
		for(int i=0; i<ch.length; i++) {
			if(i==ch.length || ch[i]==' ') {
				end = i-1;
				while(start < end) {
					char temp = ch[start];
					ch[start] = ch[end];
					ch[end] = temp;
					start++;
					end--;
				}
				start = i+1;
			}
		}
		
		System.out.println("Reversed String :: "+ new String(ch));*/

		String str = "Java Interview Questions";
		String[] split = str.split(" ");
		String result = "";
		for (String word : split) {
			for (int i = word.length() - 1; i >= 0; i--) {
				result = result + word.charAt(i);
			}

			result = result + " ";
		}
		System.out.println("Reversed String :: \n" + result);

		/*String str = "Java Interview Questions";
		String reversedString = Arrays.stream(str
							.split(" "))
					.map(word -> new StringBuilder(word)
							.reverse()
							.toString())
					.collect(Collectors
							.joining(" "));
		
		System.out.println("Reversed Words :: \n"+ reversedString);*/
	}

	private static void findSecondLargeElement() {

		// Find 2nd Largest Element

		/*int[] arr = {1, 5, 3, 2, 4, 5};
		int largest = Integer.MIN_VALUE;
		int second = Integer.MAX_VALUE;
		
		for(int i=0; i<arr.length; i++) {
			if(largest < arr[i]) {
				second = largest;
				largest = arr[i];
			}else if(largest > arr[i] && second !=arr[i]) {
				second = arr[i];
			}
		}
		System.out.println("Second Largest Element :: \n"+ second);*/

		int[] arr = { 1, 5, 3, 2, 4, 5 };
		Integer secondLargest = Arrays.stream(arr).boxed().distinct().sorted(Collections.reverseOrder()).skip(1)
				.findFirst().orElse(-1);

		System.out.println("Second Largest Element :: \n" + secondLargest);

	}

	private static void findDuplicateElements() {

		// Find Duplicate Elements in Array

		/*int[] arr = {1, 2, 2, 3, 4, 4, 4, 5};
		for(int i=0; i<arr.length; i++) {
			int count = 0;
			for(int j=i+1; j<arr.length; j++) {
				if(arr[i]==arr[j]) {
					count++;
				}
			}
			if(count==1) {
				System.out.print(arr[i]+" ");
			}
		}*/

		/*int[] arr = {1, 2, 2, 3, 4, 4, 4, 5};
		Set<Integer> seen = new LinkedHashSet<>();
		Set<Integer> duplicate = new LinkedHashSet<>();
		
		System.out.println("Duplicate Elements :: ");
		for(int num : arr) {
			if(!seen.add(num)) {
				duplicate.add(num);
			}
		}
		System.out.println(duplicate);*/

	}

	private static void firstNonRepeatedCharacter() {

		// Find 1st Non-Repeated Character

		/*String str = "swiss";
		
		System.out.println("First Non-Repeated Character :: ");
		for (int i = 0; i < str.length(); i++) {
			int count = 1;
			for (int j = i + 1; j < str.length(); j++) {
				if(i != j && str.charAt(i)==str.charAt(j)) {
					count++;
				}
			}
			
			if(count==1) {
				System.out.println(str.charAt(i));
				break;
			}
		}*/

		/*String str = "swiss";
		Map<Character, Integer> map = new LinkedHashMap<>();
		
		for (char ch : str.toCharArray()) {
			if (map.containsKey(ch)) {
				map.put(ch, map.get(ch) + 1);
			} else {
				map.put(ch, 1);
			}
		}
		
		System.out.println("First Non-Repeated Character :: ");
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			if (entry.getValue() == 1) {
				System.out.println(entry.getKey());
				break;
			}
		}*/

		String str = "swiss";
		Map<Character, Long> map = str.chars().mapToObj(ch -> (char) ch)
				.collect(Collectors.groupingBy(ch -> ch, LinkedHashMap::new, Collectors.counting()));

		Character firstNonRepeated = map.entrySet().stream().filter(ele -> ele.getValue() == 1).map(Map.Entry::getKey)
				.findFirst().orElse(null);

		System.out.println("First Non-Repeated Character :: \n" + firstNonRepeated);
	}
}

/*
⚡ String Coding

Reverse a string without using StringBuilder.reverse()

Check if a string is palindrome

Count occurrences of each character

First non-repeating character

Remove duplicates from a string

Check anagram of two strings

Print duplicate characters with count

Find the longest substring without repeating characters

Find frequency of words in a sentence

Reverse each word in a string




🔥 Array Coding

Find max and min element

Second highest and second lowest

Reverse array

Left rotate / right rotate array

Move all zeros to the end

Find missing number (1 to N)

Find duplicate number in array

Two sum problem

Merge two sorted arrays

Kadane’s Algorithm (max sum subarray)




🔥 Java 8 Functional & Stream Coding

Count frequency of elements using streams

Find even & odd numbers using stream

Sort list with stream

Convert list to map, map to list

Find duplicate elements in a list using stream

Group employees by department

Find highest-paid employee in each department

Find second highest number using streams

Remove duplicates from list using distinct()

Sum of squares of numbers



🔥 Collections Coding

Implement custom sorting using Comparator

Sort list of employees by name/salary

LRU Cache using LinkedHashMap

Custom HashMap (override hashCode & equals)

Fail-fast vs Fail-safe iteration example

Convert HashMap → TreeMap sorted

Remove entries from map while iterating

Merging two HashMaps

Compare two HashMaps

Frequency count using HashMap



🔥 Core Algorithms

Binary search

Linear search

Bubble sort

Merge sort

Quick sort

Factorial (iterative + recursive)

Fibonacci (iterative + recursive)

Check prime number

Count digits of a number

Reverse an integer



🔥 Matrix Coding

Transpose matrix

Print diagonal elements

Rotate matrix 90 degrees

Add two matrices

Spiral order traversal

Matrix multiplication

Count zero rows

Row with maximum 1s

Check symmetric matrix

Find largest element in matrix



🔥 Linked List Coding

Reverse a linked list

Detect cycle (Floyd's algorithm)

Find middle of linked list

Remove nth node from end

Merge two sorted linked lists

Check palindrome linked list

Delete node without head pointer

Intersection point of two lists

Sort linked list

Flatten a linked list



🔥 Stack / Queue Coding

Implement stack using array

Implement queue using array

Implement stack using two queues

Balanced parentheses

Next greater element

Minimum element in stack

Implement queue using stack

Reverse stack using recursion

Evaluate postfix expression

Stock span problem



🔥 Multithreading Coding

Print even-odd using two threads

Print 1–10 numbers using threads

Thread-safe Singleton

Producer–Consumer using wait/notify

Deadlock example and fix

Create thread using Runnable vs Thread

Use ExecutorService for thread pool

Use Callable + Future to return result

Volatile variable example

Read-write operation with synchronized



💥 Now — Top 10 MUST-CODE Questions (Interview Favourite)

1️⃣ Reverse a String
2️⃣ Check Palindrome (String & Number)
3️⃣ Find Missing Number in Array
4️⃣ Find Duplicate in Array / List
5️⃣ Second Highest Number
6️⃣ Count Occurrence of Characters
7️⃣ Remove Duplicates from List (Java 8)
8️⃣ Group Employees by Department (Java 8)
9️⃣ Two Threads Print Even-Odd
🔟 Highest Paid Employee Using Streams





*/