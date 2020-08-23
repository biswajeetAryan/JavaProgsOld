package com.company;
import java.util.*;
public class DictionaryLargestString {
	static boolean isSubSequence(String s, String letters) {
		Map<Character, Integer> cMap = new HashMap<Character, Integer>();
		for (char c : s.toCharArray())
			if (!cMap.containsKey(c))
				cMap.put(c, 1);
			else
				cMap.put(c, cMap.get(c) + 1);
		
		for (char c : letters.toCharArray())
			if (cMap.containsKey(c))
				cMap.put(c, cMap.get(c) - 1);
		
		for (int i : cMap.values())
			if (i > 0)
				return false;
		return true;
	}
	static String largestStr(String [] arr, String str) {
		String result = "";
		for (String s : arr)
			if (s.length() > result.length() && isSubSequence(s, str))
				result = s;
		return result.length() == 0 ? null : result;
	}
	public static void main(String[] args) {
		String[] arr = {"ale", "apple", "monkey", "plea"};
		String str = "abpcplea";
		System.out.println(largestStr(arr, str));
	}
}
