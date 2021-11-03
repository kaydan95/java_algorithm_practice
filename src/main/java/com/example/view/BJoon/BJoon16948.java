package com.example.view.BJoon;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//데스나이트객체
class deathKnight {
    int r;
    int c;
    int cnt;
    deathKnight(int r, int c, int cnt){
        this.r = r;
        this.c = c;
        this.cnt = cnt;
    }
}

public class BJoon16948 {

    //체스판 한 면 크기
    static int N;
    static int[][] chessboard;
    static boolean[][] checked;

    //행, 열 별로 움직일 수 있는 좌표크기
    static int[] mr = {-2, -2, 0, 0, 2, 2};
    static int[] mc = {-1, 1, -2, 2, -1, 1};

    static int r1, c1, r2, c2;


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //첫째줄에 입력받은 체스판 한 면 크기 N
        N = Integer.parseInt(br.readLine());

        //N크기 만큼의 체스판 배열
        chessboard = new int[N+1][N+1];
        //탐색여부 기록용 배열
        checked = new boolean[N+1][N+1];

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        // 처음 데스나이트의 위치
        r1 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());

        // 데스나이트가 옮겨갈 위치
        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());

        bfs();
    }

    public static void bfs(){
        Queue<deathKnight> queue = new LinkedList<>();
        queue.add(new deathKnight(r1, c1, 0));
        checked[r1][c1] = true;

        while(!queue.isEmpty()){
            deathKnight startpoint = queue.poll();

            for(int i=0; i<6; i++){
                int nr1 = startpoint.r + mr[i];
                int nc1 = startpoint.c + mc[i];
                int ncnt = startpoint.cnt + 1;

                if(nr1<0 || nc1<0 || nr1>N || nc1>N || checked[nr1][nc1]){
                    continue;
                }

                if(nr1 == r2 && nc1 == c2){
                    System.out.println(ncnt);
                    System.exit(0);
                }
            
                checked[nr1][nc1] = true;
                queue.add(new deathKnight(nr1, nc1, ncnt));

            }
        }
        System.out.println(-1);
    }
}
