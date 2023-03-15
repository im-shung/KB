package day3.sort;

import java.util.*;

public class SortMethod {

	public static void main(String[] args) {
		
		// 1-1. 배열 정렬 - 정수
		int[] arr1 = { 5, 3, 7, 4, 1 };
		Arrays.sort(arr1);
		System.out.println(Arrays.toString(arr1));
		
		// 1-2. 배열 정렬 - 문자열
		String[] arr2 = {"samsung","apple","LG","banana","google"};
		Arrays.sort(arr2);
		System.out.println(Arrays.toString(arr2));
		
		// 2-1. ArrayList 정렬 - 정수
		ArrayList<Integer> arr3 = new ArrayList<>();
		arr3.add(5);
		arr3.add(3);
		arr3.add(7);
		arr3.add(4);
		arr3.add(1);
		Collections.sort(arr3);
		System.out.println(arr3);
		
		// 2-1. ArrayList 정렬 - 문자열
		ArrayList<String> arr4 = new ArrayList<>();
		arr4.add("samsung");
		arr4.add("apple");
		arr4.add("LG");
		arr4.add("banana");
		arr4.add("google");
		Collections.sort(arr4);
		System.out.println(arr4);
		
		// 3. 내림차순 정렬 - Collections.reverseOrder()
		Integer[] arr5 = { 5, 3, 7, 4, 1 }; // Primitive 타입은 적용 불가
		Arrays.sort(arr5, Collections.reverseOrder());
		System.out.println(Arrays.toString(arr5));
		
		Arrays.sort(arr2, Collections.reverseOrder());
		System.out.println(Arrays.toString(arr2));
		
		
	}

}
