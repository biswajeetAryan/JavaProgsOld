package com.company;

public class WaveSort {
	void swap(int arr[],int a, int b) {
		int temp = arr[a];
		arr[a]=arr[b];
		arr[b]=temp;
	}

	void wave(int arr[]) {
		for(int i=0;i<arr.length;i+=2) {		
			if(i>0 && arr[i] < arr[i-1])
					swap(arr,i, i-1);
			if(i<arr.length-1 && arr[i] < arr[i+1])
					swap(arr,i, i+1);
		}
	}
	public static void main(String[] args) {
		int arr[] = {10,5,6,3,2,20,100,80};

		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+" ");
		System.out.println();

		WaveSort w = new WaveSort();
		w.wave(arr);

		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+" ");
	}

}
