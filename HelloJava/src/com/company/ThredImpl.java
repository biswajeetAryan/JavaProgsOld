package com.company;

public class ThredImpl implements Runnable {
	
	static int doThis() {
		System.out.println("this method called");
		return 1;
	}
	
	@Override
	public void run() {
		int i = doThis();
		
	}

}
