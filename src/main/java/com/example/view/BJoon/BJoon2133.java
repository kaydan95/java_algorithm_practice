package com.example.view.BJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;



public class BJoon2133 {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] wall = new int[31];

        wall[0] = 1;
        
        wall[1] = 0;

        wall[2] = 3;

        if(N>1){
            for(int i=4; i<=N; i+=2){
                wall[i] = 3*wall[i-2];
                for(int j=i-4; j>=0; j-=2){
                    wall[i] += 2*wall[j];
                }
            }
        }
        System.out.println(wall[N]);
    }
}

