package com.company;

public class UglyNum {
    static public boolean isUgly(int num) {
        if(num==0 || num < 0)
            return false;
        while(num % 5==0)
            num=num/5;
        while(num%3==0)
            num=num/3;
        while(num % 2==0 )
            num=num/2;
        return num==1;
    }


    public static void main(String[] args) {
        int a = 90;
        boolean res = isUgly(a);
        System.out.println(res);
    }
}
