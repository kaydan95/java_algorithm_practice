package com.example.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJoon1197 {

    static List<Point>[] list;
    static boolean[] checked;
    static int ans;

    static class Point implements Comparable<Point>{
        int to;
        int value;

        public Point(int to, int value){
            this.to = to;
            this.value = value;
        }

        @Override
        public int compareTo(Point o) {
            return this.value = o.value;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        list = new ArrayList[V+1];
        checked = new boolean[V+1];

        for(int i=1; i<V+1; i++){
            list[i] = new ArrayList<>();
        }

        
        for(int i=1; i<E; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Point(b,c));
            list[b].add(new Point(a,c));
        }

        prim(1);
        System.out.println(ans);
    }

    static void prim(int start){
        Queue<Point> queue = new PriorityQueue<>();

        queue.add(new Point(start, 0));
        while(!queue.isEmpty()){
            Point p = queue.poll();
            int way = p.to;
            int weight = p.value;

            if(checked[way]) continue;
            checked[way] = true;
            ans += weight;

            for(Point next : list[way]){
                if(!checked[next.to]){
                    queue.add(next);
                }
            }
        }
    }
}
