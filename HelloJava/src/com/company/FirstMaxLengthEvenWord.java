package com.company;

import java.util.Arrays;
import java.util.*;

public class FirstMaxLengthEvenWord {
	static String findMaxLenEven(String str) {
		int maxLen=0, currLen=0, i=0;
		int startAt=-1;
		int n = str.length();
		while(i<n) {
			if(str.charAt(i) == ' ') {
				if(currLen%2 == 0 && currLen>maxLen) {
					maxLen = currLen;
					startAt = i-currLen;
				}
				currLen = 0;
			}else {
				currLen++;
			}
			i++;
		}
		if(currLen%2 == 0 && currLen>maxLen) {
			maxLen = currLen;
			startAt = i-currLen;
		}
		
		return str.substring(startAt, startAt+maxLen);
	}
	public static void main(String[] args) {
		String str = "You as are given aS am array of n numbers a1";  
		String p = Arrays.stream(str.split(" "))
				.filter(s->s.length()%2==0)
				.max(Comparator.comparing(String::length))
				.get();
	    System.out.println( findMaxLenEven(str));
	    System.out.println( findMaxLenEven(p));
	}
}
