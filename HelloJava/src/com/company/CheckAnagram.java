package com.company;
import java.util.*;

public class CheckAnagram {
	static List<List<String>> printAnagram(String[] strList) {
		HashMap<HashMap<Character, Integer>, List<String>> hm = new HashMap<>();
		List<List<String>> res = new ArrayList<List<String>>();
		
		for(int i=0;i<strList.length;i++) {
			HashMap<Character, Integer> temp = new HashMap<>();
			String word = strList[i];
			for(int j=0;j<word.length();j++) {
				if(temp.containsKey(word.charAt(j))) {
					int x = temp.get(word.charAt(j));
					temp.put(word.charAt(j), x+1);
				}else {
					temp.put(word.charAt(j), 1);
				}
			}
			
			if(hm.containsKey(temp)) {
				hm.get(temp).add(word);
			}else {
				List<String> tempList = new ArrayList<>();
				tempList.add(word);
				hm.put(temp, tempList);
			}
		}
		
		for(HashMap<Character, Integer> key : hm.keySet()) {
			List<String> tempRes = hm.get(key);
			res.add(tempRes);
		}
		return res;
	}
	public static void main(String[] args) {
		String[] strList = {"cat", "dog", "tac", "god", "act" };
		List<List<String>> res = printAnagram(strList);
		System.out.println(res);
	}
}
