package com.company;

import java.util.Arrays;

public class CoinCollectingDp {
	public static void maxValue(int grid[][], int r, int c) {
		int [][] dp = new int[r][c];
		
		for(int[] row : dp) {
			Arrays.fill(row, 0);
		}
		
		for(int row=r-1;row>=0;row--) {
			for(int col=0;col<c;col++) {
				int top = (row == r-1) ? 0 : dp[row+1][col];
				int right = (col == 0) ? 0 : dp[row][col-1];
				
				dp[row][col] = grid[row][col] + Math.max(top, right);
			}
		}
		
		System.out.println(dp[0][c-1]);
	}
	public static void main(String[] args) {
//		int grid[][] = {{0,0,1,0,0,1},
//						{0,0,0,1,0,0},
//						{0,1,0,0,1,0},
//						{0,0,0,1,0,0},
//						{1,0,0,0,1,0},
//						{0,0,1,0,0,1}
//						};
		int route[][] = {
							{0, 0, 0, 0, 5},
							{0, 1, 1, 1, 0},
							{2, 0, 0, 0, 0}
						};
//		int n = grid.length;
//		maxValue(grid, n);
		maxValue(route, 3, 5);
	}
}
