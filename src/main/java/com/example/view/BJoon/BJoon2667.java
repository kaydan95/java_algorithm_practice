package com.example.view.BJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class BJoon2667 {

    public static boolean checked[][];
    public static int map[][];
    public static int apt[];
    public static int dx[] = {1,0,-1,0};
    public static int dy[] = {0,1,0,-1};
    public static int N,n,cnt = 0;

    public static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        checked = new boolean[N][N];

        for(int i=0; i<map.length; i++){
            String s = br.readLine();
            String[] cur = s.split("");
            for(int j=0; j<map.length; j++){
                map[i][j] = Integer.parseInt(cur[j]);
            }
        }


        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j] == 1 && !checked[i][j]){
                    cnt = 1;
                    Counting_apt(i,j);
                    list.add(cnt);
                }
            }
        }

        Collections.sort(list);

        
        System.out.println(list.size());

        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i));
        }

    }

    public static int Counting_apt (int x, int y){

        checked[x][y] = true;

        for(int i=0; i<dx.length; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx>=0 && ny>=0 && nx<N && ny<N){
                if(map[nx][ny] == 1 && !checked[nx][ny]){
                    Counting_apt(nx, ny);
                    cnt+=1;
                }
            }
        }
        return cnt;
    }
}
