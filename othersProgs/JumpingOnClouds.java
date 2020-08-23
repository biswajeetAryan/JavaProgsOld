package com.company;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class JumpingOnClouds {
    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c) {
        int steps = 1;
        int resp = 0;
        int i=0;
        for (i=0;i<c.length-1; i += steps){
            if(i+2 <= c.length-1 && c[i + 2] != 1){
                steps = 2;
            }else if(i+1 <= c.length-1 && c[i+1] != 1){
                steps = 1;
            }
            resp ++;
        }
        return resp;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        int[] c = new int[n];

        for (int i = 0; i < n; i++) {
            c[i] = scanner.nextInt();
        }

        int result = jumpingOnClouds(c);
        System.out.println("result = " + result);

        scanner.close();
    }
}
