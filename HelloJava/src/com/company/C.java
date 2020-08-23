package com.company;

 class A { 
    int temp = 10; 
//    A(int t){
//    	this.temp = t;
//    }
    void print() 
    { 
        System.out.println("In Class A"+temp); 
    } 
} 
class B extends A { 
    int temp = 20; 
    public void print() 
    { 
        System.out.println("In Class B"); 
    } 
} 
class C extends A{ 
//	C(){
//		super(5);
//	}
    public static void main(String args[]) 
    { 
        A a = new B(); 
//    	A a = new C();
    	
        System.out.println(a.temp); 
        a.print(); 
    } 
} 