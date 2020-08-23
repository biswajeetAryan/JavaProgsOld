package com.company;

class PrintEvenOdd{
	private int start;
	private int max;
	boolean printZero;
	PrintEvenOdd(int s, int m){
		this.start = s;
		this.max = m;
		this.printZero = true;
	}
	
	public void printZero() {
		while(start<=max) {
			synchronized(this){
				if(printZero) {
					System.out.print(0);
					printZero = false;					
					this.notifyAll();
				}else {
					try {
						this.wait();
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	public void printOdd() {
		while(start<=max) {
			synchronized(this){
				if(start%2 != 0 && !printZero)  {
					System.out.print(start);
					printZero = true;
					start++;
					this.notifyAll();
				}else {
					try {
						this.wait();
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	public void printEven() {
		while(start<=max) {
			synchronized(this){
				if(start%2 == 0 && !printZero) {
					System.out.print(start);
					printZero = true;
					start++;
					this.notifyAll();
				}else {
					try {
						this.wait();
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}


public class PrintSeqThread {
	public static void main(String[] args) {
		PrintEvenOdd p = new PrintEvenOdd(1,9);
		
		Thread tZ = new Thread(() -> p.printZero());
		Thread tO = new Thread(() -> p.printOdd());
		Thread tE = new Thread(() -> p.printEven());
		
		tZ.start();
		tO.start();
		tE.start();
	}
}
	
