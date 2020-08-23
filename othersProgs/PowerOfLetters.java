package com.company;

import java.util.HashMap;
import java.util.Iterator;

public class PowerOfLetters {
    public void calcPower(String str) {
        HashMap<Character, Integer> letterMap = new HashMap<>();
        for(int i=0;i<str.length();i++){
            int v =0;
            if(letterMap.containsKey(str.charAt(i)))
                v = letterMap.get(str.charAt(i));
            letterMap.put(str.charAt(i), v+1);
        }

//        Iterator<HashMap.Entry<Character, Iterator>> itr = letterMap.enterSet().iterator();
        letterMap.forEach((k,v) -> System.out.print(k+""+v));
    }

    public static void main(String args[]){
        String x = "aaabcccdduu";
        PowerOfLetters p = new PowerOfLetters();
        p.calcPower(x);
    }
}
