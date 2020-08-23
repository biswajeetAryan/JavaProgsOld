package com.company;
import java.util.*;

public class NormalForm {
	static void printNormalForm(int num, int den) {
		if(den == 0) {
			System.out.println("Invalid fraction");
			return;
		}
		if(num == 0) {
			System.out.print(0);
			return;
		}
            
        
        StringBuilder sb = new StringBuilder();
        Map<Long, Integer> map = new HashMap<>();
        
        if(num<0 && den>0 || num>0 && den<0)
            sb.append("-");
        
		long n = Math.abs((long) num);
		long d = Math.abs((long) den);
        
		
		long r = n%d;
		sb.append(n/d);
		
		if(r != 0)
			sb.append(".");
		else {
			System.out.print(sb.toString());
			return;
		}
        
		
		while(r != 0) {
			if(map.containsKey(r)) {
				sb.insert(map.get(r),"(");
                sb.append(")");
				break;
			}else {
				map.put(r, sb.length());
				r*=10;
				sb.append(r/d);
				r%=d;
			}
		}
		
		System.out.print(sb.toString());
	}
	public static void main(String[] args) {
		int num = 2;
		int den = 3;
		
		printNormalForm(num, den);
	}

}
