package com.company;

public class SecSmallestElement {
	public static void main(String[] args) {
		int [] arr = {0,0,0,0,0,0};
		int first=Integer.MAX_VALUE, sec = Integer.MAX_VALUE;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]<first) {
				sec = first;
				first = arr[i];
			}
			if(arr[i]<sec && arr[i] != first) {
				sec = arr[i];
			}
		}
		if(sec == Integer.MAX_VALUE) {
			System.out.println("No sec smallest element present");
		}else {
			System.out.println("sec = "+sec);
		}
		
	}
}
