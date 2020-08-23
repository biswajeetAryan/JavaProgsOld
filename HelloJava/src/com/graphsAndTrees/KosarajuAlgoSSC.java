package com.graphsAndTrees;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class KosarajuAlgoSSC {
    public static LinkedList<Integer> adj [];
    public static int n;
    KosarajuAlgoSSC(int V){
        n = V;
        adj = new LinkedList[n];
        for(int i=0;i<n;i++)
            adj[i]=new LinkedList();
    }
    public static void addIntoAdjlist(int v1, int v2){
        adj[v1].add(v2);
    }
    public static void DFS(int v){
        boolean visited [] = new boolean[n];
        Stack<Integer> vStack = new Stack<>();
        DFSUtil(v,visited,vStack);
//        while(!visited[n-1]){
//            for(int r=1;r<n;r++){
//                if(!visited[r]){
//                    DFSUtil(r,visited,vStack);
//                    break;
//                }
//            }
//        }
        DFSUtil(9,visited,vStack);

        System.out.println(vStack);
    }
    public static void DFSUtil(int v, boolean visited [], Stack vStack){
        visited[v]=true;
        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()){
            int s = i.next();
            if(!visited[s])
                DFSUtil(s,visited,vStack);
        }
        vStack.push(v);
    }

    public static void main(String[] args) {
        KosarajuAlgoSSC g = new KosarajuAlgoSSC(12);
        addIntoAdjlist(1, 2);
        addIntoAdjlist(2, 3);
        addIntoAdjlist(2, 4);
        addIntoAdjlist(3, 1);
        addIntoAdjlist(4, 5);
        addIntoAdjlist(5, 6);
        addIntoAdjlist(6, 4);
        addIntoAdjlist(7, 6);
        addIntoAdjlist(7, 8);
        addIntoAdjlist(8, 9);
        addIntoAdjlist(9, 10);
        addIntoAdjlist(10, 11);
        addIntoAdjlist(10, 7);
        DFS(2);
    }
}
