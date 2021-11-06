package com.example.view.BJoon;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJoon2606 {

    static int map[][];
    static boolean checked[];
    static int cnt = 0;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int C = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        map = new int[C+1][C+1];
        checked = new boolean[C+1];

        for(int i=0; i<N; i++){
            String S = br.readLine();
            StringTokenizer st = new StringTokenizer(S, " ");

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            map[from][to] = 1;
            map[to][from] = 1;
        }
        System.out.println(bfs(1));
    }

    public static int bfs(int startpoint){
        Queue<Integer> queue = new LinkedList<>();

        queue.add(startpoint);
        checked[startpoint] = true;

        while(!queue.isEmpty()){
            int StartPoint = queue.poll();

            for(int i=1; i<map.length; i++){
                if(map[StartPoint][i]==1 && checked[i] == false){
                    queue.add(i);
                    checked[i] = true;
                    cnt+=1;
                }
            }
        }
        return cnt;
    }
}
