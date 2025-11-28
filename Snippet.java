package com.nt.coding.challanges;

import java.util.HashSet;
import java.util.Set;

public class Snippet {
	private static void longestSubstringWithoutRepeatingCharacter() {
	    String str = "aabbbccccda";
	    Set<Character> set = new HashSet<>();
	    int left = 0;
	    int longest = 0;
	    int start = 0; // to track substring start index
	
	    for (int right = 0; right < str.length(); right++) {
	        char ch = str.charAt(right);
	
	        // If duplicate found, shrink window from the left
	        while (set.contains(ch)) {
	            set.remove(str.charAt(left++));
	        }
	
	        // Add current char to set
	        set.add(ch);
	
	        // Update max length and start index
	        if (right - left + 1 > longest) {
	            longest = right - left + 1;
	            start = left;
	        }
	    }
	
	    // Extract substring using the recorded start and longest
	    String longestSubstring = str.substring(start, start + longest);
	
	    System.out.println("Longest Substring length :: " + longest);
	    System.out.println("Longest Substring :: " + longestSubstring);
	}
	
}

