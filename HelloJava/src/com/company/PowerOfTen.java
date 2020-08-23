package com.company;

public class PowerOfTen {
//	static boolean isPower(int x, int y) 
//	{            
//		double res2 = Math.log(y) / Math.log(x);
//		return (res2 - Math.ceil(res2)) == 0; 
//	} 
	public static void main(String[] args) {
		int n = 1000000;
		int r = -1;
		boolean res = true;
			while(n>0) {
			r = n%10;
			if(n>10 && r != 0) {
				res = false;
			}
			n /= 10;
		}
		if(r == 1 && res)
			System.out.println("Yes");
		else
			System.out.println("No");
//		if(isPower(10, 9000000)) 
//			System.out.println("1"); 
//		else
//			System.out.println("0"); 
		
	} 
}
