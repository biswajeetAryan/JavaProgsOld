package com.company;

public class RemoveSpaceFromArray {
	static void removeSpace(String str) {
		
		int n=str.length();
		int l=0;
		char[] strArr = str.toCharArray();
		for(int i=0;i<n;i++) {
			if(strArr[i] != ' ')
			strArr[l++] = strArr[i];
		}
		for(int k=0;k<l;k++)
			System.out.print(strArr[k]);
	}
	public static void main(String[] args) {
		String str = "A 1abc 2abcd 3";
		removeSpace(str);
	}	
}
