package com.example.view.BJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Pointer {
    int x;
    int y;

    Pointer(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class BJoon1303 {

    public static boolean checked[][];
    public static char war[][];
    public static Queue<Pointer> queue = new LinkedList<>();
    public static int dx[] = {1,0,-1,0};
    public static int dy[] = {0,1,0,-1};
    public static int i,j,N, M, B, W, cnt= 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 첫째줄에서 입력받은 가로길이(N)과 세로길이(M)
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        war = new char[N][M];


        //입력받은 N과 M의 크기만큼 반복문 -> 둘째줄부터 입력받은 값 넣기
        for(i=0; i<M; i++){
            String s = br.readLine();
            for(j=0; j<N; j++){
                war[i][j] = s.charAt(j);
            }
        }

        checked = new boolean[N][M];

        for(i=0; i<N; i++){
            for(j=0; j<M; j++){
                if(!checked[i][j]){
                    queue.add(new Pointer(i, j));
                    checked[i][j] = true;
                    cnt = 1;

                    bfs();

                    if(war[i][j] == 'W'){
                        W += cnt*cnt;
                    }else B += cnt*cnt;
                }
            }
        }

        System.out.println(W + " " + B);

        

    }
    public static void bfs(){

        while(!queue.isEmpty()){
            Pointer startpPointer = queue.poll();

            for(int i=0; i<dx.length; i++){
                int nx = startpPointer.x + dx[i];
                int ny = startpPointer.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M){
                    continue;
                }
                if(checked[nx][ny]){
                    continue;
                }
                if(war[nx][ny] != war[startpPointer.x][startpPointer.y]){
                    continue;
                }

                cnt += 1;
                checked[nx][ny] = true;
                queue.add(new Pointer(nx, ny));
            }
        }

    }
}
