package com.company;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MinimumSwaps {
    // Complete the minimumBribes function below.
    static void minimumBribes(int[] arr, int n) { // eg. 2,4,5,1,3
        int swap=0;
        boolean visited[]=new boolean[arr.length];

        for(int i=0;i<arr.length;i++){
            int j=i,oneCycleWithNodes=0;

            while(!visited[j]){
                visited[j]=true;
                j=arr[j]-1;
                oneCycleWithNodes++;
            }

            if(oneCycleWithNodes!=0) //swap count =: path to join n nodes = one complete cycle visiting n nodes - 1
                swap+=oneCycleWithNodes-1; // => swp (for i=0) = 3 (one cycle(2-4-1-2)) -1
        }
        System.out.println(swap);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int n = scanner.nextInt();

        int[] q = new int[n];

        for (int i = 0; i < n; i++) {
            q[i] = scanner.nextInt();
        }

        minimumBribes(q, n);


        scanner.close();
    }
}
