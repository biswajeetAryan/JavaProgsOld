package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;

public class MaxProduct {
    public static int maxProduct(String[] words) {
        if(words==null || words.length<2){
            return 0;
        }

        int[] bitR = new int[words.length];
        for(int i=0; i<words.length; i++){
            int result = 0;
            for(char ch : words[i].toCharArray()){
                System.out.println("ch = "+ch);
                System.out.println("result = "+result);
                System.out.println(ch-'a');
                System.out.println(1<< (ch-'a'));
                result = result | (1<< (ch-'a'));
            }

            System.out.println("result in bit = "+result);
            System.out.println();
            bitR[i] = result;
        }
        int result = 0;
        for(int i=0; i<words.length; i++){
            for(int j=i+1; j<words.length; j++){

                if((bitR[i] & bitR[j]) == 0){
                    result = Math.max(result, words[i].length() * words[j].length());
                }


            }
        }
        return result;
     }

    public static void main(String[] args) {
        String [] words = {"a","ab","abc","d","cd","bcd","abcd"};
        int res = maxProduct(words);
        System.out.println(res);
    }
}
