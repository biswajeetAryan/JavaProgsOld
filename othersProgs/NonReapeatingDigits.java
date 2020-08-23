package com.company;

import java.util.HashSet;
import java.util.Scanner;

public class NonReapeatingDigits {
    static void minimumBribes(int x, int y, int z) {
        int count =0;
        if(y>0 && z>y)
        for(int i = y;i<=z;i++){
            int n = i;
            int product = x*i;
            String prodStr = Integer.toString(product);
            boolean valid = true;
            while(n>0){
                System.out.println("n = "+n);
                if(prodStr.contains(Integer.toString(n%10))){
                    valid = false;
                    break;
                }
                n = n/10;
            }
            if(valid)
                count++;
        }
        System.out.println("count = " +count);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

//        int n = scanner.nextInt();
//
//        int[] q = new int[n];
//
//        for (int i = 0; i < n; i++) {
//            q[i] = scanner.nextInt();
//        }
        int x = 0; int y=0;int z=0;
        minimumBribes(x, y, z);


        scanner.close();
    }
}
