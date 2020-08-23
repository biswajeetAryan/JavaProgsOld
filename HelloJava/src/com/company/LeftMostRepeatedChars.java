package com.company;

import java.util.Arrays;

public class LeftMostRepeatedChars {
	static int findChar(String str) {
		int res = -1;
		int l=0, r=str.length()-1;
		boolean visited[] = new boolean[256];
		
		for(int i=r;i>=0;i--) {
			if(visited[str.charAt(i)] == true)
				res = i;
			else
				visited[str.charAt(i)] = true;
		}
		return res;
	}
	public static void main(String[] args) {
		String str = "geeksforgeeks";
		System.out.println(str.charAt(findChar(str)));
	}
}
