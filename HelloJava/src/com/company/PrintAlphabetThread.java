package com.company;

class PrintAlpha implements Runnable{
	PrintAlphabetThread obj;
    int threadNumber;
    static int number = 65;
    PrintAlpha(PrintAlphabetThread obj, int result){
        this.obj = obj;
        this.threadNumber = result;
    }
    @Override
    public void run() {
        synchronized(obj) {
        	while (number <= PrintAlphabetThread.MAX_NUMBERS) {
                if(number % 3 != threadNumber){
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    System.out.println(Thread.currentThread().getName() + " - " + (char)number++);
                    obj.notifyAll();
                }
            }
        }
    }                             
}

public class PrintAlphabetThread {
	final static int MAX_NUMBERS = 90;
	public static void main(String[] args) {
		PrintAlphabetThread obj = new PrintAlphabetThread();
		
        Thread t1 = new Thread(new PrintAlpha(obj, 0), "T1");
        Thread t2 = new Thread(new PrintAlpha(obj, 1), "T2");
        Thread t3 = new Thread(new PrintAlpha(obj, 2), "T3");
        t1.start();
        t2.start();
        t3.start();
	}
}
