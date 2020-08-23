package com.company;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MedianOfSortedArrays {
    public static float medianOfSortedArrayOptimal(int arrX[], int arrY[]) {
        int lenX = arrX.length;
        int lenY = arrY.length;
        if (lenX > lenY)
            return medianOfSortedArrayOptimal(arrY, arrX);
        System.out.println("lenX = "+lenX+" lenY = "+lenY);
        if(lenX == 0 && lenY>0)
            if(lenY%2 == 0)
                return (float)(arrY[(lenY)/2]+arrY[((lenY)/2)-1])/2;
            else
                return (float)arrY[(lenY)/2];
        else if(lenY == 0 && lenX>0){
            if(lenX%2 == 0)
                return (float)(arrX[(lenX)/2]+arrX[((lenX)/2)-1])/2;
            else
                return (float)arrX[(lenX)/2];}
        else if(lenY == 0 && lenX == 0)
            return 0;



        int partX = 0;
        int partY = 0;
        int startX = 0;
        int endX = lenX;
        while (startX <= endX) {
            partX = (startX + endX) / 2;
            partY = (lenX + lenY + 1) / 2 - partX;
            System.out.println("partX = " + partX + " partY = " + partY);

            int maxLeftX;
            if(lenX > 0)
                maxLeftX = (partX < 1) ? Integer.MIN_VALUE : arrX[partX-1];
            else
                maxLeftX = Integer.MIN_VALUE;
            System.out.println("maxLeftX = " + maxLeftX);

            int maxLeftY;
            if(lenY > 0)
                maxLeftY = (partY < 1) ? Integer.MIN_VALUE : arrY[partY-1];
            else
                maxLeftY = Integer.MIN_VALUE;
            System.out.println("maxLeftY = " + maxLeftY);

            int minRightX;
            if(lenX > 0)
                if(partX <0)
                    minRightX = Integer.MIN_VALUE;
                else if(partX == lenX)
                    minRightX = Integer.MAX_VALUE;
                else
                    minRightX = arrX[partX];
            else
                minRightX = Integer.MIN_VALUE;
            System.out.println("minRightX = " + minRightX);

            int minRightY;
            if(lenY > 0)
                if(partY <0)
                    minRightY = Integer.MIN_VALUE;
                else if(partY == lenY)
                    minRightY = Integer.MAX_VALUE;
                else
                    minRightY = arrY[partY];
            else
                minRightY = Integer.MIN_VALUE;
            System.out.println("minRightY = " + minRightY);

            if((maxLeftX <= minRightY) && (maxLeftY <= minRightX)){
                if((lenX+lenY)%2 == 0)
                    return ((float)Math.max(maxLeftX,maxLeftY)+ Math.min(minRightX,minRightY))/2;
                else
                    return ((float)Math.max(maxLeftX,maxLeftY));
            }
            else if(maxLeftX > minRightY)
                endX = partX-1;
            else
                startX = partX+1;
        }

        throw new IllegalArgumentException();
    }

    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int arrX [] = {};
        int arrY [] = {2,3};
        float median = -1;
        median = medianOfSortedArrayOptimal(arrX, arrY);
        System.out.println("median = " + median);
        sc.close();
    }
}
