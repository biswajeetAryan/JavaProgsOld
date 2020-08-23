package com.company;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class RepeatedString {
    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        long resp = 0;
        char arr[] = s.toCharArray();
        long l = arr.length;
        int rep = countAs(arr, l);

        if(l == rep)
            return n;

        resp = (n/l)*rep;
        int remain = countAs(arr, n%l);
        resp += remain;
        return resp;
    }
    static int countAs(char arr [], long n){
        int c =0;
        for(int i=0;i<n;i++){
            if(arr[i]=='a')
                c++;
        }
        return c;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String s = scanner.nextLine();

        long n = scanner.nextLong();

        long result = repeatedString(s, n);

        System.out.println("res = "+ result);
        scanner.close();
    }
}
