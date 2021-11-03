package com.example.view.BJoon;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJoon1197 {
	
    static int V, E;
	static boolean[] checked;
    static ArrayList<Point>[] list;
    static long ans = 0;

    public static class Point implements Comparable<Point>{

        int to;
        int value;

        public Point(int to, int value){
            this.to = to;
            this.value = value;
        }

        @Override
        public int compareTo(Point o) {
            if(this.value > o.value){
                return 1;
            }
            else if(this.value == o.value){
                return 0;
            }
            else {
                return -1;
            }
            // return this.value - o.value;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        checked = new boolean[V+1];
        list = new ArrayList[V+1];

        for(int i=0; i<=V; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new Point(b,c));
            list[b].add(new Point(a,c));
        }

        prim();
        System.out.println(ans);
    }

    private static void prim(){
        Queue<Point> queue = new PriorityQueue<>();
        queue.add(new Point(1,0));
        int counting = 0;

        while(!queue.isEmpty()){
            Point p = queue.poll();
            int nextpoint = p.to;
            int weight = p.value;

            if(checked[nextpoint]){
                continue;
            }
            checked[nextpoint] = true;
            ans += weight;

            for(Point next : list[nextpoint]){
                if(!checked[next.to]){
                    queue.add(next);
                }
            }

            if(++counting == V){
                break;
            }
        }
    }
}