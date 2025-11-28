package com.nt.coding.challanges;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Coding_Challanges02 {

	public static void main(String[] args) {

		/*
		
		
		
		Which java version we use.
		What are ClassLoaders and types of ClassLoaders.
		For Intern Communation what we are using.
		What is ClassLoader and Types of ClassLoaders.
		What is Deligation principle in java.
		What is Difference ClassPath and Path.
		What is Transient and where it use.
		Class A extends Class B But class A Searized but i don't want to seariazed 
		that class B then how to restrict that.
		What is Garbage Collector in java.
		What are the alternative approatch then using System.gc() appart form this.
		What is internal implementation of HashSet.
		What is Enum in java.
		In Threading we have two ways to create thread which is good.
		Difference between count-down latch and cyclicbarrier in java.
		What is Lock interface and its implementation and which scenarios it is better to 
		use locks over traditional synchronized block in java.
		What is difference between race condition and what is deadlock in java.
		How to avoid deadlock situation in our application.
		What is mean by autoBoxing and autounboxing in java.
		Executor framework -> Explain it flow.
		Difference between execute.submit() and execute.execute() methods.
		What are design pattens we use.
		What is difference between abstract factory and factory design pattern.
		How many ways we handles security in your application.
		
		
		
		
		*/

		// check number is prime or not
		checkPrintNumber(); // 17 -> is prime 1, 17
		System.out.println();
		// print factorial
		factorialNum(); // 5 -> 120 : 1*2*3*4*5
		System.out.println();
		// check armstrong numer
		checkArmstrongNum(); // 153 -> 1*1*1 + 5*5*5 + 3*3*3 = 158
		System.out.println();
		// reverse number
		reverseNum(); // 123 -> 321
		System.out.println();
		// check number palindrome or not
		checkPalindromNUm(); // 121 <--> 121 palindrome
		System.out.println();
		// greatest common divider
		GCD(); // 24, 54 -> 6 Greatest Common Divider
		System.out.println();
		// fibonacci series
		fibonacciSeries(); // 1 1 2 3 5 8 13
		System.out.println();
		// sum of each digit
		sumOfDigits(); // 453 = 12
		System.out.println();
		// swap two numbers without + operator and without third variable
		swapTwoNumbers(); // 10, 20 -> 20, 10
		System.out.println();
		// print prime numbers
		printPrimeNums(); // 1, 2, 3, 5, 7, 11,13, 17
		System.out.println();

		// LeetCode
		// remove given element from array
		removeElement(); // 3 2 2 3 -> target = 3 -> output 2 2
		System.out.println();

		// remove duplicate elements from array
		removeDuplicates(); // 1 2 2 3 4 -> 1 2 3 4
		System.out.println();

		// just +1 of last element of an array
		plusOne(); // 1 2 3 -> 1 2 4
		System.out.println();

		// multiply two string numbers
		multiplyOfTwoStrings(); // "120" * "2" -> 240
		System.out.println();

		// get the group of anagrams
		groupAnagrams(); // ["eat","tea","tan","ate","nat","bat"]
		System.out.println();// output -> [["bat"], ["tan","nat"], ["eat","tea","ate"]]
	}

	private static void groupAnagrams() {
		String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };

		ArrayList<List<String>> anagramList = 
					new ArrayList<>(Arrays.stream(strs)
						.collect(Collectors.groupingBy(s -> {
						char[] ch = ((String) s).toCharArray();
						Arrays.sort(ch);
						return new String(ch);
		})).values());

		anagramList.forEach(System.out::println);
	}

	private static void multiplyOfTwoStrings() {
		System.out.println();
		String num1 = "120";
		String num2 = "2";
		String multiply = new BigInteger(num1).multiply(new BigInteger(num2)).toString();

		System.out.println(multiply);
	}

	public static void plusOne() {
		System.out.println();
		int digits[] = { 1, 2, 3 };

		for (int i = digits.length - 1; i >= 0; i--) {
			if (digits[i] < 9) {
				digits[i]++;
				for (int n : digits) {
					System.out.print(n + " ");
				}
				return;
			}
			digits[i] = 0;

		}
		int[] result = new int[digits.length + 1];
		result[0] = 1;

		for (int n : result) {
			System.out.print(n + " ");
		}

	}

	public static void removeDuplicates() {
		System.out.println();
		int nums[] = { 1, 1, 2 };
		if (nums.length == 0)
			System.out.println(0);

		Set<Integer> set = new LinkedHashSet<>();
		for (int num : nums) {
			set.add(num);
		}

		int index = 0;
		for (int n : set) {
			nums[index++] = n;
		}

		for (int i = 0; i < index; i++) {
			System.out.print(nums[i] + " ");
		}
	}

	public static void removeElement() {
		System.out.println();
		int arr[] = { 3, 2, 2, 3 };
		int target = 3;

		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != target) {
				arr[count++] = arr[i];
			}
		}

		for (int i = 0; i < count; i++) {
			System.out.print(arr[i] + " ");
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

	private static void swapTwoNumbers() {
		int num1 = 10;
		int num2 = 20;

		num1 = num1 ^ num2;
		num2 = num1 ^ num2;
		num1 = num1 ^ num2;

		System.out.println(num1 + "  " + num2);
	}

	private static void sumOfDigits() {
		System.out.println();
		int num = 453;
		int sum = 0;
		while (num != 0) {
			sum = sum + num % 10;
			num = num / 10;
		}
		System.out.println(sum);
	}

	private static void fibonacciSeries() {
		int f1 = 0;
		int f2 = 1;
		int fib;

		for (int i = 0; i <= 8; i++) {
			System.out.print(f2 + " ");
			fib = f1 + f2;
			f1 = f2;
			f2 = fib;
		}
	}

	private static void GCD() {
		int num1 = 24;
		int num2 = 54;

		while (num2 != 0) {
			int temp = num2;
			num2 = num1 % num2;
			num1 = temp;
		}

		System.out.println(num1);
	}

	private static void checkPalindromNUm() {
		int num = 121;
		int rev = 0;
		int temp = num;
		while (temp != 0) {
			int rem = temp % 10;
			rev = rev * 10 + rem;
			temp = temp / 10;
		}

		if (num == rev) {
			System.out.println(num + " Is Palindrome...");
		} else {
			System.out.println(num + " Is Not Palindrome.!");
		}
	}

	private static void reverseNum() {
		int num = 123;
		int rev = 0;

		while (num != 0) {
			int rem = num % 10;
			rev = rev * 10 + rem;
			num = num / 10;
		}

		System.out.println(rev);
	}

	private static void checkArmstrongNum() {
		int num = 153;
		int sum = 0;
		int temp = num;
		while (temp > 0) {
			int rem = temp % 10;
			sum = sum + rem * rem * rem;
			temp = temp / 10;
		}

		if (num == sum) {
			System.out.println(num + " Is Armstrong...");
		} else {
			System.out.println(num + " Is Not Armstrong.!");
		}
	}

	private static void factorialNum() {
		int num = 5;
		int fact = 1;
		for (int i = 1; i <= num; i++) {
			fact = fact * i;
		}
		System.out.println(fact);
	}

	private static void checkPrintNumber() {
		int num = 19;
		boolean flag = true;
		for (int i = 2; i <= num / 2; i++) {
			if (num <= 1) {
				flag = false;
			}

			if (num % i == 0) {
				flag = false;
				break;
			}
		}

		if (flag) {
			System.out.println(num + " Is Prime Number...");
		} else {
			System.out.println(num + " Is Not Prime.!");
		}

	}
}
