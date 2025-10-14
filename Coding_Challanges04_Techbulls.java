package com.nt.coding.challanges;

import java.util.Arrays;

public class Coding_Challanges04_Techbulls {

	public static void main(String[] args) {

		System.out.println();
		pattern01();
		System.out.println();
		pattern02();
		System.out.println();
		pattern03();
		System.out.println();
		pattern04();
		System.out.println();
		pattern05();
		System.out.println();
		pattern06();
		System.out.println();
		pattern07();
		System.out.println();
		reverseNumber();
		System.out.println();
		reverseArray();
		System.out.println();
		reverseString();
		System.out.println();
		reverseSentence();
		System.out.println();
		reverseEachWord();
		System.out.println();
		kthRotate();
		System.out.println();
		targateTwoSum();
		System.out.println();
		removeDuplicate();
		System.out.println();
		movesZerosLeft();
		System.out.println();
		findMissingNum();
		System.out.println();
		findMissingNums();
		System.out.println();
		maxSubarraySum();
		System.out.println();
		mergeArray();
		System.out.println();

	}

	private static void mergeArray() {
		int[] arr = {1, 3, 5};
        int[] brr = {2, 4, 6};
        int[] crr = new int[arr.length + brr.length];

        int i = 0, j = 0; 

        for (int k = 0; k < crr.length; k++) {
            if (i < arr.length && j < brr.length) {
                if (arr[i] <= brr[j]) {
                    crr[k] = arr[i++];
                } else {
                    crr[k] = brr[j++];
                }
            } else if (i < arr.length) {
                crr[k] = arr[i++];
            } else {
                crr[k] = brr[j++];
            }
        }

        System.out.println("Merge Two Arrays :: ");
        for (int nums : crr) {
            System.out.print(nums + " ");
        }
	}

	private static void maxSubarraySum() {
		int[] arr = { -2, -3, 4, -1, -2, 1, 5, -3 };

		int maxSum = arr[0];
		int currSum = arr[0];

		for (int i = 0; i < arr.length; i++) {
			if (currSum + arr[i] > arr[i]) {
				currSum = currSum + arr[i];
			} else {
				currSum = arr[i];
			}
			if (currSum > maxSum) {
				maxSum = currSum;
			}
		}
		System.out.println("Max Subarray Sum :: " + maxSum);
	}

	private static void findMissingNums() {
		int[] arr = { 1, 2, 3, 5, 8 };

		System.out.println("Missing Nums :: ");
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = arr[i] + 1; j < arr[i + 1]; j++) {
				System.out.print(j + " ");
			}
		}
		System.out.println();
	}

	private static void findMissingNum() {
		int[] arr = { 1, 2, 3, 5 };
		int length = arr.length + 1;
		int totalSum = length * (length + 1) / 2;
		int arrSum = 0;
		for (int nums : arr) {
			arrSum = arrSum + nums;
		}

		System.out.println("Missing Number is :: " + (totalSum - arrSum));
	}

	private static void movesZerosLeft() {
		int[] arr = { 0, 1, 2, 0, 3, 0, 4 };
		int count = 0;
		for (int nums : arr) {
			if (nums != 0) {
				arr[count++] = nums;
			}
		}

		while (count < arr.length) {
			arr[count++] = 0;
		}

		System.out.println("Moves Zeros to Left :: ");
		System.out.println(Arrays.toString(arr));
	}

	private static void removeDuplicate() {
		int arr[] = { 1, 1, 2, 2, 3, 3 };
		for (int i = 0; i < arr.length; i++) {
			boolean flag = false;
			for (int j = 0; j < i; j++) {
				if (arr[i] == arr[j]) {
					flag = true;
					break;
				}
			}

			if (!flag) {
				System.out.print(arr[i] + " ");
			}
		}
		System.out.println();
	}

	private static void targateTwoSum() {
		int[] arr = { 7, 2, 11, 6, 4 };
		int target = 9;
		System.out.println("Target Sum :: ");
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] + arr[j] == target) {
					System.out.print(arr[i] + " , " + arr[j]);
				}
			}
		}
		System.out.println();
	}

	private static void kthRotate() {
		int[] arr = { 1, 2, 3, 4, 5 };
		int kth = 2;
		kth = kth % arr.length;

		while (kth > 0) {
			int temp = arr[arr.length - 1];
			for (int i = arr.length - 1; i > 0; i--) {
				arr[i] = arr[i - 1];
			}
			arr[0] = temp;
			kth--;
		}

		System.out.println("Kth Rotate :: ");
		for (int nums : arr) {
			System.out.print(nums + " ");
		}
		System.out.println();
	}

	private static void reverseEachWord() {
		/*String str = "hello world"; // olleh dlrow
		String[] split = str.split(" ");
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < split.length; i++) {
			for (int j = split[i].length() - 1; j >= 0; j--) {
				sb.append(split[i].charAt(j));
			}
			sb.append(" ");
		}
		System.out.println("Reverse Each Char of String :: " + sb.toString().trim());
		*/

		String str = "hello world";
		char[] ch = str.toCharArray();
		String rev = "";
		int start = 0;

		for (int i = 0; i <= ch.length; i++) {
			if (i == ch.length || ch[i] == ' ') {
				for (int j = i - 1; j >= start; j--) {
					rev = rev + ch[j];
				}
				rev = rev + " ";
				start = i + 1;
			}
		}
		System.out.println("Reverse Each Char Of String :: " + rev.trim());
	}

	private static void reverseSentence() {
		String str = "hello world"; // world hello
		String[] split = str.split(" ");
		String rev = "";
		for (int i = split.length - 1; i >= 0; i--) {
			rev = rev + split[i] + " ";
		}
		System.out.println("Reverse Sentence :: " + rev);
	}

	private static void reverseString() {
		String str = "hello";
		String rev = "";

		for (int i = str.length() - 1; i >= 0; i--) {
			rev = rev + str.charAt(i);
		}

		System.out.println("Reverse String :: " + rev);
	}

	private static void reverseArray() {
		int arr[] = { 1, 3, 2, 4, 5 };
		int start = 0;
		int end = arr.length - 1;
		while (start < end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}

		System.out.println("Reverse Array :: ");
		for (int num : arr) {
			System.out.print(num + " ");
		}
		System.out.println();
	}

	private static void reverseNumber() {
		int num = 12345;
		int rev = 0;
		while (num != 0) {
			int rem = num % 10;
			rev = rev * 10 + rem;
			num = num / 10;
		}

		System.out.println("Reverse Number :: " + rev);
	}

	private static void pattern07() {
		/*
			5 4 3 2 1 9 8 7 6
			 4 3 2 1 9 8 7 6 
			  3 2 1 9 8 7 6  
			   2 1 9 8 7 6   
			    1 9 8 7 6    
			     9 8 7 6     
			      8 7 6      
			       7 6       
			        6        
		*/

		for (int i = 1; i <= 9; i++) {
			boolean flag = true;
			int k = 6 - i;
			int l;
			if (i <= 5) {
				l = 9;
			} else {
				l = 15 - i;
			}

			for (int j = 1; j <= 17; j++) {
				if (j >= i && j <= 18 - i && flag) {
					if (j <= 10 - i) {
						System.out.print(k--);
					} else {
						System.out.print(l--);
					}
					flag = false;
				} else {
					System.out.print(" ");
					flag = true;
				}
			}
			System.out.println();
		}
	}

	private static void pattern06() {
		/*
			987654321
			87654321 
			7654321  
			654321   
			54321    
			4321     
			321      
			21       
			1        
		*/

		for (int i = 1; i <= 9; i++) {
			int k = 10 - i;
			for (int j = 1; j <= 9; j++) {
				if (j <= 10 - i) {
					System.out.print(k--);
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

	private static void pattern05() {
		/*
			    1   
			   121  
			  12321 
			 1234321
			 1234321
			  12321 
			   121  
			    1   
		*/

		for (int i = 1; i <= 8; i++) {
			int k = 1;
			for (int j = 1; j <= 7; j++) {
				if ((j >= 5 - i && j <= 3 + i) && (j >= i - 4 && j <= 12 - i)) {
					System.out.print(k);
					if (j < 4) {
						k++;
					} else {
						k--;
					}
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

	private static void pattern04() {
		/*
			1234321
			 12321 
			  121  
			   1   
		*/

		for (int i = 1; i <= 4; i++) {
			int k = 1;
			for (int j = 1; j <= 7; j++) {
				if (j >= i && j <= 8 - i) {
					System.out.print(k);
					if (j < 4) {
						k++;
					} else {
						k--;
					}
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

	private static void pattern03() {
		/*	
			    1   
			   121  
			  12321 
			 1234321
		 */

		for (int i = 1; i <= 4; i++) {
			int k = 1;
			for (int j = 1; j <= 7; j++) {
				if (j >= 5 - i && j <= 4 - 1 + i) {
					System.out.print(k);
					if (j < 4) {
						k++;
					} else {
						k--;
					}
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

	private static void pattern02() {
		/*
			1
			23
			345
			4567
		*/

		for (int i = 1; i <= 4; i++) {
			int k = i;
			for (int j = 1; j <= 4; j++) {
				if (j <= i) {
					System.out.print(k++);
				}
			}
			System.out.println();
		}

	}

	private static void pattern01() {
		/*
			1
			12
			123
			1234
			12345
		*/

		for (int i = 1; i <= 5; i++) {
			int k = 1;
			for (int j = 1; j <= 5; j++) {
				if (j <= i) {
					System.out.print(k++);
				}
			}
			System.out.println();
		}
	}

}
