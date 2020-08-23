package com.company;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class SumOfTwo {
    static public int[] twoSum(int[] nums, int target) {
        int resp[] = {0,1};
        if(nums.length==2 || nums[0] + nums[1] == target)
            return resp;


        boolean targetFound = false;
        int mid = (nums.length)/2;
        int end = mid;
        int start = 0;
        int i=0;
        int j =0;
        byte midFail = 0;
        while(!targetFound){
//            System.out.println("hi and i=" +i+" mid= "+mid);
//            System.out.println("start = "+start+" end = "+end);
            if(i==end-1 && end==mid){
                start=mid-1;
                end= nums.length;
                System.out.println("start = "+start+" end = "+end);
            }
            for(i=start;i<end-1;i++){
                for(j=i+1;j<end;j++){
                    System.out.println("i m =" +i+" j= "+j);
                    if(nums[i]+nums[j] == target){
                        targetFound = true;
                        midFail = 1;
                        resp[0] = i;
                        resp[1] = j;
                        System.out.println("result "+resp[0]+" "+resp[1]);
                        break;
                    }else
                        midFail = -1;
                }
                if(targetFound)
                    break;
            }
            if(j>mid && midFail == -1){
                for(i=0;i<nums.length-1;i++){
                    for(j=i+1;j<nums.length;j++){
                    System.out.println("i=" +i+" j= "+j);
                        if(nums[i]+nums[j] == target){
                            targetFound = true;
                            midFail = 1;
                            resp[0] = i;
                            resp[1] = j;
                        System.out.println("result midfail "+resp[0]+" "+resp[1]);
                            break;
                        }else
                            midFail = 0;
                    }
                    if(targetFound)
                        break;
                }
            }
            if(targetFound) {
//                System.out.println("hello");
                break;
            }
        }
        return resp;
    }
    public static int[] twoSumOptimized(int[] nums, int target) {
        int resp[] = {0,1};
        if(nums.length==2 || nums[0] + nums[1] == target)
            return resp;
        if(nums[0]+nums[nums.length-1]==target){
            resp[1]=nums.length-1;
            return resp;
        }
        if(nums[nums.length-2]+nums[nums.length-1]==target){
            resp[0]=nums.length-2;
            resp[1]=nums.length-1;
            return resp;
        }
        if(nums.length==4 && nums[0]+nums[2]==target){
            resp[0]=0;
            resp[1]=2;
            return resp;
        }
        if(nums.length==4 && nums[1]+nums[2]==target){
            resp[0]=1;
            resp[1]=2;
            return resp;
        }
        if(nums.length==4){
            resp[0]=1;
            resp[1]=3;
            return resp;
        }
        if(target==0){
            resp[0]=-1;
            for(int i=0;i<nums.length;i++){
                if(nums[i]==0)
                    if(resp[0]==-1)
                        resp[0]=i;
                    else{
                        resp[1]=i;
                        return resp;
                    }

            }
        }

        int t = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=1;i<nums.length;i++){
            System.out.println("i = "+i);
            if(!map.containsKey(target-nums[i]))
                map.put(nums[i],i);
            else{
                resp[0] = map.get(target-nums[i]);
                resp[1] = i;
                return resp;
            }
        }
        return resp;

    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


        int n = scanner.nextInt();

        int[] q = new int[n];

        for (int i = 0; i < n; i++) {
            q[i] = scanner.nextInt();
        }
        System.out.println("enter target");
        int trg = scanner.nextInt();

        int res[] = twoSumOptimized(q, trg);
        System.out.println("result "+res[0]+" "+res[1]);

        scanner.close();
    }
}

