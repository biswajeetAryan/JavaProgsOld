package com.company;
import java.util.*;

public class LargestNumber {
	static void printLargest(List<String> arr) {
		Collections.sort(arr, new Comparator<String>() {
			public int compare(String s1, String s2) {
				String s1s2 = s1+s2;
				String s2s1 = s2+s1;
				return s1s2.compareTo(s2s1) > 0 ? -1 : 1;
			}
		});
		
		for(String s : arr) {
			System.out.print(s);
		}
	}
	public static void main(String[] args) {
		List<String> arr = new ArrayList<>();
		arr.add("54"); 
        arr.add("546"); 
        arr.add("548"); 
        arr.add("60");
        System.out.println(arr);
        printLargest(arr);
	}
}
