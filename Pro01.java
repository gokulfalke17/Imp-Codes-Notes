package com.nt.coding.challanges;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Pro01 {
	public static void main(String[] args) {

		occurenceOfEachCharacter();
		System.out.println();
		getEvenNumbers();
		System.out.println();
		findDuplicateElements();
		System.out.println();
		occurenceOfEachWord();
		System.out.println();
		findMinMaxElement();
		System.out.println();
		sortList();
		System.out.println();
		reverseEachWordCharacter();
		System.out.println();
		firstNonRepeatedCharacter();
		System.out.println();
		margeTwoLists();
		System.out.println();
		removeDuplicateElements();
		System.out.println();

	}

	private static void removeDuplicateElements() {

		int arr[] = { 1, 2, 2, 3, 4, 4, 5 };
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != arr[count]) {
				count++;
				int temp = arr[i];
				arr[i] = arr[count];
				arr[count] = temp;
			}
		}

		System.out.println("After Remove Duplicate :: ");
		for (int i = 0; i <= count; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	private static void margeTwoLists() {
		List<Integer> list1 = List.of(1, 2, 3, 4, 5);
		List<Integer> list2 = List.of(4, 5, 6, 7, 8, 9);

		List<Integer> result = Stream.concat(list1.stream(), list2.stream()).distinct().collect(Collectors.toList());

		System.out.println(result);
	}

	private static void firstNonRepeatedCharacter() {
		String str = "swiss";
		Character character = str.chars().mapToObj(ch -> (char) ch)
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().filter(e -> e.getValue() == 1).map(Map.Entry::getKey).findFirst().orElse(null);

		System.out.println(character);
	}

	private static void reverseEachWordCharacter() {

		String str = "hello java world";

		String reverse1 = Arrays.stream(str.split(" ")).map(word -> new StringBuffer(word).reverse().toString())
				.collect(Collectors.joining(" "));

		System.out.println(reverse1); // olleh avaj dlrow

		System.out.println("\n----------------------\n");

//========================================================================================================================		

		String reverse2 = Arrays.stream(str.split(" "))
				.collect(Collectors.collectingAndThen(Collectors.toList(), list -> {
					Collections.reverse(list);
					return String.join(" ", list);
				}));

		System.out.println(reverse2); // world java hello

		System.out.println("\n----------------------\n");

//========================================================================================================================		

		String reverse3 = Arrays.stream(str.split(" ")).map(word -> new StringBuilder(word).reverse().toString())
				.collect(Collectors.collectingAndThen(Collectors.toList(), list -> {
					Collections.reverse(list);
					return String.join(" ", list);
				}));

		System.out.println(reverse3); // dlrow avaj olleh

	}

	private static void sortList() {

		List<String> list = List.of("mno", "abc", "pqr", "xyz", "stv");
		List<String> sortedList = list.stream().sorted().collect(Collectors.toList());

		System.out.println(sortedList); // sort string list
	}

	private static void findMinMaxElement() {

		List<Integer> list = Arrays.asList(12, 56, 30, 22, 9, 19, 39, 4);
		Integer min = list.stream().min(Integer::compare).get();
		Integer max = list.stream().max(Integer::compare).get();

		System.out.println("Min :: " + min + "\nMax :: " + max); // get min and max elements
	}

	private static void occurenceOfEachWord() {

		String str = "java spring java boot spring";
		Map<String, Long> map = Arrays.stream(str.split(" "))
				.collect(Collectors.groupingBy(s -> s, Collectors.counting()));

		System.out.println(map); // count occurrence of each world
	}

	private static void findDuplicateElements() {

		List<Integer> list = List.of(1, 2, 3, 3, 4, 4, 5);
		Set<Integer> duplicates = list.stream().filter(e -> Collections.frequency(list, e) > 1)
				.collect(Collectors.toSet());

		System.out.println(duplicates); // get duplicate elements only
	}

	private static void getEvenNumbers() {

		List<Integer> list = List.of(1, 4, 2, 3, 6, 5, 7, 9, 8);
		List<Integer> evenList = list.stream().filter(e -> e % 2 == 0).collect(Collectors.toList());

		System.out.println(evenList); // get only even list
	}

	private static void occurenceOfEachCharacter() {

		String str = "programming";
		Map<Character, Long> map = str.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		System.out.println(map); // get all character occurrence

		Map<Character, Long> result = map.entrySet().stream().filter(e -> e.getValue() >= 2)
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

		System.out.println(result); // get only >= 2 occurrence count

	}
}
