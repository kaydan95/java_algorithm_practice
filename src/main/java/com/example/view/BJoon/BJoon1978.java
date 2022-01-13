package com.example.view.BJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BJoon1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int total = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            boolean prime = true;

            int n = Integer.parseInt(st.nextToken());

            if(n == 1){
                continue;
            }

            for(int j=2; j<=Math.sqrt(n); j++){
                if(n%j == 0){
                    prime = false;
                    break;
                }
            }

            if(prime){
                total++;
            }
            
        }
        
        System.out.println(total);

    }
}
