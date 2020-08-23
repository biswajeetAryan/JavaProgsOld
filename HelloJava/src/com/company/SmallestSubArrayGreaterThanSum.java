package com.company;

import java.util.Scanner;

public class SmallestSubArrayGreaterThanSum {
	public static void findRes(int arr[], int x) {
		int n = arr.length;
		int minLen = n+1;
		int st=0, l=0;
		int sum= 0;
		while(l<n) {
			while(sum<=x && l<n) {
				sum+=arr[l++];
			}
			
			while(sum > x && st<n) {
				if(l-st < minLen) {
					minLen = l-st;
				}				
				sum-=arr[st++];
			}			
		}
		
		System.out.println(minLen);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		int x = sc.nextInt();
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		findRes(arr, x);
		
		sc.close();
	}
}
