package com.nt.coding.challanges;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Pro02 {

	public static void main(String[] args) {

		reverseString();
		System.out.println();
		checkPalindrome();
		System.out.println();
		reverseNumber();
		System.out.println();
		factorial();
		System.out.println();
		fibonacciSeries();
		System.out.println();
		CheckPrimeNumber();
		System.out.println();
		printPrimeNums();
		System.out.println();
		checkArmstrong();
		System.out.println();
		swapTwoNums();
		System.out.println();
		duplicateOccurrence();
		System.out.println();
		countWords();
		System.out.println();
		findMinMaxSecondMaxMin();
		System.out.println();
		linearSearch();
		System.out.println();
		anagramCheck();
		System.out.println();

//=========>>> Java 8 <<<=============//
		
		System.out.println("=========>>> Java 8 <<<=============");
		
		System.out.println();
		findEvens();
		System.out.println();
		findWordStratsWith();
		System.out.println();
		OccurrenceOfCharacter();
		System.out.println();
		findDuplicateElements();
		System.out.println();
		firstNonRepeatingCharacter();
		System.out.println();
		sortList();
		System.out.println();
		maxElement();
		System.out.println();
		StringArrToMap();
		System.out.println();
		margeTwoArrays();
		System.out.println();
		secondHeighest();
		System.out.println();
		getSumOfList();
		System.out.println();
		countStringWithLength();
		System.out.println();
		convertListToUpperCase();
		System.out.println();
		removeDuplicate();
		System.out.println();
		sortDescending();
		System.out.println();
		findLongestString();
		System.out.println();
		joinStrings();
		System.out.println();
		convertMapToList();
		System.out.println();
		partationEvenOdd();
		System.out.println();
		groupByLength();
		System.out.println();
		flattenListOfList();
		System.out.println();
		wordFrequency();
		System.out.println();
		reduceMethodOp();
		System.out.println();
		OptionalOp();
		System.out.println();
		nthLargest();
		System.out.println();
		
	}

	private static void nthLargest() {
		List<Integer> list = Arrays.asList(4, 2, 6, 1, 3, 5);
		int nth = 3;
		Integer nthLargest = list.stream()
								.sorted(Comparator
										.reverseOrder())
								.skip(nth-1)
								.findFirst()
								.get();
		
		System.out.println(nthLargest);
	}

	private static void OptionalOp() {
		
		String str = null;
		Optional<String> opt = Optional
									.ofNullable(str);
		
		System.out.println(opt.orElse("default"));
	}

	private static void reduceMethodOp() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4);
		Integer prod = list.stream()
						.reduce(1, (a, b) -> a*b);
		
		System.out.println(prod);
	}

	private static void wordFrequency() {
		System.out.println();
		String str = "java is java and spring is java";
		Arrays.stream(str.split(" "))
			.collect(Collectors
					.groupingBy(word -> word, Collectors
							.counting()))
			.forEach((key, value) -> System.out.println(key+" -> "+value));
	}

	private static void flattenListOfList() {
		List<List<Integer>> list = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 4));
		 list.stream()
		 	.flatMap(l -> l
		 			.stream())
		 	.forEach(e -> System.out.print(e+" "));
	}

	private static void groupByLength() {
		List<String> list = Arrays.asList("hello", "java", "prgoramming");
		list.stream()
			.collect(Collectors
					.groupingBy(String::length))
			.forEach((key, value) -> System.out.println(key+" "+ value));
	}

	private static void partationEvenOdd() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
		list.stream()
			.collect(Collectors
					.partitioningBy(e -> e%2==0))
			.forEach((key, value) -> 
					System.out.println((key ? "Even":"Odd")+"->"+value));
		
	}

	private static void convertMapToList() {
		Map<Integer, String> map = Map.of(1, "one", 2, "two");
		List<String> list = map.values()
							.stream()
							.toList();
		
		System.out.println(list);
	}

	private static void joinStrings() {
		List<String> list = Arrays.asList("a", "b", "c");
		String result = list.stream()
						.collect(Collectors.joining(", "));
		
		System.out.println(result);
	}

	private static void findLongestString() {
		System.out.println();
		List<String> list = Arrays.asList("java", "is", "programming", "language");
		String longest = list.stream().max(Comparator.comparing(String::length)).get();
		System.out.println(longest);
	}

	private static void sortDescending() {
		System.out.println();
		List<Integer> list = Arrays.asList(4, 1, 3, 5, 2);
		list.stream()
			.sorted((a, b) -> -a.compareTo(b))
			.forEach(e -> System.out.print(e+" "));
	}

	private static void removeDuplicate() {
		System.out.println();
		List<Integer> list = Arrays.asList(1, 2, 2, 3,6, 5, 6, 4, 4, 5);
		list.stream()
			.distinct()
			.forEach(e -> System.out.print(e+" "));
	}

	private static void convertListToUpperCase() {
		List<String> list = Arrays.asList("abc", "pqr");
		list.stream()
			.map(String::toUpperCase)
			.forEach(System.out::println);
	}

	private static void countStringWithLength() {
		List<String> list = Arrays.asList("i", "am", "gokul");
		list.stream()
			.filter(e -> e.length()>3)
			.forEach(System.out::println);
	}

	private static void getSumOfList() {
		List<Integer> list = Arrays.asList(2, 3, 4, 5, 1);
		int sum = list.stream()
					.mapToInt(Integer::intValue)
					.sum();
		
		System.out.println(sum);
	}
	

	private static void secondHeighest() {
		System.out.println();
		List<Integer> list = Arrays.asList(1, 3, 5, 2, 4);
		Integer secondHeighest = list.stream()
					.sorted(Comparator
							.reverseOrder())
					.skip(1)
					.findFirst().get();
		
		System.out.println(secondHeighest);
	}

	private static void margeTwoArrays() {
		
		Stream.concat(
				Arrays.asList(1, 2, 3).stream(),
				Arrays.asList(3, 4, 5).stream())
			.forEach(e -> System.out.print(e+" "));
	}

	private static void StringArrToMap() {
		String[] str = {"a" ,"bb", "ccc", "dddd"};
		Arrays.stream(str)
			.collect(Collectors
					.toMap(s -> s, s -> s.length()))
			.forEach((key, value) -> System.out.println(key+" "+value));
	}

	private static void maxElement() {
		int[] arr = {1, 5, 3, 4, 6, 7, 3, 5};
		int max = Arrays.stream(arr)
					.max()
					.getAsInt();
		
		System.out.println(max);
	}

	private static void sortList() {
		String[] str = {"Abc", "Karan", "Arjun", "Spring"};
		Arrays.stream(str)
			.sorted()
			.forEach(System.out::println);
	}

	private static void firstNonRepeatingCharacter() {	
		String str = "swiss";
		LinkedHashMap<Character, Long> map = str.chars()
			.mapToObj(ch -> (char)ch)
			.collect(Collectors
					.groupingBy(s -> s, LinkedHashMap::new, Collectors.counting()));
		
		Character result = map
							.entrySet()
							.stream()
							.filter(e -> e.getValue()==1)
							.map(Map.Entry::getKey)
							.findFirst()
							.orElse(null);
		
		System.out.println(result);
		
	}

	private static void findDuplicateElements() {
		int[] arr = {1, 2, 2, 3, 4, 4, 5};
		Set<Integer> duplicate = new HashSet<>();
		Arrays.stream(arr)
				.filter(e -> !duplicate.add(e))
				.forEach(System.out::println);
	}

	private static void OccurrenceOfCharacter() {
		String str = "java";
		Arrays.stream(str.split(""))
			.collect(Collectors
					.groupingBy(s -> s, Collectors.counting()))
			.forEach((key, value) -> System.out.println(key+"->"+value));
	}

	private static void findWordStratsWith() {
		String[] str = {"Backend", "Frontend", "String", "Spring", "Boot", "Java"};
		Arrays.stream(str)
			.filter(e -> e.startsWith("B"))
			.forEach(System.out::println);
		
	}

	private static void findEvens() {
		int arr[] = {1, 2, 3, 4, 5, 6, 7};
		Arrays.stream(arr)
			.filter(e -> e%2==0)
			.forEach(System.out::println);
	}

	private static void anagramCheck() {
		String str1 = "listen";
		String str2 = "silent";
		
		/*char[] ch1 = str1.toCharArray();
		char[] ch2 = str2.toCharArray();
		Arrays.sort(ch1);
		Arrays.sort(ch2);
		
		if(Arrays.equals(ch1, ch2)) {
			System.out.println("Is Anagrams...");
		}else {
			System.out.println("Is Not Anagrams.!");
		}*/
		
		int count1 = 0;
		int count2 = 0;
		
		if(str1.length()==str2.length()) {
			for(int i=0; i<str1.length(); i++) {
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
			}
		}else {
			System.out.println("Length is Not Same, so Not Anagrams.!");
		}
	}

	private static void linearSearch() {
		int arr[] = {1, 2, 3, 4, 5, 6, 7};
		int target = 4;
		boolean flag = false;
		for(int num : arr) {
			if(num == target) {
				flag = true;
				break;
			}
		}
		
		if(flag) {
			System.out.println("Elemenet is Found...");
		}else {
			System.out.println("Element Not Found.!");
		}
		
	}

	private static void findMinMaxSecondMaxMin() {
		int[] arr = {1, 1, 2, 3, 4, 4, 5};
		if (arr == null || arr.length == 0) {
            System.out.println("Array is empty");
            return;
        }
        if (arr.length == 1) {
            System.out.println("Only one element: " + arr[0]);
            System.out.println("No second max/min available.");
            return;
        }

        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;

        for (int num : arr) {
            if (num > max) {
                secondMax = max;
                max = num;
            } else if (num > secondMax && num < max) {
                secondMax = num;
            }

            if (num < min) {
                secondMin = min;
                min = num;
            } else if (num < secondMin && num > min) {
                secondMin = num;
            }
        }

        System.out.println("Max :: " + max);
        if (secondMax == Integer.MIN_VALUE) {
            System.out.println("Second Max :: (no distinct second max)");
        } else {
            System.out.println("Second Max :: " + secondMax);
        }

        System.out.println("Min :: " + min);
        if (secondMin == Integer.MAX_VALUE) {
            System.out.println("Second Min :: (no distinct second min)");
        } else {
            System.out.println("Second Min :: " + secondMin);
        }
    }

    

	private static void countWords() {
		String str = "java is Programming Language";
		String[] split = str.split(" ");
		System.out.println(split.length);
	}

	private static void duplicateOccurrence() {
		String str = "java programming";
		
		Map<Character, Integer> map = new HashMap<>();
		for(Character ch : str.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0)+1);
		}
		
		map.forEach((key, value) -> {
			if(value > 1) {
				System.out.println(key+"->"+value);
			}
		});
	}

	private static void swapTwoNums() {
		/*int num1 = 10;
		int num2 = 20;
		
		num1 = num1 ^ num2;
		num2 = num1 ^ num2;
		num1 = num1 ^ num2;
		System.out.println(num1+" "+num2);*/
		
		int num1 = 10;
		int num2 = 20;
		int temp = num1;
		num1 = num2;
		num2 = temp;
		System.out.println(num1+" "+num2);
	}

	private static void checkArmstrong() {
		System.out.println();
		int num = 153;
		int temp = num;
		int sum = 0;

		while (num > 0) {
			int rem = num % 10;
			sum = sum + rem * rem * rem;
			num = num / 10;
		}

		if (sum == temp) {
			System.out.println(temp + " Is Armstrong...");
		} else {
			System.out.println(temp + " Is Not Armstrong.!");
		}
	}

	private static void printPrimeNums() {
		int limit = 20;

		for (int i = 2; i <= limit; i++) {
			boolean flag = true;
			for (int j = 2; j <= i / 2; j++) {
				if (i % j == 0) {
					flag = false;
					break;
				}
			}

			if (flag) {
				System.out.print(i + " ");
			}
		}
	}

	private static void CheckPrimeNumber() {
		System.out.println();
		int num = 19;
		boolean flag = false;

		for (int i = 2; i <= num / 2; i++) {
			if (num % i == 0) {
				flag = true;
			}
		}

		if (!flag) {
			System.out.println(num + " Is Prime...");
		} else {
			System.out.println(num + " Is Not Prime.!");
		}
	}

	private static void fibonacciSeries() {
		int f1 = 0;
		int f2 = 1;
		int fib;

		for (int i = 0; i <= 10; i++) {
			System.out.print(f1 + " ");
			fib = f1 + f2;
			f1 = f2;
			f2 = fib;
		}
	}

	private static void factorial() {
		int num = 5;
		int fact = 1;
		for (int i = 1; i <= num; i++) {
			fact = fact * i;
		}

		System.out.println(fact);
	}

	private static void reverseNumber() {
		int num = 1234;
		int rev = 0;
		while (num != 0) {
			int rem = num % 10;
			rev = rev * 10 + rem;
			num = num / 10;
		}

		System.out.println(rev);
	}

	private static void checkPalindrome() {
		String str = "pop";
		String rev = new StringBuilder(str).reverse().toString();
		if (rev.equals(rev)) {
			System.out.println(str + " Is Palindrome...");
		} else {
			System.out.println(str + " Is Not Palindrome.!");
		}
	}

	private static void reverseString() {
		String str = "hello";
		String rev = "";

		for (int i = str.length() - 1; i >= 0; i--) {
			rev = rev + str.charAt(i);
		}

		System.out.println(rev);
	}
}
