package com.company;

public class StackGetMin {
	int min = Integer.MAX_VALUE;
	int[] stk = new int[10];
	int i=0;
	void push(int item) {
		if(i == 9)
			return;
		if(i == 0) {
			stk[i++] = item;
			min = item;
		}else
		if(item < min) {
			stk[i++] = item*2 - min;
			min = item;
		}
		else
			stk[i++] = item;
	}
	void pop() {
		if(i == 0 || i == 10)
			return;
		int item = stk[i-1];
		if(item < min) {
			min = 2*min - item;
		}
		i--;
	}
	
	int getMin() {
		if(stk.length == 0)
			return Integer.MIN_VALUE;
		return min;
	}
	public static void main(String[] args) {
		StackGetMin s = new StackGetMin();
		s.push(20);
		s.push(5);
		s.push(6);
		s.push(30);
		s.push(1);
		s.pop();
		s.push(10);
		System.out.println(s.getMin());
		s.push(12);
		s.push(11);
	}

}
