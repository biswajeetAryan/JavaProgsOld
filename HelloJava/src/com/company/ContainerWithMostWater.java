package com.company;

public class ContainerWithMostWater {
	static int findArea(int arr[]) {
		int area = 0;
		int l=0,r=arr.length-1;
		while(l<r) {
			int min = Math.min(arr[l], arr[r]);
			area = Math.max(area, min*(r-l));
			
			if(arr[l]<arr[r])
				l++;
			else
				r--;
			
		}
		return area;
	}
	public static void main(String[] args) {
		int[] arr = {3, 1, 2, 4, 5};
		
		System.out.println(findArea(arr));
	}
}
