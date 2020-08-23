package com.company;

import java.util.*;

public class OrderOfOne {
	HashMap<Integer, Integer> map = new HashMap<>();
	List<Integer> arr = new ArrayList<>();
	
	void insert(int item) {
		if(map.containsKey(item))
			return;
		arr.add(item);
		
		map.put(item, arr.size()-1);
		
	}
	
	void remove(int item) {
		Integer index = map.get(item);
		if(index == null)
			return;
		
		int last = arr.get(arr.size()-1);
		Collections.swap(arr, index, arr.size()-1);
		
		arr.remove(arr.size()-1);
		
		map.put(last, index);
		
		System.out.println(arr);
	}
	
	void search(int item) {
		
	}
	
	void getRandom() {
		Random r = new Random();
		int ri = r.nextInt(arr.size()-1);
		System.out.println(arr.get(ri));
	}
	public static void main(String[] args) {
		OrderOfOne o = new OrderOfOne();
		for(int i=1;i<=10;i++)
			o.insert(i);
		System.out.println(o.arr);
		o.remove(5);
		o.remove(9);
		
	}
}
