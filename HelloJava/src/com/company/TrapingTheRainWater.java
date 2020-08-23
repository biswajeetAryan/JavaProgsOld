package com.company;

public class TrapingTheRainWater {
	static int getRes(int arr[]) {
		int s=0;
		int leftMax=0, rightMax=0;
		int low = 0, high = arr.length-1;
		
		while(low<=high) {
			if(arr[low]<arr[high]) {
				if(leftMax<arr[low])
					leftMax = arr[low];
				else
					s += leftMax-arr[low];
				low++;
			}else {
				if(rightMax<arr[high])
					rightMax = arr[high];
				else
					s += rightMax-arr[high];
				high--;
			}
		}
		return s;
	}
	public static void main(String[] args) {
		int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
		
		System.out.println(getRes(arr));
	}
}
