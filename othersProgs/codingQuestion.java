package com.company;

import java.io.IOException;
import java.util.*;

public class codingQuestion {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();
            int[][] V = new int[N][2];
            for (int x = 0; x < N; x++) {
                for(int y=0;y<2;y++){
                    int queriesItem = scanner.nextInt();
                    V[x][y] = queriesItem;

                }
            }
            arrayManipulation(N, V);
        }
        scanner.close();
    }
    static void arrayManipulation(int n, int[][] q) {
        int c =0;
        HashMap<Integer,Integer>map=new HashMap<Integer, Integer>();
        for(int i=0;i<n;i++){
            for(int p=q[i][0]; p<=q[i][1]; p++){
                if(!map.containsKey(p)){
                    map.put(p, 1);
                    c++;
                }
            }
        }
        System.out.println(c);

    }

}
