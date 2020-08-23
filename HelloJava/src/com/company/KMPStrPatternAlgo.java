package com.company;

public class KMPStrPatternAlgo {
	public static void main(String[] args) {
		String str = "ABABABCABABABCABABABC"; //ABABCABABCD
		char[] strArr = str.toCharArray();
		
		int n = str.length();
		int[] lps = new int[n]; //longest prefix which is also suffix
		lps[0] = 0;
		
		int j=0,i=1;		
		while(i<n) {
			if(strArr[j] == strArr[i]) {
				lps[i] = j+1;
				i++;
				j++;
			}else {
				if(j == 0) {
					lps[i] = 0;
					i++;
				}else {
					j = lps[j-1];
				}
			}
		}
		
		for(int k=0;k<n;k++)
			System.out.print(lps[k]+" ");
		System.out.println();
		
		String res ="";
		
		for(int k=1;k<n;k++) {
			if(lps[k-1] <= lps[k]) {
				if(lps[k-1] == 0)
					res = res+strArr[k-1];
			}else {
				res = res+"*";
				if(k == n-1)
					res = res+strArr[k];
			}
		}
		
		System.out.print(res);
	}
}
