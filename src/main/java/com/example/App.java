package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class App {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //입력받을 배열 A크기 N
        int N = Integer.parseInt(br.readLine()); 
        //N크기 만큼 담긴 배열 A
        int[] A = new int[N];

        //입력받은 수들을 한글자씩 토큰화
        StringTokenizer st = new StringTokenizer(br.readLine());

        //각 숫자가 몇 개인지 셀 배열F
        int[] F = new int[1000001];

        //A배열에 숫자를 넣어준다. A[0]=1, A[1]=1, A[2]=2, A[3]=3, A[4]=4, A[5]=2, A[6]=1
        //A[i]에 해당하는 수를 늘려준다 -> 카운트
        //F[A[0]]=F[1] -> 1을 카운트, F[A[1]]=F[1] -> 1을 또 카운트 
        //모든과정을 반복하면 F[1]=3, F[2]=2 F[3]=1 F[4]=1
        for(int i=0; i<A.length; i++){
            A[i] = Integer.parseInt(st.nextToken());
            F[A[i]] += 1;
        }

        //배열 A의 인덱스를 담고 꺼낼 스택
        Stack<Integer> stack = new Stack<>();

        StringBuilder sb = new StringBuilder();

        stack.push(0);
        for(int i=1; i<A.length; i++){
            while(!stack.isEmpty() && F[A[stack.peek()]] < F[A[i]]){
                A[stack.pop()] = A[i];
            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            A[stack.pop()] = -1;
        }

        for(int i=0; i<A.length; i++){
            sb.append(A[i]).append(" ");
        }

        System.out.println(sb);

    }
}
