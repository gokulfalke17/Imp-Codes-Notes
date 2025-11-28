package com.nt.coding.challanges;

import java.util.HashSet;
import java.util.Set;

//iMocha #2

public class GuestHappyNumberWindow {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 1, 3, 2};
		guestHappyNumber(arr, 3);
	}

	private static void guestHappyNumber(int[] arr, int k) {
		int maxDistinct = 0;

		for (int i = 0; i < arr.length - k; i++) {
			Set<Integer> set = new HashSet<>();
			for (int j = i; j < i + k; j++) {
				set.add(j);
			}

			maxDistinct = Math.max(maxDistinct, set.size());
		}

		System.out.println("Max Distinct Guest in array Window :: " + maxDistinct);
	}
}
