package com.company;

import java.util.ArrayList;

public class MaxOfSubMatrixDP {
    public static void printSumSimple(int mat [][], int n, int k){
        ArrayList<Integer> arr = new ArrayList<>();
        for(int r=0; r<n-k+1; r++){
            int sum = 0;
            for(int c=0; c<n-k+1; c++){
                sum = sumOfSubMat(mat, r-1, c, k, n) - sumOfRow(mat, r-1, c, k, n) + sumOfRow(mat, r+k-1, c, k, n);
                sum = sum - sumOfRow(mat, r+1, c, k, n) + mat[r+1][c+1];
                arr.add(sum);
            }
        }
        arr.sort(Integer::compareTo);
        System.out.println(arr.get(arr.size()-1));
    }
    static int sumOfSubMat(int mat [][], int i, int j, int k, int n){
        int sum =0;

        for(int r=i; r<k+i; r++)
            for(int c=j; c<k+j; c++)
                if(r>=0 && c>=0)
                    sum+=mat[r][c];
        return sum;
    }
    static int sumOfRow(int mat[][], int i, int j, int k, int n){
        int sum =0;
            if(i>=0 && j>=0 && j<n-k+1 && i<n)
                for(int c=j; c<=j+k-1; c++){
                    sum+=mat[i][c];
                }
        return sum;
    }

    public static void main(String arg[])
    {
        int mat[][] = { {1, 1, 1, 1, 1},
                {2, 2, 2, 2, 2},
                {3, 3, 3, 3, 3},
                {4, 4, 4, 4, 4},
                {5, 5, 5, 5, 5},
        };
        int k = 3;
        int n = 5;
        for(int r=0; r<n; r++){
            for(int c=0; c<n; c++){
                System.out.print(mat[r][c]+" ");
            }
            System.out.println();
        }

        System.out.println();
        printSumSimple(mat, n, k);
    }
}
