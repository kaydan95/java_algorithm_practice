package com.example.view.BJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class BJoon2225 {


    
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int dp[][] = new int[N+1][K+1];

        for(int i=1; i <= N; i++){
            for(int j=1; j <= K; j++){
                if(j == 1){
                    dp[i][j] = 1;
                } else if(i == 1){
                    dp[i][j] = j;
                } else {
                    dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1000000000;
                }
            }
        }
        System.out.println(dp[N][K]);
    }


}
