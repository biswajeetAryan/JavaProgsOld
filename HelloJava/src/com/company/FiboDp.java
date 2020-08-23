package com.company;
import java.math.BigInteger;
import java.util.*;
public class FiboDp {
	
	public BigInteger cachedFibN(int n) {
//		if (n < 0) {
//			throw new IllegalArgumentException(
//					"n must not be less than zero");
//		}
//		int dp[] = new int[n+2];
//		dp[0] = 0;
//		dp[1] = 1;
//		for(int i=2;i<=n ;i++) {
//			dp[i] = dp[i-1]+dp[i-2];
//		}
//		
//		return dp[n];
		BigInteger a = BigInteger.valueOf(0);
		BigInteger b = BigInteger.valueOf(1);
		BigInteger c = BigInteger.valueOf(1);
		for(int i=2;i<=n;i++) {
			c = a.add(b);
			a = b;
			b = c;
		}
		return b;
	}
	public static void main(String[] args) {
		int n = 1000;

		System.out.println(new FiboDp().cachedFibN(n));

	}

}
