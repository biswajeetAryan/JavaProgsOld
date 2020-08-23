package com.graphsAndTrees;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class Domino {
    private int n;
    private LinkedList<Integer> adj [];
    public static HashMap<String,Integer> timeMap = new HashMap<>();
    public static int dl [] = new int[2];
    public static float timeTaken = 0;
    Domino(int v) {
        n = v;
        adj = new LinkedList[n+1];
        for(int i = 1;i<=n;i++)
            adj[i]= new LinkedList();
    }
    void addEdge(int v1, int v2){
        adj[v1].add(v2);
    }
    void BFS(int v){
        boolean [] visitedArr = new boolean[n+1];
        LinkedList<Integer> queue = new LinkedList<>();

        visitedArr[v] = true;
        queue.add(v);

        while(queue.size()!=0){
            int s = queue.poll();
            Iterator<Integer> i = adj[s].listIterator();
            float time =0;
            while(i.hasNext()) {
                int ver = i.next();
                int t = timeMap.get(String.valueOf(s) +"="+String.valueOf(ver));
                if (!visitedArr[ver]) {
                    visitedArr[ver] = true;
                    queue.add(ver);
                    dl[0]= ver;
                    dl[1]=0;
                    if(time==0)
                        time+= t;
                    else
                        time+=(t>time)?(t-time):(time-t);
                }else{
                    dl[0]=s;
                    dl[1]=ver;
                    time=(float)t/2;
                }
            }
            timeTaken+=time;
        }
    }

    public static void main(String[] args) {
        Domino g = new Domino(5);

        g.addEdge(1, 2);
        timeMap.put("1=2", 5);
        g.addEdge(2, 3);
        timeMap.put("2=3", 1);
        g.addEdge(1, 4);
        timeMap.put("1=4", 5);
        g.addEdge(4, 5);
        timeMap.put("4=5",1);
        g.addEdge(2, 4);
        timeMap.put("2=4",6);

//        1 2 5
//        2 3 1
//        1 4 5
//        4 5 1
//        2 4 6


        g.BFS(1);
        if(dl[1]!=0)
            System.out.println(dl[0]+" and "+dl[1]+" t= "+timeTaken);
        else
            System.out.println(dl[0]+" t= "+timeTaken);

    }
}
