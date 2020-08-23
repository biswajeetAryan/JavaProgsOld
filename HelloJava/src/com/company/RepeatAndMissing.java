package com.company;

public class RepeatAndMissing {
	static void printRepeatAndMissing(int arr[], int n) {
		for(int i=0;i<n;i++) {
			int absVal = Math.abs(arr[i]);
			if(arr[absVal - 1] > 0)
				arr[absVal - 1] = -arr[absVal - 1];
			else
				System.out.println("Repeated = "+absVal);
		}
		
		for(int i=0;i<n;i++)
			if(arr[i] > 0)
				System.out.println("missing = "+i);
	}
	public static void main(String[] args) {
		int arr[] = { 7, 3, 4, 5, 5, 6, 2 }; 
        int n = arr.length; 
        
        printRepeatAndMissing(arr, n);
	}
}
