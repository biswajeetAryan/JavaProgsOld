package com.company;

public class JosephusProblem {
	static int sol(int n, int k) {
		if(n==1)
			return 1;
		
		return (sol(n - 1, k) + k) % n;
	}
	public static void main(String[] args) {
		int arr[] = {2,3,1,4,5};
		int n = arr.length;
		int r = sol(5,3)-1;
		
		if(r<0)
			r = n-1; 
		System.out.println(r);
		System.out.println(arr[r]);
	}
}
