package com.company;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MinimumBribes {
    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q, int n) {
        int temp=0;
        boolean sorted = false;
        String ans = "";
        int bribed = 0;
        HashMap <Integer, Integer> itemSwapMap = new HashMap<>();
        while(!sorted){
            boolean swapNeeded = false;
            for(int i=0;i<n-1;i++){
                if(q[i] > q[i+1]){
                    swapNeeded = true;
                    temp = q[i];
                    q[i] = q[i+1];
                    q[i+1] = temp;

                    if(!itemSwapMap.containsKey(temp)){
                        itemSwapMap.put(temp, 1);
                    }else {
                        int swaps = itemSwapMap.get(temp);
                        if(swaps == 2){
                            ans = "Too chaotic";
                            break;
                        }
                        itemSwapMap.put(temp, swaps + 1);
                    }
                    bribed ++;
                    System.out.println("b = "+bribed);
                }
                if(!ans.isEmpty()){
                    System.out.println("hi break");
                    break;}

            }
            for (int j = 0;j < n;j++)
                System.out.print(q[j]+" ");
            System.out.println();
            if(!swapNeeded || !ans.isEmpty())
                sorted = true;
        }
        if(!ans.isEmpty())
            System.out.println(ans);
        else
            System.out.println(bribed);
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
