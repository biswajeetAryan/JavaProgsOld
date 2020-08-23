package com.company;


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class CheckMagazine {

    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, Integer> mapN = new HashMap<>();

        boolean yes = false;
        for(String m : magazine){
            if(!map.containsKey(m))
                map.put(m,1);
            else{
                int v = map.get(m);
                map.put(m,v+1);
            }
        }

        for(String n : note){
            if(!mapN.containsKey(n))
                mapN.put(n,1);
            else{
                int vn = mapN.get(n);
                mapN.put(n,vn+1);
            }
        }

        for(Map.Entry<String,Integer> e : mapN.entrySet()){
            System.out.println(e.getKey()+" p = "+map.containsKey(e.getKey())+" v ="+map.get(e.getKey()));
            if(map.containsKey(e.getKey()) && map.get(e.getKey()) >= e.getValue()){
                System.out.println(e.getKey()+" "+e.getValue());
                yes = true;}
            else{
                System.out.println("f = "+e.getKey()+" "+e.getValue());
                yes = false;
            break;}}

        if(yes)
            System.out.println("Yes");
        else
            System.out.println("No");

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
    }
}
