package com.example.view.BJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BJoon1743 {

    public static int N, M, K;
    public static boolean checked[][];
    public static int map[][];
    public static int dx[] = {0,1,0,-1};
    public static int dy[] = {1,0,-1,0};
    public static int cnt, result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 세로 가로 순!!!!
        map = new int[N+1][M+1];
        checked = new boolean[N+1][M+1];

        // 주어진 좌표가 세로(N) 가로(M) 순!!!
        for(int i=0; i<K; i++){
            String s = br.readLine();
            st = new StringTokenizer(s, " ");
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[r][c] = 1;
        }

        for(int i=1; i<N+1; i++){
            for(int j=1; j<M+1; j++){
                if(map[i][j] == 1 && !checked[i][j]){
                    cnt = 1;
                    counting(i,j);
                    result = Math.max(cnt, result);
                }
            }
        }

        System.out.println(result);

    }

    public static void counting(int x, int y){
        checked[x][y] = true;

        for(int i=0; i<dx.length; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 1 || ny < 1 || nx >= N+1 || ny >= M+1) continue;
            else if(map[nx][ny] == 1 && !checked[nx][ny]){
                counting(nx, ny);
                cnt += 1;
                checked[nx][ny] = true;
            }
        }
    }
    
}
