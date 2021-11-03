package com.example.view.BJoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class Virus{
    int x;
    int y;
    Virus(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class BJoon14502 {

    static int[][] lab;
    static int[][] viruslab; //바이러스 퍼졌을때를 가정하고 쓰는 맵
    static int N, M;
    static int[] dn = {-1,1,0,0};
    static int[] dm = {0,0,-1,1};
    static int anw = 0;
    
       // 1. 벽을 세운다. (DFS)
       public static void setwall(int count_wall){
        // 벽이 3개라면 바이러스 퍼진 결과로 안전지대 최대값 도출
        if(count_wall == 3){
            spreadvirus();
            CheckSafePlace();
            return;
        }
        // 아니라면 계속 벽을 세우고 허물고를 반복
        else {
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(lab[i][j] == 0){
                        lab[i][j] = 1;
                        setwall(count_wall + 1);

                        //결국엔 벽 3개를 다 허물어서 빈공간으로 만들기
                        lab[i][j] = 0;
                    }
                }
            }
        }
    }

    // 2. 벽을 세우고 난 후의 과정 -> 바이러스 확산(BFS)
    public static void spreadvirus(){
        Queue<Virus> queue = new LinkedList<>();
        viruslab = new int[N][M];

        // 벽 세우기에서 사용했던 연구실 lab[][] 과 똑같은 걸 생성
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                viruslab[i][j] = lab[i][j];
            }
        }

        // 반복문 돌렸을 때 바이러스라면 큐에 추가해서 기록
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(viruslab[i][j] == 2){
                    queue.add(new Virus(i,j));
                }
            }
        }

        // 큐가 빌때까지 모든 경우의 수를 다 탐색(꺼내고 넣기를 반복)
        while(!queue.isEmpty()){
            Virus virus = queue.poll();
            int x = virus.x;
            int y = virus.y;

            // 상하좌우 4방향으로 움직일 수 있음
            for(int i=0; i<4; i++){
                int xx = x+dn[i]; // X 축 새 지점
                int yy = y+dm[i]; // Y축 새 지점

                // 새 지점이 연구실을 벗어나지 않고
                if(xx>=0 && yy>=0 && xx<N && yy<M){
                    // 벽이 없는 빈공간이라면
                    if(viruslab[xx][yy] == 0){
                        viruslab[xx][yy] = 2; // 바이러스 전파
                        queue.add(new Virus(xx, yy)); // 큐에 추가
                    }
                }
            }
        }
    }

    // 3. 바이러스 확산 다 되고 안전지대 체크
    public static void CheckSafePlace(){
        int checking = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                // 바이러스가 퍼진 상태를 나타내는 연구실[][] 배열에서 0인걸 체크
                if(viruslab[i][j] == 0){
                    checking++; // 카운팅
                }
            }
        }
        anw = Math.max(anw, checking);
    }


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        //지도 세로 & 가로 길이
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 이차원배열로 연구소 크기 설정
        lab = new int[N][M];

        // 입력받은 값들로 연구실 지도 입력
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<M; j++){
                lab[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 반복문을 돌려서 벽을 세우고 허물고를 반복
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(lab[i][j] == 0){  // 벽이 하나도 없을때
                    lab[i][j] = 1; // 벽을 하나 세우고
                    setwall(1); // 카운팅
                    lab[i][j] = 0; // 허물고 빈공간으로 초기화
                }
            }
        }

        System.out.println(anw);
    }
}
