package com.example;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class App {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //크기가 N인 수열 A={A1, A2, A3 ... An}
        //오큰수NGE(i)도 N개나온다
        //수열의 크기가 4 / A={3 5 2 7} res[0]=5
        //예제 출력 {5 7 7 -1}

        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Integer> st = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int C = sc.nextInt();

        int[] N = new int[C];

        StringTokenizer S = new StringTokenizer(sc.nextLine());


        for(int i=0; i<N.length; i++){
            N[i] = Integer.parseInt(S.nextToken());
        }

        for(int i=0; i<N.length; i++){
            while(!st.isEmpty()){
                int n = N[i];
                if( N[st.peek()] < n){
                    N[st.pop()] = n;
                }
                else{
                    break;
                }
            }
            st.push(i);
        }

        if(!st.isEmpty()){
            N[st.pop()] = -1;
        }

        for(int i=0; i<N.length; i++){
            sb.append(N[i]).append(" ");
        }
        System.out.println(sb);

    }
}
