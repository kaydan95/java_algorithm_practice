package com.example.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import org.w3c.dom.TypeInfo;


class pw {
    int original;
    int cnt;

    public pw(int original, int cnt){
        this.original = original;
        this.cnt = cnt;
    }
}
public class BJoon1963 {

    static int T;
    static boolean[] checked;
    static Queue<pw> queue;
    static int start, end;
    static StringBuilder sb;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());

        for(int i=0; i<T; i++){
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());

            checked = new boolean[10001];
            queue = new LinkedList<>();
            
            bfs();
        }
    }

    // 입력받은 네 자리 숫자를 하나씩 바꿈 -> 방문한적 없고 소수이면 -> bfs
    // 제곱근으로 나눠지면 소수가 아님
    // 값 못찾으면 Impossible 출력

    private static void bfs(){
        queue.add(new pw(start,0));
        sb = new StringBuilder();

        // 암호가 변경되지 않았을 경우, 0 출력
        if(start == end){
            System.out.println(0);
            return;
        }

        // 탐색시작
        while(!queue.isEmpty()){
            // 탐색을 위해 queue 에서 비번을 꺼내야함
            pw pw = queue.poll();

            if(!checked[pw.original]){
                checked[pw.original] = true;

                // 조각낸 걸 문자형으로 배열에 담아준다
                char[] each_numbers = Integer.toString(pw.original).toCharArray();

                // 각 네자리 숫자를 0-9까지 바꿔봐야함
                for(int i=0; i<=9; i++){
                    for(int j=0; j<4; j++){
                        //숫자 첫번째 자리가 0이면 패스
                        if(i==0 && j==0){
                            continue;
                        }
                        char origin = each_numbers[j];

                    
                        // 문자형을 int형으로 나타내야해서 0을 더해주고 시작
                        each_numbers[j] = (char)(i+'0');
                        int n = Integer.parseInt(String.valueOf(each_numbers));
                        each_numbers[j] = origin;
                        

                        if(checked[n]){
                            continue;
                        }
                        if(prime_check(n)){
                            if(n == end){
                                System.out.println(pw.cnt + 1);
                                return;
                            }
                            queue.add(new pw(n, pw.cnt + 1));
                        }

                    }
                }
            }
        }
        System.out.println("Impossible");
    }

    private static boolean prime_check(int n){
        for(int i=2; i<=(int)Math.sqrt(n); i++){
            if(n%i == 0){
                return false;
            }
        } return true;
    }
}
