package com.nt.coding.challanges;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Pro07_Company_Practice {

	public static void main(String[] args) {

		reverseString();
		System.out.println();
		palindrome();
		System.out.println();
		occurrence();
		System.out.println();
		removeDuplicates();
		System.out.println();
		subsequenceCharacter();
		System.out.println();
		wordOccurrence();
		System.out.println();
		numberOp();
		System.out.println();
		WordNumberSum();
		System.out.println();
		missingElement();
		System.out.println();
		missingElements();
		System.out.println();
		findDuplicateUsingJava8();
		System.out.println();
		margeTwoMaps();
		System.out.println();
		frequecnyOfElement();
		System.out.println();
		checkPalindrome();
		System.out.println();
		checkAnagramStringsUsingMap();
		System.out.println();
		margeTwoArrays();
		System.out.println();

	}

	private static void margeTwoArrays() {
		int arr1[] = {1, 2, 3, 4, 5};
		int arr2[] = {6, 7, 8, 9, 10};
		int result[] = new int[arr1.length + arr2.length];
		
		int index = 0;
		
		for(int i=0; i<arr1.length;i++) {
			result[index++] = arr1[i];
			result[index++] = arr2[arr2.length-1-i];
		}
		
		System.out.println(Arrays.toString(result));
	}

	private static void checkAnagramStringsUsingMap() {
		/*String str1 = "listen";
		String str2 = "silent";
		
		if(str1.length()!=str2.length()) {
			System.out.println("Length is not Same so, Not Anagrams.!");
		}
		
		Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();
		
		for(char ch : str1.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0)+1);
		}
		
		for(char ch : str2.toCharArray()) {
			if(!map.containsKey(ch)) {
				System.out.println("Not Anagrams.");
			}
			map.put(ch, map.get(ch)-1);
			if(map.get(ch)==0) {
				map.remove(ch);
			}
		}
		
		if(map.isEmpty()) {
			System.out.println("Is Anagrams");
		}*/

		String str1 = "listen";
		String str2 = "silent";

		if (str1.length() != str2.length()) {
			System.out.println("Length is Not Same, So Not Anagrams.!");
		}

		Map<Character, Long> map1 = str1.chars().mapToObj(ch -> (char) ch)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		Map<Character, Long> map2 = str2.chars().mapToObj(ch -> (char) ch)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		
		if (map1.equals(map2)) {
			System.out.println("Is Anagrams");
		} else {
			System.out.println("Is Not Anagrams.!");
		}

	}

	private static void checkPalindrome() {
		/* String str = "aabb";
		 Set<Character> set = new HashSet<>();
		 for(char ch : str.toCharArray()) {
			 if(!set.add(ch)) {
				 set.remove(ch);
			 }
		 }
		 
		 if(set.size() <= 1) {
			 System.out.println("Is Palindrome...");
		 }else {
			 System.out.println("Is Not Palindrome.");
		 }*/

		/*String str = "abab";
		Map<Character, Long> map = str.chars().mapToObj(ch -> (char) ch)
				.collect(Collectors.groupingBy(c -> c, Collectors.counting()));
		long checkPalindrome = map.values().stream().filter(val -> val % 2 != 0).count();
		
		if(checkPalindrome <=1) {
			System.out.println("After Rearranging is Palindrome...");
		}else {
			System.out.println("Is Not Palindrome.!");
		}*/

		String str = "abab";
		Map<Character, Integer> map = new HashMap<>();

		for (char ch : str.toCharArray())
			map.put(ch, map.getOrDefault(ch, 0) + 1);

		int check = 0;
		for (int value : map.values())
			if (value % 2 != 0)
				check++;

		System.out.println(check <= 1 ? "After Rearranging is Palindrome..." : "Is Not Palindrome");
	}

	private static void frequecnyOfElement() {
		List<Integer> list = Arrays.asList(1, 2, 2, 3, 4, 4, 4, 5);
		Map<Integer, Long> map = list.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(map);

		/*
		Stream<String> s = Stream.<String>builder().add("A").add("B").add("C").build();
		s.forEach(ele-> System.out.println(ele));
		
		//Stream.builder() -> is used to build stream manually in java 8.
		*/

		/*
		Stream.generate(() -> "Hello").limit(2).forEach(System.out::println);
		
		//Stream.generate() -> It is used to create infinite stream
		*/

	}

	private static void margeTwoMaps() {
		Map<Integer, String> map1 = new LinkedHashMap<>();
		map1.put(1, "abc");
		map1.put(2, "pqr");

		Map<Integer, String> map2 = new LinkedHashMap<>();
		map2.put(3, "mno");
		map2.put(4, "xyz");

		map1.putAll(map2);

		System.out.println(map1);
	}

	private static void findDuplicateUsingJava8() {
		List<Integer> list = Arrays.asList(1, 2, 2, 3, 4, 4, 4, 5);
		Set<Integer> duplicates = list.stream().filter(ele -> Collections.frequency(list, ele) > 1)
				.collect(Collectors.toSet());

		System.out.println(duplicates);
	}

	private static void missingElements() {
		int arr[] = { 1, 2, 4, 6, 10 };
		// 3, 5, 7, 8, 9

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = arr[i] + 1; j < arr[i + 1]; j++) {
				System.out.print(j + " ");
			}
		}
		System.out.println();
	}

	private static void missingElement() {
		int arr[] = { 1, 2, 0, 3, 5 };
		int length = 5;
		int totalSum = length * (length + 1) / 2;
		int arrSum = 0;
		for (int num : arr) {
			arrSum = arrSum + num;
		}

		int missing = totalSum - arrSum;
		System.out.println("Missing :: " + missing);
	}

	private static void WordNumberSum() {
		String str1 = "thousand";
		String str2 = "four";

		Map<String, Integer> map = new HashMap<>();
		map.put("zero", 0);
		map.put("one", 1);
		map.put("two", 2);
		map.put("three", 3);
		map.put("four", 4);
		map.put("five", 5);
		map.put("six", 6);
		map.put("seven", 7);
		map.put("eight", 8);
		map.put("nine", 9);
		map.put("ten", 10);
		map.put("eleven", 11);
		map.put("twelve", 12);
		map.put("thirteen", 13);
		map.put("fourteen", 14);
		map.put("fifteen", 15);
		map.put("sixteen", 16);
		map.put("seventeen", 17);
		map.put("eighteen", 18);
		map.put("nineteen", 19);
		map.put("twenty", 20);
		map.put("thirty", 30);
		map.put("forty", 40);
		map.put("fifty", 50);
		map.put("sixty", 60);
		map.put("seventy", 70);
		map.put("eighty", 80);
		map.put("ninety", 90);
		map.put("hundred", 100);
		map.put("thousand", 1000);

		int num1 = 0;
		for (String word : str1.toLowerCase().split(" ")) {
			num1 = num1 + map.getOrDefault(word, 0);
		}

		int num2 = 0;
		for (String word : str2.toLowerCase().split(" ")) {
			num2 = num2 + map.getOrDefault(word, 0);
		}

		System.out.println("Sum is :: " + (num1 + num2));

	}

	private static void numberOp() {
		List<Integer> list = Arrays.asList(1, 2, 2, 3, 4, 4, 4, 5);
//		List<Integer> uniqueList = list.stream().distinct().toList();
//		System.out.println(uniqueList);

		Set<Integer> seen = new LinkedHashSet<>();
		Set<Integer> unique = new LinkedHashSet<>();

		for (int num : list) {
			if (!seen.add(num)) {
				unique.add(num);
			}
		}
		System.out.println(unique);
		System.out.println(seen);

	}

	private static void wordOccurrence() {
		String str = "java is good java is powerful";
		/*String[] split = str.split(" ");
		
		Map<String, Integer> map = new LinkedHashMap<String, Integer>();
		
		for (String word : split) {
			map.put(word, map.getOrDefault(word, 0) + 1);
		}
		
		System.out.println(map);*/

		String[] split = str.split(" ");

		for (int i = 0; i < split.length; i++) {

			if (split[i].equals("0")) {
				continue;
			}
			int count = 1;

			for (int j = i + 1; j < split.length; j++) {
				if (split[i].equals(split[j])) {
					count++;
					split[j] = "0";
				}
			}

			System.out.println(split[i] + "->" + count);
		}
	}

	private static void subsequenceCharacter() {
		String str = "aabbbccccdaaa";
		int count;

		for (int i = 0; i < str.length();) {
			count = 1;
			int j;
			for (j = i + 1; j < str.length(); j++) {
				if (str.charAt(i) == str.charAt(j)) {
					count++;
				} else {
					break;
				}
			}
			System.out.print(str.charAt(i) + "" + count);
			i = j;
		}
		System.out.println();

	}

	private static void removeDuplicates() {
		int[] arr = { 1, 2, 2, 2, 2, 3, 4, 4, 4, 5 };
		for (int i = 0; i < arr.length; i++) {
			int count = 0;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					count++;
				}
			}
			if (count == 1) {
				System.out.println(arr[i]);
			}
		}
	}

	private static void occurrence() {
		String str = "hello";
		/*Map<Character, Integer> map = new LinkedHashMap<>();
		
		for(Character ch : str.toCharArray()) {
			if(map.containsKey(ch)) {
				map.put(ch, map.get(ch)+1);
			}else {
				map.put(ch, 1);
			}
		}
		
		System.out.println(map);*/

		/*Map<Character, Integer> map = new LinkedHashMap<>();
		
		for (Character ch : str.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}
		
		System.out.println(map);*/

		/*LinkedHashMap<Character, Long> map = str.chars()
							.mapToObj(ch -> (char)ch)
							.collect(Collectors
									.groupingBy(ch -> ch, LinkedHashMap::new, 
											Collectors.counting()));
		System.out.println(map);*/

		char[] ch = str.toCharArray();

		for (int i = 0; i < ch.length; i++) {
			int count = 1;
			if (ch[i] == '0') {
				continue;
			}

			for (int j = i + 1; j < ch.length; j++) {
				if (ch[i] == ch[j]) {
					count++;
					ch[j] = '0';
				}
			}
			System.out.println(ch[i] + "->" + count);
		}
	}

	private static void palindrome() {
		String str = "madam";
		String rev = "";

		for (int i = str.length() - 1; i >= 0; i--) {
			rev = rev + str.charAt(i);
		}

		if (str.equals(rev)) {
			System.out.println(str + " Is Palindrome...");
		} else {
			System.out.println(str + " Is Not Palindrome.!");
		}

		int num = 1221;
		int revNum = 0;
		int temp = num;
		while (temp != 0) {
			int rem = temp % 10;
			revNum = revNum * 10 + rem;
			temp = temp / 10;
		}

		if (num == revNum) {
			System.out.println(num + " Is Palindrome...");
		} else {
			System.out.println(num + " Is Not Palindrome.!");
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
}


/*

Q. Can you explain Intermediate Operations in Streams?
A. Intermediate operations return another stream, allowing method chaining.
Examples include map(), filter(), sorted(), and distinct().
They are lazy and execute only when a terminal operation 
(like collect() or forEach()) is called.



Q. What is HTTP Status Code 204?
A. 204 means “No Content.” The request was successful, but the server
has no content to return in the response body.



Q. How does JWT work with Refresh Tokens?
A. When the access token expires, the refresh token (with a longer 
expiry) is used to generate a new access token without re-login.


*/