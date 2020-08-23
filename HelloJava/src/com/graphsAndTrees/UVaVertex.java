package com.graphsAndTrees;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class UVaVertex {
    private int n;
    private int l;
    private LinkedList<Integer> adj [];
    UVaVertex(int v) {
        n = v;
        l=v;
        adj = new LinkedList[n+1];
        for(int i = 1;i<=n;i++)
            adj[i]= new LinkedList();
    }
    void addEdge(int v1, int v2){
        adj[v1].add(v2);
    }

    void DFSUtil(int v, boolean visitedArr[], int arr[]){
        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()){
            int s = i.next();
            if(!visitedArr[s]){
                visitedArr[s]=true;
                arr[s-1] = 1;
                l--;
                DFSUtil(s, visitedArr,arr);}
        }
    }
    void DFS(int v){
        boolean visited[] = new boolean[n+1];
        int arr[] = new int[n];

        DFSUtil(v,visited, arr);
        System.out.print(l);
        for(int i=0;i<n;i++)
            if(arr[i]==0)
                System.out.print(" "+(i+1));
    }
    public static void main(String[] args) {
        UVaVertex g = new UVaVertex(4);

        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
//        g.addEdge(4, 5);
//        g.addEdge(1, 1);
////        g.addEdge(3, 3);



        g.DFS(1);
    }
}
