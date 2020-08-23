package com.company;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class CountingValleys {
    static int countingValleys(String s) {
        char arr [] = s.toCharArray();
        int loc = 0;
        int resp = 0;
        int prevStep = 0;
        for (int i=0;i<arr.length;i++){
            prevStep = loc;
            if(arr[i] == 'U')
                loc += 1;
            if(arr[i] == 'D')
                loc += -1;
            if(prevStep < 0 && loc == 0)
                resp ++;
        }
        return resp;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

//        int n = scanner.nextInt();
//        System.out.println("n = " + n);
        String s = scanner.nextLine();
        System.out.println("s = " + s);

        int result = countingValleys(s);
        System.out.println("result = " + result);
        scanner.close();
    }
}
