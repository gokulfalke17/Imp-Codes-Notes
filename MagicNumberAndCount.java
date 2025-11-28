package com.nt.coding.challanges;

//iMocha #1

public class MagicNumberAndCount {
	public static void main(String[] args) {
		int arr[] = { 8, 13, 40, 28 };
		countMagicNums(arr);
	}

	private static void countMagicNums(int[] arr) {
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

			if (sum % 4 == 0 && prod % 4 == 0) {
				System.out.println(arr[i] + " Is Magical Number.");
				count++;
			}
		}

		System.out.println("Total Magic Number :: " + count);
	}
}
