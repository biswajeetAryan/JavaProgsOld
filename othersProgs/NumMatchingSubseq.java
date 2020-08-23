package com.company;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class NumMatchingSubseq {
    public static int numMatchingSubseq(String str, String[] words) {
        int count = 0;
        for(String word:words){
            int l1 = str.length(), l2 = word.length();
            if(isSubsequence(str,word,l1,l2))
                count++;
        }
        return count;
    }

    public static boolean isSubsequence(String str,String t,int l1, int l2){
//        int i = 0, j = 0, l1 = str.length(), l2 = t.length();
//        if(l2 > l1){
//            return false;
//        }
//        while(i < l1 && j < l2){
//            if(str.charAt(i) == t.charAt(j)){
//                i++;
//                j++;
//            }else{
//                i++;
//            }
//        }
//        return j == l2;
        if(l2==0)
            return true;
        if(l1==0)
            return false;

        char strChar[]=str.toCharArray();
        char tChar[]=t.toCharArray();
        if(strChar[l1-1]==tChar[l2-1])
            return isSubsequence(str,t,l1-1,l2-1);
        else
            return isSubsequence(str, t,l1-1,l2);

    }

    public static void main(String[] args) {
        String S = "abcde";
        String [] words = {"a", "bb", "acd", "ace"};
        int res = numMatchingSubseq(S,words);
        System.out.println(res);
    }
}
