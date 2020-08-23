package com.company;

// Formula T[i][j] = max(T[i-1][j], val[i]+T[i-1][j-wt[i]])

public class KnapsackProblem {
	static void findMax(int val[], int wt[], int W) {
		int n = val.length;
		int K[][] = new int[n+1][W+1];
				
		for(int i=0; i <= n; i++){
            for(int j=0; j <= W; j++){
                if(i == 0 || j == 0){
                    K[i][j] = 0;
                }else {
	                if(j<wt[i-1]){ // the length is n+1 so to get actual weight we have to take val[i-1] instead of val[i] same for wt[i-1] in place of wt[i]
	                	K[i][j] = K[i-1][j];
	                }else{	                    
	                    K[i][j] = Math.max(K[i-1][j], K[i-1][j-wt[i-1]] + val[i-1]);
	                }
                }
            }
        }
		System.out.println(K[n][W]);
	}
	public static void main(String[] args) {
		int value[] = {1,4,5,7};
		int weight[] = {1,3,4,5};
		int W = 7;
		
		findMax(value, weight, W);
	}
}
