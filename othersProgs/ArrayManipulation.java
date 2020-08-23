package com.company;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ArrayManipulation {
    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] q) {
        HashMap<Integer,Integer>map=new HashMap<Integer, Integer>();
        for(int i=0;i<q.length;i++){
            for(int j=q[i][0]-1; j<=q[i][1]-1;j++){
                if(!map.containsKey(j))
                    map.put(j, q[i][2]);
                else{
                    int v = map.get(j);
                    map.put(j, q[i][2]+v);
                }
            }
        }

        return (Collections.max(map.values()));
    }
    static long arrayManipulationOptimized(int n, int[][] q) {
        long[]arr=new long[n];
        for(int i=0;i<q.length;i++){
            System.out.println("l= "+ (q[i][0]-1) +" r= "+(q[i][1]-1));
            add(arr,q[i][0]-1,q[i][1]-1,q[i][2]);
        }
        System.out.println();
        for(int k =1;k<n;k++){
            arr[k]+=arr[k-1];
            System.out.print(arr[k]+" ");
        }

        LongSummaryStatistics stat = Arrays.stream(arr).summaryStatistics();
        return stat.getMax();

    }
    static void add(long[]arr, int l, int r, int k){
        arr[l]+=k;
        if(r<arr.length-1)
            arr[r+1]+= -k;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

//        String[] nm = scanner.nextLine().split(" ");
//        int[] tab = {12, 1, 21, 8};
//        IntSummaryStatistics stat = Arrays.stream(tab).summaryStatistics();
//        int min = stat.getMin();
//        int max = stat.getMax();
//        System.out.println(max);
//        System.out.println(min);

        int n = scanner.nextInt();//Integer.parseInt(nm[0]);

        int m = scanner.nextInt();//Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
//            String[] queriesRowItems = scanner.nextLine().split(" ");
//            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = scanner.nextInt();//Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulationOptimized(n, queries);
        System.out.println(result);

//        bufferedWriter.write(String.valueOf(result));
//        10 4
//        2 6 8
//        3 5 7
//        1 8 1
//        5 9 15
//        bufferedWriter.newLine();

//        bufferedWriter.close();

        scanner.close();
    }

}
