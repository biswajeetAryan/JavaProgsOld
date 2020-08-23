package com.company;

import java.io.*;
import java.util.*;
import java.util.HashMap;
import java.util.Set;

public class SockMerchant {
    static HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    static int sockMerchant(int n, int[] ar) {
        int res = 0;
        for(int i=0;i<n;i++){
            if(map.containsKey(ar[i]))
                map.put(ar[i], map.get(ar[i])+1);
            else
                map.put(ar[i], 1);
        }

        Set<Integer> keySet = map.keySet();
        for(Integer key : keySet){
            res += map.get(key)/2;
        }


        return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = scanner.nextInt();
        }

        int result = sockMerchant(n, ar);
        scanner.close();
    }
}
