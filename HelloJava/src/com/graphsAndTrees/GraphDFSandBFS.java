package com.graphsAndTrees;

import java.util.Iterator;
import java.util.LinkedList;

public class GraphDFSandBFS {
    private int n;
    private LinkedList<Integer> adj [];
    GraphDFSandBFS(int v) {
        n = v;
        adj = new LinkedList[n];
        for(int i = 0;i<n;i++)
            adj[i]= new LinkedList();
    }
    void addEdge(int v1, int v2){
        adj[v1].add(v2);
    }
    void BFS(int v){
        boolean [] visitedArr = new boolean[n];
        LinkedList<Integer> queue = new LinkedList<>();

        visitedArr[v] = true;
        queue.add(v);

        while(queue.size()!=0){
            int s = queue.poll();
            System.out.println(s);
            Iterator<Integer> i = adj[s].listIterator();
            System.out.println();
            while(i.hasNext()) {
                int ver = i.next();
                if (!visitedArr[ver]) {
                    visitedArr[ver] = true;
                    queue.add(ver);
                }
            }
        }
    }
    void DFSUtil(int v, boolean visitedArr[]){
        visitedArr[v] = true;
        System.out.println(v);
        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()){
            int s = i.next();
            if(!visitedArr[s])
                DFSUtil(s, visitedArr);
        }
    }
    void DFS(int v){
        boolean visited[] = new boolean[n];
        DFSUtil(v,visited);
    }
    public static void main(String[] args) {
        GraphDFSandBFS g = new GraphDFSandBFS(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal "+
                "(starting from vertex 2)");

        g.DFS(2);
    }
}
