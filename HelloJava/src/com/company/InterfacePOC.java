package com.company;

interface I1 {
  abstract void method();
}
	 
interface I2 {
  abstract void method();
}
public class InterfacePOC implements I1, I2 {

	@Override
	public void method() {
		// TODO Auto-generated method stub
		System.out.print("hi");
	}
	public static void main(String[] args) {
		I1 a = new InterfacePOC();
		I2 b = new InterfacePOC();
		
		a.method();
		b.method();
	}

}
