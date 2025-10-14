package com.nt.coding.challanges;

import java.util.Arrays;

public class Coding_Challanges01 {

	public static void main(String[] args) {

		// reverse string
		reverseString(); // hello -> olleh
		System.out.println();
		// check palindrome string
		checkPalindrome(); // madam <--> madam
		System.out.println();
		// find first non-repeating char
		firstNonRepeating(); // swiss -> w
		System.out.println();
		// count vowles and consonent
		vowelsAndConsonentCount(); // hello -> v-> 2 c->3
		System.out.println();
		// remove duplicate characters
		removeDuplicate(); // programming -> progamin
		System.out.println();
		// reverse each word
		reverseEachWord(); // hello world -> olleh dlrow
		System.out.println();
		// find longest word
		findLongestWord(); // java is plateform independent language -> independent
		System.out.println();
		// check two strings are anagrams are not
		checkAnagramStrings(); // silent <--> listen
		System.out.println();
		// find duplicate characters
		findDuplicateCharcters(); // programming -> r g m
		System.out.println();
		mostFrequentChars();	//successes -> s, hello -> l

	}

	private static void mostFrequentChars() {
		System.out.println();
		String str = "successes";
        int[] freq = new int[256];
        for (char ch : str.toCharArray()) {
            freq[ch]++;
        }
        char maxChar = ' ';
        int max = 0;
        for (char ch : str.toCharArray()) {
            if (freq[ch] > max) {
                max = freq[ch];
                maxChar = ch;
            }
        }
        System.out.println(maxChar);
	}

	private static void findDuplicateCharcters() {
		String str = "programming";
		boolean[] flag = new boolean[str.length()];
		for (int i = 0; i < str.length(); i++) {
			if (flag[i]) {
				continue;
			}
			int count = 0;
			for (int j = i + 1; j < str.length(); j++) {
				if (str.charAt(i) == str.charAt(j)) {
					count++;
					flag[j] = true;
				}
			}
			if (count >= 1) {
				System.out.print(str.charAt(i) + " ");
			}
		}
	}

	private static void checkAnagramStrings() {
		String str1 = "silent";
		String str2 = "listen";

		if (str1.length() != str2.length()) {
			System.out.println("Is Not Anagrams, Lengths are not Same.!");
		}

		char[] ch1 = str1.toCharArray();
		char[] ch2 = str2.toCharArray();
		Arrays.sort(ch1);
		Arrays.sort(ch2);
		if (Arrays.equals(ch1, ch2)) {
			System.out.println("Is Anagrams...");
		} else {
			System.out.println("Is Not Anagrams.!");
		}
	}

	private static void findLongestWord() {
		System.out.println();
		String str = "java is plateform independent language";
		String longest = "";

		String[] split = str.split(" ");

		for (String s : split) {
			if (s.length() > longest.length()) {
				longest = s;
			}
		}
		System.out.println(longest);
	}

	private static void reverseEachWord() {
		System.out.println();
		String str = "hello world";
		/*String[] split = str.split(" ");
		String result = "";
		
		for (String s : split) {
			result = result + new StringBuffer(s).reverse().toString() + " ";
		}
		
		System.out.println(result.trim());*/

		String[] split = str.split(" ");

		for (String s : split) {
			int start = 0;
			int end = s.length() - 1;
			char[] ch = s.toCharArray();
			while (start < end) {
				char temp = ch[start];
				ch[start] = ch[end];
				ch[end] = temp;
				start++;
				end--;
			}
			System.out.print(new String(ch) + " ");
		}
	}

	private static void removeDuplicate() {
		String str = "programming";
		for (int i = 0; i < str.length(); i++) {
			int count = 0;
			for (int j = i + 1; j < str.length(); j++) {
				if (i != j && str.charAt(i) == str.charAt(j)) {
					count++;
				}
			}

			if (count != 1) {
				System.out.print(str.charAt(i));
			}
		}
	}

	private static void vowelsAndConsonentCount() {
		String str = "hello";
		int vCount = 0;
		int cCount = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o'
					|| str.charAt(i) == 'u' || str.charAt(i) == 'A' || str.charAt(i) == 'E' || str.charAt(i) == 'I'
					|| str.charAt(i) == 'O' || str.charAt(i) == 'U') {
				vCount++;
			}

			if (!(str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o'
					|| str.charAt(i) == 'u' || str.charAt(i) == 'A' || str.charAt(i) == 'E' || str.charAt(i) == 'I'
					|| str.charAt(i) == 'O' || str.charAt(i) == 'U') && str.charAt(i) >= 'a' && str.charAt(i) <= 'z'
					|| str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
				cCount++;
			}
		}

		System.out.println("V -> " + vCount + "\nC -> " + cCount);
	}

	private static void firstNonRepeating() {
		String str = "swiss";
		for (int i = 0; i < str.length(); i++) {
			boolean flag = false;
			for (int j = 0; j < str.length(); j++) {
				if (i != j && str.charAt(i) == str.charAt(j)) {
					flag = true;
					break;
				}
			}
			if (!flag) {
				System.out.println(str.charAt(i));
				break;
			}
		}
	}

	private static void checkPalindrome() {
		String str = "madam";
		String rev = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			rev = rev + str.charAt(i);
		}

		if (rev.equals(str)) {
			System.out.println("Is Palindrome...");
		} else {
			System.out.println("Is Not Palindrome.!");
		}
	}

	private static void reverseString() {
		String str = "hello";
		char[] ch = str.toCharArray();
		int start = 0;
		int end = str.length() - 1;

		while (start < end) {
			char temp = ch[start];
			ch[start] = ch[end];
			ch[end] = temp;
			start++;
			end--;
		}

		System.out.println(new String(ch));
	}

}
