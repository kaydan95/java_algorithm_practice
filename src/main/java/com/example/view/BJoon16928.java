package com.example.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class BJoon16928 {
    // 모든 변경위치들을 담을 배열
    static int[] change;

    // 해당 위치들까지 갈 수 있는 경우의 수를 담은 배열
    static int[] count = new int[101];

    // 이전에 탐색했던 곳인지 아닌지 기록한걸 담을 배열
    static boolean[] visited = new boolean[101];        

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        change = new int[101];
        for(int i=1; i<=100; i++){
            change[i] = i;
        }

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());


 
        for(int i=0 ; i<N+M ; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int start = Integer.parseInt(st.nextToken());
            int conclusion = Integer.parseInt(st.nextToken());

            change[start] = conclusion;
        }
        bfs();
        System.out.println(count[100]);
 
    }

    public static void bfs() {
        Queue<Integer> que = new LinkedList<>();
        // 게임 시작포인트1 -> 탐색 시작 지점
        que.add(1);

        // 탐색했던 곳임을 표시
        visited[1] = true;
        
        while(!que.isEmpty()) {
            // 탐색을 시작하려면 큐에서 꺼내기
            int startpoint = que.poll();

            // 주사위 굴려서 나올 수 있는 경로 모두 탐색
            for(int dice=1; dice<= 6; dice++) {
                // 현재 시점 + 주사위 값 한 값이 100보다 작은 경우
                if(startpoint + dice <= 100) { 
                    int newpoint = startpoint + dice;
                    // 근데 탐색기록이 없는 값인 경우
                    if(!visited[change[newpoint]]) {
                        // 큐에 해당 노드를 넣고
                        que.add(change[newpoint]);
                        // 탐색한 곳이라고 표시해주고
                        visited[change[newpoint]] = true;
                        // 주사위를 굴리기 전 값까지 오는 경우의 수에다가 + 1
                        count[change[newpoint]] = count[startpoint] + 1;
                    }
                }
            }
        }
    }
}