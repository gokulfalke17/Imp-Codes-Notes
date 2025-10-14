package com.nt.coding.challanges;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Coding_Challanges03_iMicha {

	public static void main(String[] args) {

		reverseString();
		System.out.println();
		checkPalindrome();
		System.out.println();
		findSecondHeighest();
		System.out.println();
		characterFreq();
		System.out.println();
		missingNum();
		System.out.println();
		findDuplicateElements();
		System.out.println();
		removeDuplicatesCharacters();
		System.out.println();
		bubbleSort();
		System.out.println();
		fibonacciSeries();
		System.out.println();
		checksAnagrams();
		System.out.println();

//-----------------------------------------//

		reverseNumber();
		System.out.println();
		factorial();
		System.out.println();
		countVowels();
		System.out.println();
		checkPrimeNumber();
		System.out.println();
		sumDigits();
		System.out.println();
		swapNumsWithoutPlusAndTemp();
		System.out.println();
		countWords();
		System.out.println();
		findMaxNum();
		System.out.println();
		evenOdd();
		System.out.println();
		findFirstNonRepeating();
		System.out.println();
		findSameElements();
		System.out.println();
		pairSum();
		System.out.println();
		mejorityArray();
		System.out.println();
		moveZerosLast();
		System.out.println();
		kthRotate();
		System.out.println();
		magicalNumberCount();
		System.out.println();
		guestHappyNumberWindow();
		System.out.println();

	}

	private static void guestHappyNumberWindow() {
		int arr[] = { 1, 2, 1, 3, 2 };
		int k = 3;
		int maxDistinct = 0;

		for (int i = 0; i < arr.length - k; i++) {
			Set<Integer> set = new HashSet<>();
			for (int j = i; j < i + k; j++) {
				set.add(j);
			}

			maxDistinct = Math.max(maxDistinct, set.size());
		}
		System.out.println("Max Distinct Guest in Array Window :: " + maxDistinct);
	}

	private static void magicalNumberCount() {
		int arr[] = { 8, 13, 40, 28, 55 };
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			int temp = arr[i];
			int sum = 0;
			int prod = 1;

			while (temp != 0) {
				int rem = temp % 10;
				sum = sum + rem;
				prod = prod * rem;
				temp = temp / 10;
			}

			if (sum % arr.length == 0 && prod % arr.length == 0) {
				System.out.println(arr[i] + " Is Magical Nums.");
				count++;
			}
		}

		System.out.println("Magical Numbers Count :: " + count);
	}

	private static void kthRotate() {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
		int kth = 4;
	}

	private static void moveZerosLast() {
		int[] arr = { 1, 0, 4, 0, 5, 5, 0, 0 };
		int count = 0;

		for (int num : arr) {
			if (num != 0) {
				arr[count++] = num;
			}
		}

		while (count < arr.length) {
			arr[count++] = 0;
		}

		System.out.println(Arrays.toString(arr));
	}

	private static void mejorityArray() {
		int arr[] = { 2, 2, 1, 2, 3, 2, 2 };
		int count = 0;
		int flag = 0;

		for (int num : arr) {
			if (count == 0) {
				flag = num;
			}

			count += (num == flag) ? 1 : -1;
		}

		count = 0;

		for (int num : arr) {
			if (num == flag) {
				count++;
			}
		}

		if (count > arr.length / 2) {
			System.out.println("Is Mejority Array...");
		} else {
			System.out.println("Is Not Mejority Array.!");
		}
	}

	private static void pairSum() {
		int[] arr = { 1, 2, 3, 7, 5, 3 };
		int target = 7;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] + arr[j] == target) {
					// System.out.println(i + ", " + j);
					System.out.println(arr[i] + ", " + arr[j]);
				}
			}
		}
	}

	private static void findSameElements() {
		int[] arr1 = { 1, 2, 3, 4 };
		int[] arr2 = { 3, 4, 5, 6 };

		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr2.length; j++) {
				if (arr1[i] == arr2[j]) {
					System.out.print(arr1[i] + " ");
				}
			}
		}
		System.out.println();

	}

	private static void findFirstNonRepeating() {
		System.out.println();
		String str = "swiss";

//		for (int i=str.length()-1; i>=0; i--) {	//last non-repeating
		for (int i = 0; i < str.length(); i++) { // first non-repeating
			boolean flag = false;
			for (int j = 0; j < str.length(); j++) {
				if (i != j && str.charAt(i) == str.charAt(j)) {
					flag = true;
				}
			}
			if (!flag) {
				System.out.println(str.charAt(i));
				break;
			}
		}
	}

	private static void evenOdd() {
		int[] arr = { 3, 6, 2, 5, 4, 6, 9 };
		int[] evens = Arrays.stream(arr).filter(n -> n % 2 == 0).toArray();
		for (int e : evens) {
			System.out.print(e + " ");
		}
		System.out.println("\n");

		int[] odds = Arrays.stream(arr).filter(n -> n % 2 != 0).toArray();
		for (int o : odds) {
			System.out.print(o + " ");
		}
	}

	private static void findMaxNum() {
		int arr[] = { 1, 5, 8, 6, 9, 8, 3 };
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			if (max < arr[i]) {
				max = arr[i];
			}
		}

		System.out.println(max);
	}

	private static void countWords() {
		String str = "   hello word    ".trim();
		String[] split = str.split(" ");

		int noOfWords = split.length;
		System.out.println(noOfWords);
	}

	private static void swapNumsWithoutPlusAndTemp() {
		int num1 = 10;
		int num2 = 20;

		num1 = num1 ^ num2;
		num2 = num1 ^ num2;
		num1 = num1 ^ num2;

		System.out.println(num1 + ", " + num2);
	}

	private static void sumDigits() {
		int num = 123;
		int sum = 0;
		while (num != 0) {
			int rem = num % 10;
			sum = sum + rem;
			num = num / 10;
		}

		System.out.println(sum);
	}

	private static void checkPrimeNumber() {
		int num = 23;
		boolean flag = false;
		for (int i = 2; i < num / 2; i++) {
			if (num % i == 0) {
				flag = true;
			}
		}

		System.out.println(!flag ? "Is Prime Number..." : "Is Not Prime Number.!");
	}

	private static void countVowels() {
		String str = "hello world";
		int vowelCount = 0;
		char[] ch = str.toCharArray();
		for (int i = 0; i < str.length(); i++) {
			if (ch[i] == 'a' || ch[i] == 'e' || ch[i] == 'i' || ch[i] == 'o' || ch[i] == 'u' || ch[i] == 'A'
					|| ch[i] == 'E' || ch[i] == 'I' || ch[i] == 'O' || ch[i] == 'U') {
				vowelCount++;
			}
		}

		System.out.println(vowelCount);
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
		int num = 123;
		int rev = 0;
		while (num != 0) {
			int rem = num % 10;
			rev = rev * 10 + rem;
			num = num / 10;
		}

		System.out.println(rev);
	}

	private static void checksAnagrams() {
		System.out.println();
		String str1 = "anuj";
		String str2 = "juna";

		char[] ch1 = str1.toCharArray();
		char[] ch2 = str2.toCharArray();

		Arrays.sort(ch1);
		Arrays.sort(ch2);

		System.out.println(Arrays.equals(ch1, ch2) ? "Is Anagram..." : "Is Not Anagram.!");

	}

	private static void fibonacciSeries() {
		int limit = 8;
		int f1 = 0;
		int f2 = 1;
		int fib;

		for (int i = 0; i < limit; i++) {
			fib = f1 + f2;
			System.out.print(fib + " ");
			f1 = f2;
			f2 = fib;
		}
	}

	private static void bubbleSort() {
		int[] arr = { 0, 9, 8, 7, 6, 5 };

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] < arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}

		for (int num : arr) {
			System.out.print(num + " ");
		}
		System.out.println();
	}

	private static void removeDuplicatesCharacters() {
		String str = "programming";

		for (int i = 0; i < str.length(); i++) {
			boolean flag = false;
			for (int j = 0; j < i; j++) {
				if (str.charAt(i) == str.charAt(j)) {
					flag = true;
				}
			}
			if (!flag) {
				System.out.print(str.charAt(i));
			}
		}
		System.out.println();
	}

	private static void findDuplicateElements() {
		int arr[] = { 1, 2, 3, 3, 4, 5, 6, 5 };
		for (int i = 0; i < arr.length; i++) {
			int count = 0;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					count++;
				}
			}
			if (count != 0) {
				System.out.print(arr[i] + " ");
			}
		}
		System.out.println();
	}

	private static void missingNum() {
		int[] arr = { 1, 2, 3, 4, 6, 7 };
		int nums = 7;

		int totalSum = nums * (nums + 1) / 2;
		int arrSum = 0;
		for (int num : arr) {
			arrSum = arrSum + num;
		}

		System.out.println("Missing Number :: " + (totalSum - arrSum));
	}

	private static void characterFreq() {
		String str = "banana";
		/*Map<Character, Integer> map = new LinkedHashMap<>();
		for(char ch : str.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0)+1);
		}
		
		map.forEach((key, value) -> System.out.println(key +" -> "+ value));*/

		boolean[] flag = new boolean[str.length()];

		for (int i = 0; i < str.length(); i++) {
			int count = 0;
			if (!flag[i]) {
				for (int j = 0; j < str.length(); j++) {
					if (str.charAt(i) == str.charAt(j)) {
						flag[j] = true;
						count++;
					}
				}
			}
			if (count != 0 && flag[i]) {
				System.out.print(str.charAt(i) + "" + count);
			}
		}

		System.out.println();
	}

	private static void findSecondHeighest() {
		int arr[] = { 1, 4, 3, 6, 3, 3, 2, 7, 5, 7, 4 };
		int heighest = 0;
		int second = 0;

		for (int i = 0; i < arr.length; i++) {
			if (heighest < arr[i]) {
				second = heighest;
				heighest = arr[i];
			} else if (second <= arr[i] && heighest != arr[i]) {
				second = arr[i];
			}
		}

		System.out.println("Heighest :: " + heighest + "\nSecond Heighest :: " + second);
	}

	private static void checkPalindrome() {
		String str = "racar";
		String rev = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			rev = rev + str.charAt(i);
		}

		if (str.equals(rev)) {
			System.out.println("Is Palindrome...");
		} else {
			System.out.println("Is Not Palindrome.!");
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
